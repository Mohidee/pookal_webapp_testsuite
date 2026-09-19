Feature: Admin Customer Management - Create New Shop

  Background:
    Given the user is on the admin login page
    When the user enters a valid username
    And the user enters a valid password
    And the user clicks the login button
    Then the user should be redirected to the dashboard

  @smoke @admin @addcustomer
  Scenario: Create a new shop with all fields including image upload
    Given the admin is on the customers page
    When the admin clicks the Add Customer button
    Then the Create New Shop modal should be displayed
    When the admin enters full name "Test Customer"
    And the admin enters email "test@pookal.com"
    And the admin enters password "Test@123"
    And the admin enters role "Admin"
    And the admin enters shop name "Test Flowers"
    And the admin enters phone "9876543210"
    And the admin uploads an image "C:\\Users\\pc\\images\\shop_logo.png"
    And the admin selects plan "Pro"
    And the admin selects billing cycle "Yearly"
    And the admin enters start date "18-09-2026"
    And the admin enters notes "This is a test shop created via automation"
    And the admin clicks the submit button