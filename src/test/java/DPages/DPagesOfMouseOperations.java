package DPages;

import org.openqa.selenium.By;

public class DPagesOfMouseOperations {
	public static By MouseRightClick = By.xpath("//span[text()='right click me']");
	public static By MouseRightClickQuitOption = By.xpath("//span[text()='Quit']");
	public static By MouseScrollToframe = By.xpath("//iframe");
	public static By ToDoubleClickBox = By.xpath("//span[contains(text(),'Double click the block')]/preceding-sibling::div");
	public static By Draggable = By.id("draggable");
	public static By Droppable = By.id("droppable");
	public static By AfterDropped = By.xpath("//p[contains(text(),'Dropped!')]");

}
