package com.tests;

import java.net.MalformedURLException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.driver.Driver;
import com.pages.Login_Pages;
import com.utilities.ReadPropertiesFile;

public class ThriveTest extends Driver {
	
	public static final String fileName = null;
	public ReadPropertiesFile readfile = new ReadPropertiesFile();
	public Properties prop = readfile.readPropertiesFile(fileName);
	
	Login_Pages login_pages;
	
	@BeforeMethod
	public void initialization() throws MalformedURLException {
		Driver.core_Capabilities();
	}
	
	@Test(priority = 0)
	public void unsuccessful_Login() {
		login_pages = new Login_Pages(driver);
		login_pages.login();
		login_pages.clear_email_Field();
		login_pages.email_Field("suhasr.m25@gmail.com");
		login_pages.password_Field("12345");
		login_pages.login_Button_Field();
		String error_message =login_pages.getErrorMessage();
		Assert.assertEquals("Invalid credentials", error_message);
		login_pages.ok_button_Field();
	}
	
	@Test(priority = 1)
	public void successful_Login() {
		login_pages = new Login_Pages(driver);
		login_pages.login();
		login_pages.clear_email_Field();
		login_pages.email_Field("suhasr.m25@gmail.com");
		login_pages.clear_password_Field();
		login_pages.password_Field("Suhas@2021#*");
		login_pages.login_Button_Field();
		String welcome_msg = login_pages.getWelcomeMessage();
		Assert.assertEquals("Find Food Near You", welcome_msg);
	}
}
