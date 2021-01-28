@firstFeature
  Feature: Example

Scenario: Interview Example
  Given User launch chrome browser
  When User opens URL "https://www.microsoft.com/en-us/"
  And Validate menus
  And Clicks on Windows
  And Validate menu options
  And User search "Visual Studio" on search bar
  And User checks prices
  And Validate same prices
  And User makes paying flow
  Then Close browser