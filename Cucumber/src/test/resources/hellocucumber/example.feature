Feature: A set of scenarios for testing the "example" module

  Scenario: Teacher uploads a file in the News forum with size of 256 MB
    Given succefull 'Teacher' Login
    And 'Teacher' successfully navigate to 'My First Course Page'
    And successfully entered 'News Forum'
    When 'Teacher' 
    Then the scenario passes


  Scenario: Testing how a case where a user adds a product to the cart
    Given an example scenario
    When all step definitions are implemented
    Then the scenario passes
