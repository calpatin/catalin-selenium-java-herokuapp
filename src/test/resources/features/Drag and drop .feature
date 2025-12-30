@UI @actions @dragAndDrop @Run
@Defect
#HTML5 drag & drop is not reliably supported by Selenium Actions API.
#This scenario demonstrates the limitation and is marked as Defect by design.
Feature: Drag and drop

  Scenario: Drag column a to column B
    Given I open the Drag and Drop Page
    When I drag column A onto column B
    Then column A should be in position B
