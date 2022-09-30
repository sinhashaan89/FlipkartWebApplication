package org.flipkart.genericUtility;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * this class has reusable method
 * @author shaan
 *
 */
public class WebDriverUtility {
	WebDriver driver;
	/**
	 * @author shaan
	 * this method is used to initialize the webDriver
	 * @return
	 */
	public final WebDriver selectWebDriver(String browser) {

		switch (browser) {
		case "chrome":
			
			
			WebDriverManager.chromedriver().setup();

			ChromeOptions options=new ChromeOptions();
			
			options.setPageLoadStrategy(PageLoadStrategy.NONE);
		
			
			driver=new ChromeDriver();

			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();

			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();

			break;

		default:System.out.println("browser name not present");
		break;	
		}
		return driver;
	}
	/**
	 * @author shaan
	 * this method sends url
	 * @param url
	 */
	public void sendUrl(String url) {
		driver.get(url);
	}



	/**
	 * @author shaan
	 * this method is used for implicit wait
	 * @param timeOut
	 */
	public void implicitWait( long timeOut) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOut));
	}
	/**
	 * @author shaan
	 * this method is used maximize the browser
	 */
	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}
	/**
	 * @author shaan
	 * this method is used close the browser
	 */
	public void closeBrowser() {
		driver.quit();
	}
	/**
	 * @author shaan
	 * this method is used to handle popup
	 */
	public void acceptAlertPopUp() {
		driver.switchTo().alert().accept();
	}
	/**
	 * @author shaan
	 * this method is used to handle popup
	 */
	public void dismissAlertPopUp() {
		driver.switchTo().alert().dismiss();
	}
	/**
	 * @author shaan
	 * this method is used to handle popup
	 * @param key
	 */
	public void sendkeysToAlertPopUp(String key) {
		driver.switchTo().alert().sendKeys(key);
	}
	/**
	 * this method is used to select the DropDown by Index
	 * @author shaan
	 * @param element
	 * @param index
	 */
	public void selectToDropDown(WebElement element,int index) {
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	/**
	 * this method is used to select the DropDown by ByValue
	 * @author shaan
	 * @param element
	 * @param value
	 */
	public void selectDropDown(WebElement element,String value) {
		Select s=new Select(element);
		s.selectByValue(value);
	}
	/**
	 * this method is used to select the DropDown by VisibleText
	 * @author shaan
	 * @param text
	 * @param element
	 */
	public void selectDropDown(String text,WebElement element) {
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	/**
	 * this method is used to deSelect the DropDown by Index
	 * @author shaan
	 * @param element
	 * @param index
	 */
	public void deSelectDropDown(WebElement element,int index) {
		Select s=new Select(element);
		s.deselectByIndex(index);
	}
	/**
	 * @author shaan
	 * this method is used to deSelect the DropDown by ByValue
	 * @param element
	 * @param value
	 */
	public void deSelectDropDown(WebElement element,String value) {
		Select s=new Select(element);
		s.deselectByValue(value);
	}
	/**
	 * @author shaan
	 * this method is used to deSelect the DropDown by VisibleText
	 * @param text
	 * @param element
	 */
	public void deSelectDropDown(String text,WebElement element) {
		Select s=new Select(element);
		s.deselectByVisibleText(text);
	}
	/**
	 * @author shaan
	 * this method is used to navigate back
	 */
	public void goBack() {
		driver.navigate().back();
	}
	/**
	 * @author shaan
	 * this method is used switch to particular window or tab
	 */
	public void switchWindow(String title) {
		Set<String> allTab = ThreadSafeClass.getDriver().getWindowHandles();
		for (String win : allTab) {
			ThreadSafeClass.getDriver().switchTo().window(win);
			if(ThreadSafeClass.getDriver().getTitle().contains(title)) {
				break;
			}
		}
	}
	/**
	 * @author shaan
	 * this method is used take screenshot in Base64 format
	 */
	public String TakesScreenShotInBase64()
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		String path=ts.getScreenshotAs(OutputType.BASE64);
		return path;
	}

}
