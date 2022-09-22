package DPages;

import org.openqa.selenium.By;

public class DPageOfMultipleWindows {
	public static By NewBrowserWindow = By.name("newbrowserwindow123");
	public static By MenuOfNewBrowserWindow = By.xpath("//span[contains(text(),'Menu')]");
	public static By QA_Automation=By.xpath("(//a[contains(text(),'QA Automation')])[1]");
	public static By Practice_Automation=By.xpath("(//a[contains(text(),'Practice Automation')])[1]");
	public static By NewMessageWindow=By.name("newmessagewindow321");
	public static By NewMessageWindowText=By.xpath("/html/body");
	public static By NewBrowserTab = By.name("newbrowsertab453");
	public static By QA_Automation1=By.xpath("(//span[contains(text(),'QA Automation')])");
	public static By Practice_Automation1=By.xpath("(//span[contains(text(),'Practice Automation')])");
	public static By DemoSite_MultipleWindows = By.xpath("(//span[contains(text(),'Demo Site – Multiple Windows')])");
}
