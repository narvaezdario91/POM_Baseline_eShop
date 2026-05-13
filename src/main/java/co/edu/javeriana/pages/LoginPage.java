package co.edu.javeriana.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * LoginPage — Page Object para la página de autenticación de eShop.
 *
 * NOTA PARA EL EXPERIMENTO (Fragilidad de Selectores):
 * Los localizadores de esta clase están acoplados a atributos específicos
 * del DOM (aria-label, placeholder, name). Cualquier cambio en estos
 * atributos en el SUT (eShop) requerirá modificar ESTA clase, recompilar
 * y re-ejecutar. En SMDT, el agente LLM resuelve estos dinámicamente.
 */
public class LoginPage extends BasePage {

    // --- SELECTORES ACOPLADOS (vulnerables a mutaciones M1, M2, M5) ---
    private final By signInLink = By.xpath("//a[contains(@aria-label, 'Sign')]");
    private final By usernameField = By.xpath("//input[@placeholder='Username']");
    private final By passwordField = By.xpath("//input[@placeholder='Password']");
    private final By loginButton = By.xpath("//button[@type='submit' or contains(@name, 'button')]");
    private final By loginHeading = By.xpath("//h1[contains(text(), 'Login')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void clickSignIn() {
        click(signInLink);
    }

    public void enterUsername(String username) {
        type(usernameField, username);
    }

    public void enterPassword(String password) {
        type(passwordField, password);
    }

    public void clickLoginButton() {
        click(loginButton);
    }

    public boolean isLoginPageDisplayed() {
        return isElementVisible(loginHeading);
    }

    /**
     * Método de conveniencia que ejecuta el flujo completo de login.
     */
    public void login(String username, String password) {
        clickSignIn();
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }
}
