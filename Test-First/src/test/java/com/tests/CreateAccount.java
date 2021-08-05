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


public class CreateAccount extends Browsers {
	
	
	@Test

	public void createAccount () throws InterruptedException, IOException
	{
		driver.get("https://demo.opencart.com/");
	
		File source=new File("Drivers\\FakeMail.xlsx");
			@SuppressWarnings("deprecation")
			WebDriverWait wait = new WebDriverWait(driver, 5, 5);
			
			FileInputStream input = new FileInputStream(source);
			
			
			XSSFWorkbook wb = new XSSFWorkbook(input);
			
			
			XSSFSheet sheet1 = wb.getSheetAt(0);
	      
			
			
			XSSFSheet sheet2 = wb.getSheetAt(0);

			DataFormatter formatter = new DataFormatter();
			
			// klikanje na my acc
			wait.until(ExpectedConditions.presenceOfElementLocated
			         (By.linkText("My Account")));
			driver.findElement(By.linkText("My Account")).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated
			         (By.linkText("Register")));
		
		driver.findElement(By.linkText("Register")).click();
		
		//username
		
		
		
		wait.until(ExpectedConditions.presenceOfElementLocated
		         (By.id("input-firstname")));
		
		driver.findElement(By.id("input-firstname")).sendKeys("Test");
		
		//..
		
		wait.until(ExpectedConditions.presenceOfElementLocated
		         (By.id("input-lastname")));
		
		driver.findElement(By.id("input-lastname")).sendKeys("Test");
		
		//unos emaila
		
		//puni tablice
		
		
		int rowcount = sheet1.getPhysicalNumberOfRows();
		
		
	
			
	
		//pretvori broj u tekst
	//		String data0 = formatter.formatCellValue(sheet1.getRow(i).getCell(1));
	//String data1 =	sheet1.getRow(i).getCell(0).getStringCellValue();
			String mail = formatter.formatCellValue(sheet1.getRow(0).getCell(0));
			WebDriverWait wait6 = new WebDriverWait(driver, 10);
			wait6.until( ExpectedConditions.visibilityOfElementLocated(By.id("input-email")));	    
			
	WebElement unosMaila =   driver.findElement (By.id("input-email"));
			
	         unosMaila.sendKeys(mail);
			

		
		//unos ostalog
		wait.until(ExpectedConditions.presenceOfElementLocated
		         (By.id("input-telephone")));
		
		driver.findElement(By.id("input-telephone")).sendKeys("123456");
		
		wait.until(ExpectedConditions.presenceOfElementLocated
		         (By.id("input-password")));
		String password = formatter.formatCellValue(sheet1.getRow(0).getCell(1));
		driver.findElement(By.id("input-password")).sendKeys(password);
		
		wait.until(ExpectedConditions.presenceOfElementLocated
		         (By.id("input-confirm")));
		
		driver.findElement(By.id("input-confirm")).sendKeys(password);
		
		
		wait.until(ExpectedConditions.presenceOfElementLocated
		         (By.id("input-confirm")));
		
		driver.findElement(By.xpath("//*[@id=\'content\']/form/div/div/input[1]")).click();

			driver.findElement(By.xpath("//*[@id=\'content\']/form/div/div/input[2]")).click();
			driver.findElement(By.linkText("Continue")).click();
		
		}
			

		
		
		
	}