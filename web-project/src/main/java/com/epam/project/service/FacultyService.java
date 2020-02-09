package com.epam.project.service;

import com.epam.project.dao.DaoHelper;
import com.epam.project.dao.DaoHelperFactory;
import com.epam.project.dao.interfaces.FacultyDao;
import com.epam.project.dao.interfaces.UserDao;
import com.epam.project.entity.Faculty;
import com.epam.project.entity.User;
import com.epam.project.exceptions.ConnectionPoolException;
import com.epam.project.exceptions.DaoException;
import com.epam.project.exceptions.ServiceException;

import java.util.List;
import java.util.Optional;

public class FacultyService {
    private DaoHelperFactory daoHelperFactory;

    public FacultyService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public List<Faculty> getAllFaculties() throws ServiceException {
        try (DaoHelper factory = daoHelperFactory.create()) {
            FacultyDao facultyDao = factory.createFacultyDao();
            return facultyDao.getAll();
        } catch (ConnectionPoolException | DaoException e) {
            throw new ServiceException(e);
        }
    }

    public Optional<Faculty> getById(Integer id) throws ServiceException {
        try (DaoHelper factory = daoHelperFactory.create()) {
            FacultyDao facultyDao = factory.createFacultyDao();
            return facultyDao.getById(id);
        } catch (ConnectionPoolException | DaoException e) {
            throw new ServiceException(e);
        }
    }
}