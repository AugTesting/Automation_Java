package testNG;

import org.testng.annotations.Test;

import DPages.DPagesOfDataDriven;
import utility.BaseLibrary;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class D_DataDriven extends BaseLibrary{
	HashMap<String,String> hmap= new HashMap<String,String>();
	@Test(priority=1)
	public void LaunchDataDrivenPage() {
		driver.get(objectprop.getProperty("DataDrivenURL")); 
		String PageTitle=driver.getTitle();
		System.out.println("PageTitle : "+PageTitle);
		Assert.assertEquals(PageTitle, objectprop.getProperty("DataDrivenTitle"));
	}
	@Test(priority=2)
	public void ValidateDataDriven() throws Exception {
		File ObjFile = new File(System.getProperty("user.dir")+"//src//test//resources//AutomationDemoSIte.xlsx");
		try {
		FileInputStream ObjFileInputStream= new FileInputStream(ObjFile);
			XSSFWorkbook objXSSFWorkbook=new XSSFWorkbook(ObjFileInputStream);
			XSSFSheet ObjXSSFSheet=objXSSFWorkbook.getSheet("TestData");
			int NoOfRows=ObjXSSFSheet.getLastRowNum();
            System.out.println("NoOfRows : "+NoOfRows);
            for(int row=1;row<=NoOfRows;row++) {
            	hmap= ReadExcelFile(row,ObjXSSFSheet);
            	System.out.println("FirstName of row "+ row +" : "+ hmap.get("FirstName"));
            	System.out.println("Skills of row "+ row +" : "+ hmap.get("Skills"));
            	System.out.println("Country of row "+ row +" : "+ hmap.get("Country"));
            	if(hmap.get("RunMode").equalsIgnoreCase("no")) {
            		driver.findElement(DPagesOfDataDriven.FirstName).clear();
            		driver.findElement(DPagesOfDataDriven.FirstName).sendKeys(hmap.get("FirstName"));
            		driver.findElement(DPagesOfDataDriven.LastName).clear();
            		driver.findElement(DPagesOfDataDriven.LastName).sendKeys(hmap.get("LastName"));
            		driver.findElement(DPagesOfDataDriven.Address).clear();
            		driver.findElement(DPagesOfDataDriven.Address).sendKeys(hmap.get("Address"));
            		driver.findElement(DPagesOfDataDriven.Email).clear();
            		driver.findElement(DPagesOfDataDriven.Email).sendKeys(hmap.get("Emailaddress"));
            		driver.findElement(DPagesOfDataDriven.PhoneNumber).clear();
            		driver.findElement(DPagesOfDataDriven.PhoneNumber).sendKeys(hmap.get("PhoneNumber"));
            		
            		if(hmap.get("Gender").equalsIgnoreCase("Male")){
            		driver.findElement(DPagesOfDataDriven.MaleRadioButton).click();
            		}else {
               		driver.findElement(DPagesOfDataDriven.FeMaleRadioButton).click();
            		}
            		if(hmap.get("Hobbies").equalsIgnoreCase("Cricket")) {
            			driver.findElement(DPagesOfDataDriven.HobbiesCricket).click();
            		}else if(hmap.get("Hobbies").equalsIgnoreCase("Movies")) {
            			driver.findElement(DPagesOfDataDriven.HobbiesMovies).click();	
            		}else {
            			driver.findElement(DPagesOfDataDriven.HobbiesHockey).click();
            		}
            		JavascriptExecutor js=(JavascriptExecutor)driver;
            		js.executeScript("window.scrollBy(0,500)");
            		
            		driver.findElement(DPagesOfDataDriven.Languages).click();
            		List<WebElement> AllLanguages=driver.findElements(DPagesOfDataDriven.AllLanguages);
            		SelectOneValueFromDropDown(AllLanguages,hmap.get("Languages"));
            		driver.findElement(DPagesOfDataDriven.LaunguageCloseIconClick).click();
            		
            		driver.findElement(DPagesOfDataDriven.SkillsField).click();
            		
            		driver.findElement(DPagesOfDataDriven.Skills).click();
            		List<WebElement> AllSkills=driver.findElements(DPagesOfDataDriven.AllSkills);
            		SelectOneValueFromDropDown(AllSkills,hmap.get("Skills"));
            		
            		driver.findElement(DPagesOfDataDriven.SelectCountry).click();
            		driver.findElement(DPagesOfDataDriven.TextBoxOfSelectcountry).sendKeys(hmap.get("SelectCountry"));
            		
            		Robot ObjRobot=new Robot();
            		ObjRobot.keyPress(KeyEvent.VK_ENTER);
            		ObjRobot.keyRelease(KeyEvent.VK_ENTER);
            		
            		driver.findElement(DPagesOfDataDriven.SkillsField).click();
            		
            		driver.findElement(DPagesOfDataDriven.Year).click();
            		List<WebElement> AllYears=driver.findElements(DPagesOfDataDriven.AllYears);
            		SelectOneValueFromDropDown(AllYears,hmap.get("DOB_YY"));
            		
            		driver.findElement(DPagesOfDataDriven.Month).click();
            		List<WebElement> AllMonths=driver.findElements(DPagesOfDataDriven.AllMonths);
            		SelectOneValueFromDropDown(AllMonths,hmap.get("DOB_MM"));
            		
            		driver.findElement(DPagesOfDataDriven.Day).click();
            		List<WebElement> AllDays=driver.findElements(DPagesOfDataDriven.AllDays);
            		SelectOneValueFromDropDown(AllDays,hmap.get("DOB_DD"));
            		
            		driver.findElement(DPagesOfDataDriven.Password).click();
            		driver.findElement(DPagesOfDataDriven.Password).sendKeys(hmap.get("Password"));
            		
            		driver.findElement(DPagesOfDataDriven.ConformPwd).click();
            		driver.findElement(DPagesOfDataDriven.ConformPwd).sendKeys(hmap.get("confirmpassword"));
            		
            		FileOutputStream ObjOutputFile=new FileOutputStream(ObjFile);
            		WriteToExcelFile(row,objXSSFWorkbook,ObjXSSFSheet);
            		objXSSFWorkbook.write(ObjOutputFile);
             	}else {
					int RouwNumber =row+1;
					System.out.println("Roun Mode is not markes as yes for Row number"+RouwNumber);
             	}	
            }
            objXSSFWorkbook.close();
            ObjFileInputStream.close();
		}catch (Exception e) {
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
