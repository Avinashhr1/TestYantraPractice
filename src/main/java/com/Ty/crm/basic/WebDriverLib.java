package com.Ty.crm.basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverLib {

	WebElement element;
	WebDriver driver;
	
	public void TextBox(WebElement element, String text) {
		element.sendKeys(text);
	}
	
	public void SelectDropdown(WebElement element, String text ) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}
	
	public void SelectDropdown(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	public void clickOnElement(WebElement element) {
		element.click();
	}
	
	public void mouseHover(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public void rightClick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	
	public void doubleClick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
}
