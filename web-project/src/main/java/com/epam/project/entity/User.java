package com.epam.project.entity;

import java.util.Objects;

public class User implements Identifiable {
    public static final String TABLE = "users";
    public static final String ID_COLUMN = "user_id";
    public static final String FIRST_NAME_COLUMN = "first_name";
    public static final String SECOND_NAME_COLUMN = "second_name";
    public static final String LOGIN_COLUMN = "login";
    public static final String PASSWORD_COLUMN = "password";
    public static final String ROLE_COLUMN = "role";

    private Integer id;
    private String firstName;
    private String secondName;
    private String login;
    private String password;
    private UserRoleEnum role;

    public User(){}

    public User(Integer id, String firstName, String secondName, String login, String password, UserRoleEnum role) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRoleEnum getRole() {
        return role;
    }

    public void setRole(UserRoleEnum role) {
        this.role = role;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return id.equals(user.id) &&
                firstName.equals(user.firstName) &&
                secondName.equals(user.secondName) &&
                login.equals(user.login) &&
                password.equals(user.password) &&
                role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, secondName, login, password, role);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", first name='" + firstName + '\'' +
                ", second name='" + secondName + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
