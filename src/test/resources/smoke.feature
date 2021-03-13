Feature: Smoke
  As a user
  I want to test all main site functional
  So that I can be sure that site works correctly

  Scenario Outline: Check switch language
    Given User opens '<homePage>' page
    And User click language button
    And User click Ireland button
    And User checks that current url contains '<irelandPage>' language


    Examples:
      | homePage              | irelandPage          |
      | https://www.ebay.com/ | https://www.ebay.ie/ |

  Scenario Outline: Check add to cart
    Given User opens '<homePage>' page
    And User enter to search field '<keyword>' and click search
    And Click on name XBOX
    And Choose black
    And Click click add to cart
    And Click go to checkout
    And Click continue like as guest

    Examples:

      | homePage              | keyword       |
      | https://www.ebay.com/ | xbox series x |

  Scenario Outline: Check remove from cart
    Given User opens '<homePage>' page
    And User enter to search field '<keyword>' and click search
    And Click on name XBOX
    And Choose black
    And Click click add to cart
    And Click remove


    Examples:

      | homePage              | keyword       |
      | https://www.ebay.com/ | xbox series x |


  Scenario Outline: Check cart after closing page and reopen
    Given User opens '<homePage>' page
    And User enter to search field '<keyword>' and click search
    And Click on name XBOX
    And Choose black
    And Click click add to cart
    And User go to '<google>' on this page
    And User reopen '<homePage>'
    And Check cart


    Examples:

      | homePage              | keyword       | google                  |
      | https://www.ebay.com/ | xbox series x | https://www.google.com/ |

  Scenario Outline: Check check help page with search field
    Given User opens '<helpPage>' page
    And Enter to search field '<keyword>'
    And Click to first link
    And Check the open page



    Examples:

      | helpPage                       | keyword        |
      | https://www.ebay.com/help/home | refund an item |


  Scenario Outline: Check check help page with categories
    Given User opens '<helpPage>' page
    And Click Shipping & Tracking categories
    And Click to Shipping for Sellers
    And Click Setting up your shipping options



    Examples:

      | helpPage                       |
      | https://www.ebay.com/help/home |


  Scenario Outline: Check correct value of quantity
    Given User opens '<homePage>' page
    And User enter to search field '<keyword>' and click search
    And Click on name bicycle
    And Add correct value of '<quantity>'
    And Click click add to cart
    Then Check cart counter

    Examples:

      | homePage              | keyword |  | quantity |
      | https://www.ebay.com/ | bicycle |  | 3        |





