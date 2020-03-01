package com.epam.project.mapper;

import com.epam.project.entity.UserRoleEnum;
import com.epam.project.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {
    @Override
    public User map(ResultSet resultset) throws SQLException {
        Integer id = resultset.getInt(User.ID_COLUMN);
        String firstName = resultset.getString(User.FIRST_NAME_COLUMN);
        String secondName = resultset.getString(User.SECOND_NAME_COLUMN);
        String login = resultset.getString(User.LOGIN_COLUMN);
        String password = resultset.getString(User.PASSWORD_COLUMN);
        String roleString = resultset.getString(User.ROLE_COLUMN);
        UserRoleEnum userRoleEnum = UserRoleEnum.valueOf(roleString);
        return new User(id, firstName, secondName, login, password, userRoleEnum);
    }
}
