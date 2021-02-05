$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("/Users/macbook/eclipse-workspace/gridigen-1/src/main/java/Feature/JoinPage_VerifyMandatoryFiels.feature");
formatter.feature({
  "line": 1,
  "name": "functional testing for  join page",
  "description": "",
  "id": "functional-testing-for--join-page",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "verify the page with some mandatory fields",
  "description": "",
  "id": "functional-testing-for--join-page;verify-the-page-with-some-mandatory-fields",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "launch the firefox browser and open the application",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "click on join",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "fill some of the mandatory values",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "verify submit button",
  "keyword": "Then "
});
formatter.match({
  "location": "JoinPage_VerifyMandatoryFiels.launch_the_firefox_browser_and_open_the_application()"
});
formatter.result({
  "duration": 16079264116,
  "status": "passed"
});
formatter.match({
  "location": "JoinPage_VerifyMandatoryFiels.click_on_join()"
});
formatter.result({
  "duration": 496389547,
  "status": "passed"
});
formatter.match({
  "location": "JoinPage_VerifyMandatoryFiels.fill_some_of_the_mandatory_values()"
});
formatter.result({
  "duration": 136848388,
  "status": "passed"
});
formatter.match({
  "location": "JoinPage_VerifyMandatoryFiels.verify_submit_button()"
});
formatter.result({
  "duration": 468628449,
  "status": "passed"
});
});