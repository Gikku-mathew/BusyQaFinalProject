package com.webappsecurity.tests;

import java.io.FileInputStream;


import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utils.BrowserFactory;

@Listeners(utils.NGListeners.class)	


public class TestBase {
public WebDriver driver;
public static Properties properties;
Logger logger=Logger.getLogger("TestBase");

public static void configReader() {
	 //Declare a properties object
   properties = new Properties();

   //Read configuration.properties file
   try {
   	properties.load(new FileInputStream(
   			System.getProperty("user.dir") 
   			+ "\\src\\test\\resources\\Configurations.properties"));
   } catch (IOException e) {
       System.out.println("Configuration properties file cannot be found");
   }	
}


	@BeforeMethod
	public void setUp() throws IOException {
	configReader();
	properties.load(getClass().getResourceAsStream("/log4j.properties"));
	PropertyConfigurator.configure(properties);
	driver = BrowserFactory.chooseBrowser("chrome");
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.get(properties.getProperty("url"));
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
