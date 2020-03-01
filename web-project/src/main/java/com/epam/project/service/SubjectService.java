package com.epam.project.service;

import com.epam.project.dao.DaoHelper;
import com.epam.project.dao.DaoHelperFactory;
import com.epam.project.dao.api.SubjectDao;
import com.epam.project.entity.Subject;
import com.epam.project.exceptions.ConnectionPoolException;
import com.epam.project.exceptions.DaoException;
import com.epam.project.exceptions.ServiceException;

import java.util.Optional;

public class SubjectService {
    private DaoHelperFactory daoHelperFactory;

    public SubjectService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public Optional<Subject> getById(Integer id) throws ServiceException {
        try (DaoHelper factory = daoHelperFactory.create()) {
            SubjectDao subjectDao = factory.createSubjectDao();
            return subjectDao.getById(id);
        } catch ( DaoException e) {
            throw new ServiceException(e);
        }
    }
}
