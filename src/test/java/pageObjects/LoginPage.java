package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By userInput = By.cssSelector("#user-name");
	By pwInput = By.cssSelector("#password");
	By submitButton = By.xpath("//input[@type='submit']");
	By errorMessage = By.cssSelector("[data-test='error']");
	
	public void loginWithCredentials(String user, String pw) throws InterruptedException {
		driver.findElement(userInput).sendKeys(user);
		Thread.sleep(2000);
		driver.findElement(pwInput).sendKeys(pw);
		Thread.sleep(2000);
		driver.findElement(submitButton).click();
	}
	
	public Boolean verifyLoginPage() {
		return driver.findElement(userInput).isDisplayed();
	}
	
	public Boolean verifyErrorMesage() {
		return driver.findElement(errorMessage).isDisplayed();
	}
	
	public String getLoginErrorMessage() {
		return driver.findElement(errorMessage).getText();
	}
}
