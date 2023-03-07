package pageObjects;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class InventoryPage {
	public WebDriver driver;

	public InventoryPage(WebDriver driver) {
		this.driver = driver;
	}

	By inventoryPagecontainer = By.cssSelector("#inventory_container");
	By filterProducts = By.className("product_sort_container");
	By itemName = By.xpath("//div[@class='inventory_item_name']");
	By addToCartButton = By.xpath("//*[contains(@id,'add-to-cart')]");
	By price = By.className("inventory_item_price");
	By cartButton = By.cssSelector("#shopping_cart_container");
	

	public Boolean verifyInventoryPage() {
		return driver.findElement(inventoryPagecontainer).isDisplayed();
	}

	public void listProducts() {
		driver.findElement(filterProducts).click();
	}

	public void sortedList(String filter) {
		Select list = new Select(driver.findElement(filterProducts));
		List<WebElement> nameFilter = list.getOptions();
		
		for (int i = 0; i < nameFilter.size(); i++) {
			if (filter.equals(nameFilter.get(i).getText())) {
				nameFilter.get(i).click();
				break;
			}
		}
	}

	public void sortedItems(String filter) {
		List<String> elements = new ArrayList<String>();
		List<String> elements2 = new ArrayList<String>();
		List<WebElement> products = driver.findElements(itemName);

		for (int i = 0; i < products.size(); i++) {
			elements.add(products.get(i).getText());
		}
		
		if (filter.equals("Name (A to Z)")) {
			elements2 = elements.stream().sorted().collect(Collectors.toList());
		}else if (filter.equals("Name (Z to A)")) {
			elements2 = elements.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		}
		Assert.assertEquals(elements, elements2);
	}
	
	
	public List<String> randomThreeItems() {
		List<String> allPrices = new ArrayList<String>();
		List<WebElement> priceProducts = driver.findElements(price);
		List<WebElement> addToCart = driver.findElements(addToCartButton);
		for (int i = 0; i < 3; i++) {
			int a = (int) (Math.random()*priceProducts.size());
			addToCart.get(a).click();
			allPrices.add(priceProducts.get(a).getText());
		}
		return allPrices;
	}
	
	
	public void clickButtonCart() {
		driver.findElement(cartButton).click();
	}
}
