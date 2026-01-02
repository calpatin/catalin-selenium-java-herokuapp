@UI @select @dropdown @dataTable @selenide @Run
Feature: Dropdown selections using Selenide

  Scenario: Select options from dropdown
    Given I open the Dropdown Page using Selenide
    When I select the following options using Selenide:
      |option  |
      |Option 1|
      |Option 2|
    Then The dropdown should display the following selected option using Selenide:
      |option  |
      |Option 2|
