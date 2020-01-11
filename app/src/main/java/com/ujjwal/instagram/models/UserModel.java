package com.ujjwal.instagram.models;

public class UserModel {

    private String userId, username, password, email;
    private int profilePicture;

    public UserModel(String userId, String username, String password, int profilePicture) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.profilePicture = profilePicture;
    }

    public UserModel(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public UserModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(int profilePicture) {
        this.profilePicture = profilePicture;
    }
}
