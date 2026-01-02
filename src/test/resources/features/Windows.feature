@UI @windows
Feature: Windows and tabs handling

  Scenario: Open and switch to a new window
    Given I open the Windows Page
    When I open a new window
    Then The new window content is displayed
    And I return to the original window

