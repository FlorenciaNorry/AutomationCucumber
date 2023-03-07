package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	
	public LoginPage loginPage;
	public InventoryPage inventoryPage;
	public PracticePage practicePage;
	public CartPage cartPage;
	public WebDriver driver;
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public LoginPage getLoginPage() {
		loginPage = new LoginPage(driver);
		return loginPage;
	}
	
	public InventoryPage getInventoryPage() {
		inventoryPage = new InventoryPage(driver);
		return inventoryPage;
	}
	
	public PracticePage getPracticePage() {
		practicePage = new PracticePage(driver);
		return practicePage;
	}
	
	public CartPage getCartPage() {
		cartPage = new CartPage(driver);
		return cartPage;
	}

}
