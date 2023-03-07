package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class TestBase {

	public WebDriver driver;
	
	@SuppressWarnings("deprecation")
	public WebDriver webDriverManager() throws IOException {
		
		FileInputStream f = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\global.properties");
		
		Properties prop = new Properties();
		prop.load(f);
		
		String browser_properties = prop.getProperty("browser");
		String browser_maven = System.getProperty("browser");
		
		String browser = browser_maven != null ? browser_maven : browser_properties;
		
		String url_properties = "ExerciseUrl";
		String url_maven = System.getProperty("url");
		
		String url = url_maven != null ? url_maven : url_properties;
		
		
		if(driver == null) {
			
			if(browser.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\Flor Norry\\Desktop\\upskillingTucuman\\ultimo\\driver\\chromedriver.exe");
			    driver = new ChromeDriver();
			    
			    //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			} else if(browser.equals("firefox")) {
				
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--path C:\\selenium-drivers\\geckodriver.exe");
		        driver = new FirefoxDriver(options);
				
			}
			
		    driver.get(prop.getProperty(url));
		
		}
		
	    return driver;
	}
}
