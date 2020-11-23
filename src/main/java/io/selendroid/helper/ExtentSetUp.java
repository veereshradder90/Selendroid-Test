package io.selendroid.helper;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentSetUp extends BaseTest{
	public  static ExtentReports setUpExtentReport() {
SimpleDateFormat  formate=new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
Date date=new Date();
String actualDate=formate.format(date);
System.out.println("current folder"+System.getProperty("user.dir"));
String reportPath=System.getProperty("user.dir")+"/Reports/ExecutionReport_"+actualDate+".html";
ExtentSparkReporter sparkreport=new ExtentSparkReporter(reportPath);
 extents=new ExtentReports();
extents.attachReporter(sparkreport);
sparkreport.config().setDocumentTitle("Documenyttitle");
sparkreport.config().setTheme(Theme.DARK);
return extents;
	}
}
