package com.epam.project.dao.api;

import com.epam.project.entity.RequiredSubject;
import com.epam.project.exceptions.DaoException;

import java.util.List;

public interface RequiredSubjectDao extends Dao<RequiredSubject> {
    List<RequiredSubject> findSubjectIdByFacultyId(Integer facultyId) throws DaoException;
}
