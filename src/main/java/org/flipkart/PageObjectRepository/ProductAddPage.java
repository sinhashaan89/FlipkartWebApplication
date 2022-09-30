package org.flipkart.PageObjectRepository;

import org.flipkart.genericUtility.IConstants;
import org.flipkart.genericUtility.ThreadSafeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductAddPage {

	public ProductAddPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//img[@class='_396cs4 _3exPp9']/ancestor::a[@class='_2rpwqI']/following-sibling::a[@class='s1Q9rs']")
	private WebElement productImg ;

	@FindBy(xpath="//input[@class='_3704LK']")
	private WebElement searchTextBox ;
	
	@FindBy(xpath="//button[@class='L0Z3Pu']")
	private WebElement searchButton ;
	
	@FindBy(xpath="//button[text()='ADD TO CART']")
	private WebElement addToCart ;


	private String clickOnProduct="//a[contains(text(),'%s')]";

	private WebElement convertDynamicXpath(String Xpath, String replaceData ) {
		String xpath = String.format(Xpath, replaceData);
		return ThreadSafeClass.getDriver().findElement(By.xpath(xpath));
	}

	public ProductAddPage clickOnProduct(String replaceData) {
		convertDynamicXpath(clickOnProduct,replaceData).click();
		ThreadSafeClass.getWebDriverUtility().switchWindow(replaceData);
		return new ProductAddPage(ThreadSafeClass.getDriver());
	}

	public void addProductToCart() {
		addToCart.click();
	}


	public void setProductToExcel() {
		String text=productImg.getText();
		ThreadSafeClass.getExcelUtility().setExcelData("Flipkart", 2, 2, text);
		ThreadSafeClass.getExcelUtility().saveExceldata(IConstants.EXCELFILEPATH);
		

	}



}
