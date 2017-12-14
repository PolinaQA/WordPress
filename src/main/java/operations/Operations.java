package operations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Operations {
	
	public WebDriver driver;
	
	public Operations(WebDriver driver){
		this.driver = driver;
	}
	
	public void clickOnWebElement(WebElement webElement){
		webElement.click();
	}
	
	public void writeToWebElement(WebElement webElement, String value){
		webElement.click();
		webElement.clear();
		webElement.sendKeys(value);
	}
	
	public void scrollToElement(WebElement element){
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();
	}

}
