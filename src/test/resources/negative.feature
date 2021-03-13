Feature: Negative
  As a user
  I want to test site functional
  So that I can be sure that site works correctly with incorrect parameters


  Scenario Outline: Check incorrect search
    Given User opens '<homePage>' page
    And User enter to search field '<keyword>' and click search
    And Wait for result

    Examples:

      | homePage              | keyword       |
      | https://www.ebay.com/ | asdfgsdfgxcvb |


  Scenario Outline: Check incorrect value of quantity
    Given User opens '<homePage>' page
    And User enter to search field '<keyword>' and click search
    And Click on name
    And Add incorrect value of '<quantity>'

    Examples:

      | homePage              | keyword            |  | quantity |
      | https://www.ebay.com/ | sony playstation 5 |  | 100      |


  Scenario Outline: Check sign in without parameters
    Given User opens '<homePage>' page
    And CLick sing in
    And Click to continue button without parameters


    Examples:

      | homePage              |
      | https://www.ebay.com/ |