package com.sofka.reservas.tasks;

import com.sofka.reservas.model.CollaboratorData;
import com.sofka.reservas.pages.RegistrationPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class AttemptRegistrationWithInvalidCorporateEmail implements Task {

    private final CollaboratorData collaboratorData;
    private final RegistrationPage registrationPage;

    public AttemptRegistrationWithInvalidCorporateEmail(
        CollaboratorData collaboratorData,
        RegistrationPage registrationPage
    ) {
        this.collaboratorData = collaboratorData;
        this.registrationPage = registrationPage;
    }

    public static AttemptRegistrationWithInvalidCorporateEmail using(
        CollaboratorData collaboratorData,
        RegistrationPage registrationPage
    ) {
        return Tasks.instrumented(
            AttemptRegistrationWithInvalidCorporateEmail.class,
            collaboratorData,
            registrationPage
        );
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        registrationPage.enterFullName(collaboratorData.getFullName());
        registrationPage.enterCorporateEmail(collaboratorData.getCorporateEmail());
        registrationPage.enterPassword(collaboratorData.getPassword());
        registrationPage.enterConfirmPassword(collaboratorData.getConfirmPassword());
        registrationPage.acceptTerms();
        registrationPage.submitRegistration();
    }
}

