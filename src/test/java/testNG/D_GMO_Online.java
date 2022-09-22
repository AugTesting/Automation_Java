package testNG;

import org.testng.annotations.Test;
import org.testng.internal.Constants;

import DPages.D_PagesOfDMO_Online;
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

public class D_GMO_Online extends BaseLibrary {
	@Test(priority = -3)
	public void LaunchGMOonline() {
		driver.get(objectprop.getProperty("GMOonlinePage"));
		String PageTitle = driver.getTitle();
		System.out.println(driver.getTitle());
		Assert.assertEquals(PageTitle, objectprop.getProperty("GMOonlinePageTitle"));
		System.out.println("--------------------------------");
	}

	@Test(priority = -2)
	public void ValidateGMOHomePage() {
		driver.findElement(D_PagesOfDMO_Online.Image);
		driver.findElement(D_PagesOfDMO_Online.StartingLine);
		String Text1 = driver.findElement(D_PagesOfDMO_Online.Text1).getText();
		System.out.println("Text1 : " + Text1);
		Assert.assertEquals(Text1, objectprop.getProperty("FirstText"));
		String Text2 = driver.findElement(D_PagesOfDMO_Online.Text2).getText();
		System.out.println("Text2 : " + Text2);
		Assert.assertEquals(Text2, objectprop.getProperty("SecondText"));
		String Text3 = driver.findElement(D_PagesOfDMO_Online.Text3).getText();
		System.out.println("Text3 : " + Text3);
		Assert.assertEquals(Text3, objectprop.getProperty("ThirdText"));
		String Text4 = driver.findElement(D_PagesOfDMO_Online.Text4).getText();
		System.out.println("Text4 : " + Text4);
		Assert.assertEquals(Text4, objectprop.getProperty("FourthText"));
		/*
		 * String Text5=driver.findElement(D_PagesOfDMO_Online.Text5).getText();
		 * System.out.println("Text5 : "+Text5); Assert.assertEquals(Text5,
		 * objectprop.getProperty("FifthText"));
		 * 
		 * String Text6=driver.findElement(D_PagesOfDMO_Online.Text6).getText();
		 * System.out.println("Text6 : "+Text6); Assert.assertEquals(Text6,
		 * objectprop.getProperty("SixthText"));
		 */
		String Text9 = driver.findElement(D_PagesOfDMO_Online.Text9).getText();
		System.out.println("Text9 : " + Text9);
		Assert.assertEquals(Text9, objectprop.getProperty("NinthText"));
		driver.findElement(D_PagesOfDMO_Online.EnterGMOonlinebutton).click();
		System.out.println("--------------------------------");
	}
	@Test(priority = -1)
	public void ValidateOnlineCatalogPage() {
		String Text11=driver.getTitle();
		System.out.println(Text11);
		String OnlineCatalogText1=driver.findElement(D_PagesOfDMO_Online.OnlineCatalogText1).getText();
		System.out.println("OnlineCatalogText1 : "+OnlineCatalogText1);
		Assert.assertEquals(OnlineCatalogText1, objectprop.getProperty("SecondPageText1"));
		driver.findElement(D_PagesOfDMO_Online.ExternalFrameBackpack).sendKeys("2");
		driver.findElement(D_PagesOfDMO_Online.EnterGMOonlinebutton).click();
}
	@Test(priority = 0)
	public void ValidatePrice() {
		String UnitPriceFromGMO=driver.findElement(D_PagesOfDMO_Online.UnitPrice).getText();
		System.out.println("UnitPriceFromGMO : "+UnitPriceFromGMO);
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
