package org.flipkart.PageObjectRepository;

import org.flipkart.genericUtility.ThreadSafeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//button[text()='✕']")
	private WebElement cancelButton ;

	@FindBy(xpath="//input[@class='_3704LK']")
	private WebElement searchTextBox ;

	@FindBy(xpath="//button[@class='L0Z3Pu']")
	private WebElement searchButton ;


	public void clickOnCancelButton() {
		cancelButton.click();
	}
	public ProductAddPage TextToSearch(String text) {
		searchTextBox.sendKeys(text);
		searchButton.click();
		return new ProductAddPage(ThreadSafeClass.getDriver());
	}


}
