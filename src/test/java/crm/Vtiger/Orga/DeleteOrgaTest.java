package crm.Vtiger.Orga;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ty.crm.basic.BaseClass;
import com.Ty.crm.basic.ExcellLib;
import com.Ty.crm.basic.PropertyFileLib;
import com.Ty.crm.basic.WebDriverUtils;

import PoMPagesVtiger.HomePage;
import PoMPagesVtiger.LoginPage;

public class DeleteOrgaTest extends BaseClass {
	
	

	@Test
	public void deleteOrganization() throws Throwable {
		
		/*read data from Excel sheet*/
		String OrgName = xlib.readData("Org_details", 1, 0)+"_"+wlib.getRamDomNum();
		String org_Type = xlib.readData("Org_details", 1, 1);
		String org_industry = xlib.readData("Org_details", 1, 2);
		
		
		/*Step3 navigate to organization*/
		HomePage home = new HomePage(driver);
		home.getOrganizationslink().click();
		
		
		/*Step4 navigate to new organization page*/
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		/*Step5 create the new organization*/
		driver.findElement(By.name("accountname")).sendKeys(OrgName);
		WebElement Type_dropdown = driver.findElement(By.xpath("//select[@name='accounttype']"));
		wlib.select(Type_dropdown, org_Type);
		WebElement Industry_dropdown = driver.findElement(By.xpath("//select[@name='industry']"));
		wlib.select(Industry_dropdown, org_industry);
		driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).click();
		
		/*Step6 verify new organization created*/
		String actOrgName = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		Assert.assertTrue(actOrgName.contains(OrgName));
		
		/*Step7 navigate to organization page*/
		home.getOrganizationslink().click();
		
		/*Step8 search for created organization based on name*/
		driver.findElement(By.xpath("//td[@class='searchUIName small']/../td[3]/input")).sendKeys(OrgName);
		WebElement In_dropdown = driver.findElement(By.xpath("//td[@class='searchUIName small']/../td[5]/div/select"));
		wlib.select(In_dropdown, "Organization Name");
		
		driver.findElement(By.xpath("//td[@class='searchUIName small']/../td[6]/input")).click();
		
		/*Step9 select the organization and delete */
		driver.findElement(By.xpath("//a[contains(.,'"+OrgName+"')]/../../td[1]/input[@name='selected_id']")).click();
		driver.findElement(By.xpath("//td/table[2]/tbody/tr/td/input[@class='crmbutton small delete']")).click();
		wlib.alertOk(driver);
		
		/*Step10 search for created organization based on name*/
		driver.findElement(By.xpath("//td[@class='searchUIName small']/../td[3]/input")).sendKeys(OrgName);
		//WebElement In_dropdown = driver.findElement(By.xpath("//td[@class='searchUIName small']/../td[5]/div/select"));
		wlib.select(In_dropdown, "Organization Name");
		
		driver.findElement(By.xpath("//td[@class='searchUIName small']/../td[6]/input")).click();
		
		/*Step 11 Verify the organization is displayed*/
		boolean displayed = driver.findElement(By.xpath("//span[contains(.,'No Organization Found !')]")).isDisplayed();
		Assert.assertEquals(displayed, true);
		
	}
	
	

}
