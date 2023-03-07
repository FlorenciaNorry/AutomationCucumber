Feature: Final Proyect

	Background:
	Given I am a user on login page
	When I enter valid credentials
  Then I should see inventory page
  
  @final
	Scenario Outline: Sorting items by '<filter>'
	Given I am a user on inventory page
	When I sort items from '<filter>'
	Then I should see items correctly sorted '<filter>'
	
	Examples:
	| filter        |
	| Name (A to Z) |
	| Name (Z to A) |
	
	#@final
	#Scenario: Sorting items by name (Z to A)
	#Given I am a user on inventory page
	#When I sort items from Z to A
	#Then I should see items correctly sorted 
	
	@final
	Scenario: Cart page validation
	Given I am a user on inventory page
	When I add 3 items to cart
	And I reach cart page
	Then I should see the 3 added items
	And I should see the same prices as the added items