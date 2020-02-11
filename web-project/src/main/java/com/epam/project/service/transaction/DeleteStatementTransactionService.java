package com.epam.project.service.transaction;

import com.epam.project.dao.DaoHelper;
import com.epam.project.dao.DaoHelperFactory;
import com.epam.project.dao.api.PointsOnSubjectDao;
import com.epam.project.dao.api.StatementDao;
import com.epam.project.entity.PointsOnSubject;
import com.epam.project.exceptions.ConnectionPoolException;
import com.epam.project.exceptions.DaoException;
import com.epam.project.exceptions.ServiceException;

import java.util.List;

public class DeleteStatementTransactionService {
    private DaoHelperFactory daoHelperFactory;

    public DeleteStatementTransactionService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public void deleteStatementAndPointsOnSubjects(Integer statementId)
            throws ServiceException {
        try (DaoHelper factory = daoHelperFactory.create()) {
            factory.startTransaction();
            try {
                StatementDao statementDao = factory.createStatementDao();
                PointsOnSubjectDao pointsOnSubjectDao = factory.createPointsOnSubjectDao();

                List<PointsOnSubject> pointsOnSubjects = pointsOnSubjectDao.getPointsOnSubjectByStatementId(statementId);
                statementDao.removeById(statementId);
                for(PointsOnSubject pointsOnSubject: pointsOnSubjects){
                    Integer pointsId = pointsOnSubject.getId();
                    pointsOnSubjectDao.removeById(pointsId);
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


}
