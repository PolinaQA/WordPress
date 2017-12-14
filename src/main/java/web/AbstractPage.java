package web;

import org.openqa.selenium.WebDriver;

import operations.Operations;

public class AbstractPage {

	protected WebDriver driver;
	protected Operations ops;
	
	public AbstractPage(WebDriver driver){
		this.driver = driver;
		this.ops = new Operations(driver);
	}
	
	public void sleep(long millis){
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
