package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import driver.Driver;

public class BaseTest {
	
	protected WebDriver driver;
	
	@BeforeClass
	public void setUp(){
		Driver dr = new Driver();
		this.driver = dr.getDriver();
	}
	
	@AfterClass
	public void cleanUp(){
		driver.quit();
	}
	
	public void sleep(long millis){
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
