package testNG;

import org.testng.annotations.Test;

import utility.BaseLibrary;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class D_DropDown extends BaseLibrary{
  @Test(priority=-1)
  public void ValidateDropDownLunchBrowser() {
	  driver.get(objectprop.getProperty("DropDownURL"));
  }
  @Test(priority=0)
  public void ValidateDropDown() {
	  JavascriptExecutor js=(JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy(0,400)");
	  WebElement dropdownelement=driver.findElement(By.id("testingDropdown"));
	  dropdownelement.click();
	  Select ObjectSelect=new Select(dropdownelement);
	  //ObjectSelect.selectByIndex(2);
	  List<WebElement> AllElements=ObjectSelect.getOptions();
	  for(int i=0;i<AllElements.size();i++) {
		  String DropDownValue=AllElements.get(i).getText();
		  System.out.println("DropDownValue : "+DropDownValue);
		  if(DropDownValue.equalsIgnoreCase(objectprop.getProperty("SelectOption"))) {
			  AllElements.get(i).click();
		  }
	  }
	  TakeScreenShots();
	  
	  
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
