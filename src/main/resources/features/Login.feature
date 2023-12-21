@Regression
Feature: User can login to the system
  Background:
    Given user open browser
    And user navigates to login page

  Scenario: login with valid username and password
    When user enter valid username and password
    And user click on login button
    Then user login successfully
    And  go to home page
  Scenario: login with invalid username and password
    When user enter invalid username and password
    And user click on login button
    Then user could not login

