@practical-test
Feature: User's are able to plan their investment using the kiwisaver calculator
  As a Product Owner
  I want that the KiwiSaver Retirement Calculator users are able to calculate what their KiwiSaver projected
  balance would be at retirement
  So that
  The users are able to plan their investments better.


  Scenario Outline: KiwiSaver Retirement Calculator helps users to calculate their KiwiSaver projected balance at retirement
    Given user is on kiwisaver retirement calculator screen
    When user enters "<age>" "<employment-type>" "<salary>" "<contribution-rate>" "<current-balance>" "<voluntary-contribution>" "<voluntary-contribution-frequency>" "<risk-profile>" "<saving-goals-requirement>"
    Then user can see a projected balance "<estimate>" at retirement
    Examples:
      | age | employment-type | salary | contribution-rate | current-balance | voluntary-contribution | voluntary-contribution-frequency | risk-profile | saving-goals-requirement | estimate |
      | 30  | employed        | 82000  | 4                 |                 |                        |                                  | Defensive    |                          | 436,365  |
      | 45  | self-employed   |        |                   | 100000          | 90                     | fortnightly                      | Conservative | 290000                   | 259,581  |
      | 55  | not-employed    |        |                   | 140000          | 10                     | annually                         | Balanced     | 200000                   | 197,679  |
