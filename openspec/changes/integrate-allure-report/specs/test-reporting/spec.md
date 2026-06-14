## ADDED Requirements

### Requirement: Allure Result Generation
The system SHALL generate Allure JSON/XML result files during the execution of Cucumber tests.

#### Scenario: Running tests locally
- **WHEN** the user executes the test suite via `mvn clean test`
- **THEN** Allure result files are generated in the `target/allure-results` directory

### Requirement: Failure Screenshot Attachment
The system SHALL capture a screenshot and attach it to the Allure report whenever a Cucumber scenario fails.

#### Scenario: A test scenario fails during execution
- **WHEN** a Cucumber step fails causing the scenario to fail
- **THEN** a screenshot of the browser at the moment of failure is taken and attached to the Allure report for that specific scenario

### Requirement: Local Report Serving
The system SHALL allow the user to easily serve the generated Allure report locally using a Maven command.

#### Scenario: Viewing the report locally
- **WHEN** the user executes `mvn allure:serve` after a test run
- **THEN** a local web server is started displaying the rich HTML Allure report in the default browser
