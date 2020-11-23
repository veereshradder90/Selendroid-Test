package io.selendroid.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class RegistrationPage extends BasePOMpage{
	public RegistrationPage(AppiumDriver<MobileElement> driver) {
		super(driver);
	
	}


	@AndroidFindBy(id = "io.selendroid.testapp:id/inputUsername")
    private AndroidElement userNameTextbox;
	@AndroidFindBy(id = "io.selendroid.testapp:id/inputEmail")
    private AndroidElement emailTextbox;
	@AndroidFindBy(id = "io.selendroid.testapp:id/inputPassword")
    private AndroidElement passwordTextbox;
	@AndroidFindBy(id = "io.selendroid.testapp:id/inputName")
    private AndroidElement nameTextbox;
	@AndroidFindBy(id = "android:id/text1")
    private AndroidElement programingLanguagedropdown;
	@AndroidFindBy(xpath = "//ListView[text()['Java']")
    private AndroidElement selectProgramingLanguagedropdownValue;
	@AndroidFindBy(id = "io.selendroid.testapp:id/btnRegisterUser")
    private AndroidElement registerButton;

	
	public void setUserNameTextbox(String userNameText) {
		this.userNameTextbox.sendKeys(userNameText);
	}
	public void setEmailTextbox(String emailText) {
		this.emailTextbox.sendKeys(emailText);
	}
	public void setPasswordTextbox(String passwordText) {
		this.passwordTextbox.sendKeys(passwordText);
	}
	public void setNameTextbox(String name) {
		this.nameTextbox.sendKeys(name);;
	}
	public void clickProgramingLanguagedropdown() {
		this.programingLanguagedropdown.click();
	}
	public void clickSelectProgramingLanguagedropdownValue() {
		this.selectProgramingLanguagedropdownValue.click();
	}
	public void clickregisterButton() {
		this.registerButton.click();
	}

	

}
