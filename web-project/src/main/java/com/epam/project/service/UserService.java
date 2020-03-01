package com.epam.project.service;

import com.epam.project.dao.DaoHelper;
import com.epam.project.dao.DaoHelperFactory;
import com.epam.project.dao.api.UserDao;
import com.epam.project.entity.User;
import com.epam.project.entity.UserRoleEnum;
import com.epam.project.exceptions.ConnectionPoolException;
import com.epam.project.exceptions.DaoException;
import com.epam.project.exceptions.ServiceException;


import java.util.Optional;

public class UserService {
    private DaoHelperFactory daoHelperFactory;

    public UserService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public Optional<User> login(String login, String password) throws ServiceException {
        try (DaoHelper factory = daoHelperFactory.create()) {
            UserDao userDao = factory.createUserDao();
            return userDao.findUserByLoginAndPassword(login, password);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public Optional<User> getUserById(Integer userId) throws ServiceException {
        try (DaoHelper factory = daoHelperFactory.create()) {
            UserDao userDao = factory.createUserDao();
            return userDao.getById(userId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public boolean isLoginUnique(String login) throws ServiceException {
        try (DaoHelper factory = daoHelperFactory.create()) {
            UserDao userDao = factory.createUserDao();
            Optional<User> user = userDao.findByLogin(login);
            return !user.isPresent();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public void save(String firstName, String secondName, String login, String password, UserRoleEnum role) throws ServiceException {
        try (DaoHelper factory = daoHelperFactory.create()) {
            UserDao userDao = factory.createUserDao();
            User user = new User();
            user.setFirstName(firstName);
            user.setSecondName(secondName);
            user.setLogin(login);
            user.setPassword(password);
            user.setRole(role);
            userDao.save(user);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}