package testNG;

import org.testng.annotations.Test;

import DPages.DPagesOfFrameValidation;
import utility.BaseLibrary;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class DFrameValidation extends BaseLibrary {
	/*
	 * @Test(priority=0) public void ValidateLaunchFramesURL() {
	 * driver.get(objectprop.getProperty("FramesURL")); String
	 * PageTitle=driver.getTitle(); System.out.println("PageTitle : "+PageTitle);
	 * Assert.assertEquals(PageTitle, objectprop.getProperty("FramePageTitle")); }
	 * 
	 * @Test(priority=1) public void ValidateSingleFrame() {
	 * driver.findElement(DPagesOfFrameValidation.SingleFrame).click();
	 * driver.switchTo().frame(DPagesOfFrameValidation.Single_FrameBox);
	 * driver.findElement(DPagesOfFrameValidation.SingleFrameTextBox).
	 * sendKeys("This Is Single Frame Text Box");
	 * driver.switchTo().defaultContent(); }
	 * 
	 * @Test(priority=2) public void ValidateMultipleFrame() {
	 * driver.findElement(DPagesOfFrameValidation.Mutiple_Frame).click(); WebElement
	 * OuterFrame=driver.findElement(DPagesOfFrameValidation.MutipleFrameOuterFrame)
	 * ; driver.switchTo().frame(OuterFrame); WebElement
	 * InnerFrame=driver.findElement(DPagesOfFrameValidation.MutipleFrameInnerFrame)
	 * ; driver.switchTo().frame(InnerFrame);
	 * driver.findElement(DPagesOfFrameValidation.SingleFrameTextBox).
	 * sendKeys("This Is Multiple Frames Text Box"); }
	 */
  @Test(priority=3)
  public void LaunchFrameCherCherPage() {
	  driver.get(objectprop.getProperty("FrameCherCherPage"));
	  System.out.println(driver.getTitle());
	  WebElement Heading1 = driver.findElement(DPagesOfFrameValidation.HeadingText);
	  System.out.println(Heading1.getText());
	  WebElement Heading2 = driver.findElement(DPagesOfFrameValidation.HeadingInnerText);
	  System.out.println(Heading2.getText());
	  driver.switchTo().frame(DPagesOfFrameValidation.Frame);
  }
  @Test(priority=4)
  public void FirstFrame() {
	  System.out.println(driver.findElement(DPagesOfFrameValidation.Frame_Topic));
	  driver.findElement(DPagesOfFrameValidation.FirstFrameTextBox).sendKeys("I AM IN TEXT BOX");
	  driver.switchTo().frame(DPagesOfFrameValidation.FirstInnerFrame);
	  WebElement InnerFrame_Text=driver.findElement(DPagesOfFrameValidation.InnerFrameTextBox);
	  System.out.println(InnerFrame_Text.getText());
	  driver.findElement(DPagesOfFrameValidation.Check_Box).click();
	  
  }
  @Test(priority=5,dependsOnMethods = {"FirstFrame"})
  public void SecondFrame() {
	  driver.switchTo().defaultContent();
	  WebElement SecondFrame=driver.findElement(DPagesOfFrameValidation.SecondInnerFrame);
	  driver.switchTo().frame(SecondFrame);
	  WebElement Text=driver.findElement(DPagesOfFrameValidation.SecondFrameTitle);
	  System.out.println(Text.getText());
	  WebElement dropdown=driver.findElement(DPagesOfFrameValidation.SecondFrameTextBox);
	  Select dropdown1=new Select(dropdown);
	  //dropdown1.selectByValue("avatar");
	  dropdown1.selectByValue("babycat");
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
