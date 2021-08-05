package com.tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import BrowserLaunch.Browsers;

public class writeFakeMailtoExcel extends Browsers
{
	@Test
	public void GetFakeMailForRegistration () throws IOException
	{
	driver.get("http://www.fakemailgenerator.com/");

	
	String mail = driver.findElement(By.id("home-email")).getAttribute("value");
	XSSFWorkbook woorkbook = new XSSFWorkbook();
	XSSFSheet sheet1 = woorkbook.createSheet("List1");
	
	Row r0 =sheet1.createRow(0);
	Cell addmail = r0.createCell(0);
	addmail.setCellValue(mail+"@gmm.ss");
	
	
	Cell addpass = r0.createCell(1);
	addpass.setCellValue("1234567");
	
	

	File f = new File("Drivers\\FakeMail.xlsx");
	FileOutputStream fos = new FileOutputStream(f);
	woorkbook.write(fos);
	fos.close();
	woorkbook.close();
	System.out.println(mail);
	
	
}}

