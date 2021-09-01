package com.driver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.utilities.ReadPropertiesFile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Driver {

	public static AndroidDriver<AndroidElement> driver = null;

	public static void core_Capabilities() throws MalformedURLException {
		String fileName = null;
		ReadPropertiesFile readfile = new ReadPropertiesFile();
		Properties prop = readfile.readPropertiesFile(fileName);

		File appDir = new File("apk");
		File app = new File(appDir, "com.compass_canada.thrive-v2.28.0.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("DeviceName"));
		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		driver = new AndroidDriver<AndroidElement>(new URL(prop.getProperty("URL_CONNECTION")), capabilities);
	}
}