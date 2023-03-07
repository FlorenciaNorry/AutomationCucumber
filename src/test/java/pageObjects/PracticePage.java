package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PracticePage {
	
	public WebDriver driver;
	
	public PracticePage(WebDriver driver) {
		this.driver = driver;
	}
	
	By newTabButton = By.cssSelector("#opentab");
	By blackButtonLabels = By.cssSelector(".block.large-row-spacer legend");
	By firstElement = By.cssSelector("#hide-textbox");
	By secondElement = By.cssSelector("asd#show-textbox");
	By hiddenElement = By.cssSelector("#displayed-text");
	
	
	public void verifyFirstElement() {
		driver.findElement(firstElement);
	}
	
	public void verifySecondElement() {
		driver.findElement(secondElement);
	}
	
	public Boolean verifyElementIsNotDisplayed() {
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.invisibilityOfElementLocated(hiddenElement));
		return driver.findElement(hiddenElement).isDisplayed();
	}
	
	
	
	public void openNewTab() {
		driver.findElement(newTabButton).click();
	}
	
	public Boolean verifyPracticePage() {
		return driver.findElement(newTabButton).isDisplayed();
	}
	
	/*
	 * recibe:
	 * hace tal cosa:
	 */
	public void playWithVariousElements() {
		List<WebElement> elems = driver.findElements(blackButtonLabels);
		for(int i = 0; i < elems.size(); i++) {
			System.out.println(elems.get(i).getText());
		}
	}

}
