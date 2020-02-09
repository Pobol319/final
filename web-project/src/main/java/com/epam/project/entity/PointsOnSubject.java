package com.epam.project.entity;

public class PointsOnSubject implements Identifiable {
    public static final String TABLE = "points_on_subjects";
    public static final String ID_COLUMN = "points_on_subject_id";
    public static final String NUMBER_OF_POINTS_COLUMN = "number_of_points";
    public static final String STATEMENTS_ID_COLUMN = "statements_statement_id";
    public static final String SUBJECT_ID_COLUMN = "subjects_subject_id";

    private Integer id;
    private int numberOfPoints;
    private Integer subjectId;
    private Integer statementId;

    public PointsOnSubject() {
    }

    public PointsOnSubject(Integer id, int numberOfPoints, Integer subjectId, Integer statementId) {
        this.id = id;
        this.numberOfPoints = numberOfPoints;
        this.subjectId = subjectId;
        this.statementId = statementId;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public int getNumberOfPoints() {
        return numberOfPoints;
    }

    public void setNumberOfPoints(int numberOfPoints) {
        this.numberOfPoints = numberOfPoints;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getStatementId() {
        return statementId;
    }

    public void setStatementId(int statementId) {
        this.statementId = statementId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if ((!(o instanceof PointsOnSubject))) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        PointsOnSubject pointsOnSubject = (PointsOnSubject) o;

        if (!id.equals(pointsOnSubject.id)) {
            return false;
        }
        if (numberOfPoints != pointsOnSubject.numberOfPoints) {
            return false;
        }
        if (!subjectId.equals(pointsOnSubject.subjectId)) {
            return false;
        }
        return statementId.equals(pointsOnSubject.statementId);
    }

    @Override
    public int hashCode() {
        int result = 31 * id;
        result = 31 * result + numberOfPoints;
        result = 31 * result + subjectId;
        result = 31 * result + statementId;
        return result;
    }

    @Override
    public String toString() {
        return "PointsOnSubject{" +
                "id=" + id +
                ", points=" + numberOfPoints +
                ", subjectNameId=" + subjectId +
                ", statementId=" + statementId +
                '}';
    }

}
