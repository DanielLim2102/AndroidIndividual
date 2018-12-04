package com.example.danie.daniel2;

/**
 * Created by danie on 23/11/2018.
 */

public class User {
    public String email,username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(){

    }

    public User(String email, String username) {
        this.email = email;
        this.username = username;
    }
}
