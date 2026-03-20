package com.sofka.reservas.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import java.time.Duration;

public class DashboardHomePage extends PageObject {

    public DashboardHomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isVisible() {
        waitForCondition()
            .withTimeout(Duration.ofSeconds(30))
            .until(driver -> currentPath().contains("/dashboard"));
        return currentPath().contains("/dashboard");
    }

    public String currentPath() {
        return getDriver().getCurrentUrl();
    }

    public boolean hasAuthenticatedSession() {
        waitForCondition().until(driver -> hasStoredValue("token") && hasStoredValue("user"));
        return hasStoredValue("token") && hasStoredValue("user");
    }

    private boolean hasStoredValue(String key) {
        Object value = evaluateJavascript("return window.localStorage.getItem(arguments[0]);", key);
        return value != null
            && !"null".equals(String.valueOf(value))
            && !String.valueOf(value).isBlank();
    }
}
