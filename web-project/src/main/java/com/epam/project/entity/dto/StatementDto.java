package com.epam.project.entity.dto;

import com.epam.project.entity.*;

import java.util.List;
import java.util.Objects;

public class StatementDto implements Identifiable {
    private Integer id;
    private User user;
    private Statement statement;
    private Faculty faculty;
    private List<PointsOnSubject> pointsOnSubjects;
    private List<Subject> subjects;
    private int totalPoints;

    public StatementDto() {
    }

    public StatementDto(User user, Statement statement,
                        Faculty faculty, List<PointsOnSubject> pointsOnSubjects,
                        List<Subject> subjects, int totalPoints, List<Subject> subjects1) {
        this.id = user.getId();
        this.user = user;
        this.statement = statement;
        this.faculty = faculty;
        this.pointsOnSubjects = pointsOnSubjects;
        this.subjects = subjects;
        this.totalPoints = totalPoints;
        this.subjects = subjects1;
    }

    public User getUser() {
        return user;
    }

    public Statement getStatement() {
        return statement;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public List<PointsOnSubject> getPointsOnSubjects() {
        return pointsOnSubjects;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public void setPointsOnSubjects(List<PointsOnSubject> pointsOnSubjects) {
        this.pointsOnSubjects = pointsOnSubjects;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StatementDto)) return false;
        StatementDto that = (StatementDto) o;
        return totalPoints == that.totalPoints &&
                id.equals(that.id) &&
                user.equals(that.user) &&
                statement.equals(that.statement) &&
                faculty.equals(that.faculty) &&
                pointsOnSubjects.equals(that.pointsOnSubjects) &&
                subjects.equals(that.subjects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, statement, faculty, pointsOnSubjects, subjects, totalPoints);
    }

}
