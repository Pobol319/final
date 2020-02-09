package com.epam.project.dao;

import com.epam.project.connection.ConnectionPool;
import com.epam.project.exceptions.ConnectionFactoryException;
import com.epam.project.exceptions.ConnectionPoolException;


public class DaoHelperFactory  {
    public DaoHelper create() throws ConnectionPoolException {
        return new DaoHelper(ConnectionPool.getInstance());
    }
}
