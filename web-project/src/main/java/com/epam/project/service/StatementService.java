package com.epam.project.service;

import com.epam.project.dao.DaoHelper;
import com.epam.project.dao.DaoHelperFactory;
import com.epam.project.dao.interfaces.StatementDao;
import com.epam.project.entity.Statement;
import com.epam.project.exceptions.ConnectionPoolException;
import com.epam.project.exceptions.DaoException;
import com.epam.project.exceptions.ServiceException;

import java.util.List;
import java.util.Optional;

public class StatementService {
    private DaoHelperFactory daoHelperFactory;

    public StatementService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public boolean doesUserHaveStatement(Integer userId) throws ServiceException {
        Optional<Statement> statement = getStatementByUserId(userId);
        return statement.isPresent();
    }

    public void updateStatementRegistrationByStatementId(Integer statementId, boolean isWorthRegisterToFaculty)
            throws ServiceException {
        try (DaoHelper factory = daoHelperFactory.create()) {
            StatementDao statementDao = factory.createStatementDao();
            statementDao.updateStatementRegistrationByStatementId(statementId, isWorthRegisterToFaculty);
        } catch (ConnectionPoolException | DaoException e) {
            throw new ServiceException(e);
        }
    }

    public Optional<Statement> getStatementByUserId(Integer userId) throws ServiceException {
        try (DaoHelper factory = daoHelperFactory.create()) {
            StatementDao statementDao = factory.createStatementDao();
            return statementDao.findStatementByUserId(userId);
        } catch (ConnectionPoolException | DaoException e) {
            throw new ServiceException(e);
        }
    }


    public List<Statement> getStatementsAccordingToRegistrationToFaculty(boolean isRegistered) throws ServiceException {
        try (DaoHelper factory = daoHelperFactory.create()) {
            StatementDao statementDao = factory.createStatementDao();
            return statementDao.getStatementsAccordingToRegistrationToFaculty(isRegistered);
        } catch (ConnectionPoolException | DaoException e) {
            throw new ServiceException(e);
        }
    }


}
