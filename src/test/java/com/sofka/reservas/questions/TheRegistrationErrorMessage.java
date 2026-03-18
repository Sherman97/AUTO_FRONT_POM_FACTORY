package com.sofka.reservas.questions;

import com.sofka.reservas.pages.RegistrationPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TheRegistrationErrorMessage implements Question<String> {

    private final RegistrationPage registrationPage;

    public TheRegistrationErrorMessage(RegistrationPage registrationPage) {
        this.registrationPage = registrationPage;
    }

    public static TheRegistrationErrorMessage displayedIn(RegistrationPage registrationPage) {
        return new TheRegistrationErrorMessage(registrationPage);
    }

    @Override
    public String answeredBy(Actor actor) {
        return registrationPage.getValidationErrorMessage();
    }
}

