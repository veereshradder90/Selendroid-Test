package io.selendroid.tests;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.selendroid.helper.BaseTest;

import io.selendroid.helper.GenericMethods;
import io.selendroid.pages.HomePage;
import io.selendroid.pages.RegistrationPage;
import io.selendroid.pages.VerifyRegisterDetailsPage;

public class RegisterUserTest extends BaseTest{
	HomePage homepage;
	RegistrationPage registrationPage;
	VerifyRegisterDetailsPage verifyRegisterDetailsPage;
	
	
		@Test (dataProvider ="test-data")
	public void registerUserTest(String userName, String emailId, String passWord, String name) throws InterruptedException {
		homepage=new HomePage(driver);
		verifyRegisterDetailsPage=new VerifyRegisterDetailsPage(driver);
		registrationPage=new RegistrationPage(driver);
		homepage.clickShowProgressBar();
		registrationPage.setUserNameTextbox(userName);
		driver.hideKeyboard();
		registrationPage.setEmailTextbox(emailId);
		registrationPage.setPasswordTextbox(passWord);
		registrationPage.setNameTextbox(name);;
		registrationPage.clickProgramingLanguagedropdown();
		registrationPage.clickSelectProgramingLanguagedropdownValue();
		registrationPage.clickregisterButton();
		verifyRegisterDetailsPage.clickRegisterUserButton();
		
		
	}

	@DataProvider(name ="test-data")
	public Object[][] excelDP() throws IOException{
    	GenericMethods methods=new GenericMethods();
    	Object[][] arrObj = methods.getExcelData(GenericMethods.readDataFromPropertiesFile("fileName", Android_Property_FilePath),GenericMethods.readDataFromPropertiesFile("sheetName", Android_Property_FilePath));
    	return arrObj;
	}
	
	
}
