package org.flipkart.genericUtility;

import org.flipkart.PageObjectRepository.AddToCartPage;
import org.flipkart.PageObjectRepository.HomePage;
import org.flipkart.PageObjectRepository.ProductAddPage;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class InstanceClass {

	public WebDriver driver;
	public WebDriverUtility WebDriverUtility;
	public ExcelUtility excelFileUtility;
	public FileUtility fileUtility;
	public JavaUtility javaUtility;
	public JavaScriptExecutorUtility javascriptexecutor;
	public SoftAssert assertSoft;
	
	public String url;
	public String username;
	public String userpass;
	public String browser;
	public String to;
	public long timeouts;
	public HomePage homePage;
	public ProductAddPage productPage;
	public AddToCartPage addToCart;
	
}
