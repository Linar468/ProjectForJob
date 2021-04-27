Feature: I want to make some actions on main page

  Scenario: Open Women Page
    Given I am on main page
    When I click "Women" tab
    Then I am on women page

  Scenario: Open Dresses Page
    Given I am on main page
    When I click "DRESSES" tab
    Then I am on dresses page

  Scenario: Open T-shirts Page
    Given I am on main page
    When I click "T-SHIRTS" tab
    Then I am on t-shirts page