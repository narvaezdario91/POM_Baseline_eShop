package co.edu.javeriana.steps;

import co.edu.javeriana.pages.CatalogPage;
import co.edu.javeriana.pages.ProductDetailPage;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * BrowseSteps — Glue Code para la navegación del catálogo.
 */
public class BrowseSteps {

    private final WebDriver driver = Hooks.getDriver();
    private CatalogPage catalogPage;
    private ProductDetailPage productDetailPage;

    @Cuando("el usuario selecciona el producto {string}")
    public void elUsuarioSeleccionaElProducto(String productName) {
        catalogPage = new CatalogPage(driver);
        productDetailPage = new ProductDetailPage(driver);
        catalogPage.selectProduct(productName);
    }

    @Entonces("el sistema muestra el detalle del producto {string}")
    public void elSistemaMuestraElDetalleDelProducto(String productName) {
        productDetailPage = new ProductDetailPage(driver);
        assertTrue(productDetailPage.isProductDetailDisplayed(productName),
                "No se mostró el detalle del producto: " + productName);
    }
}
