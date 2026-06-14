## 1. Maven Configuration

- [x] 1.1 Add `allure-cucumber7-jvm` dependency to `pom.xml`.
- [x] 1.2 Add `allure-maven` plugin to `pom.xml` in the `<build><plugins>` section.

## 2. Cucumber Integration

- [x] 2.1 Update Cucumber configuration (via `junit-platform.properties` or Surefire plugin properties) to register the `io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm` plugin.
- [x] 2.2 Verify that running `mvn clean test` generates files in `target/allure-results`.

## 3. Failure Screenshots Hook

- [x] 3.1 Locate or create the Cucumber `Hooks` class (e.g., in `co.edu.javeriana.eshop.hooks`).
- [x] 3.2 Implement an `@After` method that takes the Cucumber `Scenario` as a parameter.
- [x] 3.3 Add logic to check `if (scenario.isFailed())`, capture a screenshot using WebDriver, and attach it to the Allure report (`Allure.addAttachment()`).

## 4. Verification

- [x] 4.1 Intentionally fail a test scenario locally.
- [x] 4.2 Run `mvn clean test` followed by `mvn allure:serve`.
- [x] 4.3 Verify the HTML report opens in the browser, shows the failure, and includes the attached screenshot.
