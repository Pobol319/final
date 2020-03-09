package com.epam.project.entity;

import java.util.ArrayList;
import java.util.List;

public class Faculty implements Identifiable {
    public static final String TABLE = "faculties";
    public static final String ID_COLUMN = "faculty_id";
    public static final String MAX_SIZE_COLUMN = "max_size";
    public static final String NAME_COLUMN = "name";

    private Integer id;
    private FacultyEnum name;
    private int maxSize;

    public Faculty(Integer id, FacultyEnum name, int maxSize) {
        this.id = id;
        this.name = name;
        this.maxSize = maxSize;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public FacultyEnum getName() {
        return name;
    }

    public void setName(FacultyEnum name) {
        this.name = name;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", maxSize=" + maxSize +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if ((!(o instanceof Faculty))) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Faculty faculty = (Faculty) o;
        if (!id.equals(faculty.id)) {
            return false;
        }
        if (maxSize != faculty.maxSize) {
            return false;
        }
        return name.equals(faculty.name);
    }

    @Override
    public int hashCode() {
        int result = 31 * id;
        result = 31 * result + name.hashCode();
        result = 31 * result + maxSize;
        return result;
    }

}
