package testNG;

import org.testng.annotations.Test;

import DPages.DAlerts;
import utility.BaseLibrary;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class AlertsChecking extends BaseLibrary {
  @Test(priority=-2)
  public void LaunchAlertsPage() {
	  driver.get(objectprop.getProperty("AlertUrl"));
	  String TitleofAlertPage=driver.getTitle();
	  System.out.println("TitleofAlertPage:" + TitleofAlertPage);
	  Assert.assertEquals(TitleofAlertPage, objectprop.getProperty("TitleofAlertPage"));
	}
  @Test(priority=-1)
  public void SimpleAlert() {
	  driver.findElement(DAlerts.SimpleAlertBox).click();
	  Alert objSimpleAlert=driver.switchTo().alert();
	  String TextofAlert = objSimpleAlert.getText();
	  System.out.println("TextofAlert :"+ TextofAlert );
	  Assert.assertEquals(TextofAlert, objectprop.getProperty("SimpleAlertPopUp"));
	  WaitUntilAlertIsPresent();
	  objSimpleAlert.accept();
	
	  }
  @Test(priority=0)
  public void ConfirmAlertBoxOk() {
	  driver.findElement(DAlerts.ConfirmTextBox).click();
	  WaitUntilAlertIsPresent();
	  Alert ObjConfirmAlert=driver.switchTo().alert();
	  String TextofConfirmAlert=ObjConfirmAlert.getText();
	  System.out.println("TextofConfirmAlert :" +TextofConfirmAlert);
	  Assert.assertEquals(TextofConfirmAlert, objectprop.getProperty("ConfirmAlertPopUp"));
	  ObjConfirmAlert.accept();
	  String ConfirmAlertOkText=driver.findElement(DAlerts.ConfirmTextOkMessage).getText();
	  System.out.println("ConfirmAlertOkText : " +ConfirmAlertOkText);
	  Assert.assertEquals(ConfirmAlertOkText, objectprop.getProperty("TextAfterClickedOk"));
	  }
  @Test(priority=1)
  public void ConfirmAlertBoxCancel() {
	 driver.findElement(DAlerts.ConfirmTextBox).click();
	 Alert ObjConfirmAlert1= driver.switchTo().alert();
	 String TextofConfirmAlert=ObjConfirmAlert1.getText();
	 System.out.println("TextofConfirmAlert : "+ TextofConfirmAlert);
	 Assert.assertEquals(TextofConfirmAlert, TextofConfirmAlert);
	 WaitUntilAlertIsPresent();
	 ObjConfirmAlert1.dismiss();
	 String ConfirmAlertCancelText= driver.findElement(DAlerts.ConfirmTextCancelMessage).getText();
	 System.out.println("ConfirmAlertOkText : "+ ConfirmAlertCancelText);
	 Assert.assertEquals(ConfirmAlertCancelText, objectprop.getProperty("TextAfterClickedCancel"));
  }
  @Test(priority=2)
  public void PromptAlertBoxOkYes() {
	  driver.findElement(DAlerts.PromptAlertBox).click();
	  Alert ObjPromptAlert=driver.switchTo().alert();
	  WaitUntilAlertIsPresent();
	  String TextofPromptAlert=ObjPromptAlert.getText();
	  System.out.println("TextofPromptAlert : " +TextofPromptAlert);
	  Assert.assertEquals(TextofPromptAlert, TextofPromptAlert);
	  ObjPromptAlert.sendKeys(objectprop.getProperty("PromptAlertSendMessage1"));
	  ObjPromptAlert.accept();
	  System.out.println(driver.findElement(DAlerts.AfterSendMessageOk).getText());
	  }
  @Test(priority=3)
  public void PromptAlertBoxNo() {
	  driver.findElement(DAlerts.PromptAlertBox).click();
	  Alert PromptAlertTextMessage=driver.switchTo().alert();
	  PromptAlertTextMessage.getText();
	  PromptAlertTextMessage.sendKeys(objectprop.getProperty("PromptAlertSendMessage2"));
	  PromptAlertTextMessage.accept();
	  System.out.println(driver.findElement(DAlerts.AfterSendMessageOk).getText());
  }
  @Test(priority=4)
  public void PromptAlertBoxCancel() {
	  driver.findElement(DAlerts.PromptAlertBox).click();
	  WaitUntilAlertIsPresent();
	  Alert PromptAlert=driver.switchTo().alert();
	  PromptAlert.dismiss();
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
