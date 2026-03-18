package com.sofka.reservas.tasks;

import com.sofka.reservas.pages.RegistrationPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class OpenTheRegistrationForm implements Task {

    private final RegistrationPage registrationPage;

    public OpenTheRegistrationForm(RegistrationPage registrationPage) {
        this.registrationPage = registrationPage;
    }

    public static OpenTheRegistrationForm in(RegistrationPage registrationPage) {
        return Tasks.instrumented(OpenTheRegistrationForm.class, registrationPage);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        registrationPage.openRegistrationForm();
        registrationPage.resetSessionState();
        registrationPage.openRegistrationForm();
    }
}

