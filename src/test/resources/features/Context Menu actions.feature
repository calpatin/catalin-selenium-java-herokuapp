@UI @actions @contextMenu @rightClick
Feature: Context Menu actions

  Scenario: Display alert on right click
    Given I open the Context Menu Page
    When I right click on the context menu area
    Then An Alert with the text "You selected a context menu" is displayed
