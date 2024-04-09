@data
Feature: This is a test feature

  @start
  Scenario Outline: open google and search something
    Given open google url: <url>
    When input <test> on search box
      And I click search button
    Then I can see the <test>
    Examples:
      | test | url                     |
      | abc  | https://www.google.com/ |
      | dev  | https://www.google.com/ |

  @end
  Scenario: open google and search something
    Given open google url: https://www.google.com/
    When input selenium on search box
    Then I am on search results page
