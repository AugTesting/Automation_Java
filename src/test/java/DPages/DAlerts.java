package DPages;

import org.openqa.selenium.By;

public class DAlerts {
	//test comment   
	public static By SimpleAlertBox=By.name("alertbox");
	public static By ConfirmTextBox=By.name("confirmalertbox");
	public static By ConfirmTextOkMessage=By.xpath("//p[text()='You clicked on OK!']");
	public static By ConfirmTextCancelMessage=By.xpath("//p[text()='You clicked on Cancel!']");
	public static By PromptAlertBox=By.name("promptalertbox1234");
	public static By AfterSendMessageOk=By.xpath("//*[@id=\"demoone\"]");
}
