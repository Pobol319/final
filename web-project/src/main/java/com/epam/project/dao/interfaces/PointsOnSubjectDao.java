package com.epam.project.dao.interfaces;

import com.epam.project.entity.PointsOnSubject;
import com.epam.project.exceptions.DaoException;

import java.util.List;
import java.util.Optional;

public interface PointsOnSubjectDao extends Dao<PointsOnSubject> {
    List<PointsOnSubject> getPointsOnSubjectByStatementId(Integer statementId) throws DaoException;
}
