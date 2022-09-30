package org.flipkart.genericUtility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptExecutorUtility {
	private JavascriptExecutor javascriptexecutor;
	/**@author shaan
	 * @return 
	 * this method is used to initialize javascript executor
	 */
		public JavascriptExecutor webDriverToJavaScriptExecutor(WebDriver driver){
			javascriptexecutor=(JavascriptExecutor)driver;
			return javascriptexecutor;
		}
		/**
		 * this method is used to get URL
		 * @param url
		 */
		public void getUrl(String url){
			javascriptexecutor.executeScript("window.location='"+url+"'");
		}
		/**
		 * 
		 * @param 
		 */
		
		public void sendkeyToElement(WebElement element, String keys){
			javascriptexecutor.executeScript("arguments[0].value=arguments[1]",element,keys);
		}
		
		/**
		 * this method is used click element
		 * @param url
		 */
		public void clickOnElement(WebElement element){
			javascriptexecutor.executeScript("arguments[0].click()",element);
		}
		/**
		 * this method is used to scroll
		 */
		public void scrollTo(int x,int y){
			javascriptexecutor.executeScript("window.scrollBy("+x+","+y+")");
		}
		/**
		 * this method is used to scroll
		 * @param x
		 */
		public void scrollToHeight(int x){
			javascriptexecutor.executeScript("window.scrollBy("+x+",document.body.scrollHeight)");
		}
		/**
		 * this method is used to scroll
		 */
		public void scrollToWidth(int y){
			javascriptexecutor.executeScript("window.scrollBy(document.body.scrollWidth,"+y+")");
		}
		/**
		 * this method is used to scroll by element
		 */
		public void scrollToElement(WebElement element){
			javascriptexecutor.executeScript("arguments[0].scrollIntoView()", element);
		}
}
