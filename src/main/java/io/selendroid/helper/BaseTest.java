package io.selendroid.helper;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.aspectj.lang.annotation.Before;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	public static final String Appium_Node_Path = "C:/Program Files/Appium/node.exe";
	public static final String Appium_JS_Path = "C:/Program Files/Appium/node_modules/appium/bin/appium.js";
	public static final String Android_Property_FilePath = System.getProperty("user.dir")
			+ "\\resources\\Android.properies";
	static ExtentReports extents;
	public static ExtentTest extentTest;
	AppiumDriverLocalService appiumService;
	public DesiredCapabilities capabilities;
	public static AppiumDriver<MobileElement> driver;

	@BeforeSuite
	public void startAppoumserver() {

		/*
		 * appiumService = AppiumDriverLocalService.buildDefaultService();
		 * appiumService.start();
		 */

		/*
		 * appiumService = AppiumDriverLocalService.buildService(new
		 * AppiumServiceBuilder(). usingAnyFreePort().usingDriverExecutable(new
		 * File(Appium_Node_Path)). withAppiumJS(new File(Appium_JS_Path)));
		 * appiumService.start();
		 */

	}

	@BeforeTest
	public void LaunchApp() throws MalformedURLException, InterruptedException {
		capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,
				GenericMethods.readDataFromPropertiesFile("platformName", Android_Property_FilePath));
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,
				GenericMethods.readDataFromPropertiesFile("platformVersion", Android_Property_FilePath));
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,
				GenericMethods.readDataFromPropertiesFile("deviceName", Android_Property_FilePath));
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,
				GenericMethods.readDataFromPropertiesFile("automationName", Android_Property_FilePath));
		capabilities.setCapability(MobileCapabilityType.APP,
				GenericMethods.readDataFromPropertiesFile("app", Android_Property_FilePath));
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,
				120);

		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Thread.sleep(5000);
	}

	@AfterTest
	public void afterMethod() throws Exception {
		driver.quit();
	}

}
