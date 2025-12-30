@UI @frames
Feature: Frames handling

  Scenario: Read text from nested frames
    Given I open the Frames Page
    When I navigate to Nested Frames
    Then I can read the text from the middle frame

  @Defect
#    The editor body is read-only on the page and this is a defect
  Scenario: Write text inside an iFrame
    Given I open the Frames Page
    When I navigate to iFrame Page
    And I type "My name is Catalin!" in the editor
    Then The editor contains "My name is Catalin!"