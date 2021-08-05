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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import BrowserLaunch.Browsers;

public class AddItemToWishList extends Browsers
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

driver.findElement(By.xpath("//*[@id=\'content\']/div/div[2]/div/form/input")).click();
	
wait.until(ExpectedConditions.urlContains("https://demo.opencart.com/index.php?route=account/account"));
	driver.findElement(By.linkText("Desktops")).click();
	
	wait.until(ExpectedConditions.presenceOfElementLocated
	        (By.xpath("//*[@id=\'menu\']/div[2]/ul/li[1]/div/div/ul/li[1]/a")));
			
	
	//search for products
	
	driver.findElement(By.linkText("Desktops")).click();
	
	wait.until(ExpectedConditions.presenceOfElementLocated
	         (By.linkText("Show All Desktops")));
	
	driver.findElement(By.linkText("Show All Desktops")).click();
	
	driver.findElement(By.xpath("//*[@id=\'column-left\']/div[1]/a[1]")).click();
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("//div[@class='row']//div[2]//div[1]//div[2]//div[2]//button[2]")).click();
	
	
	
	
	wait.until(ExpectedConditions.presenceOfElementLocated
			(By.id("wishlist-total")));
	Thread.sleep(3000);
	driver.findElement(By.id("wishlist-total")).click();
	
	wait.until(ExpectedConditions.presenceOfElementLocated
			 (By.xpath("//*[@id=\'content\']/h2")));
	
	Thread.sleep(3000);
	wait.until(ExpectedConditions.presenceOfElementLocated
			 (By.className("table-responsive")));//*[@id="content"]/div[4]/div[1]/div/div[2]/div[2]/button[2]
	
	
	
	driver.findElement(By.xpath("//td[6]/a")).click();
//	driver.findElement(By.cssSelector(".btn-danger")).click();
	wait.until(ExpectedConditions.presenceOfElementLocated
			 (By.cssSelector(".alert")));
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
 */
