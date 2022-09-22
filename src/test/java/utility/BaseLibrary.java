package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseLibrary {
	public static WebDriver driver;
	public static Properties objectprop;
	
public void LaunchBrowser() {
	String browsername=objectprop.getProperty("Browser");
	switch(browsername) {
	case "ChromeDriver":
	WebDriverManager.chromedriver().setup();
	ChromeOptions objChromeOptions=new ChromeOptions();
	Map<String, Object> ChromePreferences=new HashMap<String, Object>();
	ChromePreferences.put("download.default_directory",System.getProperty("user.dir"));
	objChromeOptions.setExperimentalOption("prefs",ChromePreferences);
	driver=new ChromeDriver(objChromeOptions);
	break;
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
}
public void ReadPropertiesFile() throws IOException {
	System.out.println(System.getProperty("user.dir"));
	
	try {
		File objFile=new File(System.getProperty("user.dir")+"//src//test//resources//Configuration.Properties");
		FileInputStream objFileInput=new FileInputStream(objFile);
		objectprop=new Properties();
		objectprop.load(objFileInput);
		//System.out.println(objectprop.getProperty("FramesURL"));
		System.out.println(objectprop.getProperty("Browser"));
		} catch (FileNotFoundException e) {
				e.printStackTrace();
	}
}
	public static void WaitUntilAlertIsPresent() {
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		WebDriverWait wait = new WebDriverWait(driver,20);

		wait.until(ExpectedConditions.alertIsPresent());
	
}
	public static void TakeScreenShots() {
		File objfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String datename=new SimpleDateFormat("yymmddmmss").format(new Date());
		File destination=new File(System.getProperty("user.dir")+"//src//test//resources//Screenshots_"+datename+"Captured.jpg");
		
		try {
			FileUtils.copyFile(objfile,destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
