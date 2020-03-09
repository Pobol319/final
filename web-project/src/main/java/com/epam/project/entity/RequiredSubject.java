package com.epam.project.entity;

import java.util.Objects;

public class RequiredSubject implements Identifiable {
    public static final String TABLE = "required_subjects";
    public static final String ID_COLUMN = "required_subject_id";
    public static final String FACULTIES_ID_COLUMN = "faculties_faculty_id";
    public static final String SUBJECT_ID_COLUMN = "subjects_subject_id";

    private Integer id;
    private Integer facultyId;
    private Integer subjectId;

    public RequiredSubject(Integer id, Integer facultyId, Integer subjectId) {
        this.id = id;
        this.facultyId = facultyId;
        this.subjectId = subjectId;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer userId) {
        this.subjectId = userId;
    }

    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(Integer facultyId) {
        this.facultyId = facultyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RequiredSubject)) return false;
        RequiredSubject that = (RequiredSubject) o;
        return id.equals(that.id) &&
                facultyId.equals(that.facultyId) &&
                subjectId.equals(that.subjectId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, facultyId, subjectId);
    }

    @Override
    public String toString(){
        return "RequiredSubject{" +
                "id = " + id +
                ", facultyId = " + facultyId +
                ", subjectId = " + subjectId +
                "}";
    }

}
