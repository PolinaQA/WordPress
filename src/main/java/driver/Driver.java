package driver;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
	
	public WebDriver driver;
	private static final String CHROME_PROPERTY_NAME = "webdriver.chrome.driver";
	
	public Driver(){
		System.setProperty(CHROME_PROPERTY_NAME, "");
		setDriver();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.manage().window().maximize();
		
	}

	private void setDriver() {
		String os = System.getProperty("os.name").toLowerCase();
		String driverPath = null;
		String path = "src"+File.separator+"main"+File.separator+"java"+File.separator+"drivers"+File.separator;
		if(os.contains("mac")){
			driverPath = path+"chromedriverMac";
		}
		if(os.contains("linux")){
			driverPath = path+"chromedriverLinux";
		}
		if(os.contains("windows")){
			driverPath = path+"chromedriverWin.exe";
		}
		System.setProperty(CHROME_PROPERTY_NAME, driverPath);
	}
	
		public WebDriver getDriver(){
			return this.driver;
		}

}
