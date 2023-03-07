@practice
Feature: Practice

  @id004
  Scenario: Practice scenario
    Given I am a user on practice page
    When I open a new tab
    Then I should see a new tab opened containing the 'https://www.rahulshettyacademy.com/' url
    
  @id005
  Scenario: Practice with multiple webelements
  Given I am a user on practice page
  Then I should see all black labels
  
  @exampleWaitTest1
  Scenario: Practice wait scenario 1
  Given I am a user on practice page
  Then I should see elements displayed
  
  @exampleWaitTest2
  Scenario: Practice wait scenario 2
  Given I am a user on practice page
  Then I should not see the example element displayed
  