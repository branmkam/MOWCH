package com.example.mowch;

public class Account {
    protected String name;
    protected int number;
    protected String username;
    protected String email;
    protected String password;

    public Account(String name, int number, String username, String email, String password) {
        this.name = name;
        this.number = number;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    //change access modifiers of all methods, be cognizant of who is able to see what.
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
