@practical-test
Feature: Kiwisaver Retirement Calculator field information
  As a Product Owner
  I want that while using the KiwiSaver Retirement Calculator all fields in the calculator have got the
  information icon present
  So that The user is able to get a clear understanding of what needs to be entered in the field.


  Scenario: On KiwiSaver Retirement Calculator all fields in the calculator have got the information icon present
    Given user is on kiwisaver retirement calculator screen
    When user clicks on information icon besides current age field
    Then user can see current age information message