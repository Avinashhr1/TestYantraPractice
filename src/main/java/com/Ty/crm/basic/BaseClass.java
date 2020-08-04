package com.Ty.crm.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import PoMPagesVtiger.LoginPage;

public class BaseClass {
	public DataBaseLib dblib = new DataBaseLib();
	public ExcellLib xlib = new ExcellLib();
	public PropertyFileLib prop = new PropertyFileLib();
	public WebDriverUtils wlib = new WebDriverUtils();
	
	public WebDriver driver = null;
	
	
	
	@BeforeSuite
	public void configBS() throws Throwable {
		/* Here we connect to DataBase*/
		dblib.conectToDatabase();
	}
	
	
	@BeforeClass
	public void configBC() throws Throwable {
		/*Here we Launch the browser*/
		String BROWSER = prop.getPropertyFileData("browser");
		if(BROWSER.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}else {
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}

	}
	
//	@Parameters({"browser"})
//	@BeforeTest
//	public void configBT(String BROWSER) {
//		/*Here we Launch the browser only when executing parallel execution*/
//		if(BROWSER.equals("chrome")) {
//			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
//			driver = new ChromeDriver();
//		}else {
//			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
//			driver = new FirefoxDriver();
//		}
//	}

//	@AfterTest
//	public void configAT() {
//		/*Here we close the browser only when executing parallel execution*/
//		driver.close();
//	}
	
	
	@BeforeMethod
	public void configBM() throws Throwable {
		/*Here we Login to the Application*/
		String USERNAME = prop.getPropertyFileData("username");
		String PASSWORD = prop.getPropertyFileData("password");
		String URL = prop.getPropertyFileData("url");

		
		driver.get(URL);
		wlib.waitForPagetoLoad(driver);
		
		/*step2 login to the application*/
		LoginPage login = new LoginPage(driver);
		login.getUsernametxtbx().sendKeys(USERNAME);
		login.getPasswordtxtbx().sendKeys(PASSWORD);
		login.getLoginbtn().click();
	}
	
	@AfterMethod
	public void configAM() {
		/*Here we Logout to the Application*/
		WebElement wb = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
        wlib.moveMouseToElemnet(driver, wb);
		driver.findElement(By.linkText("Sign Out")).click();
	}
	
	
	
	@AfterClass
	public void configAC() {
		/*Here we close the browser*/
		driver.close();
	}
	
	@AfterSuite
	public void configAS() throws Exception {
		/* Here we disconnect to DataBase*/
		dblib.closeDBConnection();
		
	}
	
	
	

}
