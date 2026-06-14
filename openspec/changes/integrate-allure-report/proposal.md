## Why

We need a comprehensive and visual test reporting tool to view the execution results of our Cucumber BDD tests for the POM_Baseline_eShop project. Currently, there is no advanced reporting set up that easily integrates with both local executions and Jenkins pipelines while also supporting automatic failure screenshot attachments. Allure provides these capabilities perfectly.

## What Changes

- Add Allure Cucumber 7 JVM dependency to the Maven `pom.xml`.
- Update Cucumber execution configuration (via Surefire plugin or JUnit Platform properties) to use the Allure plugin.
- Add Allure Maven plugin to enable local report generation.
- Implement a Cucumber Hook to automatically capture and attach screenshots to the Allure report when a test scenario fails.

## Capabilities

### New Capabilities
- `test-reporting`: The capability to generate, view, and persist rich HTML test reports via Allure, including test execution status, steps, and failure screenshots.

### Modified Capabilities

## Impact

- `pom.xml`: Will have new dependencies (`allure-cucumber7-jvm`) and plugins (`allure-maven`).
- `src/test/resources/junit-platform.properties`: (or equivalent) Will be updated to register the Allure Cucumber listener.
- `src/test/java/co/edu/javeriana/eshop/hooks/Hooks.java`: Will be created or modified to include logic for capturing screenshots on failure and attaching them to Allure using Selenium WebDriver.
