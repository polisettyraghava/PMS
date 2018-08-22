Feature: Test Patient management Smoke Scenario

  Scenario: Test login with valid credentials
    Given Open firefox and start application
    When I enter valid username and valid password and select valid roletype
    Then user should be able to login successfully