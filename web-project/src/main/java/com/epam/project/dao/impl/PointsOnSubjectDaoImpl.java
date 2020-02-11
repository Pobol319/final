package com.epam.project.dao.impl;

import com.epam.project.mapper.PointsOnSubjectRowMapper;
import com.epam.project.dao.AbstractDao;
import com.epam.project.dao.api.PointsOnSubjectDao;
import com.epam.project.entity.PointsOnSubject;
import com.epam.project.exceptions.DaoException;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class PointsOnSubjectDaoImpl extends AbstractDao<PointsOnSubject> implements PointsOnSubjectDao {
    public static final String TABLE = "points_on_subjects";
    private static final String QUERY_FIND_MAX_ID = "Select * from points_on_subjects\n" +
            "WHERE  points_on_subject_id=(SELECT MAX(points_on_subject_id) FROM points_on_subjects)";
    private static final String QUERY_TO_CREATE_NEW_POINTS_ON_SUBJECT = "insert into points_on_subjects" +
            " (number_of_points,statements_statement_id,subjects_subject_id) values (?,?,?);";
    private static final String QUERY_FIND_BY_STATEMENT_ID = "SELECT * FROM points_on_subjects WHERE statements_statement_id = ?";
    private static final String QUERY_TO_DELETE_POINTS_ON_SUBJECT = " DELETE FROM points_on_subjects" +
            " WHERE points_on_subject_id = ?";

    public PointsOnSubjectDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected String getTableName() {
        return TABLE;
    }

    @Override
    public Optional<PointsOnSubject> getById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(PointsOnSubject item) throws DaoException {
        updateTable(QUERY_TO_CREATE_NEW_POINTS_ON_SUBJECT, item.getNumberOfPoints(), item.getStatementId(),
                item.getSubjectId());
    }

    @Override
    public void removeById(Integer id) throws DaoException {
        updateTable(QUERY_TO_DELETE_POINTS_ON_SUBJECT, id);
    }

    @Override
    public List<PointsOnSubject> getPointsOnSubjectByStatementId(Integer statementId) throws DaoException {
        return executeQuery(QUERY_FIND_BY_STATEMENT_ID, new PointsOnSubjectRowMapper(), statementId);
    }
}
