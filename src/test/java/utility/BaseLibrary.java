package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseLibrary {
	public static WebDriver driver;
	public static Properties objectprop;
	public static HashMap<String, String> hmap = new HashMap<String, String>();

	public static ExtentHtmlReporter ExtHtmlReports;
	public static ExtentReports extreports;
	public static ExtentTest exttest;

	public void StartExtentReports() {
		File ObjFile = new File(System.getProperty("user.dir") + "//ExtentReports//MouseValidationExtentReports.html");
		ExtentHtmlReporter ObjExtentHtmlReporter = new ExtentHtmlReporter(ObjFile);
		ObjExtentHtmlReporter.config().setDocumentTitle("Automation Sep Report");
		ObjExtentHtmlReporter.config().setReportName("Extent Report Of Mouse Validation");
		ObjExtentHtmlReporter.config().setTheme(Theme.DARK);

		extreports = new ExtentReports();
		extreports.attachReporter(ObjExtentHtmlReporter);
		extreports.setSystemInfo("BROWSER", objectprop.getProperty("Browser"));
		extreports.setSystemInfo("TESTERNAME", "TESTERID");
		extreports.setSystemInfo("ENVIRONMENT", "UAT");
	}

	public void UpdatingResultInExtentReport(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			exttest.log(Status.PASS, "TestCase is passed : " + result.getName());
		} else if (result.getStatus() == ITestResult.FAILURE) {
			exttest.log(Status.FAIL, "TestCase is failed : " + result.getName());
			exttest.log(Status.FAIL, "TestCase is failed : " + result.getThrowable());
			try {
				exttest.addScreenCaptureFromPath(TakeScreenShots(result.getName()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(result.getStatus() == ITestResult.SKIP) {
				exttest.log(Status.SKIP, "TestCase is skipped : " + result.getName());
		}
	}
	public void FlushReport() {
		extreports.flush();
		
	}
	public static String TakeScreenShots(String TestCaseName) throws IOException {
		File objfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String datename = new SimpleDateFormat("yymmddmmss").format(new Date());
		String destination = System.getProperty("user.dir") + "//ExtentReports//Screenshots//ss" + TestCaseName + datename + "Captured.jpeg";
		FileUtils.copyFile(objfile, new File(destination));
		return destination;
	}
	
	public void LaunchBrowser() {
		System.out.println("starting");
		String browsername = objectprop.getProperty("Browser");
		System.out.println("test" + browsername);
		switch (browsername) {
		case "EdgeDriver":
			System.out.println("test");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case "ChromeDriver":
			WebDriverManager.chromedriver().setup();
			ChromeOptions objChromeOptions = new ChromeOptions();
			Map<String, Object> ChromePreferences = new HashMap<String, Object>();
			ChromePreferences.put("download.default_directory", System.getProperty("user.dir"));
			objChromeOptions.setExperimentalOption("prefs", ChromePreferences);
			driver = new ChromeDriver(objChromeOptions);
			break;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void ReadPropertiesFile() throws IOException {
		System.out.println(System.getProperty("user.dir"));

		try {
			File objFile = new File(
					System.getProperty("user.dir") + "//src//test//resources//Configuration.Properties");
			FileInputStream objFileInput = new FileInputStream(objFile);
			objectprop = new Properties();
			objectprop.load(objFileInput);
			// System.out.println(objectprop.getProperty("FramesURL"));
			System.out.println(objectprop.getProperty("Browser"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void WaitUntilAlertIsPresent() {
		// WebDriverWait wait = new WebDriverWait(driver, 10);
		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.alertIsPresent());

	}

	public static void TakeScreenShots() {
		File objfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String datename = new SimpleDateFormat("yymmddmmss").format(new Date());
		File destination = new File(
				System.getProperty("user.dir") + "//src//test//resources//Screenshots_" + datename + "Captured.jpg");

		try {
			FileUtils.copyFile(objfile, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static HashMap<String, String> ReadExcelFile(int row, XSSFSheet objXSSFSheet) {
		DataFormatter ObjDataFormatter = new DataFormatter();
		hmap.put("RunMode", objXSSFSheet.getRow(row).getCell(0).getStringCellValue());
		hmap.put("TestCaseName", objXSSFSheet.getRow(row).getCell(1).getStringCellValue());
		hmap.put("FirstName", objXSSFSheet.getRow(row).getCell(2).getStringCellValue());
		hmap.put("LastName", objXSSFSheet.getRow(row).getCell(3).getStringCellValue());
		hmap.put("Address", objXSSFSheet.getRow(row).getCell(4).getStringCellValue());
		hmap.put("Emailaddress", objXSSFSheet.getRow(row).getCell(5).getStringCellValue());

		hmap.put("PhoneNumber", ObjDataFormatter.formatCellValue(objXSSFSheet.getRow(row).getCell(6)));

		hmap.put("Gender", objXSSFSheet.getRow(row).getCell(7).getStringCellValue());
		hmap.put("Hobbies", objXSSFSheet.getRow(row).getCell(8).getStringCellValue());
		hmap.put("Languages", objXSSFSheet.getRow(row).getCell(9).getStringCellValue());
		hmap.put("Skills", objXSSFSheet.getRow(row).getCell(10).getStringCellValue());
		hmap.put("Country", objXSSFSheet.getRow(row).getCell(11).getStringCellValue());
		hmap.put("SelectCountry", objXSSFSheet.getRow(row).getCell(12).getStringCellValue());

		hmap.put("DOB_YY", ObjDataFormatter.formatCellValue(objXSSFSheet.getRow(row).getCell(13)));
		hmap.put("DOB_MM", ObjDataFormatter.formatCellValue(objXSSFSheet.getRow(row).getCell(14)));
		hmap.put("DOB_DD", ObjDataFormatter.formatCellValue(objXSSFSheet.getRow(row).getCell(15)));
		hmap.put("Password", objXSSFSheet.getRow(row).getCell(16).getStringCellValue());
		hmap.put("confirmpassword", objXSSFSheet.getRow(row).getCell(17).getStringCellValue());
		return hmap;
	}

	public static void WriteToExcelFile(int row, XSSFWorkbook objXSSFWorkbook, XSSFSheet objXSSFSheet) {
		objXSSFSheet = objXSSFWorkbook.getSheet(objectprop.getProperty("DataDrivenSheetName"));
		objXSSFSheet.getRow(row).createCell(18).setCellValue("Pass");

	}

	public static void SelectOneValueFromDropDown(List<WebElement> AllFieldsFromDropDown, String DropDownValue) {
		for (int i = 1; i <= AllFieldsFromDropDown.size(); i++) {
			String IndividualValue = AllFieldsFromDropDown.get(i).getText();
			System.out.println("IndividualValue : " + IndividualValue);
			if (IndividualValue.equalsIgnoreCase(DropDownValue)) {
				AllFieldsFromDropDown.get(i).click();
				break;
			}
		}

	}

}
