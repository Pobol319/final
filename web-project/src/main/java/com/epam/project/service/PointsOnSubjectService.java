package com.epam.project.service;

import com.epam.project.dao.DaoHelper;
import com.epam.project.dao.DaoHelperFactory;
import com.epam.project.dao.api.PointsOnSubjectDao;
import com.epam.project.entity.PointsOnSubject;
import com.epam.project.exceptions.ConnectionPoolException;
import com.epam.project.exceptions.DaoException;
import com.epam.project.exceptions.ServiceException;

import java.util.List;

public class PointsOnSubjectService {
    private DaoHelperFactory daoHelperFactory;

    public PointsOnSubjectService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public List<PointsOnSubject> getPointsOnSubjectByStatementId(Integer statementId) throws ServiceException {
        try (DaoHelper factory = daoHelperFactory.create()) {
            PointsOnSubjectDao pointsOnSubjectDao = factory.createPointsOnSubjectDao();
            return pointsOnSubjectDao.getPointsOnSubjectByStatementId(statementId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
