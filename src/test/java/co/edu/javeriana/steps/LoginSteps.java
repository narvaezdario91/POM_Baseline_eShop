package co.edu.javeriana.steps;

import co.edu.javeriana.pages.CatalogPage;
import co.edu.javeriana.pages.LoginPage;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * LoginSteps — Glue Code para los pasos de autenticación.
 *
 * NOTA PARA EL EXPERIMENTO (Deuda Técnica del Glue Code):
 * Cada paso Gherkin requiere un método Java vinculado manualmente.
 * Según Binamungu et al. (2018), el 40% de profesionales realiza
 * procesos manuales para la gestión de duplicidad en Step Definitions.
 * En SMDT, esta clase entera es reemplazada por 19 líneas de YAML.
 */
public class LoginSteps {

    private final WebDriver driver = Hooks.getDriver();
    private LoginPage loginPage;
    private CatalogPage catalogPage;

    @Dado("el usuario navega a la tienda eShop")
    public void elUsuarioNavegaALaTiendaEShop() {
        loginPage = new LoginPage(driver);
        catalogPage = new CatalogPage(driver);
        loginPage.navigateTo("https://localhost:7298");
    }

    @Dado("el usuario se autentica en eShop")
    public void elUsuarioSeAutenticaEnEShop() {
        loginPage = new LoginPage(driver);
        catalogPage = new CatalogPage(driver);
        loginPage.navigateTo("https://localhost:7298");
        loginPage.login("alice", "Pass123$");
    }

    @Dado("el usuario inicia sesión con usuario {string} y contraseña {string}")
    public void elUsuarioIniciaSesionConCredenciales(String username, String password) {
        loginPage = new LoginPage(driver);
        catalogPage = new CatalogPage(driver);
        loginPage.navigateTo("https://localhost:7298");
        loginPage.login(username, password);
    }

    @Entonces("el sistema permite el acceso al catálogo")
    public void elSistemaPermiteElAccesoAlCatalogo() {
        assertTrue(catalogPage.isCatalogDisplayed(),
                "El catálogo no se mostró tras el login");
    }
}
