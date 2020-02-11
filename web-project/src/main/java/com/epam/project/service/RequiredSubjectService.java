package com.epam.project.service;

import com.epam.project.dao.DaoHelper;
import com.epam.project.dao.DaoHelperFactory;
import com.epam.project.dao.api.RequiredSubjectDao;
import com.epam.project.entity.RequiredSubject;
import com.epam.project.exceptions.ConnectionPoolException;
import com.epam.project.exceptions.DaoException;
import com.epam.project.exceptions.ServiceException;

import java.util.List;

public class RequiredSubjectService {
    private DaoHelperFactory daoHelperFactory;

    public RequiredSubjectService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public List<RequiredSubject> getIdRequiredSubjectByFacultyId(Integer facultyId) throws ServiceException {
        try (DaoHelper factory = daoHelperFactory.create()) {
            RequiredSubjectDao requiredSubjectDao = factory.createRequiredSubjectDao();
            return requiredSubjectDao.findSubjectIdByFacultyId(facultyId);
        } catch (ConnectionPoolException | DaoException e) {
            throw new ServiceException(e);
        }
    }
}
