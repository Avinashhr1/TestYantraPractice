package PoMPagesVtiger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	
	 @FindBy(name = "user_name")
	 private WebElement usernametxtbx;
	 
	 @FindBy(name = "user_password")
	 private WebElement passwordtxtbx;
	 
	 @FindBy(id = "submitButton")
	 private WebElement loginbtn;
	 
	 
	public WebElement getUsernametxtbx() {
		return usernametxtbx;
	}

	public WebElement getPasswordtxtbx() {
		return passwordtxtbx;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	} 
	 
	public String getLoginPageTitle() {
		return driver.getTitle();
	}

}
