package com.Ty.crm.basic;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptLib {

	public void enterToDisTextbox(WebDriver driver, WebElement element,String script) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(script, element);
	}
	
	
	
}
