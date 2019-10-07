package com.learn.storage.model;

public class User {

    private int id;
    private String firstName, lastName;
    private String Title;

    public User(String firstName, String lastName, String title) {
        this.firstName = firstName;
        this.lastName = lastName;
        Title = title;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
