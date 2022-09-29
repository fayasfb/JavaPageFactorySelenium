package com.automationpractice.code.demo;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class PropertiesReader 
{
	public Properties readPropertyFile() throws Exception{
		FileReader fileReader = new FileReader(new File(System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"
																+File.separator+"resources"+File.separator+"data.properties"));
		Properties properties= new Properties();
		properties.load(fileReader);
		return properties;
	}
}
