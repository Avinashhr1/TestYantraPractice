package VtigerApplication;

import java.io.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.Ty.crm.basic.PropertyFileLib;
import com.Ty.crm.basic.WaitsLib;
import com.Ty.crm.basic.WebDriverLib;

public class GenericTest {
	public WebDriver driver;
	public WaitsLib wait;
	public PropertyFileLib prop;
	public WebDriverLib wlib;
	
	
	
	@BeforeMethod
	public void OpenApplication() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WaitsLib();
		prop = new PropertyFileLib();
		wlib = new WebDriverLib();
		
		
		driver.get(prop.getPropertyFileData("url"));
		driver.manage().window().maximize();
		wait.implicitWait(driver);
		
	}
	
	@AfterMethod
	public void CloseApplication() {
		driver.quit();
	}
	
	
	
}
