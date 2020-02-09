package com.epam.project.dao.interfaces;

import com.epam.project.entity.RequiredSubject;
import com.epam.project.exceptions.DaoException;

import java.util.List;
import java.util.Optional;

public interface RequiredSubjectDao extends Dao<RequiredSubject> {
    List<RequiredSubject> findSubjectIdByFacultyId(Integer facultyId) throws DaoException;
}
