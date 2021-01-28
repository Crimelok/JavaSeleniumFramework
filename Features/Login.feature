@firstFeature
  Feature: Login

  Scenario: Successful Login with valid credentials
  Given User launch chrome browser
  When User opens URL "https://admin-demo.nopcommerce.com/login"
  And User enters email as "admin@yourstore.com" and password as "admin"
  And Click on login
  Then Page title should be "Dashboard / nopCommerce administration"
  When User click on log out link
  Then Page title should be "Your store. Login"
  And Close browser
