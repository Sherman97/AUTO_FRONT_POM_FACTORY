package com.sofka.reservas.pages;

import com.sofka.reservas.utils.TestEnvironment;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {

    @FindBy(id = "email")
    private WebElementFacade emailInput;

    @FindBy(id = "password")
    private WebElementFacade passwordInput;

    @FindBy(css = "button[type='submit']")
    private WebElementFacade loginButton;

    public void openLogin() {
        openUrl(TestEnvironment.loginUrl());
    }

    public void loginAsAdmin() {
        typeInto(emailInput, TestEnvironment.adminEmail());
        typeInto(passwordInput, TestEnvironment.adminPassword());
        loginButton.click();
    }
}
