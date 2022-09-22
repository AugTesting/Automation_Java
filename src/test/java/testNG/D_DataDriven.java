package testNG;

import org.testng.annotations.Test;

import utility.BaseLibrary;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class D_DataDriven extends BaseLibrary{
  @Test(priority=1)
  public void LaunchAutomationDemoSitePage() {
	 driver.get(objectprop.getProperty("AutomationDemoSiteURL")); 
	 String PageTitle=driver.getTitle();
	 System.out.println("PageTitle : "+PageTitle);
	 Assert.assertEquals(PageTitle, objectprop.getProperty("AutomationDemoSitePageText"));
	 
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
