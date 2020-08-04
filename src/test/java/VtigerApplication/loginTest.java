package VtigerApplication;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ty.crm.basic.ExcellLib;
import com.Ty.crm.basic.JavaScriptLib;
import com.Ty.crm.basic.WebDriverLib;

import PoMPagesVtiger.HomePage;
import PoMPagesVtiger.LoginPage;

public class loginTest extends GenericTest {
	public WebDriverLib drlib;
	public JavaScriptLib jslib;
	public ExcellLib xlib;
	
	@Test(invocationCount = 0)
	public void LogintoVtiger() throws IOException
	{
		drlib = new WebDriverLib();
		jslib = new JavaScriptLib();
		
		WebElement user_name = driver.findElement(By.name("user_name"));
		WebElement pass_word = driver.findElement(By.name("user_password"));
		WebElement loginButton = driver.findElement(By.id("submitButton"));
		
		
		//jslib.enterToDisTextbox(driver, user_name);
		
		drlib.TextBox(user_name, prop.getPropertyFileData("username"));
		drlib.TextBox(pass_word, prop.getPropertyFileData("password"));
		drlib.clickOnElement(loginButton);
		
		
	}
	
	@Test(invocationCount = 0)
	public void LogintoVtigerfromExcel() throws Throwable
	{
		drlib = new WebDriverLib();
		xlib = new ExcellLib();
		
		WebElement user_name = driver.findElement(By.name("user_name"));
		WebElement pass_word = driver.findElement(By.name("user_password"));
		WebElement loginButton = driver.findElement(By.id("submitButton"));
		
		String username = xlib.readData("Login_details", 1, 0);
		String password = xlib.readData("Login_details", 1, 1);
		//System.out.println(username+" "+password);
		
		drlib.TextBox(user_name, username);
		drlib.TextBox(pass_word, password);
		drlib.clickOnElement(loginButton);
		
		
	}
	
	@Test
	public void LogintoVtigerfromExcelpom() throws Throwable
	{
		drlib = new WebDriverLib();
		xlib = new ExcellLib();
		LoginPage login = new LoginPage(driver);
		HomePage home = new HomePage(driver);
		
//		WebElement user_name = login.getUsernametxtbx();
//		WebElement pass_word = login.getPasswordtxtbx();
//		WebElement loginButton = login.getLoginbtn();
		
		//System.out.println(login.getLoginPageTitle());
	
		String username = xlib.readData("Login_details", 1, 0);
		String password = xlib.readData("Login_details", 1, 1);
		String etitle = xlib.readData("Login_details", 1, 2);
		
		drlib.TextBox(login.getUsernametxtbx(), username);
		drlib.TextBox(login.getPasswordtxtbx(), password);
		drlib.clickOnElement(login.getLoginbtn());
		String atitle = driver.getTitle();
		System.out.println(atitle);
		Assert.assertEquals(atitle, etitle);
		
		drlib.mouseHover(driver, home.getProfileImg());
		drlib.clickOnElement(home.getSignOutlink());
			
	}
	

}
