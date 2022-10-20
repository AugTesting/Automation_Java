package DPages;

import org.openqa.selenium.By;

public class DPagesOfDataDriven {
	public static By FirstName=By.xpath("//input[@placeholder='First Name']");
	public static By LastName=By.xpath("//input[@placeholder='Last Name']");
	public static By Address=By.xpath("//textarea[@rows='3']");
	public static By Email=By.xpath("//input[@type='email']");
	public static By PhoneNumber=By.xpath("//input[@type='tel']");
	public static By MaleRadioButton=By.xpath("//input[@value='Male']");
	public static By FeMaleRadioButton=By.xpath("//input[@value='FeMale']");
	public static By HobbiesCricket=By.xpath("//input[@value='Cricket']");
	public static By HobbiesMovies=By.xpath("//input[@value='Movies']");
	public static By HobbiesHockey=By.xpath("//input[@value='Hockey']");
	public static By Languages=By.id("msdd");
	public static By AllLanguages=By.xpath("//div[@id='msdd']/following-sibling::div/ul/li");
	public static By LaunguageCloseIconClick=By.xpath("//span[@class='ui-icon ui-icon-close']");
	public static By SkillsField = By.xpath("//label[contains(text(),'Skills')]");
	public static By Skills=By.id("Skills");
	public static By AllSkills = By.xpath("//select[@id='Skills']/option");
	public static By SelectCountry=By.xpath("//span[@role='combobox']");
	public static By TextBoxOfSelectcountry = By.xpath("//input[@type='search']");
	public static By Year = By.id("yearbox");
	public static By AllYears = By.xpath("//select[@id='yearbox']/option");
	public static By Month = By.xpath("//select[@ng-model='monthbox']");
	public static By AllMonths = By.xpath("//select[@ng-model='monthbox']/option");
	public static By Day = By.xpath("//select[@ng-model='daybox']");
	public static By AllDays = By.xpath("//select[@ng-model='daybox']/option");
	public static By Password = By.id("firstpassword");
	public static By ConformPwd = By.id("secondpassword");
	
}
