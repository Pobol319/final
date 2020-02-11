package com.epam.project.dao.api;

import com.epam.project.entity.Statement;
import com.epam.project.exceptions.DaoException;

import java.util.List;
import java.util.Optional;

public interface StatementDao extends Dao<Statement> {
    Optional<Statement> findStatementByUserId(Integer userId) throws DaoException;
    List<Statement> getStatementsAccordingToRegistrationToFaculty(boolean isRegistered) throws DaoException;
    void updateStatementRegistrationByStatementId(Integer statementId, boolean isWorthRegisterToFaculty) throws DaoException;
}
