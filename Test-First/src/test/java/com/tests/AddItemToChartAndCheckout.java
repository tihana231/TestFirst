package com.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import BrowserLaunch.Browsers;

public class AddItemToChartAndCheckout extends Browsers
{
	
	 
     
	
	@Test

	public void LoginAndSearch () throws InterruptedException, IOException
	{
		
		driver.get("https://demo.opencart.com/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated
		         (By.linkText("My Account")));
		driver.findElement(By.linkText("My Account")).click();
	
	wait.until(ExpectedConditions.presenceOfElementLocated
		         (By.linkText("Login")));
	
	driver.findElement(By.linkText("Login")).click();
	
	
	wait.until(ExpectedConditions.presenceOfElementLocated
	         (By.id("input-email")));

	File source=new File("Drivers\\FakeMail.xlsx");
	FileInputStream input = new FileInputStream(source);
	XSSFWorkbook wb = new XSSFWorkbook(input);
	XSSFSheet sheet1 = wb.getSheetAt(0);
	XSSFSheet sheet2 = wb.getSheetAt(0);
	DataFormatter formatter = new DataFormatter();
	String mail = formatter.formatCellValue(sheet1.getRow(0).getCell(0));
	WebElement unosMaila =   driver.findElement (By.id("input-email"));
	unosMaila.sendKeys(mail);
	String password = formatter.formatCellValue(sheet1.getRow(0).getCell(1));
	WebElement unosPass = driver.findElement(By.id("input-password"));
	unosPass.sendKeys(password);

wait.until(ExpectedConditions.presenceOfElementLocated
        (By.xpath("//*[@id=\'content\']/div/div[2]/div/form/input")));
Thread.sleep(1000);
driver.findElement(By.xpath("//*[@id=\'content\']/div/div[2]/div/form/input")).click();
Thread.sleep(1000);
wait.until(ExpectedConditions.urlContains("https://demo.opencart.com/index.php?route=account/account"));
	driver.findElement(By.linkText("Desktops")).click();
	Thread.sleep(1000);
	wait.until(ExpectedConditions.presenceOfElementLocated
	        (By.xpath("//*[@id=\'menu\']/div[2]/ul/li[1]/div/div/ul/li[1]/a")));
			
	
	//search for products
	
	driver.findElement(By.linkText("Desktops")).click();
	
	wait.until(ExpectedConditions.presenceOfElementLocated
	         (By.linkText("Show All Desktops")));
	Thread.sleep(1000);
	driver.findElement(By.linkText("Show All Desktops")).click();
	wait.until(ExpectedConditions.presenceOfElementLocated
			(By.cssSelector(".product-layout:nth-child(1) button:nth-child(1)")));
	
	
	Thread.sleep(1000);
	
	driver.findElement(By.xpath("//div[3]/div/div[2]/div[2]/button")).click();
	
	wait.until(ExpectedConditions.presenceOfElementLocated
			(By.cssSelector("#button-cart")));
	Thread.sleep(4000);
	driver.findElement(By.cssSelector("#button-cart")).click();
	
	wait.until(ExpectedConditions.presenceOfElementLocated
			(By.cssSelector(".alert")));
	
	wait.until(ExpectedConditions.presenceOfElementLocated
			(By.xpath("//div[@id='cart']/button")));
	Thread.sleep(1000);
	driver.findElement(By.xpath("//div[@id='cart']/button")).click();
	wait.until(ExpectedConditions.presenceOfElementLocated
			(By.xpath("//a[2]/strong")));
	Thread.sleep(1000);
	driver.findElement(By.xpath("//a[2]/strong")).click();
	Thread.sleep(1000);
	wait.until(ExpectedConditions.presenceOfElementLocated
			(By.xpath("//a[contains(text(),'Checkout')]")));
	Thread.sleep(1000);
	
	if (driver.findElement(By.id("input-payment-firstname")).isDisplayed())
	{	
			
		driver.findElement(By.id("input-payment-firstname")).sendKeys("Test");
		driver.findElement(By.id("input-payment-lastname")).sendKeys("Test");
		driver.findElement(By.id("input-payment-company")).sendKeys("Test");
		driver.findElement(By.id("input-payment-address-1")).sendKeys("Test");
		driver.findElement(By.id("input-payment-address-2")).sendKeys("Test");
		driver.findElement(By.id("input-payment-city")).sendKeys("Test");
		driver.findElement(By.id("input-payment-postcode")).sendKeys("Test");
		WebElement unesidrzavu = driver.findElement(By.id("input-payment-country"));
		Select unesi = new Select(unesidrzavu);
		Thread.sleep(2000);
		unesi.selectByIndex(2);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("input-payment-zone")));
	//	WebElement unesiregiju = driver.findElement(By.id("input-payment-zone"));
		WebElement dropdown =  driver.findElement(By.id("input-payment-zone"));
		Thread.sleep(2000);
		dropdown.click();
		dropdown.sendKeys(Keys.DOWN, Keys.RETURN);
	//	Select unsesid = new Select(dropdown);
	
		//unsesid.selectByValue("3513");
	
		wait.until(ExpectedConditions.presenceOfElementLocated
				(By.xpath("//*[@id=\'input-payment-zone\']/option[2]")));
		driver.findElement(By.xpath("//*[@id=\'input-payment-zone\']/option[2]")).click();
		
		
	}	
	else
	{
		
		wait.until(ExpectedConditions.presenceOfElementLocated
				(By.xpath("//*[@id=\'button-payment-address\']")));
		
		
	}
	Thread.sleep(4000);
	driver.findElement(By.xpath("//*[@id=\'button-payment-address\']")).click();
	wait.until(ExpectedConditions.presenceOfElementLocated
			(By.id("button-shipping-address")));
	
	Thread.sleep(4000);
	driver.findElement(By.id("button-shipping-address")).click();
	
	wait.until(ExpectedConditions.presenceOfElementLocated
			(By.cssSelector("#button-shipping-method")));
	Thread.sleep(4000);
	driver.findElement(By.cssSelector("#button-shipping-method")).click();
	wait.until(ExpectedConditions.presenceOfElementLocated
			(By.cssSelector("input[value='1']")));
	Thread.sleep(4000);
	driver.findElement(By.cssSelector("input[value='1']")).click();
	wait.until(ExpectedConditions.presenceOfElementLocated
			(By.id("button-payment-method")));
	Thread.sleep(4000);
	driver.findElement(By.id("button-payment-method")).click();
	wait.until(ExpectedConditions.presenceOfElementLocated
			(By.id("button-confirm")));
	Thread.sleep(4000);
	driver.findElement(By.id("button-confirm")).click();
	wait.until(ExpectedConditions.presenceOfElementLocated
	         (By.linkText("Continue")));
	Thread.sleep(4000);
	driver.findElement(By.linkText("Continue")).click();
	
	
}
	
	
	
	
}

/*

input-password
//*[@id="content"]/div/div[2]/div/form/input
 * 
 * //*[@id="column-left"]/div[1]/a[1]
 * //*[@id="content"]/h2
 *  Success: You have modified your wish list!
 * wishlist-total
 * Show All Desktops
 * 
 * 
 * 
driver.findElement(By.id("input-email")).sendKeys("Tes4t@t.t");

wait.until(ExpectedConditions.presenceOfElementLocated
        (By.id("input-password")));

driver.findElement(By.id("input-password")).sendKeys("Test");
 */
