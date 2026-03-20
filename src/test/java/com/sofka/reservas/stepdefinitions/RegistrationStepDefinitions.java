package com.sofka.reservas.stepdefinitions;

import com.sofka.reservas.model.CollaboratorData;
import com.sofka.reservas.pages.DashboardHomePage;
import com.sofka.reservas.pages.RegistrationPage;
import com.sofka.reservas.questions.TheDashboardAccess;
import com.sofka.reservas.questions.TheRegistrationErrorMessage;
import com.sofka.reservas.tasks.AttemptRegistrationWithInvalidCorporateEmail;
import com.sofka.reservas.tasks.OpenTheRegistrationForm;
import com.sofka.reservas.tasks.RegisterCollaborator;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.WebDriver;

import java.text.Normalizer;
import java.util.Locale;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegistrationStepDefinitions {

    @Managed(driver = "chrome")
    private WebDriver browser;

    private Actor collaborator;
    private RegistrationPage registrationPage;
    private DashboardHomePage dashboardHomePage;
    private CollaboratorData validCollaborator;
    private CollaboratorData collaboratorWithInvalidCorporateEmail;

    @Before
    public void prepareScenario() {
        OnStage.setTheStage(new OnlineCast());
        collaborator = OnStage.theActorCalled("Colaborador no registrado");
        registrationPage = new RegistrationPage(browser);
        dashboardHomePage = new DashboardHomePage(browser);
        validCollaborator = new CollaboratorData(
            "Colaborador Automatizado",
            "colaborador." + System.currentTimeMillis() + "@sofka.com.co",
            "Clave123",
            "Clave123"
        );
        collaboratorWithInvalidCorporateEmail = new CollaboratorData(
            "Colaborador Correo Invalido",
            "colaborador@gmail.com",
            "Clave123",
            "Clave123"
        );
    }

    @Dado("un colaborador no registrado requiere una cuenta de acceso")
    public void unColaboradorNoRegistradoRequiereUnaCuentaDeAcceso() {
        collaborator.attemptsTo(OpenTheRegistrationForm.in(registrationPage));
        assertTrue(registrationPage.isRegistrationFormVisible());
    }

    @Cuando("diligencia correctamente la informacion requerida para el registro")
    public void diligenciaCorrectamenteLaInformacionRequeridaParaElRegistro() {
        collaborator.attemptsTo(RegisterCollaborator.withValidInformation(validCollaborator, registrationPage));
    }

    @Entonces("la cuenta del colaborador es creada correctamente")
    public void laCuentaDelColaboradorEsCreadaCorrectamente() {
        collaborator.should(seeThat(TheDashboardAccess.isAvailable(dashboardHomePage), equalTo(true)));
    }

    @Y("el colaborador accede exitosamente a la plataforma")
    public void elColaboradorAccedeExitosamenteALaPlataforma() {
        assertTrue(dashboardHomePage.currentPath().contains("/dashboard"));
    }

    @Cuando("diligencia la informacion requerida para el registro utilizando un correo corporativo invalido")
    public void diligenciaLaInformacionRequeridaParaElRegistroUtilizandoUnCorreoCorporativoInvalido() {
        collaborator.attemptsTo(
            AttemptRegistrationWithInvalidCorporateEmail.using(
                collaboratorWithInvalidCorporateEmail,
                registrationPage
            )
        );
    }

    @Entonces("la cuenta del colaborador no es creada")
    public void laCuentaDelColaboradorNoEsCreada() {
        assertTrue(registrationPage.currentPath().contains("/signup"));
    }

    @Y("el sistema informa que el correo corporativo no cumple con el formato valido")
    public void elSistemaInformaQueElCorreoCorporativoNoCumpleConElFormatoValido() {
        String rawMessage = TheRegistrationErrorMessage.displayedIn(registrationPage).answeredBy(collaborator);
        assertEquals(
            "el correo corporativo no cumple con el formato valido",
            normalizeWithoutAccents(rawMessage)
        );
    }

    private String normalizeWithoutAccents(String input) {
        String normalized = Normalizer.normalize(input == null ? "" : input, Normalizer.Form.NFD);
        return normalized
            .replaceAll("\\p{M}", "")
            .toLowerCase(Locale.ROOT)
            .trim();
    }
}
