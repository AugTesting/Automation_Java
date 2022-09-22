package testNG;

import org.testng.annotations.Test;

import DPages.DPagesOfWebTables;
import utility.BaseLibrary;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class D_WebTables extends BaseLibrary {
  @Test(priority=-2)
  public void ValidateLaunchWebTablePage() {
	  driver.get(objectprop.getProperty("WebTableURL"));
	  String WebTablePageTitle=driver.getTitle();
	  System.out.println("WebTablePageTitle : "+WebTablePageTitle);
	  Assert.assertEquals(WebTablePageTitle, objectprop.getProperty("WebTableTitle"));
  }
  @Test(priority=-1)
	  public void ValidateDataFromWebTable() throws InterruptedException {
	  JavascriptExecutor js=(JavascriptExecutor) driver; 
	  js.executeScript("window.scrollBy(0,500)");
	  List<WebElement>AllLastNames=driver.findElements(DPagesOfWebTables.AllLastNames);
	  int count=AllLastNames.size();
	  Thread.sleep(3000);
	  for(int i=1;i<=count;i++) {
		  String LastName=driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+i+"]/td[3]")).getText();
		  System.out.println("LastName"+i+ LastName);
		  if(LastName.equalsIgnoreCase(objectprop.getProperty("LastNameProvided"))) {
			 String FirstNmae=driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+i+"]/td[2]")).getText();
			 String Position=driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+i+"]/td[4]")).getText();
			 String Office=driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+i+"]/td[5]")).getText();
			 String StartDate=driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+i+"]/td[6]")).getText();
			 String Salary=driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+i+"]/td[7]")).getText();
			 System.out.println("FirstNmae "+FirstNmae);
			 System.out.println("Position "+Position);
			 System.out.println("Office"+Office);
			 System.out.println("StartDate "+StartDate);
			 System.out.println("Salary "+Salary);
			 break;
			 
		  }
		  
	  }
	  
  }
  
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
	  LaunchBrowser();
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
	  try {
		ReadPropertiesFile();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }

  @AfterSuite
  public void afterSuite() {
  }

}
