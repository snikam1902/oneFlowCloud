@test1
Feature: Login
  As a user
  I want to login the Application
  So that I can navigate to application

  Scenario: Login the Application
    Given user is on the Login page
    When user enter username "kavita" and password "manjarbok1"
    Then user shoud be able to login


  Scenario Outline: Login unsuccessful
    Given user is on the Login page
    When user enter invalid  "<username>" and invalid "<password>"
    Then user should get error "<message>"
    Examples:
      | username | password   | message               |
      | kavita   | *          | Login forbidden       |
      | 8$%7     | manjarbok1 | Internal server error |


  Scenario: Forgot password
    Given user is on the Login page
    When user click on forgot password
    And enter valid "test1@yahoo.com"
    Then  password is sent to email

