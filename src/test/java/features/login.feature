Feature: Login validations

	Background:
	Given I am a user on login page
	
	@smoke @report @asd
  Scenario: Valid login
  When I enter valid credentials
  Then I should see inventory page
  
  @smoke
  Scenario: Valid login
  When I enter valid credentials
  Then I should see inventory page
  
  @smoke
  Scenario: Valid login
  When I enter valid credentials
  Then I should see inventory page
  
  @smoke
  Scenario: Valid login
  When I enter valid credentials
  Then I should see inventory page
  
  @smoke
  Scenario: Valid login
  When I enter valid credentials
  Then I should see inventory page
  
  @smoke
  Scenario: Valid login
  When I enter valid credentials
  Then I should see inventory page
  
  @smoke
  Scenario: Valid login
  When I enter valid credentials
  Then I should see inventory page
  
  @smoke
  Scenario: Valid login
  When I enter valid credentials
  Then I should see inventory page
  
  @smoke
  Scenario: Valid login
  When I enter valid credentials
  Then I should see inventory page
  
  @smoke
  Scenario: Valid login
  When I enter valid credentials
  Then I should see inventory page
  
  @smoke
  Scenario: Valid login
  When I enter valid credentials
  Then I should see inventory page
  
  @smoke
  Scenario: Valid login
  When I enter valid credentials
  Then I should see inventory page
  
  @smoke
  Scenario: Valid login
  When I enter valid credentials
  Then I should see inventory page
  
  @smoke
  Scenario: Valid login
  When I enter valid credentials
  Then I should see inventory page
  
  @smoke
  Scenario: Valid login
  When I enter valid credentials
  Then I should see inventory page
  
  @smoke
  Scenario: Valid login
  When I enter valid credentials
  Then I should see inventory page
  
  @smoke
  Scenario: Valid login
  When I enter valid credentials
  Then I should see inventory page
  
  @smoke
  Scenario: Valid login
  When I enter valid credentials
  Then I should see inventory page
  
  @smoke
  Scenario: Valid login
  When I enter valid credentials
  Then I should see inventory page
  
  @smoke
  Scenario: Valid login
  When I enter valid credentials
  Then I should see inventory page
  
  @report
  Scenario Outline: Valid login combinations
  When I attempt to login with '<user>' user and '<pw>' password
  Then I should see inventory page
  
  Examples:
    | user            | pw           |
    | standard_user   | secret_sauce |
    | locked_out_user | secret_sauce |
    | problem_user    | secret_sauce |


  Scenario: Invalid login
  When I enter invalid credentials
  Then I should see an error message displayed
  
  Scenario: Data Table example
  When I login with the following details
  	| standard_user | secret_sauce |
  	| row 1 col 0   | row 1 col 1  |
  	| row 2 col 0   | row 2 col 1  |
  Then I should see inventory page
  
  
  
  
  