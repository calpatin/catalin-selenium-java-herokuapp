@UI @smoke @explicitWaits
Feature: Dynamic loading examples

  Scenario Outline: Dynamic Loading works correctly
    Given I open the "<example>" Page
    When I start the dynamic loading
    Then The dynamic loaded text is displayed
    Examples:
      | example  |
      | example1 |
      | example2 |
