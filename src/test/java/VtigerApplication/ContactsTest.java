package VtigerApplication;

import org.testng.annotations.Test;

import com.Ty.crm.basic.ExcellLib;
import PoMPagesVtiger.CreatecontactsPage;
import PoMPagesVtiger.HomePage;
import PoMPagesVtiger.LoginPage;
import PoMPagesVtiger.contactsPage;

public class ContactsTest extends GenericTest {

	@Test
	public void createContactsTest() throws Throwable {
		LoginPage login = new LoginPage(driver);
		HomePage home = new HomePage(driver);
		contactsPage contactss = new contactsPage(driver);
		CreatecontactsPage contacts = new CreatecontactsPage(driver);
		ExcellLib xlib = new ExcellLib();
		
		String USERNAME = prop.getPropertyFileData("username");
		String PASSWORD = prop.getPropertyFileData("password");
		String BROWSER = prop.getPropertyFileData("browser");
		
		
		 String firstname = xlib.readData("contacts_info", 1, 0);
		 String lastname = xlib.readData("contacts_info", 1, 1);
		 String title = xlib.readData("contacts_info", 1, 2);
		 String email = xlib.readData("contacts_info", 1, 3);
		 String phone = xlib.readData("contacts_info", 1, 4);
		 
		
		
		wlib.TextBox(login.getUsernametxtbx(), USERNAME);
		wlib.TextBox(login.getPasswordtxtbx(), PASSWORD);
		wlib.clickOnElement(login.getLoginbtn());
		
		wlib.clickOnElement(home.getContactslink());
		
		wlib.clickOnElement(contactss.getCreatecontactBtn());
		
		wlib.SelectDropdown(contacts.getPrefixDropdown(),"Mr.");
		
		contacts.setFirstname(firstname);
		contacts.setLastname(lastname);
		contacts.setPhoneno(phone);
		contacts.setEmailname(email);
		contacts.setTitlename(title);
		
		
//		wlib.TextBox(driver.findElement(By.name("mobile")), "7293278932");
//		wlib.SelectDropdown((driver.findElement(By.xpath("//select[@name='leadsource']"))), "Employee");
		
		wlib.clickOnElement(contacts.getSavebtn());
		
		
		
	}
	
	
	
}
