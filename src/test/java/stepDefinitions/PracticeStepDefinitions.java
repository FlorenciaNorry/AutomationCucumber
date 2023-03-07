package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.PracticePage;
import utils.GenericUtils;
import utils.TestContextSetup;

public class PracticeStepDefinitions {
	
	public TestContextSetup testContextSetup;
	public PracticePage practicePage;
	
	public PracticeStepDefinitions(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.practicePage = testContextSetup.pageObjectManager.getPracticePage();
	}
	
	@Given("I am a user on practice page")
	public void i_am_a_user_on_practice_page() {
		Assert.assertEquals(practicePage.verifyPracticePage(), true);
	}
	
	@When("I open a new tab")
	public void i_open_a_new_tab() throws InterruptedException {
		practicePage.openNewTab();
	}
	
	@Then("I should see a new tab opened")
	public void i_should_see_a_new_tab_opened() throws InterruptedException {
		Thread.sleep(3000);
		testContextSetup.genericUtils.switchBetweenTabs(1);
		System.out.println(testContextSetup.genericUtils.getCurrentUrl());
	}
	
	@Then("^I should see a new tab opened containing the '(.*)' url$")
	public void i_should_see_a_new_tab_opened_v2(String url) throws InterruptedException {
		Thread.sleep(3000);
		testContextSetup.genericUtils.switchBetweenTabs(1);
		String currentTabUrl = testContextSetup.genericUtils.getCurrentUrl();
		Assert.assertEquals(currentTabUrl, url);
	}
	
	@Then("I should see all black labels")
	public void iShouldSeeAllBlackLabels() throws InterruptedException {
		Thread.sleep(3000);
		practicePage.playWithVariousElements();
	}
	
	
	
	
	@Then("^I should see elements displayed$")
    public void i_should_see_elements_displayed() {
		practicePage.verifyFirstElement();
		practicePage.verifySecondElement();
    }

    @Then("^I should not see the example element displayed$")
    public void i_should_not_see_the_example_element_displayed() {
        Boolean result = practicePage.verifyElementIsNotDisplayed();
        Assert.assertEquals(result, false);
    }
	
	

}
