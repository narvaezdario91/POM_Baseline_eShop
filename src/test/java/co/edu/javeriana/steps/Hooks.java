package co.edu.javeriana.steps;

import co.edu.javeriana.pages.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Hooks — Gestiona el ciclo de vida del WebDriver (Before/After).
 *
 * NOTA PARA EL EXPERIMENTO:
 * Este archivo es "infraestructura obligatoria" del enfoque POM.
 * Cada proyecto de automatización convencional necesita esta configuración
 * manual de drivers, opciones, y limpieza. En SMDT, el protocolo MCP
 * maneja todo esto automáticamente.
 */
public class Hooks {

    private static WebDriver driver;

    @Before
    public void setUp(Scenario scenario) {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();
            // Aceptar certificados auto-firmados (eShop usa HTTPS local)
            options.addArguments("--ignore-certificate-errors");
            options.addArguments("--allow-insecure-localhost");
            options.addArguments("--window-size=1280,720");
            options.addArguments("--disable-blink-features=AutomationControlled");
            // Descomentar para modo headless:
            // options.addArguments("--headless=new");

            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }

        System.out.println("🎬 Scenario: " + scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println("❌ FAILED: " + scenario.getName());
        } else {
            System.out.println("✅ PASSED: " + scenario.getName());
        }

        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
