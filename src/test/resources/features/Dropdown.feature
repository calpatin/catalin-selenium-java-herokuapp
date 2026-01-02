@UI @select @dropdown @dataTable
Feature: Dropdown selections

#  DataTable here because we are testing the same page with different data
  Scenario: Select options form dropdown
    Given I open the Dropdown Page
    When I select the following option for dropdown:
    |Option 1|
    |Option 2|
    Then The selected option should be correctly selected


