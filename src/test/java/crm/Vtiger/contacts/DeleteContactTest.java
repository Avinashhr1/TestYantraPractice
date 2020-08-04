package crm.Vtiger.contacts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ty.crm.basic.BaseClass;

import PoMPagesVtiger.CreatecontactsPage;
import PoMPagesVtiger.HomePage;
import PoMPagesVtiger.contactsPage;

public class DeleteContactTest extends BaseClass {

	@Test
	public void deleteContactTest() throws Throwable {
		
		/*read data from Excel sheet*/
		String contactName = xlib.readData("contacts_info", 1, 0)+"_"+wlib.getRamDomNum();
		String lastname = xlib.readData("contacts_info", 1, 1);
		String contact_title = xlib.readData("contacts_info", 1, 2);
		
		
		/*step3 navigate to contacts page*/
		HomePage home = new HomePage(driver);
		home.getContactslink().click();
				
		/*step4 navigate to new contacts page*/
		contactsPage contacts = new contactsPage(driver);
		contacts.getCreatecontactBtn().click();
		//driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		/*step5 navigate to new contacts page*/
		CreatecontactsPage ncontact = new CreatecontactsPage(driver);
		ncontact.setFirstname(contactName);
		ncontact.setLastname(lastname);
		ncontact.setTitlename(contact_title);
		ncontact.getSavebtn().click();
		
		/*step6 verify new contact is created*/
		String ncontactName = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		Assert.assertTrue(ncontactName.contains(contactName));
		
		/*Step7 navigate to contacts page*/
		home.getContactslink().click();
		
		/*Step8 search for created contact based on name*/
		driver.findElement(By.xpath("//td[@class='searchUIName small']/../td[3]/input")).sendKeys(contactName);
		WebElement In_dropdown = driver.findElement(By.xpath("//td[@class='searchUIName small']/../td[5]/div/select"));
		wlib.select(In_dropdown,"First Name");
		
		driver.findElement(By.xpath("//td[@class='searchUIName small']/../td[6]/input")).click();
		
		/*Step9 select the contact and delete */
		driver.findElement(By.xpath("//a[contains(.,'"+contactName+"')]/../../td[1]/input[@name='selected_id']")).click();
		driver.findElement(By.xpath("//td/table[2]/tbody/tr/td/input[@class='crmbutton small delete']")).click();
		wlib.alertOk(driver);
	}
	
	
	
}
