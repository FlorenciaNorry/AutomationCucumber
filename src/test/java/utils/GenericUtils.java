package utils;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;

public class GenericUtils {
	
	public WebDriver driver;
	private List<String> listPricesCart;
	public GenericUtils(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void switchBetweenTabs(int desiredTab) {
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(desiredTab));
	}
	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	public void saveListPriceElements(List<String>priceThreeProducts) {
		this.listPricesCart = priceThreeProducts;
	}
	
	public List<String> obtainListPriceElements() {
		return listPricesCart;
	}
}
