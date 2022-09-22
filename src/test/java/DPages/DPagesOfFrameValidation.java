package DPages;

import org.openqa.selenium.By;

public class DPagesOfFrameValidation {

	public static By SingleFrame=By.xpath("//a[contains(text(),'Single Iframe')]");
	public static String Single_FrameBox="singleframe";
	public static By SingleFrameTextBox=By.xpath("//input[@type='text']");
	public static By Mutiple_Frame=By.xpath("//a[contains(text(),'Iframe with in an')]"); 
	public static By MutipleFrameOuterFrame=By.xpath("//iframe[@src='MultipleFrames.html']");
	public static By MutipleFrameInnerFrame=By.xpath("//iframe[@src='SingleFrame.html']");
	
	public static By HeadingText = By.xpath("//h1[@class='breadcrumb-item']");
	public static By HeadingInnerText = By.xpath("//label[contains(text(),'Topic : ')]");
	public static String Frame = "iamframe";
	public static By Frame_Topic = By.id("topic");
	public static By FirstFrameTextBox = By.xpath("//b[@id='topic']/following::input");
	public static String FirstInnerFrame = "frame3";
	public static By InnerFrameTextBox = By.xpath("//b[contains(text(),'Inner Frame Check box :')]");
	public static By Check_Box = By.id("a");
	public static By SecondInnerFrame = By.xpath("//iframe[@id='frame2']");
	public static By SecondFrameTitle = By.xpath("//b[contains(text(),'Animals')]");
	public static By SecondFrameTextBox = By.id("animals");
	public static By SecondFrameDropDown = By.xpath("//option[@value='avatar']");

	}


