package org.flipkart.genericUtility;


import org.flipkart.PageObjectRepository.AddToCartPage;
import org.flipkart.PageObjectRepository.HomePage;
import org.flipkart.PageObjectRepository.ProductAddPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

public class BaseClass extends InstanceClass {


	@BeforeSuite
	public void suiteSetup() {


	}
	//@Parameters("BROWSER")
	@BeforeClass
	public void classSetup() {
		
		WebDriverUtility=new WebDriverUtility();
		excelFileUtility=new ExcelUtility();
		fileUtility=new FileUtility();
		javaUtility=new JavaUtility();
		javascriptexecutor=new JavaScriptExecutorUtility();
		assertSoft=new SoftAssert();

		ThreadSafeClass.setWebDriverUtility(WebDriverUtility);
		ThreadSafeClass.setExcelUtility(excelFileUtility);
		ThreadSafeClass.setJavaUtility(javaUtility);

		
		excelFileUtility.intializeExcel(IConstants.EXCELFILEPATH);
		fileUtility.intializePropertyFile(IConstants.PROPERTYFILEPATH);
		url=fileUtility.getDataFromProperty("url");
		username=fileUtility.getDataFromProperty("userusername");
		userpass=fileUtility.getDataFromProperty("userpassword");
		browser=fileUtility.getDataFromProperty("browser");
		to=fileUtility.getDataFromProperty("timeout");
		timeouts = javaUtility.convertStringToLong(to);
		



		driver=WebDriverUtility.selectWebDriver(browser);
		ListenerImplementationClass.testLog.info("Open Browser");
		

		ThreadSafeClass.setDriver(driver);
		WebDriverUtility.maximizeBrowser();
		WebDriverUtility.implicitWait(timeouts);
		WebDriverUtility.sendUrl(url);
	
		//page object creation
		 homePage = new HomePage(driver);
		 productPage = new ProductAddPage(driver);
		 addToCart=new AddToCartPage(driver);
		 javascriptexecutor.webDriverToJavaScriptExecutor(driver);

	}
	@BeforeMethod
	public void methodSetup() {

	}
	@AfterMethod
	public void methodTearDown() {
	
		WebDriverUtility.closeBrowser();
	}
	@AfterClass
	public void classTearDown() {
		
		
		ListenerImplementationClass.testLog.info("Close Browser");
	}

	@AfterSuite
	public void suiteTearDown() {

		excelFileUtility.closeWorkbook();

	}


}
