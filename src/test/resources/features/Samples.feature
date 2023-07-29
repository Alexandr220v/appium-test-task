@smoke
Feature: Samples actions
  As a user
  I want to use Samples
  So I will be able to perform different actions

  Scenario: Select samples
    Given user login to app with "admin" and "admin"
    Then user should see Sample list page with title "Samples List"
    And user select "Native View" sample
    And user should see list of native view demos
      | Hello World, I'm View one   |
      | Hello World, I'm View two   |
      | Hello World, I'm View three |
