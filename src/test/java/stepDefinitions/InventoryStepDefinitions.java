package stepDefinitions;

import java.util.List;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.InventoryPage;
import utils.TestContextSetup;

public class InventoryStepDefinitions {
	
	//public WebDriver driver;
	public TestContextSetup testContextSetup;
	public InventoryPage inventoryPage;
	
	public InventoryStepDefinitions(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.inventoryPage = testContextSetup.pageObjectManager.getInventoryPage();
	}
	
	@Then("I should see inventory page")
	public void i_should_see_inventory_page() {
		Assert.assertEquals(inventoryPage.verifyInventoryPage(), true);
	}
	
	//Comienzo del proyecto final 
	   @Given("^I am a user on inventory page$")
	    public void i_am_a_user_on_inventory_page() throws Throwable {
	    }
	
	    //test1 y 2
	    @When("^I sort items from '(.*)'$")
	    public void i_sort_items_from_z_to_a(String filter) throws Throwable {
	    	inventoryPage.listProducts();
	    	inventoryPage.sortedList(filter);
	    }
	    
	    @Then("^I should see items correctly sorted '(.*)'$")
	    public void i_should_see_items_correctly_sorted(String filter) throws Throwable {
	    	inventoryPage.sortedItems(filter);
	    }
	    
	    
	    //test3
	    @When("^I add 3 items to cart$")
	    public void i_add_3_items_to_cart() throws Throwable {
	    	List<String>priceThreeProducts=inventoryPage.randomThreeItems();
	    	testContextSetup.genericUtils.saveListPriceElements(priceThreeProducts);
	    	inventoryPage.clickButtonCart();
	    }

	   
}
