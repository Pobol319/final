package com.epam.project.entity;

import java.util.Date;
import java.util.Objects;

public class Statement implements Identifiable {
    public static final String TABLE = "statements";
    public static final String ID_COLUMN = "statement_id";
    public static final String DATE_COLUMN = "date";
    public static final String IS_REGISTERED_COLUMN = "is_registered";
    public static final String FACULTIES_ID_COLUMN = "faculties_faculty_id";
    public static final String USER_ID_COLUMN = "users_user_id";

    private Integer id;
    private Date date;
    private boolean isRegisteredToFaculty;
    private Integer userId;
    private Integer facultyId;

    public Statement(){};

    public Statement(Integer id, Date date, boolean isRegisteredToFaculty, Integer userId, Integer facultyId) {
        this.id = id;
        this.date = date;
        this.isRegisteredToFaculty = isRegisteredToFaculty;
        this.userId = userId;
        this.facultyId = facultyId;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Integer getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean getIsRegisteredToFaculty(){
        return isRegisteredToFaculty;
    }

    public void setIsRegisteredToFaculty(boolean isRegisteredToFaculty){
        this.isRegisteredToFaculty = isRegisteredToFaculty;
    }

    @Override
    public String toString() {
        return "Statement{" +
                "id=" + id +
                ", date=" + date +
                ", userId='" + userId + '\'' +
                ", facultyId='" + facultyId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Statement)) return false;
        Statement statement = (Statement) o;
        return isRegisteredToFaculty == statement.isRegisteredToFaculty &&
                Objects.equals(id, statement.id) &&
                Objects.equals(date, statement.date) &&
                Objects.equals(userId, statement.userId) &&
                Objects.equals(facultyId, statement.facultyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, isRegisteredToFaculty, userId, facultyId);
    }

}
