$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:Features/Example.feature");
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
  "name": "User opens URL \"https://www.microsoft.com/en-us/\"",
  "keyword": "When "
});
formatter.match({
  "location": "Steps.user_opens_URL(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Validate menus",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.validate_menus()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Clicks on Windows",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.clicks_on_windows()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Validate menu options",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.validate_menu_options()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User search \"Visual Studio\" on search bar",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.user_search_on_search_bar(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User checks prices",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.user_checks_prices()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Validate same prices",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.validate_same_prices()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User makes paying flow",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.user_makes_paying_flow()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Close browser",
  "keyword": "Then "
});
formatter.match({
  "location": "Steps.close_browser()"
});
formatter.result({
  "status": "passed"
});
});