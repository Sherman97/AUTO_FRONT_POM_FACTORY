package com.sofka.reservas.stepdefinitions;

import com.sofka.reservas.steps.AdminReservationsSteps;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.thucydides.core.annotations.Steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AdminReservationsStepDefinitions {

    @Steps
    private AdminReservationsSteps adminSteps;

    @Dado("que el usuario administrador ingresa al modulo de reservas")
    public void queElUsuarioAdministradorIngresaAlModuloDeReservas() {
        adminSteps.authenticateAsAdmin();
        assertThat(adminSteps.shouldSeeAdminReservationsPage(), is(true));
    }

    @Cuando("aplica filtros de consulta por fecha estado sede y usuario")
    public void aplicaFiltrosDeConsultaPorFechaEstadoSedeYUsuario() {
        adminSteps.applyFilters("", "Finalizada", "2", "33");
    }

    @Entonces("visualiza los resultados filtrados en la tabla")
    public void visualizaLosResultadosFiltradosEnLaTabla() {
        assertThat(adminSteps.shouldSeeRows(), is(true));
    }

    @Cuando("abre el detalle de una reserva existente")
    public void abreElDetalleDeUnaReservaExistente() {
        adminSteps.openFirstReservationDetail();
    }

    @Entonces("el sistema muestra la informacion de detalle")
    public void elSistemaMuestraLaInformacionDeDetalle() {
        assertThat(adminSteps.shouldSeeDetailModal(), is(true));
    }

    @Cuando("navega a la siguiente pagina del listado de reservas")
    public void navegaALaSiguientePaginaDelListadoDeReservas() {
        adminSteps.goToNextPage();
    }

    @Entonces("el listado mantiene la paginacion activa")
    public void elListadoMantieneLaPaginacionActiva() {
        assertThat(adminSteps.shouldSeePagination(), is(true));
    }

    @Cuando("aplica una combinacion de filtros sin coincidencias")
    public void aplicaUnaCombinacionDeFiltrosSinCoincidencias() {
        adminSteps.applyFilters("", "Finalizada", "2", "33");
    }

    @Entonces("el sistema informa que no hay resultados")
    public void elSistemaInformaQueNoHayResultados() {
        assertThat(adminSteps.shouldSeeNoResults(), is(true));
    }
}
