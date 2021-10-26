$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:Features/AmazonExample.feature");
formatter.feature({
  "name": "Example",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@firstFeature"
    }
  ]
});
formatter.scenario({
  "name": "Interview Example",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@firstFeature"
    }
  ]
});
formatter.step({
  "name": "User launch chrome browser",
  "keyword": "Given "
});
formatter.match({
  "location": "Steps.user_launch_chrome_browser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User opens URL \"https://www.amazon.com/\"",
  "keyword": "When "
});
formatter.match({
  "location": "Steps.user_opens_URL(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User search for amazon product \"Samsung Galaxy Note 20\"",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.user_search_for_amazon_product(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User verifies item is displayed on the results page and stores price",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.user_verifies_item_and_stores_price()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks on the first result",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.user_clicks_on_the_first_result()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User validates same prices",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.user_validates_same_prices()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User does the cart flow",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.user_does_cart_flow()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User deletes product from cart",
  "keyword": "Then "
});
formatter.match({
  "location": "Steps.user_deletes_product_from_cart()"
});
formatter.result({
  "status": "passed"
});
});