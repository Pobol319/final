package com.epam.project.dao.api;

import com.epam.project.entity.PointsOnSubject;
import com.epam.project.exceptions.DaoException;

import java.util.List;

public interface PointsOnSubjectDao extends Dao<PointsOnSubject> {
    List<PointsOnSubject> getPointsOnSubjectByStatementId(Integer statementId) throws DaoException;
}
