@US01 @ui
Feature: As a user I want to confirm correct remaining amount that's left to plan

  Background: user logs in
    Given user is logged in

  Scenario: Verify left-to-plan amount is the difference between the sum of the income amounts and the sum of all other planned amounts
    #Given user is logged in
    When user is directed to "Budget" module
    And user enters income-fields values
      | Paycheck 1 | 5000.00 |
      | Church     | 500.00  |
    Then total amount left to plan is 4500
    And user clears income-fields values
      | Paycheck 1 | 0.00 |
      | Church     | 0.00 |
    And user logs out

