@UI @fluentWaits
Feature: Dynamic controls with Fluent Wait

  Scenario: Verify Checkbox is dynamically removed
    Given I open the Dynamic Controls Page
    When I select and remove the checkbox
    Then The checkbox is no longer displayed on page
    And A confirmation message is shown