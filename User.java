package com.ecoquest.models;

public class User {
    private String username;
    private String passwordHash;
    public User(String username, String password) {
        this.username = username;
        this.passwordHash = String.valueOf(password.hashCode());
    }
    public String getUsername() { return username; }
    public boolean checkPassword(String inputPass) {
        return String.valueOf(inputPass.hashCode()).equals(passwordHash);
    }
    public String toCSV() { return username + "," + passwordHash; }
}