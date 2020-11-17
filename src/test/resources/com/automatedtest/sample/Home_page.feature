Feature: Home page

  @amazon
  Scenario: Amazon hat buying automation sample
    Given A user navigates to Amazon web page
    Then Amazon Logo is displayed
    Then page title contains "Amazon.com:"
    When a user searches for "hats for men"
    Then results are shown
    When the user click option in position "1"
    Then user is in product page
    Then user add "2" units to cart
    And user navigates to cart page
    Then user check quantity of items is "2"
    And user checks the price is correct for 2 items added
    When a user searches for "hats for women"
    Then results are shown
    When the user click option in position "1"
    Then user is in product page
    Then user add "1" units to cart
    And user navigates to cart page
    Then user check quantity of items is "3"
    Then user checks the price is correct for 1 items added
    When user change total items from first item added to 1
    Then user check quantity of items is "2"
    And total price is updated for 1 hat for men and 1 hat for women

