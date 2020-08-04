package PoMPagesVtiger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(linkText = "Contacts")
	private WebElement contactslink;
	
	@FindBy(linkText = "Organizations")
	private WebElement Organizationslink;
	
	@FindBy(linkText = "Calendar")
	private WebElement Calendarlink;
	
	@FindBy(linkText = "Leads")
	private WebElement Leadslink;
	
	@FindBy(linkText = "Products")
	private WebElement Productslink;
	
	@FindBy(linkText = "Documents")
	private WebElement Documentslink;
	
	@FindBy(linkText = "Email")
	private WebElement Emaillink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement profileImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutlink;
	
	public WebElement getContactslink() {
		return contactslink;
	}

	public WebElement getOrganizationslink() {
		return Organizationslink;
	}


	public WebElement getProfileImg() {
		return profileImg;
	}

	public WebElement getSignOutlink() {
		return signOutlink;
	}	
	
	
	
	
	
}
