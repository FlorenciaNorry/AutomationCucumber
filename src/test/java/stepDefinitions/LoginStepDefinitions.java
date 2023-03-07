package stepDefinitions;

import java.util.List;

import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import utils.TestContextSetup;

public class LoginStepDefinitions {
	
	//public WebDriver driver;
	public TestContextSetup testContextSetup;
	public LoginPage loginPage;
	
	public LoginStepDefinitions(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.loginPage = testContextSetup.pageObjectManager.getLoginPage();
	}
	
	@When("^I login with the following details$")
    public void i_login_with_the_following_details(DataTable table) throws InterruptedException {
        List<List<String>> li = table.asLists();
        
        //loginPage.loginWithCredentials(li.get(0).get(0), li.get(0).get(1));
        
        //System.out.println(li.get(0).get(0) + " | " + li.get(0).get(1));
        System.out.println(li.get(1).get(0) + " | " + li.get(1).get(1));
        System.out.println(li.get(2).get(0) + " | " + li.get(2).get(1));
    }
	
	@When("^I do something on the background block$")
    public void i_do_something_on_the_background_block() {
        System.out.println("I'M IN BACKGROUND BLOCK!!");
    }
	
	

	@Given("I am a user on login page")
	public void i_am_a_user_on_login_page() {
		Assert.assertEquals(loginPage.verifyLoginPage(), true);
	}
	
	@When("I enter valid credentials")
	public void i_enter_valid_credentials() throws InterruptedException {
		loginPage.loginWithCredentials("standard_user", "secret_sauce");
	}
	
	@When("I enter invalid credentials")
	public void i_enter_invalid_credentials() throws InterruptedException {
		loginPage.loginWithCredentials("standard_user", "invalid pass");
	}
	
	@When("^I attempt to login with '(.*)' user and '(.*)' password$")
	public void i_enter_credentials(String user, String pw) throws InterruptedException {
		loginPage.loginWithCredentials(user, pw);
	}
	
	@Then("I should see an error message displayed")
	public void i_should_see_an_error_message_displayed() {
		Assert.assertEquals(loginPage.verifyErrorMesage(), true);
		Assert.assertEquals(loginPage.getLoginErrorMessage(), "Epic sadface: Username and password do not match any user in this service");
	}
	
}
