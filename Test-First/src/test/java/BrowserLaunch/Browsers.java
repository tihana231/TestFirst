package BrowserLaunch;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeOptions;



public class Browsers {

	public static WebDriver driver;
	public static Actions action;
	
	@SuppressWarnings("deprecation")
	@BeforeMethod(alwaysRun=true)
	 @Parameters("browser")
	public void openBrowser(@Optional("Firefox") String browser) throws Exception {
		if(browser.equalsIgnoreCase("Firefox")){
			
			System.setProperty("webdriver.gecko.driver", "Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
	//		driver.get("https://demo.opencart.com/");
			driver.manage().window().maximize();
		 driver.get("https://demo.opencart.com/");
		}
		//Check if parameter passed as 'chrome'
		else if(browser.equalsIgnoreCase("Chrome")){
			
			System.setProperty("webdriver.chrome.driver","Drivers\\chromedriver.exe");
			
			driver = new ChromeDriver();
	//		driver.get("https://demo.opencart.com/");
			driver.manage().window().maximize();
		}
else if(browser.equalsIgnoreCase("ChromeHeadless")){
			
			System.setProperty("webdriver.chrome.driver","Drivers\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("window-size=1400,800");
			options.addArguments("headless");
			driver = new ChromeDriver(options);
	//		driver.get("https://demo.opencart.com/");
			driver.manage().window().maximize();
		}
				
		else{
			//If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}		 
	 
	 

	 
		
	
	@AfterMethod
	public void closeBrowser(@Optional("Chrome") String browser) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.quit();
}
}