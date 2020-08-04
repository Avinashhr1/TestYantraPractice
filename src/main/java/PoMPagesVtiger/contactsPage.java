package PoMPagesVtiger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class contactsPage extends BasePage {

	
	public contactsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement CreatecontactBtn;
	
	public WebElement getCreatecontactBtn() {
		return CreatecontactBtn;
	}

	
	
	
	
	
}
