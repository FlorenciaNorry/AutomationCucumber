package pageObjects;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CartPage {
	
public WebDriver driver;
	
	By cartContainer = By.className("cart_item");
	By price = By.className("inventory_item_price");

	public CartPage(WebDriver driver) {
		this.driver = driver;
	}	

	public void IamInCartPage() {
		driver.findElement(cartContainer).isDisplayed();
	}
	
	public void validateThreeElements() {
		List<WebElement> quantityCarts = driver.findElements(cartContainer);
		//System.out.println(quantityCarts.size());
		Assert.assertEquals(3, quantityCarts.size());
	}
	
	public void validatePrices(List<String> listPriceThreeElements) {
		List<WebElement> priceCart = driver.findElements(price);
		
		for(int i=0; i<priceCart.size(); i++) {
			String pecio = priceCart.get(i).getText(); 
			Assert.assertEquals(pecio, listPriceThreeElements.get(i));
			//System.out.println(pecio);
			//System.out.println(listPriceThreeElements.get(i));
		}
	}
}
