package com.epam.project.dao.impl;

import com.epam.project.mapper.UserRowMapper;
import com.epam.project.dao.AbstractDao;
import com.epam.project.dao.api.UserDao;
import com.epam.project.entity.User;
import com.epam.project.exceptions.DaoException;

import java.sql.Connection;
import java.util.Optional;


public class UserDaoImpl extends AbstractDao<User> implements UserDao {
    private static final String TABLE = "users";
    private static final String QUERY_FIND_BY_ID = "SELECT * FROM users WHERE user_id = ?";
    private static final String QUERY_FIND_BY_LOGIN_PASSWORD = "SELECT * FROM users WHERE login = ? AND password = ?";
    private static final String QUERY_FIND_BY_LOGIN = "SELECT * FROM users WHERE login = ?";
    private static final String QUERY_CREATE_NEW_USER = "insert into users (first_name,second_name,login,password,role) values (?,?,?,?,?)";

    public UserDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public Optional<User> findUserByLoginAndPassword(String login, String password) throws DaoException {
        return executeForSingleResult(QUERY_FIND_BY_LOGIN_PASSWORD, new UserRowMapper(), login, password);
    }

    @Override
    public Optional<User> findByLogin(String login) throws DaoException {
        return executeForSingleResult(QUERY_FIND_BY_LOGIN, new UserRowMapper(), login);
    }

    @Override
    public Optional<User> getById(Integer id) throws DaoException {
        return executeForSingleResult(QUERY_FIND_BY_ID, new UserRowMapper(), id);
    }

    @Override
    protected String getTableName() {
        return TABLE;
    }

    @Override
    public void save(User item) throws DaoException {
        updateTable(QUERY_CREATE_NEW_USER, item.getFirstName(), item.getSecondName(), item.getLogin(), item.getPassword(), item.getRole());
    }

    @Override
    public void removeById(Integer id) {

    }
}
