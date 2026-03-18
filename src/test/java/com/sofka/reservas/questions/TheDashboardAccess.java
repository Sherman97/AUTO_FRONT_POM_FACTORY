package com.sofka.reservas.questions;

import com.sofka.reservas.pages.DashboardHomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TheDashboardAccess implements Question<Boolean> {

    private final DashboardHomePage dashboardHomePage;

    public TheDashboardAccess(DashboardHomePage dashboardHomePage) {
        this.dashboardHomePage = dashboardHomePage;
    }

    public static TheDashboardAccess isAvailable(DashboardHomePage dashboardHomePage) {
        return new TheDashboardAccess(dashboardHomePage);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return dashboardHomePage.isVisible() && dashboardHomePage.hasAuthenticatedSession();
    }
}
