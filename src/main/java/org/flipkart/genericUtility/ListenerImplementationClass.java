package org.flipkart.genericUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementationClass implements ITestListener {

	private ExtentTest test;
	public static ExtentTest testLog;
	private ExtentReports report;
	public void onTestStart(ITestResult result) {
		test.assignAuthor("Shaan");
		test.assignCategory("reg");
	}

	public void onTestSuccess(ITestResult result) {
		test.pass(result.getMethod().getMethodName()+"passed");
	}

	public void onTestFailure(ITestResult result) {
		test.fail(result.getMethod().getMethodName()+"test failed");
		test.fail(result.getThrowable());
		String path = ThreadSafeClass.getWebDriverUtility().TakesScreenShotInBase64();
		test.addScreenCaptureFromBase64String(path, result.getMethod().getMethodName());
	}

	public void onTestSkipped(ITestResult result) {
		test.skip(result.getMethod().getMethodName()+"test skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onStart(ITestContext context) {
		ExtentSparkReporter spark=new ExtentSparkReporter("./emailable-report/extent-reports");
		spark.config().setDocumentTitle("Flikart TestCase");
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("Flipkart Report");

		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Platform", "Windows");
		test=report.createTest(context.getClass().getSimpleName());
		testLog=test;

	}

	public void onFinish(ITestContext context) {
		report.flush();
	}

}
