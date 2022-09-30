package org.flipkart.ProductAdd;

import org.flipkart.genericUtility.BaseClass;
import org.flipkart.genericUtility.IConstants;
import org.flipkart.genericUtility.ListenerImplementationClass;
import org.flipkart.genericUtility.ThreadSafeClass;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(org.flipkart.genericUtility.ListenerImplementationClass.class)
public class InsertProductInCart extends BaseClass{

	
	@Test(retryAnalyzer = org.flipkart.genericUtility.RetryImplementationClass.class)
	public void AddProductToCart() {
		homePage.clickOnCancelButton();
		String productName=ThreadSafeClass.getExcelUtility().getExcelData(IConstants.NameOfSheet, 2, 1);
		homePage.TextToSearch(productName).setProductToExcel();
		String expectedProduct=ThreadSafeClass.getExcelUtility().getExcelData(IConstants.NameOfSheet, 2, 2);
		productPage.clickOnProduct(expectedProduct).addProductToCart();
		ListenerImplementationClass.testLog.info("Product added");
		String actualProduct=addToCart.getProductNameInCart();
		expectedProduct=expectedProduct.substring(0, 20);
		ListenerImplementationClass.testLog.info("Verifying Product being added to Cart");
		Assert.assertTrue(actualProduct.contains(expectedProduct));
		ListenerImplementationClass.testLog.info("Product Being Successfully Added ");
		System.out.println("Product Added Successfully ");
	
	}

}
