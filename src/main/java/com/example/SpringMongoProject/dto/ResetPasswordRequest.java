package com.example.SpringMongoProject.dto;

public class ResetPasswordRequest {
    private String phoneNumber;
    private String resetCode;
    private String newPassword;

    // Getters and setters
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getResetCode() {
        return resetCode;
    }

    public void setResetCode(String resetCode) {
        this.resetCode = resetCode;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    // Constructor không tham số
    public ResetPasswordRequest() {
    }

    // Constructor có tham số
    public ResetPasswordRequest(String phoneNumber, String resetCode, String newPassword) {
        this.phoneNumber = phoneNumber;
        this.resetCode = resetCode;
        this.newPassword = newPassword;
    }
}