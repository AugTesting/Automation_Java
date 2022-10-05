package testNG;

import org.testng.annotations.Test;

import DPages.DPagesOfMouseOperations;
import utility.BaseLibrary;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class DMouseValidation extends BaseLibrary{
  @Test(priority=-2)
  public void LaunchJQuery() {
	  exttest=extreports.createTest(new Object() {}.getClass().getEnclosingMethod().getName());
	  driver.get(objectprop.getProperty("MouseRightClickURL"));
	  String JQueryPageTitle=driver.getTitle();
	  System.out.println("JQueryPageTitle : "+JQueryPageTitle);
	  Assert.assertEquals(JQueryPageTitle, objectprop.getProperty("JQueryTitle"));
  }
  @Test(priority=-1)
  public void ValidatdeRightClick() {
	  exttest=extreports.createTest(new Object() {}.getClass().getEnclosingMethod().getName());
	  WebElement Element=driver.findElement(DPagesOfMouseOperations.MouseRightClick);	  
	  Actions object= new Actions(driver);
	  object.contextClick(Element).build().perform();
	  driver.findElement(DPagesOfMouseOperations.MouseRightClickQuitOption).click();
	  WaitUntilAlertIsPresent();
	  Alert objalert=driver.switchTo().alert();
	  String AlertText=objalert.getText();
	  System.out.println("AlertText : "+AlertText);
	  Assert.assertEquals(AlertText,objectprop.getProperty("TextOfQuitAlertBox"), "AlertTextValidated");
	  objalert.accept();
}
  @Test(priority=0)
  public void ValidateScrollAndDoubleClick() {
	  exttest=extreports.createTest(new Object() {}.getClass().getEnclosingMethod().getName());
	  driver.get(objectprop.getProperty("MouseOperationDoubleClick"));
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	//  js.executeScript("window.scrollBy(0,500)");
	//  js.executeScript("window.scrollBy(0,-200)");
	//  js.executeScript("window.scrollBy(700,0)");
	//  js.executeScript("window.scrollBy(-200,0)");
	  
	  WebElement element=driver.findElement(DPagesOfMouseOperations.MouseScrollToframe);
	  js.executeScript("arguments[0].scrollIntoView(true)", element);
	  driver.switchTo().frame(element);
	  Actions ObjOfActions=new Actions(driver);
      WebElement doubleclickelement =driver.findElement(DPagesOfMouseOperations.ToDoubleClickBox);
	  ObjOfActions.doubleClick(doubleclickelement).build().perform();
	  String backgroundcolorafterdoubleclick=driver.findElement(DPagesOfMouseOperations.ToDoubleClickBox).getCssValue("background-color");
	  System.out.println("backgroundcolorafterdoubleclick : "+backgroundcolorafterdoubleclick);
	  Assert.assertEquals(backgroundcolorafterdoubleclick, objectprop.getProperty("yellowcolorRgb"));
  }
  @Test(priority=1)
  public void ValidateDragAndDrop() {
	  exttest=extreports.createTest(new Object() {}.getClass().getEnclosingMethod().getName());
	  driver.navigate().to(objectprop.getProperty("MouseOperationDragAndDrop"));
	  WebElement frameelement=driver.findElement(DPagesOfMouseOperations.MouseScrollToframe);
	//  driver.switchTo().frame(frameelement);
	  Actions ObjAct=new Actions(driver);
	  WebElement dragelement=driver.findElement(DPagesOfMouseOperations.Draggable);
	 // ObjAct.clickAndHold(dragelement).build().perform();
	  WebElement dropelement=driver.findElement(DPagesOfMouseOperations.Droppable);
	  //ObjAct.release(dropelement).build().perform();
	  ObjAct.dragAndDrop(dragelement, dropelement).build().perform();
	  String AfterDrop=driver.findElement(DPagesOfMouseOperations.Droppable).getText();
	  System.out.println("AfterDrop :"+AfterDrop);
	  Assert.assertEquals(AfterDrop, objectprop.getProperty("AfterDrop"));
	  
	  
  }
  
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod(ITestResult result) {
	  UpdatingResultInExtentReport(result);
  }

 
@BeforeClass
  public void beforeClass() {
	  StartExtentReports();
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
	FlushReport();
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
