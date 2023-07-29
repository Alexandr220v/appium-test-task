@smoke
Feature: Login
  As a user
  I want to login to app
  So I will be able to use basic functions

  Scenario: Login with valid username and password
    Given user login to app with "admin" and "admin"
    Then user should see Sample list page with title "Samples List"
    And user should see Sample list of samples
      | Native View      |
      | Slider           |
      | Vertical swiping |
      | Drag & Drop      |
      | Double Tap       |
      | Long Press       |
      | Photo View       |
      | Web View         |
      | Carousel         |
      | Wheel Picker     |


  Scenario Outline: Login with invalid username and password
    Given user login to app with "<username>" and "<password>"
    Then user should see "<error message>"

    Examples:
      | username                             | password | error message                     |
      | admin                                | invalid  | Invalid  Credentials              |
      | admin                                | empty    | Please enter Username or password |
      | invalid                              | admin    | Invalid  Credentials              |
      | empty                                | admin    | Please enter Username or password |
      | empty                                | empty    | Please enter Username or password |
      | verylongusernameverylongusernamevery | admin    | Invalid  Credentials              |
