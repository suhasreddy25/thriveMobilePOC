package com.pages;

import java.util.Properties;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.driver.Driver;
import com.utilities.ReadPropertiesFile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Login_Pages extends Driver {
	
	public static final String filename = null;
	public ReadPropertiesFile readPropertiesFile = new ReadPropertiesFile();
	public Properties prop = readPropertiesFile.readPropertiesFile(filename);
	
	@FindBy(xpath = "//android.widget.TextView[@text='Log In']")
	AndroidElement login_Hyperlink;

	@FindBy(xpath = "//android.widget.EditText[@text='Email']")
	AndroidElement email_TextInput;

	@FindBy(xpath = "//android.widget.EditText[@text='Password']")
	AndroidElement password_Input;
	
	@FindBy(xpath = "//android.widget.Button[@text='Log In']")
	AndroidElement login_Button;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Invalid credentials']")
	AndroidElement error_msg;

	@FindBy(xpath = "//android.widget.Button[@text='OK']")
	AndroidElement OK_button;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Find Food Near You']")
	AndroidElement welcome_message;
	
	public Login_Pages(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void login() {
		login_Hyperlink.click();
	}

	public void email_Field(String email) {
		email_TextInput.sendKeys(email);
	}
	
	public void password_Field(String password) {
		password_Input.sendKeys(password);
	}

	public void login_Button_Field() {
		login_Button.click();
	}
	
	public String getErrorMessage() {
		return error_msg.getText();
	}
	
	public void ok_button_Field() {
		OK_button.click();
	}
	
	public void clear_email_Field() {
		email_TextInput.clear();
	}
	
	public void clear_password_Field() {
		password_Input.clear();
	}
	
	public String getWelcomeMessage() {
		return welcome_message.getText();
	}

}
