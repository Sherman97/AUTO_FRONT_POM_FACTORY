package com.sofka.reservas.steps;

import com.sofka.reservas.pages.AdminReservationsPage;
import com.sofka.reservas.pages.LoginPage;
import net.thucydides.core.annotations.Step;

public class AdminReservationsSteps {

    private LoginPage loginPage;
    private AdminReservationsPage adminReservationsPage;

    @Step("Autenticar administrador en modulo de reservas")
    public void authenticateAsAdmin() {
        loginPage.openLogin();
        loginPage.loginAsAdmin();
    }

    @Step("Validar que el admin ingreso al modulo de reservas")
    public boolean shouldSeeAdminReservationsPage() {
        return adminReservationsPage.isLoaded();
    }

    @Step("Aplicar filtros de consulta")
    public void applyFilters(String date, String status, String site, String user) {
        adminReservationsPage.applyBasicFilters(date, status, site, user);
    }

    @Step("Limpiar filtros de consulta")
    public void clearFilters() {
        adminReservationsPage.clearFilters();
    }

    @Step("Validar que existen reservas en la tabla")
    public boolean shouldSeeRows() {
        return adminReservationsPage.hasRows();
    }

    @Step("Abrir detalle de la primera reserva")
    public void openFirstReservationDetail() {
        adminReservationsPage.openFirstRowDetail();
    }

    @Step("Validar modal de detalle visible")
    public boolean shouldSeeDetailModal() {
        return adminReservationsPage.detailModalIsVisible();
    }

    @Step("Ir a la siguiente pagina de la tabla")
    public void goToNextPage() {
        adminReservationsPage.goToNextPageIfAvailable();
    }

    @Step("Validar controles de paginacion visibles")
    public boolean shouldSeePagination() {
        return adminReservationsPage.hasPaginationControls();
    }

    @Step("Validar estado sin resultados")
    public boolean shouldSeeNoResults() {
        return adminReservationsPage.hasNoResultsState();
    }
}
