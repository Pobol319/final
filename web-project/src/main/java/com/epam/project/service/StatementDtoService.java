package com.epam.project.service;

import com.epam.project.comparator.StatementDtoComparatorByTotalPoints;
import com.epam.project.entity.*;
import com.epam.project.entity.dto.StatementDto;
import com.epam.project.exceptions.ServiceException;

import java.util.*;

public class StatementDtoService {
    private UserService userService;
    private StatementService statementService;
    private FacultyService facultyService;
    private PointsOnSubjectService pointsOnSubjectService;
    private SubjectService subjectService;

    public StatementDtoService(UserService userService, StatementService statementService,
                               FacultyService facultyService, PointsOnSubjectService pointsOnSubjectService,
                               SubjectService subjectService) {
        this.userService = userService;
        this.statementService = statementService;
        this.facultyService = facultyService;
        this.pointsOnSubjectService = pointsOnSubjectService;
        this.subjectService = subjectService;
    }

    public StatementDto getStatementDtoInfo(Integer userId) throws ServiceException {
        StatementDto statementDto = new StatementDto();
        Optional<User> userOptional = userService.getUserById(userId);
        Optional<Statement> statementOptional = statementService.getStatementByUserId(userId);
        if (statementOptional.isPresent() & userOptional.isPresent()) {
            Statement statement = statementOptional.get();
            Optional<Faculty> faculty = facultyService.getById(statement.getFacultyId());
            List<PointsOnSubject> pointsOnSubjects = pointsOnSubjectService.getPointsOnSubjectByStatementId(statement.getId());
            List<Subject> subjects = getSubjects(pointsOnSubjects);
            int totalPoints = getTotalPoints(pointsOnSubjects);

            statementDto.setId(userId);
            statementDto.setUser(userOptional.get());
            statementDto.setStatement(statement);
            statementDto.setFaculty(faculty.get());
            statementDto.setSubjects(subjects);
            statementDto.setPointsOnSubjects(pointsOnSubjects);
            statementDto.setTotalPoints(totalPoints);
        }
        return statementDto;
    }

    public List<StatementDto> getStatementDtoAccordingToRegistration(boolean isRegisteredToFaculty) throws ServiceException {
        List<Statement> statements = statementService.getStatementsAccordingToRegistrationToFaculty(isRegisteredToFaculty);
        List<StatementDto> statementDtoList = new ArrayList<>();
        for (Statement statement : statements) {
            StatementDto statementDto = getStatementDtoInfo(statement.getUserId());
            statementDtoList.add(statementDto);
        }
        return statementDtoList;
    }

    public Map<Faculty, List<StatementDto>> getEnrolledStatementDtoListAccordingToFaculty(List<Faculty> facultyList,
                                                                                          List<StatementDto> statementDtoList) {
        Map<Faculty, List<StatementDto>> facultyMap = new HashMap<>();
        for (Faculty faculty : facultyList) {
            List<StatementDto> facultyStatementDtoList = getSortedStatementDtoListAccordingToFaculty(faculty, statementDtoList);
            List<StatementDto> enrolledStatementDto = new ArrayList<>();
            int sizeOfSet = Math.min(faculty.getMaxSize(), facultyStatementDtoList.size());
            for (int i = 0; i < sizeOfSet; i++) {
                enrolledStatementDto.add(facultyStatementDtoList.get(i));
            }
            facultyMap.put(faculty, enrolledStatementDto);
        }
        return facultyMap;
    }

    private List<StatementDto> getSortedStatementDtoListAccordingToFaculty(Faculty faculty,
                                                                           List<StatementDto> statementDtoList) {
        List<StatementDto> facultyStatementDtoList = new ArrayList<>();
        for (StatementDto statementDto : statementDtoList) {
            if (faculty.getName() == statementDto.getFaculty().getName()) {
                facultyStatementDtoList.add(statementDto);
            }
        }
        facultyStatementDtoList.sort(new StatementDtoComparatorByTotalPoints().reversed());
        return facultyStatementDtoList;
    }

    private List<Subject> getSubjects(List<PointsOnSubject> pointsOnSubjects) throws ServiceException {
        List<Subject> subjects = new ArrayList<>();
        for (PointsOnSubject pointsOnSubject : pointsOnSubjects) {
            Integer id = pointsOnSubject.getSubjectId();
            Optional<Subject> subject = subjectService.getById(id);
            subject.ifPresent(subjects::add);
        }
        return subjects;
    }

    private int getTotalPoints(List<PointsOnSubject> pointsOnSubjects) {
        int totalPoints = 0;
        for (PointsOnSubject pointsOnSubject : pointsOnSubjects) {
            totalPoints += pointsOnSubject.getNumberOfPoints();
        }
        return totalPoints;
    }
}
