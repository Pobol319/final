package com.epam.project.service.transaction;

import com.epam.project.dao.DaoHelper;
import com.epam.project.dao.DaoHelperFactory;
import com.epam.project.dao.interfaces.PointsOnSubjectDao;
import com.epam.project.dao.interfaces.StatementDao;
import com.epam.project.entity.PointsOnSubject;
import com.epam.project.entity.Statement;
import com.epam.project.entity.Subject;
import com.epam.project.entity.User;
import com.epam.project.entity.dto.FacultyDto;
import com.epam.project.exceptions.ConnectionPoolException;
import com.epam.project.exceptions.DaoException;
import com.epam.project.exceptions.ServiceException;


import java.util.*;

public class CreateStatementTransactionService {
    private DaoHelperFactory daoHelperFactory;

    public CreateStatementTransactionService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public void createStatementAndPointsOnSubjects(User user, FacultyDto facultyDto, String[] points)
            throws ServiceException {
        try (DaoHelper factory = daoHelperFactory.create()) {
            factory.startTransaction();
            try {
                StatementDao statementDao = factory.createStatementDao();
                PointsOnSubjectDao pointsOnSubjectDao = factory.createPointsOnSubjectDao();

                List<Integer> pointsOnSubjects = convertArrayFromStringToInt(points);
                Integer statementId = user.hashCode();
                Integer userId = user.getId();
                Integer facultyId = facultyDto.getFaculty().getId();
                createStatement(statementId, userId, facultyId, statementDao);

                List<Subject> subjects = facultyDto.getSubjects();
                for (int i = 0; i < pointsOnSubjects.size(); i++) {
                    Integer subjectId = subjects.get(i).getId();
                    createPointsOnSubject(pointsOnSubjects.get(i), subjectId, statementId, pointsOnSubjectDao);
                }
                factory.commitTransaction();
            } catch (DaoException e) {
                factory.rollBackTransaction();
                throw new DaoException();
            } finally {
                factory.finishTransaction();
            }
        } catch (ConnectionPoolException | DaoException e) {
            throw new ServiceException(e);
        }
    }

    private void createStatement(Integer statementId, Integer userId, Integer facultyId, StatementDao statementDao)
            throws DaoException {
        Date date = new Date();
        Statement statement = new Statement(statementId, date, false, userId, facultyId);
        statementDao.save(statement);
    }

    private void createPointsOnSubject(int numberOfPoints, Integer subjectId, Integer
            statementId, PointsOnSubjectDao pointsOnSubjectDao)
            throws DaoException {
        PointsOnSubject pointsOnSubject = new PointsOnSubject();
        pointsOnSubject.setNumberOfPoints(numberOfPoints);
        pointsOnSubject.setSubjectId(subjectId);
        pointsOnSubject.setStatementId(statementId);

        pointsOnSubjectDao.save(pointsOnSubject);
    }

    private List<Integer> convertArrayFromStringToInt(String[] stringArray) {
        List<Integer> integerList = new ArrayList<>();
        for (String stringNumber : stringArray) {
            Integer integer = Integer.parseInt(stringNumber);
            integerList.add(integer);
        }
        return integerList;
    }
}
