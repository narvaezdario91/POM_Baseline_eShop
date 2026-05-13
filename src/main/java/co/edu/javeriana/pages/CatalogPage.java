package co.edu.javeriana.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * CatalogPage — Page Object para la página principal del catálogo de eShop.
 *
 * NOTA PARA EL EXPERIMENTO (Fragilidad ante M4):
 * El heading "Ready for a new adventure?" está hardcodeado en la aserción.
 * Si cambia en el SUT, esta clase falla.
 */
public class CatalogPage extends BasePage {

    // --- SELECTORES ACOPLADOS (vulnerables a mutaciones M3, M4) ---
    private final By catalogHeading = By.xpath("//h1[contains(text(), 'Ready for a new adventure?')]");

    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCatalogDisplayed() {
        return isElementVisible(catalogHeading);
    }

    /**
     * Selecciona un producto del catálogo por su nombre visible.
     * Usa un XPath dinámico basado en el texto del enlace.
     */
    public void selectProduct(String productName) {
        By productLink = By.xpath("//a[contains(., '" + productName + "')]");
        click(productLink);
    }
}
