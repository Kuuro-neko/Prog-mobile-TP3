package com.example.prog_mobile_tp3;

import androidx.annotation.NonNull;

public class User {
    /*
    private static final String TABLE_NAME = "users";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_LOGIN = "login";
    private static final String COLUMN_PASSWORD = "password";
    private static final String COLUMN_LASTNAME = "lastname";
    private static final String COLUMN_FIRSTNAME = "firstname";
    private static final String COLUMN_BIRTHDATE = "birthdate";
    private static final String COLUMN_PHONE = "phone";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_INTERESTS = "interests";
     */
    private int id;
    private String login;
    private String password;
    private String lastname;
    private String firstname;
    private String birthdate;
    private String phone;
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    private String interests;

    public User(int id, String login, String password, String lastname, String firstname, String birthdate, String phone, String email, String interests) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.lastname = lastname;
        this.firstname = firstname;
        this.birthdate = birthdate;
        this.phone = phone;
        this.email = email;
        this.interests = interests;
    }

    public User() {}

    @NonNull
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", interests='" + interests + '\'' +
                '}';
    }
}
