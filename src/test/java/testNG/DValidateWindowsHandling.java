package testNG;

import org.testng.annotations.Test;

import DPages.DPageOfMultipleWindows;
import utility.BaseLibrary;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class DValidateWindowsHandling extends BaseLibrary{
  @Test(priority=-1)
  public void LaunchMutipleWindow() {
	driver.get(objectprop.getProperty("MultipleWindowURL"));
	System.out.println(driver.getCurrentUrl());
  }
  @Test(priority=0)
  public void ValidateNewBrowserWindow() {
	  //driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	  String ParentWindow=driver.getWindowHandle();
	  driver.findElement(DPageOfMultipleWindows.NewBrowserWindow).click();
	  Set<String> AllWindows=driver.getWindowHandles();
	  for(String window : AllWindows) {
		  driver.switchTo().window(window);
	 	  String Title = driver.getTitle();
		  System.out.println("Title of New Browser : "+Title);
		//  driver.manage().window().maximize();
		  if(Title.equals(objectprop.getProperty("NewBrowserWindowTitle"))) {
			  //driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
			  driver.findElement(DPageOfMultipleWindows.MenuOfNewBrowserWindow).click();
			  driver.findElement(DPageOfMultipleWindows.QA_Automation).click();
			  driver.findElement(DPageOfMultipleWindows.Practice_Automation).click();
			  driver.close();
		  }
	  }
	  driver.switchTo().window(ParentWindow);
	  String ParentWindowText=driver.findElement(DPageOfMultipleWindows.NewBrowserWindow).getText();
	  System.out.println("ParentWindowText : "+ParentWindowText);
	 // driver.quit();
  }

	/*
	 * @Test public void ValidateNewMessageWindow() { String
	 * ParentWindow=driver.getWindowHandle(); ParentWindow=driver.getTitle();
	 * System.out.println("ParentWindow : "+ParentWindow);
	 * driver.findElement(DPageOfMultipleWindows.NewMessageWindow).click();
	 * Set<String> ChildWindows=driver.getWindowHandles(); for(String Window :
	 * ChildWindows) { driver.switchTo().window(Window);
	 * System.out.println(driver.getTitle()); } }
	 */
  @Test(priority=1)
  public void ValidateNewBrowserTab() {
	  driver.getWindowHandle();
	  driver.findElement(DPageOfMultipleWindows.NewBrowserTab).click();
	  Set<String> ChildWindows=driver.getWindowHandles();
	  for(String Window : ChildWindows) {
		  driver.switchTo().window(Window);
		  String NewBrowserWindowText=driver.getTitle();
		  System.out.println("NewBrowserWindowText : "+NewBrowserWindowText);
		  if(NewBrowserWindowText.equals(objectprop.getProperty("NewBrowserTabTitle"))) {
		  System.out.println(driver.getTitle());
		  driver.switchTo().window(Window);
		  driver.findElement(DPageOfMultipleWindows.QA_Automation1).click();
		  driver.findElement(DPageOfMultipleWindows.Practice_Automation1).click();
		  driver.findElement(DPageOfMultipleWindows.DemoSite_MultipleWindows).click();
		  System.out.println(driver.getTitle());
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
