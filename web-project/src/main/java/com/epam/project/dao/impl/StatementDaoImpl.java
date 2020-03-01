package com.epam.project.dao.impl;

import com.epam.project.mapper.StatementRowMapper;
import com.epam.project.dao.AbstractDao;
import com.epam.project.dao.api.StatementDao;
import com.epam.project.entity.Statement;
import com.epam.project.exceptions.DaoException;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class StatementDaoImpl extends AbstractDao<Statement> implements StatementDao {
    public static final String TABLE = "statements";
    private static final String QUERY_FIND_BY_USER_ID = "SELECT * FROM statements WHERE users_user_id = ?";
    private static final String QUERY_TO_CREATE_NEW_STATEMENT = "insert into statements" +
            " (date,is_registered,faculties_faculty_id,users_user_id) values (?,?,?,?);";
    private static final String QUERY_TO_DELETE_STATEMENT = " DELETE FROM statements" +
            " WHERE statement_id = ?";
    private static final String QUERY_FIND_STATEMENT_ACCORDING_TO_REGISTRATION_TO_FACULTY =
            "SELECT * FROM statements WHERE is_registered = ?";
    private static final String QUERY_TO_UPDATE_STATEMENT_COLUMN_IS_REGISTERED = " UPDATE statements SET is_registered = ?" +
            " WHERE statement_id = ?";

    public StatementDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected String getTableName() {
        return TABLE;
    }

    @Override
    public Optional<Statement> getById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(Statement item) throws DaoException {
        int isRegisteredToFacultyInt = convertBooleanToTinyInt(item.getIsRegisteredToFaculty());
        updateTable(QUERY_TO_CREATE_NEW_STATEMENT, item.getDate(), isRegisteredToFacultyInt,
                item.getFacultyId(), item.getUserId());
    }

    @Override
    public Optional<Integer> saveAndReturnGeneratedKey(Statement item) throws DaoException {
        int isRegisteredToFacultyInt = convertBooleanToTinyInt(item.getIsRegisteredToFaculty());
        return updateTableWithGeneratedKeys(QUERY_TO_CREATE_NEW_STATEMENT, item.getDate(), isRegisteredToFacultyInt,
                item.getFacultyId(), item.getUserId());
    }

    @Override
    public void removeById(Integer id) throws DaoException {
        updateTable(QUERY_TO_DELETE_STATEMENT, id);
    }

    @Override
    public Optional<Statement> findStatementByUserId(Integer userId) throws DaoException {
        return executeForSingleResult(QUERY_FIND_BY_USER_ID, new StatementRowMapper(), userId);
    }


    @Override
    public List<Statement> getStatementsAccordingToRegistrationToFaculty(boolean isRegistered) throws DaoException {
        int isRegisteredToFacultyInt = convertBooleanToTinyInt(isRegistered);
        return executeQuery(QUERY_FIND_STATEMENT_ACCORDING_TO_REGISTRATION_TO_FACULTY,
                new StatementRowMapper(), isRegisteredToFacultyInt);
    }

    @Override
    public void updateStatementRegistrationByStatementId(Integer statementId, boolean isWorthRegisterToFaculty) throws DaoException {
        int isWorthRegisterToFacultyInt = convertBooleanToTinyInt(isWorthRegisterToFaculty);
        updateTable(QUERY_TO_UPDATE_STATEMENT_COLUMN_IS_REGISTERED, isWorthRegisterToFacultyInt, statementId);
    }

    private int convertBooleanToTinyInt(boolean registration) {
        int registrationInt = 0;
        if (registration) {
            registrationInt = 1;
        }
        return registrationInt;
    }

}
