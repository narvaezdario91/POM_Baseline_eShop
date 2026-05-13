package co.edu.javeriana.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * CartPage — Page Object para la página del carrito de compras.
 */
public class CartPage extends BasePage {

    // --- SELECTORES ACOPLADOS ---
    private final By cartLink = By.xpath("//a[contains(@aria-label, 'cart') or contains(@aria-label, 'shopping bag')]");
    private final By cartHeading = By.xpath("//h1[contains(text(), 'Shopping bag')]");
    private final By quantityInput = By.xpath("//input[contains(@aria-label, 'product quantity') or contains(@aria-label, 'quantity')]");
    private final By updateButton = By.xpath("//button[contains(text(), 'Update')]");
    private final By emptyCartMessage = By.xpath("//*[contains(., 'Your shopping bag is empty')]");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void goToCart() {
        click(cartLink);
    }

    public boolean isCartPageDisplayed() {
        return isElementVisible(cartHeading);
    }

    public boolean isProductInCart(String productName) {
        By productText = By.xpath("//*[contains(text(), '" + productName + "')]");
        return isElementVisible(productText);
    }

    public void setQuantity(String quantity) {
        WebDriver d = this.driver; // needed for clearing
        type(quantityInput, quantity);
    }

    public void clickUpdate() {
        click(updateButton);
    }

    public boolean isCartEmpty() {
        return isElementVisible(emptyCartMessage);
    }
}
