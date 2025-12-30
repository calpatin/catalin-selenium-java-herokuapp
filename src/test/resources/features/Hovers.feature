@UI @actions @hover
Feature: Hover actions

  Scenario Outline: Display user details on hover
    Given I open the Hover Page
    When I hover on user <userIndex>
    Then the details "<expectedDetails>" are displayed
    Examples:
      | userIndex | expectedDetails |
      | 1         | name: user1     |
      | 2         | name: user2     |
      | 3         | name: user3     |