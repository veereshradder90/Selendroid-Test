package io.selendroid.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePage extends BasePOMpage{

	public HomePage(AppiumDriver<MobileElement> driver) {
		super(driver);
		
	}
	
	@AndroidFindBy(id = "io.selendroid.testapp:id/waitingButtonTest")
    private AndroidElement showProgressBar;
	@AndroidFindBy(id = "io.selendroid.testapp:id/visibleButtonTest")
    private AndroidElement displayTextView;
	@AndroidFindBy(id = "io.selendroid.testapp:id/input_adds_check_box")
    private AndroidElement iAcceptAdds;
	@AndroidFindBy(id = "io.selendroid.testapp:id/showPopupWindowButton")
    private AndroidElement displayPopUpWindow;
	@AndroidFindBy(id = "io.selendroid.testapp:id/showToastButton")
    private AndroidElement displayToast;
	@AndroidFindBy(id = "io.selendroid.testapp:id/exceptionTestButton")
    private AndroidElement pressUnhandledException;
	@AndroidFindBy(id = "io.selendroid.testapp:id/exceptionTestField")
    private AndroidElement exceptionTextField;
	@AndroidFindBy(id = "io.selendroid.testapp:id/topLevelElementTest")
    private AndroidElement displayFocusOnLayout;	
	@AndroidFindBy(id = "io.selendroid.testapp:id/my_text_field")
    private AndroidElement myTestField;
	

	public void clickShowProgressBar() {
		showProgressBar.click();
	}
}
