package com.epam.project.connection;


import com.epam.project.exceptions.ConnectionFactoryException;
import com.epam.project.exceptions.PropertyReaderException;
import com.epam.project.property.PropertyReader;
import com.mysql.cj.jdbc.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String DATABASE_PROPERTIES_PATH = "database.properties";
    private static final String URL_PROPERTY = "dbURrl";
    private static final String USER_PROPERTY = "user";
    private static final String PASSWORD_PROPERTY = "password";
    private static final String MAX_POOL_SIZE_PROPERTY = "maxPoolSize";

    private static String url;
    private static String user;
    private static String password;
    private static String maxPoolSize;


    public static Connection create() throws ConnectionFactoryException {
        Connection connection;
        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new ConnectionFactoryException("Error with creation of connection", e);
        }
        return connection;
    }

    public static void readProperties() throws ConnectionFactoryException {
        try {
            PropertyReader propertyReader = new PropertyReader(DATABASE_PROPERTIES_PATH);
            url = propertyReader.read(URL_PROPERTY);
            user = propertyReader.read(USER_PROPERTY);
            password = propertyReader.read(PASSWORD_PROPERTY);
            maxPoolSize = propertyReader.read(MAX_POOL_SIZE_PROPERTY);
        } catch (PropertyReaderException e) {
            throw new ConnectionFactoryException("Error with creation of connection", e);
        }
    }

    public static int getMaxPoolSize() {
        return Integer.parseInt(maxPoolSize);
    }
}
