Feature: Register
  As a new user
  I want to register the Application
  So that I can navigate through the application

  @test5
  Scenario: New User Register

    Given new user is on the Login page
    When user click on Register link
    And enter following credential
      | testing | newThing@yahoo.com | password1 | Polski  |
      | sakr    | test@yahoo.com     | mank123   | English |
    Then User should able login application
