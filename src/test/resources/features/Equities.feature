Feature: Verify that the current GameStop Corp stock value is within the 52 week range
  I want to verify that the current stock value for the GameStop Corp on the page
  is within the values of the the 52 Week Range from the page

  Scenario Outline: Compare the current value with the 52 week range
    Given "<page>" equity page
    When get the current Stock value from the page
    And get the 52 week range values
    Then verify that the current value is within the 52 week range values

    Examples:
      | page                         |
      | /equities/gamestop-corp      |
      | /equities/apple-computer-inc |
