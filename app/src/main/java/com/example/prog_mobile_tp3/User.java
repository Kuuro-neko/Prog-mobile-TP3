package com.example.prog_mobile_tp3;

import androidx.annotation.NonNull;

public class User {
    private int id;
    private String login;
    private String password;
    private String lastname;
    private String firstname;
    private String birthdate;
    private String phone;
    private String email;
    private String interests;
    private String planning_8_10;
    private String planning_10_12;
    private String planning_14_16;
    private String planning_16_18;

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

    public String getPlanning_8_10() {
        return planning_8_10;
    }

    public void setPlanning_8_10(String planning_8_10) {
        this.planning_8_10 = planning_8_10;
    }

    public String getPlanning_10_12() {
        return planning_10_12;
    }

    public void setPlanning_10_12(String planning_10_12) {
        this.planning_10_12 = planning_10_12;
    }

    public String getPlanning_14_16() {
        return planning_14_16;
    }

    public void setPlanning_14_16(String planning_14_16) {
        this.planning_14_16 = planning_14_16;
    }

    public String getPlanning_16_18() {
        return planning_16_18;
    }

    public void setPlanning_16_18(String planning_16_18) {
        this.planning_16_18 = planning_16_18;
    }
    public User(int id, String login, String password, String lastname, String firstname, String birthdate, String phone, String email, String interests, String planning_8_10, String planning_10_12, String planning_14_16, String planning_16_18) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.lastname = lastname;
        this.firstname = firstname;
        this.birthdate = birthdate;
        this.phone = phone;
        this.email = email;
        this.interests = interests;
        this.planning_8_10 = planning_8_10;
        this.planning_10_12 = planning_10_12;
        this.planning_14_16 = planning_14_16;
        this.planning_16_18 = planning_16_18;
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
                ", planning_8_10='" + planning_8_10 + '\'' +
                ", planning_10_12='" + planning_10_12 + '\'' +
                ", planning_14_16='" + planning_14_16 + '\'' +
                ", planning_16_18='" + planning_16_18 + '\'' +
                '}';
    }
}
