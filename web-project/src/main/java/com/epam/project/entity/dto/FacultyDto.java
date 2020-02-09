package com.epam.project.entity.dto;

import com.epam.project.entity.Faculty;
import com.epam.project.entity.Identifiable;
import com.epam.project.entity.Subject;

import java.util.List;
import java.util.Objects;

public class FacultyDto implements Identifiable {
    private Integer id;
    private Faculty faculty;
    private List<Subject> subjects;

    public FacultyDto(){}

    public FacultyDto(Faculty faculty, List<Subject> subjects) {
        this.id = faculty.getId();
        this.faculty = faculty;
        this.subjects = subjects;
    }


    @Override
    public Integer getId() {
        return id;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FacultyDto)) return false;
        FacultyDto that = (FacultyDto) o;
        return id.equals(that.id) &&
                faculty.equals(that.faculty) &&
                subjects.equals(that.subjects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, faculty, subjects);
    }
}
