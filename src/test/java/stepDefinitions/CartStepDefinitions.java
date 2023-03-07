package stepDefinitions;

import java.util.List;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.CartPage;
import utils.TestContextSetup;

public class CartStepDefinitions {

	public TestContextSetup testContextSetup;
	public CartPage cartPage;
	
	public CartStepDefinitions(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.cartPage = testContextSetup.pageObjectManager.getCartPage();
		}
	
		@And("^I reach cart page$")
	    	public void i_reach_cart_page() throws Throwable {
			cartPage.IamInCartPage();	
		}  
	
	  	@Then("^I should see the 3 added items$")
	  		public void i_should_see_the_3_added_items() throws Throwable {
	  		  cartPage.validateThreeElements();
	    }
	   
	    @And("^I should see the same prices as the added items$")
	    	public void i_should_see_the_same_prices_as_the_added_items() throws Throwable {
	    	List<String>listPriceThreeElements = testContextSetup.genericUtils.obtainListPriceElements();
	    	cartPage.validatePrices(listPriceThreeElements);
	    }
}
