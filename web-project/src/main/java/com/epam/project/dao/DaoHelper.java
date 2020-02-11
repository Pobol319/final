package com.epam.project.dao;

import com.epam.project.connection.ConnectionPool;
import com.epam.project.connection.ProxyConnection;
import com.epam.project.dao.impl.*;
import com.epam.project.dao.api.*;
import com.epam.project.exceptions.ConnectionPoolException;
import com.epam.project.exceptions.DaoException;

import java.sql.SQLException;

public class DaoHelper implements AutoCloseable {
    private ProxyConnection connection;

    public DaoHelper(ConnectionPool pool) throws ConnectionPoolException {
        this.connection = pool.getConnection();
    }

    public UserDao createUserDao() {
        return new UserDaoImpl(connection);
    }

    public FacultyDao createFacultyDao() {
        return new FacultyDaoImpl(connection);
    }

    public PointsOnSubjectDao createPointsOnSubjectDao() {
        return new PointsOnSubjectDaoImpl(connection);
    }

    public RequiredSubjectDao createRequiredSubjectDao() {
        return new RequiredSubjectDaoImpl(connection);
    }

    public StatementDao createStatementDao() {
        return new StatementDaoImpl(connection);
    }

    public SubjectDao createSubjectDao() {
        return new SubjectDaoImpl(connection);
    }

    @Override
    public void close() {
        connection.close();
    }

    public void startTransaction() throws DaoException {
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public void finishTransaction() throws DaoException {
        try {
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public void commitTransaction() throws DaoException {
        try {
            connection.commit();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public void rollBackTransaction() throws DaoException {
        try {
            connection.rollback();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
