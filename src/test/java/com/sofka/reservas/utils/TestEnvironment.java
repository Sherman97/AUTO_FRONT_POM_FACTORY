package com.sofka.reservas.utils;

public final class TestEnvironment {

    public static final String BASE_URL = System.getProperty("webdriver.base.url", "http://localhost:5173");
    public static final String LOGIN_PATH = "/login";
    public static final String ADMIN_PATH = "/admin-reservations";
    private static final String DEFAULT_ADMIN_EMAIL = "prueba.admin@demo.com";
    private static final String DEFAULT_ADMIN_PASSWORD = "admin123";

    private TestEnvironment() {
    }

    public static String loginUrl() {
        return BASE_URL + LOGIN_PATH;
    }

    public static String adminReservationsUrl() {
        return BASE_URL + ADMIN_PATH;
    }

    public static String adminEmail() {
        return System.getProperty("admin.email", DEFAULT_ADMIN_EMAIL);
    }

    public static String adminPassword() {
        return System.getProperty("admin.password", DEFAULT_ADMIN_PASSWORD);
    }
}
