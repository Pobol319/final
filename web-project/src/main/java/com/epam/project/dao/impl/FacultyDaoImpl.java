package com.epam.project.dao.impl;

import com.epam.project.mapper.FacultyRowMapper;
import com.epam.project.dao.AbstractDao;
import com.epam.project.dao.api.FacultyDao;
import com.epam.project.entity.Faculty;
import com.epam.project.exceptions.DaoException;

import java.sql.Connection;
import java.util.Optional;

public class FacultyDaoImpl extends AbstractDao<Faculty> implements FacultyDao {
    public static final String TABLE = "faculties";
    private static final String QUERY_FIND_BY_ID = "SELECT * FROM faculties WHERE faculty_id = ?";

    public FacultyDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public Optional<Faculty> getById(Integer id) throws DaoException {
        return executeForSingleResult(QUERY_FIND_BY_ID,new FacultyRowMapper(),id);
    }

    @Override
    public void save(Faculty item) {

    }

    @Override
    public void removeById(Integer id) {

    }

    @Override
    protected String getTableName() {
        return TABLE;
    }
}
