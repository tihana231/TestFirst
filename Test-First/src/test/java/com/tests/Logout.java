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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import BrowserLaunch.Browsers;

public class Logout extends Browsers
{
	@Test

	public void createAccount () throws InterruptedException, IOException
	{
		driver.get("https://demo.opencart.com/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
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
wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("My Account")));
driver.findElement(By.linkText("My Account")).click();

wait.until(ExpectedConditions.presenceOfElementLocated
        (By.linkText("Logout")));
WebElement logout = driver.findElement(By.linkText("Logout"));
String textlogout = logout.getText();
System.out.println (textlogout);
driver.findElement(By.linkText("Logout")).click();
	
wait.until(ExpectedConditions.urlContains("https://demo.opencart.com/index.php?route=account/logout"));

wait.until(ExpectedConditions.presenceOfElementLocated
        (By.linkText("Logout")));
}
}

/*
input-email
input-password
//*[@id="content"]/div/div[2]/div/form/input
*/