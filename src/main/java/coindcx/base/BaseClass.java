package coindcx.base;

import java.util.NoSuchElementException;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass{

	private static final Logger log = LogManager.getLogger(BaseClass.class);

	public static WebDriver driver;
	public  WebDriverWait wait;
	
	public static Properties prop;
	
	

	public  void click(WebElement ele)  {
		try {
			
			ele.click();
		}
		catch(Exception e) {
			log.error(e.getMessage());
		}
	}
	
	public void clickCaptcha(WebElement frame, WebElement ele )
	{ 

		try {
			WebDriverWait explictWait = new WebDriverWait(driver,10);

			explictWait.until(ExpectedConditions.visibilityOf(frame));

			driver.switchTo().frame(frame);

			explictWait.until(ExpectedConditions.visibilityOf(ele)).click();
		} 
		catch(Exception e){

			log.info(" Frame doesn't exist to switch ");
		}

		driver.switchTo().defaultContent();
	}
	
	public boolean isEnabled(WebElement ele) {
		boolean flag = false;
		try {
			flag = ele.isEnabled();
		} catch (Exception e) {
			log.error("Element not present {}",e.getMessage());
		}
		return flag;
	}

	
	

	public void jsClick(WebElement ele){
		try {
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", ele);
		}catch (Exception e) {
			log.error(e.getMessage());
		}

	}



	public  void setValue(WebElement ele, String str){
		
		ele.clear();
		ele.sendKeys(str);
	}



	public void waitAndClick(WebElement ele, int time) throws Exception {
		
		click(ele);
	}

	protected void navigateTo(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	

	public boolean isElementPresent(WebElement ele) {
		boolean flag = false;
		try {
			flag = ele.isDisplayed();
		} catch (Exception e) {
			log.info("Element not present");
		}
		return flag;
	}

	

	

	

	public void scrollForElement(WebElement ele) throws Exception{

		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", ele);
		new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(ele));

	}

	public void close() {
		driver.close();
	}

	

	public void highlight(WebElement element) throws Exception {
		try {
			waitUntilElementDetected(element);
			JavascriptExecutor je = (JavascriptExecutor) driver;
			je.executeScript("arguments[0].style.border='3px solid green',background='yellow'", element);
			log.info("Highlighted text is : {}" ,element.getText().replace("\n", ""));
		} catch (RuntimeException localRuntimeException) {
			log.info("Error in Highlighting the element : {}" ,localRuntimeException.getMessage() + "Fail");
			localRuntimeException.getMessage();
			throw localRuntimeException;
		}
	}



	
	public void scollTillPageEnd() {
		try {
			long pageHeight = (long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");

			while (true) {
				((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
				Thread.sleep(2000);

				long newHeight = (long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");
				if (newHeight == pageHeight) {
					break;
				}
				pageHeight = newHeight;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void waitUntilElementDetected(WebElement ele) {
		wait=new WebDriverWait(driver,20);
		try {
			wait.until(ExpectedConditions.visibilityOf(ele));
		}catch (TimeoutException e) {
			log.info(ele.getText());
			throw new NoSuchElementException();
		}
	}
	
	public void waitForPageToLoad() {
		new WebDriverWait(driver,20).until(
				driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
	}
}
