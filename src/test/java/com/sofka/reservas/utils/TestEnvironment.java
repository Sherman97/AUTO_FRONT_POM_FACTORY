package com.sofka.reservas.utils;

public final class TestEnvironment {

    public static final String BASE_URL = "http://localhost:8080";
    public static final String SIGNUP_PATH = "/signup";

    private TestEnvironment() {
    }

    public static String signupUrl() {
        return BASE_URL + SIGNUP_PATH;
    }
}
