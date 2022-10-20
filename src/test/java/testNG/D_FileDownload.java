package testNG;

import org.testng.annotations.Test;

import DPages.DpagesOfFileDownload;
import utility.BaseLibrary;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class D_FileDownload extends BaseLibrary {
	/*
	 * @Test(priority=-1) public void LaunchFileDownloadPage(){
	 * driver.get(objectprop.getProperty("FileDownloadURL"));
	 * System.out.println(driver.getCurrentUrl()); String
	 * PageTitle=driver.getTitle(); System.out.println(driver.getTitle());
	 * Assert.assertEquals(PageTitle,
	 * objectprop.getProperty("FileDownloadPageText")); }
	 * 
	 * @Test(priority=-1) public void ValidateFileDownload() throws
	 * InterruptedException{ JavascriptExecutor js= (JavascriptExecutor) driver;
	 * js.executeScript("window.scrollBy(0,600)");
	 * driver.findElement(DpagesOfFileDownload.FileSize1MB).click();
	 * driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); File
	 * objFile=new File(System.getProperty("user.dir"));
	 * System.out.println(objFile); File[] AllFiles =objFile.listFiles(); Boolean
	 * FileFound=false; for(File EachFile:AllFiles) { //
	 * driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); String
	 * NameOfEachFile=EachFile.getName();
	 * System.out.println("NameOfEachFile : "+NameOfEachFile);
	 * if(NameOfEachFile.contains(objectprop.getProperty("TypeOfDownloadedFile"))) {
	 * FileFound=true; Assert.assertTrue(FileFound, "DownloadedFileNotFound");
	 * //break; } // EachFile.deleteOnExit();
	 * 
	 * } if(FileFound=false) Assert.assertFalse(FileFound, "File not found"); }
	 */
  @Test(priority=0)
   public void ValidateLaunchFileDownloadPage() {
	  //driver.switchTo().window(null)
	 driver.get(objectprop.getProperty("AutomationDemoSiteFileDownloadURL"));
	 System.out.println(driver.getCurrentUrl());
	 String AutomationPageTitle=driver.getTitle();
	 System.out.println("AutomationPageTitle : "+AutomationPageTitle);
	 Assert.assertEquals(AutomationPageTitle, objectprop.getProperty("AutomationDemoSitePageTitle"));
	 
  }
  @Test(priority=1)
  public void FileDownloadPage() {
	  System.out.println(driver.getTitle());
	  driver.findElement(DpagesOfFileDownload.DownloadButton).click();
	  File objectOfFile=new File(System.getProperty("user.dir"));
	  File[] AllFiles1=objectOfFile.listFiles();
	  for(File IndividualFile:AllFiles1) {
		  String NameOfIndividualFile= IndividualFile.getName();
		  System.out.println("NameOfIndividualFile : "+NameOfIndividualFile);
	//	  if(NameOfIndividualFile)
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
