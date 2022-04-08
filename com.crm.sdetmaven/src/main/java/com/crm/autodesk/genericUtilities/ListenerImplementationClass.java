package com.crm.autodesk.genericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementationClass implements ITestListener {
	
	ExtentTest test;
	ExtentReports report;
	public void onTestStart(ITestResult result) {
		//Step 3: Create a test method during the test execution start
		test=report.createTest(result.getMethod().getMethodName());
	}
	public void onTestSuccess(ITestResult result) {
		//Step 4: log the pass method to test
		test.log(Status.PASS, result.getMethod().getMethodName());
	}

	public void onTestFailure(ITestResult result) {
		//Step 6: log fail method to test and take screenshot and attach to extent report, add exceptionlog 
		test.log(Status.FAIL,result.getMethod().getMethodName());
		test.log(Status.FAIL,result.getThrowable());
		String path = null;
		WebDriverUtility wUtil=new WebDriverUtility();
		try {
		path= wUtil.takesScreenshot(BaseClass.sDriver, result.getMethod().getMethodName());
			}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(path);
		}

	
	public void onTestSkipped(ITestResult result) {
		//Step 5: log the skipped method to test(test case name and exception to be passed)
		test.log(Status.SKIP,result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getThrowable());
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}
	public void onTestFailedWithTimeout(ITestResult result) {
	}
	public void onStart(ITestContext context) {
		//Step1: Extent report configuration
		//ITestResult result;
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter("./extentReport"+new JavaUtility().getSystemDate()+".html");
		htmlReporter.config().setReportName("Regression Extention Report_"/*+result.getMethod().getMethodName()+"Extention Report"*/);
		htmlReporter.config().setDocumentTitle("Execution report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		
		//Step2: attach the physical report and do system configuration
		report= new ExtentReports();
		report.attachReporter(htmlReporter);
	}
	public void onFinish(ITestContext context) {
		report.flush();
	}
}
