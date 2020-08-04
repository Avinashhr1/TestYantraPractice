package com.Ty.crm.basic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileLib {
	/*
	 * @author Avinash
	 * This class will get the data from the property file
	 *
	 */
	public String getPropertyFileData(String key) throws IOException {
		/* step1: Get the java representaion of the physical file  */
		FileInputStream fis = new FileInputStream("./CommonProperties/common.properties");
		
		/*step2: Using property file load all the keys into java object*/
		Properties prop = new Properties();
		prop.load(fis);
		
		/*step3: read data from the property file*/
		String value = prop.getProperty(key);
		
		return value;
		
	}
	
	
	
	

}
