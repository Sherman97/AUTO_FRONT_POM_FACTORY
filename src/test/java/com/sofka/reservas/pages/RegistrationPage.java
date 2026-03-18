package com.sofka.reservas.pages;

import com.sofka.reservas.utils.TestEnvironment;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends PageObject {

    @FindBy(id = "fullName")
    private WebElementFacade fullNameInput;

    @FindBy(id = "email")
    private WebElementFacade corporateEmailInput;

    @FindBy(id = "password")
    private WebElementFacade passwordInput;

    @FindBy(id = "confirmPassword")
    private WebElementFacade confirmPasswordInput;

    @FindBy(id = "termsAccepted")
    private WebElementFacade termsAcceptedCheckbox;

    @FindBy(css = "button[type='submit']")
    private WebElementFacade createAccountButton;

    @FindBy(css = ".error-message")
    private WebElementFacade errorMessage;

    @FindBy(css = ".signup-form-wrapper h2")
    private WebElementFacade registrationTitle;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void openRegistrationForm() {
        openUrl(TestEnvironment.signupUrl());
        waitFor(registrationTitle);
    }

    public void resetSessionState() {
        evaluateJavascript("window.localStorage.clear();");
        evaluateJavascript("window.sessionStorage.clear();");
        getDriver().manage().deleteAllCookies();
    }

    public void enterFullName(String fullName) {
        typeInto(fullNameInput, fullName);
    }

    public void enterCorporateEmail(String corporateEmail) {
        typeInto(corporateEmailInput, corporateEmail);
    }

    public void enterPassword(String password) {
        typeInto(passwordInput, password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        typeInto(confirmPasswordInput, confirmPassword);
    }

    public void acceptTerms() {
        if (!termsAcceptedCheckbox.isSelected()) {
            termsAcceptedCheckbox.click();
        }
    }

    public void submitRegistration() {
        createAccountButton.click();
    }

    public String getValidationErrorMessage() {
        waitFor(errorMessage);
        return errorMessage.getText().trim();
    }

    public boolean isRegistrationFormVisible() {
        return registrationTitle.isVisible();
    }

    public String currentPath() {
        return getDriver().getCurrentUrl();
    }
}
