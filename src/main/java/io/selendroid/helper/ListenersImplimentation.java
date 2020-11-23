package io.selendroid.helper;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

public class ListenersImplimentation extends BaseTest implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		extentTest=extents.createTest(result.getMethod().getMethodName());
	ExtentFactory.getInstance().setExtent(extentTest);
	ExtentFactory.getInstance().removeExtentObject();
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentFactory.getInstance().getExtent().log(Status.PASS, "Test case "+result.getMethod().getMethodName()+"is passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Test case "+result.getMethod().getMethodName()+"is failed");
		ExtentFactory.getInstance().getExtent().log(Status.FAIL,result.getThrowable());
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		SimpleDateFormat  formate=new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		Date date=new Date();
		String actualDate=formate.format(date);
		String screenshotPath=System.getProperty("user.dir")+"/Reports/screenshots"+actualDate+".jpeg";
		File dest=new File(screenshotPath);
		try {
			FileUtils.copyFile(src,dest);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			ExtentFactory.getInstance().getExtent().addScreenCaptureFromPath(screenshotPath, "Test case failuir screenshot");
			ExtentFactory.getInstance().removeExtentObject();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentFactory.getInstance().getExtent().log(Status.SKIP, "Test case "+result.getMethod().getMethodName()+"is skipped");
		ExtentFactory.getInstance().removeExtentObject();
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
		
	}

	@Override
	public void onStart(ITestContext context) {
extents=ExtentSetUp.setUpExtentReport();
		
	}

	@Override
	public void onFinish(ITestContext context) {
		extents.flush();
		
	}

}
