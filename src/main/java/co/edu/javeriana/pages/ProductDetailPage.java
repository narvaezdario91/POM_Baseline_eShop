package co.edu.javeriana.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * ProductDetailPage — Page Object para la vista de detalle de un producto.
 *
 * NOTA PARA EL EXPERIMENTO (Fragilidad ante M3):
 * El botón "Add to shopping bag" está localizado por texto exacto.
 * La mutación M3 cambia este texto, causando un fallo inmediato.
 */
public class ProductDetailPage extends BasePage {

    // --- SELECTORES ACOPLADOS (vulnerables a mutación M3) ---
    private final By addToCartButton = By.xpath("//button[contains(text(), 'Add to shopping bag')]");
    private final By productHeading = By.tagName("h1");

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public void addToCart() {
        click(addToCartButton);
    }

    public String getProductName() {
        return getText(productHeading);
    }

    public boolean isProductDetailDisplayed(String productName) {
        By heading = By.xpath("//h1[contains(text(), '" + productName + "')]");
        return isElementVisible(heading);
    }
}
