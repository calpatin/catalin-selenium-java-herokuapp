@UI @alerts
Feature: Javascript alerts handling

  Scenario: Accept simple alert
    Given I open the JavaScript alert page
    When I click for JS Alert
    Then The alert is displayed and accepted

  Scenario: Dismiss confirmation alert
    Given I open the JavaScript alert page
    When I click for JS Confirm
    Then The confirmation is cancelled

  Scenario: Input prompt alert
    Given I open the JavaScript alert page
    When I enter the "Dummy text" in the JS Prompt
    Then The prompt result contains "Dummy text"