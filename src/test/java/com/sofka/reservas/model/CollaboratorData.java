package com.sofka.reservas.model;

public class CollaboratorData {

    private final String fullName;
    private final String corporateEmail;
    private final String password;
    private final String confirmPassword;

    public CollaboratorData(String fullName, String corporateEmail, String password, String confirmPassword) {
        this.fullName = fullName;
        this.corporateEmail = corporateEmail;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public String getFullName() {
        return fullName;
    }

    public String getCorporateEmail() {
        return corporateEmail;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }
}

