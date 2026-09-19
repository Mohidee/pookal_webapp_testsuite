Feature: Admin Login

  Background:
    Given the user is on the admin login page

  @smoke @login
  Scenario: Login with valid credentials
    When the user enters a valid username
    And the user enters a valid password
    And the user clicks the login button
    Then the user should be redirected to the dashboard