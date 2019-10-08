package com.twu.biblioteca;

public class User {
    private String id;
    private String password;
    private String name;
    private String email;
    private String phoneNumber;

    public User(String id, String password, String name, String email, String phoneNumber) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public boolean validate(String password){
        return password.equals(this.password);
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }
}
