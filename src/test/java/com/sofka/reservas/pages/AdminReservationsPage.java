package com.sofka.reservas.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class AdminReservationsPage extends PageObject {

    @FindBy(css = ".admin-page-header h1")
    private WebElementFacade pageTitle;

    @FindBy(id = "reservation-date")
    private WebElementFacade filterDate;

    @FindBy(id = "reservation-status")
    private WebElementFacade filterStatus;

    @FindBy(id = "reservation-site")
    private WebElementFacade filterSite;

    @FindBy(id = "reservation-user")
    private WebElementFacade filterUser;

    @FindBy(css = ".admin-filter-actions button")
    private List<WebElementFacade> filterButtons;

    @FindBy(css = ".admin-reservations-table tbody tr")
    private List<WebElementFacade> tableRows;

    @FindBy(css = ".admin-reservations-table tbody tr:first-child button")
    private List<WebElementFacade> firstRowActions;

    @FindBy(css = ".admin-reservation-detail-modal, .modal-content.admin-create-modal")
    private List<WebElementFacade> detailModal;

    @FindBy(css = ".admin-pagination button")
    private List<WebElementFacade> paginationButtons;

    @FindBy(css = ".admin-no-results, .empty-state")
    private List<WebElementFacade> emptyState;

    public boolean isLoaded() {
        return pageTitle.waitUntilVisible().containsText("Gest");
    }

    public void applyBasicFilters(String date, String status, String site, String user) {
        if (date != null && !date.isBlank() && filterDate.isPresent()) {
            filterDate.clear();
            filterDate.type(date);
        }
        selectByVisibleTextOrValue(filterStatus, status);
        selectByVisibleTextOrValue(filterSite, site);
        selectByVisibleTextOrValue(filterUser, user);
        clickFilterButton("Filtrar");
    }

    public void clearFilters() {
        clickFilterButton("Limpiar");
    }

    public boolean hasRows() {
        withTimeoutOf(Duration.ofSeconds(10)).waitForAll(tableRows);
        return !tableRows.isEmpty();
    }

    public void openFirstRowDetail() {
        for (WebElementFacade action : firstRowActions) {
            String text = action.getText().trim();
            if (!text.isBlank()) {
                action.click();
                return;
            }
        }
        if (!firstRowActions.isEmpty()) {
            firstRowActions.get(0).click();
        }
    }

    public boolean detailModalIsVisible() {
        return !detailModal.isEmpty() && detailModal.get(0).isVisible();
    }

    public void goToNextPageIfAvailable() {
        for (WebElementFacade button : paginationButtons) {
            String text = button.getText().trim();
            if ("Siguiente".equalsIgnoreCase(text) || ">".equals(text)) {
                if (button.isEnabled()) {
                    button.click();
                }
                return;
            }
        }
    }

    public boolean hasPaginationControls() {
        return !paginationButtons.isEmpty();
    }

    public boolean hasNoResultsState() {
        return !emptyState.isEmpty() && emptyState.get(0).isVisible();
    }

    private void clickFilterButton(String label) {
        for (WebElementFacade button : filterButtons) {
            if (button.getText().trim().equalsIgnoreCase(label)) {
                button.click();
                return;
            }
        }
    }

    private void selectByVisibleTextOrValue(WebElementFacade selectElement, String value) {
        if (value == null || value.isBlank() || !selectElement.isPresent()) {
            return;
        }
        Select select = new Select(selectElement);
        try {
            select.selectByVisibleText(value);
        } catch (Exception ignored) {
            try {
                select.selectByValue(value);
            } catch (Exception ignoredAgain) {
                // Keep current selection if requested option is not available.
            }
        }
    }
}
