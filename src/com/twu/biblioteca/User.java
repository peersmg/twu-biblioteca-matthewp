package com.twu.biblioteca;

public class User {
    private String id;
    private String password;

    public User(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public boolean validate(String password){
        return password == this.password;
    }
}
