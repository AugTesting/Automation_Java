package testNG;

import org.testng.annotations.Test;

import DPages.DPagesOfFileUpload;
import utility.BaseLibrary;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class D_FileUpload extends BaseLibrary{
  @Test(priority=0)
  public void ValidateLaunchFileUploadURL() {
	  driver.get(objectprop.getProperty("FileUploadURL"));
	  System.out.println(driver.getCurrentUrl());
	  String PageTitle=driver.getTitle();
	  System.out.println("PageTitle : "+PageTitle);
	  Assert.assertEquals(PageTitle, objectprop.getProperty("DemoPageTitle"));
  }
  @Test(priority=1)
  public void ValidateLaunchFileUpload() throws InterruptedException {
	  Actions object=new Actions(driver);
	  WebElement BrowserElement=driver.findElement(DPagesOfFileUpload.BrowseButton);
	  object.click(BrowserElement).build().perform();
	  File objfile=new File(System.getProperty("user.dir")+"//src//test//resources//Image1.jpg");
	  
	  StringSelection objStringSelection=new StringSelection(objfile.toString());
	  Clipboard objClipboard=Toolkit.getDefaultToolkit().getSystemClipboard();
	  objClipboard.setContents(objStringSelection, null);
	  
	  Transferable objTransferable=objClipboard.getContents(null);
	  if(objTransferable.isDataFlavorSupported(DataFlavor.stringFlavor)) {
		  try {
			  System.out.println(objTransferable.isDataFlavorSupported(DataFlavor.stringFlavor));  
	  }catch(Exception e) {
		  e.printStackTrace();
	  }
	}
	  Robot objRobot;
	try {
		Thread.sleep(4000);
		objRobot = new Robot();
		objRobot.keyPress(KeyEvent.VK_ENTER);
		objRobot.keyRelease(KeyEvent.VK_ENTER);
		objRobot.keyPress(KeyEvent.VK_CONTROL);
		objRobot.keyPress(KeyEvent.VK_V);
		objRobot.keyRelease(KeyEvent.VK_CONTROL);
		objRobot.keyRelease(KeyEvent.VK_V);
		objRobot.keyPress(KeyEvent.VK_ENTER);
		objRobot.keyRelease(KeyEvent.VK_ENTER);
	} catch (AWTException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
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
