package com.example.SpringMongoProject.Controller;

public class LoginRequest {
    private String phoneNumber;
    private String password;

    // Getters and setters
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Constructor không tham số (yêu cầu cho deserialization)
    public LoginRequest() {
    }

    // Constructor có tham số (tùy chọn)
    public LoginRequest(String phoneNumber, String password) {
        this.phoneNumber = phoneNumber;
        this.password = password;
    }
}
