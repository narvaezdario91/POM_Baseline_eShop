package co.edu.javeriana.steps;

import co.edu.javeriana.pages.CartPage;
import co.edu.javeriana.pages.CatalogPage;
import co.edu.javeriana.pages.ProductDetailPage;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * CartSteps — Glue Code para las operaciones del carrito.
 *
 * NOTA PARA EL EXPERIMENTO:
 * Esta clase contiene el mayor volumen de Glue Code del proyecto baseline.
 * Cada operación del carrito requiere instanciar manualmente el Page Object
 * correspondiente e invocar sus métodos. En SMDT, esto se resuelve con
 * instrucciones en lenguaje natural en el archivo .steps.yaml.
 */
public class CartSteps {

    private final WebDriver driver = Hooks.getDriver();
    private CatalogPage catalogPage;
    private ProductDetailPage productDetailPage;
    private CartPage cartPage;

    @Cuando("el usuario agrega el producto al carrito")
    public void elUsuarioAgregaElProductoAlCarrito() {
        productDetailPage = new ProductDetailPage(driver);
        productDetailPage.addToCart();
    }

    @Dado("el usuario agrega {string} al carrito")
    public void elUsuarioAgregaProductoAlCarrito(String productName) {
        catalogPage = new CatalogPage(driver);
        productDetailPage = new ProductDetailPage(driver);
        catalogPage.selectProduct(productName);
        productDetailPage.addToCart();
    }

    @Entonces("el carrito muestra el producto {string}")
    public void elCarritoMuestraElProducto(String productName) {
        cartPage = new CartPage(driver);
        cartPage.goToCart();
        assertTrue(cartPage.isProductInCart(productName),
                "El producto '" + productName + "' no se encontró en el carrito");
    }

    @Cuando("el usuario cambia la cantidad a {string} y actualiza")
    public void elUsuarioCambiaLaCantidadYActualiza(String quantity) {
        cartPage = new CartPage(driver);
        cartPage.goToCart();
        cartPage.setQuantity(quantity);
        cartPage.clickUpdate();
    }

    @Entonces("el carrito muestra el mensaje {string}")
    public void elCarritoMuestraElMensaje(String message) {
        cartPage = new CartPage(driver);
        assertTrue(cartPage.isCartEmpty(),
                "No se mostró el mensaje de carrito vacío: " + message);
    }
}
