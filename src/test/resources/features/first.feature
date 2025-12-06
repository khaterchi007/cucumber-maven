@Unique
Feature: Basic login test

  As a user,
  I want to verify that the login works
  So that I can access the application.

  @MyFirst
  Scenario: Successful login with valid credentials
    Given the user is on the login page
    When the user enters "admin" and "motdepasse123"
    And the user clicks the "Login" button
    Then the user is redirected to the home page
    And the welcome message "Welcome, admin!" is displayed