package com.epam.project.service;

import com.epam.project.entity.Faculty;
import com.epam.project.entity.RequiredSubject;
import com.epam.project.entity.Subject;
import com.epam.project.entity.dto.FacultyDto;
import com.epam.project.exceptions.ServiceException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FacultyDtoService {
    private FacultyService facultyService;
    private RequiredSubjectService requiredSubjectService;
    private SubjectService subjectService;

    public FacultyDtoService(FacultyService facultyService, RequiredSubjectService requiredSubjectService, SubjectService subjectService) {
        this.facultyService = facultyService;
        this.requiredSubjectService = requiredSubjectService;
        this.subjectService = subjectService;
    }

    public FacultyDto getFacultyDtoInfo(Integer facultyId) throws ServiceException {
        Optional<Faculty> facultyOptional = facultyService.getById(facultyId);
        List<Subject> subjects = getSubjects(facultyId);
        FacultyDto facultyDto = new FacultyDto();
        if (facultyOptional.isPresent()) {
            facultyDto.setId(facultyId);
            facultyDto.setFaculty(facultyOptional.get());
            facultyDto.setSubjects(subjects);
        }
        return facultyDto;
    }

    private List<Subject> getSubjects(Integer facultyId) throws ServiceException {
        List<RequiredSubject> requiredSubjects = requiredSubjectService.getIdRequiredSubjectByFacultyId(facultyId);
        List<Subject> subjects = new ArrayList<>();
        for (RequiredSubject requiredSubject : requiredSubjects) {
            Integer id = requiredSubject.getSubjectId();
            Optional<Subject> subject = subjectService.getById(id);
            subject.ifPresent(subjects::add);
        }
        return subjects;
    }
}
