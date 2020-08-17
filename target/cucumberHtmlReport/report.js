$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/UI/pxCentralSaasLogin.feature");
formatter.feature({
  "line": 1,
  "name": "Px central Saas login",
  "description": "",
  "id": "px-central-saas-login",
  "keyword": "Feature"
});
formatter.before({
  "duration": 19691131,
  "status": "passed"
});
formatter.before({
  "duration": 3440619666,
  "status": "passed"
});
formatter.scenario({
  "line": 3,
  "name": "validate Central Saas login for existing user",
  "description": "",
  "id": "px-central-saas-login;validate-central-saas-login-for-existing-user",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "I navigate to \"stage_rc\"",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I should see page title as \" Sign in to Portworx \"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "stage_rc",
      "offset": 15
    }
  ],
  "location": "NavigationSteps.navigateTo(String)"
});
formatter.result({
  "duration": 15535800064,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "",
      "offset": 8
    },
    {
      "val": " Sign in to Portworx ",
      "offset": 28
    }
  ],
  "location": "AssertionSteps.checkPageTitle(String,String)"
});
formatter.result({
  "duration": 22858868,
  "status": "passed"
});
formatter.after({
  "duration": 203806465,
  "status": "passed"
});
});