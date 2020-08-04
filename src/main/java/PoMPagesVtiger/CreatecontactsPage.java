package PoMPagesVtiger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatecontactsPage extends BasePage{

	
	public CreatecontactsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(name="firstname")
	private WebElement firstnameTxtbox;
	
	@FindBy(name="lastname")
	private WebElement lastnameTxtbox;
	
	@FindBy(id="title")
	private WebElement titleTxtbox;
	
	@FindBy(id="email")
	private WebElement emailTxtbox;
	
	@FindBy(id="phone")
	private WebElement phoneTxtbox;
	
	
	@FindBy(xpath = "//select[@name='salutationtype']")
	private WebElement prefixDropdown;

	@FindBy(xpath="//input[@class='crmbutton small save']")
	private WebElement savebtn;
	
	public WebElement getPrefixDropdown() {
		return prefixDropdown;
	}
	
	public void setFirstname(String firstname) {
		firstnameTxtbox.sendKeys(firstname);
	}
	
	public void setLastname(String lastname) {
		lastnameTxtbox.sendKeys(lastname);
	}
	public void setTitlename(String title) {
		titleTxtbox.sendKeys(title);
	}
	public void setPhoneno(String phone) {
		phoneTxtbox.sendKeys(phone);
	}
	
	public void setEmailname(String email) {
		emailTxtbox.sendKeys(email);
	}
	public WebElement getSavebtn() {
		return savebtn;
	}
	
	
}
