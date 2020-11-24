package io.selendroid.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class VerifyRegisterDetailsPage extends BasePOMpage {

	public VerifyRegisterDetailsPage(AppiumDriver<MobileElement> driver) {
		super(driver);

	}

	@AndroidFindBy(id = "io.selendroid.testapp:id/buttonRegisterUser")
	private AndroidElement registerUserButton;

	public void clickRegisterUserButton() {
		registerUserButton.click();
		;
	}
}
