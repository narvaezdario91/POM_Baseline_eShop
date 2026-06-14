## Context

The POM_Baseline_eShop is a BDD test automation project using Cucumber, Selenium WebDriver, and JUnit 5 Platform. Currently, the reporting mechanism is limited to the default Cucumber console or basic JUnit output. To provide better visibility into test execution—especially for failures occurring locally and on Jenkins CI—we are integrating Allure Report. Allure offers rich, interactive HTML reports with built-in support for Cucumber steps and Selenium screenshots.

## Goals / Non-Goals

**Goals:**
- Generate detailed Allure results (`.json` files) during Cucumber test execution.
- Automatically capture and embed browser screenshots in the Allure report when a test scenario fails.
- Ensure the configuration works seamlessly for local development (using the Allure Maven plugin) and is ready to be consumed by the Allure Jenkins plugin.

**Non-Goals:**
- Modifying existing Cucumber feature files or step definitions beyond the global Hooks.
- Configuring the Jenkins server itself (this design focuses on the project-level code configuration).

## Decisions

- **Use `allure-cucumber7-jvm` Dependency**: This is the official integration for Cucumber 7. It automatically hooks into the Cucumber lifecycle to log steps and results.
- **Use `junit-platform.properties` for Cucumber Plugin Configuration**: Since the project uses the JUnit Platform Suite engine to run Cucumber tests (`cucumber.junit-platform.naming-strategy=long` is already set in Surefire), adding the Allure listener via `junit-platform.properties` (`cucumber.plugin=io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm`) is the cleanest approach.
- **Screenshot Hook Implementation**: We will implement a `@After` Hook in Cucumber (`co.edu.javeriana.eshop.hooks.Hooks.java` or similar) that checks `scenario.isFailed()`. If true, it retrieves the WebDriver instance, takes a screenshot as bytes, and attaches it using `Allure.addAttachment()`.

## Risks / Trade-offs

- **Risk**: Test execution might slow down slightly due to screenshot capturing and JSON report generation.
  **Mitigation**: Screenshots are only taken on failure. The overhead of JSON generation is minimal.
- **Risk**: The WebDriver lifecycle management must be robust so the Hook can access the active driver instance when a failure occurs.
  **Mitigation**: Ensure the WebDriver instance is accessible via a singleton or dependency injection within the step definitions/hooks context.
