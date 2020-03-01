package com.epam.project.service;

import com.epam.project.dao.DaoHelper;
import com.epam.project.dao.DaoHelperFactory;
import com.epam.project.dao.api.PointsOnSubjectDao;
import com.epam.project.dao.api.StatementDao;
import com.epam.project.entity.PointsOnSubject;
import com.epam.project.entity.Statement;
import com.epam.project.entity.Subject;
import com.epam.project.entity.User;
import com.epam.project.entity.dto.FacultyDto;
import com.epam.project.exceptions.ConnectionPoolException;
import com.epam.project.exceptions.DaoException;
import com.epam.project.exceptions.ServiceException;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class StatementService {
    private DaoHelperFactory daoHelperFactory;

    public StatementService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public boolean doesUserHaveStatement(Integer userId) throws ServiceException {
        Optional<Statement> statement = getStatementByUserId(userId);
        return statement.isPresent();
    }

    public void updateStatementRegistrationByStatementId(Integer statementId, boolean isWorthRegisterToFaculty)
            throws ServiceException {
        try (DaoHelper factory = daoHelperFactory.create()) {
            StatementDao statementDao = factory.createStatementDao();
            statementDao.updateStatementRegistrationByStatementId(statementId, isWorthRegisterToFaculty);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public Optional<Statement> getStatementByUserId(Integer userId) throws ServiceException {
        try (DaoHelper factory = daoHelperFactory.create()) {
            StatementDao statementDao = factory.createStatementDao();
            return statementDao.findStatementByUserId(userId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }


    public List<Statement> getStatementsAccordingToRegistrationToFaculty(boolean isRegistered) throws ServiceException {
        try (DaoHelper factory = daoHelperFactory.create()) {
            StatementDao statementDao = factory.createStatementDao();
            return statementDao.getStatementsAccordingToRegistrationToFaculty(isRegistered);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public void createStatementAndPointsOnSubjects(User user, FacultyDto facultyDto, List<Integer> points)
            throws ServiceException {
        try (DaoHelper factory = daoHelperFactory.create()) {
            factory.startTransaction();
            try {
                StatementDao statementDao = factory.createStatementDao();
                PointsOnSubjectDao pointsOnSubjectDao = factory.createPointsOnSubjectDao();

                Integer userId = user.getId();
                Integer facultyId = facultyDto.getFaculty().getId();
                Optional<Integer> statementIdOptional = createStatement(userId, facultyId, statementDao);
                Integer statementId;
                if (statementIdOptional.isPresent()) {
                    statementId = statementIdOptional.get();
                } else {
                    throw new DaoException();
                }

                List<Subject> subjects = facultyDto.getSubjects();
                for (int i = 0; i < points.size(); i++) {
                    Integer subjectId = subjects.get(i).getId();
                    createPointsOnSubject(points.get(i), subjectId, statementId, pointsOnSubjectDao);
                }
                factory.commitTransaction();
            } catch (DaoException e) {
                factory.rollBackTransaction();
                throw new DaoException();
            } finally {
                factory.finishTransaction();
            }
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public void deleteStatementAndPointsOnSubjects(Integer statementId)
            throws ServiceException {
        try (DaoHelper factory = daoHelperFactory.create()) {
            factory.startTransaction();
            try {
                StatementDao statementDao = factory.createStatementDao();
                PointsOnSubjectDao pointsOnSubjectDao = factory.createPointsOnSubjectDao();

                List<PointsOnSubject> pointsOnSubjects = pointsOnSubjectDao.getPointsOnSubjectByStatementId(statementId);
                statementDao.removeById(statementId);
                for (PointsOnSubject pointsOnSubject : pointsOnSubjects) {
                    Integer pointsId = pointsOnSubject.getId();
                    pointsOnSubjectDao.removeById(pointsId);
                }
                factory.commitTransaction();
            } catch (DaoException e) {
                factory.rollBackTransaction();
                throw new DaoException();
            } finally {
                factory.finishTransaction();
            }
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    private Optional<Integer> createStatement(Integer userId, Integer facultyId, StatementDao statementDao)
            throws DaoException {
        Date date = new Date();
        Statement statement = new Statement();
        statement.setDate(date);
        statement.setIsRegisteredToFaculty(false);
        statement.setUserId(userId);
        statement.setFacultyId(facultyId);
        return statementDao.saveAndReturnGeneratedKey(statement);
    }

    private void createPointsOnSubject(int numberOfPoints, Integer subjectId, Integer
            statementId, PointsOnSubjectDao pointsOnSubjectDao)
            throws DaoException {
        PointsOnSubject pointsOnSubject = new PointsOnSubject();
        pointsOnSubject.setNumberOfPoints(numberOfPoints);
        pointsOnSubject.setSubjectId(subjectId);
        pointsOnSubject.setStatementId(statementId);

        pointsOnSubjectDao.save(pointsOnSubject);
    }


}
