# eShop POM Baseline — Selenium Java + Cucumber

> **Propósito**: Implementación convencional de automatización BDD para el estudio comparativo con SMDT.  
> **Proyecto**: Tesis MISO — Pontificia Universidad Javeriana Cali

---

## Pre-requisitos

- **Java 17+** (JDK)
- **Maven 3.9+**
- **Google Chrome** (última versión)
- **eShop** corriendo en `https://localhost:7298`

## Ejecución

```bash
# Compilar y ejecutar todas las pruebas
mvn clean test

# Ejecutar un feature específico
mvn test -Dcucumber.features=src/test/resources/features/login.feature
```

## Reportes

Tras la ejecución, los reportes se generan en:
- `target/cucumber-report.html` (HTML)
- `target/cucumber-report.json` (JSON)

## Estructura

```
src/
├── main/java/co/edu/javeriana/pages/   # Page Objects (selectores acoplados)
│   ├── BasePage.java                    # Utilidades comunes
│   ├── LoginPage.java                   # Selectores de login
│   ├── CatalogPage.java                 # Selectores de catálogo
│   ├── ProductDetailPage.java           # Selectores de detalle
│   └── CartPage.java                    # Selectores del carrito
└── test/
    ├── java/co/edu/javeriana/
    │   ├── runners/TestRunner.java       # Punto de entrada Cucumber
    │   └── steps/                        # Glue Code (Step Definitions)
    │       ├── Hooks.java                # Lifecycle del WebDriver
    │       ├── LoginSteps.java           # Steps de autenticación
    │       ├── BrowseSteps.java          # Steps de navegación
    │       └── CartSteps.java            # Steps del carrito
    └── resources/features/               # Escenarios Gherkin
        ├── login.feature
        ├── browse.feature
        ├── add_to_cart.feature
        └── remove_from_cart.feature
```

## Notas para el Experimento

Este proyecto es el **baseline convencional** del estudio comparativo. Los selectores están deliberadamente acoplados a atributos específicos del DOM (`aria-label`, `placeholder`, texto de botones) para demostrar la fragilidad ante cambios de UI.

Las mutaciones M1-M5 afectarán directamente los Page Objects y requerirán:
1. Localizar el selector roto en la clase Java correspondiente
2. Modificar el `By.xpath(...)` o `By.cssSelector(...)`
3. Recompilar con `mvn compile`
4. Re-ejecutar con `mvn test`
