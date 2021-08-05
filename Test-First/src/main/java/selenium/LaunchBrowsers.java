package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Parameters;

public class LaunchBrowsers {

	 public static WebDriver driver;
	
	 @SuppressWarnings("deprecation")
	@BeforeTest
	 @Parameters("browser")
	 
	public void setUp(String browser) throws Exception {
		// TODO Auto-generated method stub

			//Check if parameter passed from TestNG is 'firefox'
			if(browser.equalsIgnoreCase("Firefox")){
		
				System.setProperty("webdriver.geckodriver.driver", ".Drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
			//Check if parameter passed as 'chrome'
			else if(browser.equalsIgnoreCase("Chrome")){
				
				System.setProperty("webdriver.chrome.driver",".Drivers\\chromedriver.exe");
				
				driver = new ChromeDriver();
			}

					
			else{
				//If no browser passed throw exception
				throw new Exception("Browser is not correct");
			}
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}		 
		 
	 
}
		 
		 /*System.setProperty("webdriver.chrome.driver","Drivers\\chromedriver.exe");
driver = new ChromeDriver();
driver.get("https://demo.opencart.com/");
System.out.println(driver.getTitle());
driver.quit();

/*
System.setProperty("webdriver.geckodriver.driver","Drivers\\geckodriver.exe");
WebDriver driver1 = new ChromeDriver();
driver1.get("https://demo.opencart.com/");
System.out.println(driver1.getTitle());
driver1.quit();*/
	


