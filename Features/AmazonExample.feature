@firstFeature
  Feature: Example

Scenario: Interview Example
  Given User launch chrome browser
  When User opens URL "https://www.amazon.com/"
  And User search for amazon product "Samsung Galaxy Note 20"
  And User verifies item is displayed on the results page and stores price
  And User clicks on the first result
  And User validates same prices
  And User does the cart flow
  Then User deletes product from cart

