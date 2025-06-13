package base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.AccountOverviewPage;
import path.ConstantPath;

public class ControlActions {

	protected static WebDriver driver;
	protected static WebDriverWait wait;
	protected static JavascriptExecutor je;

	public static void start(String url) {
		System.out.println("Launch Browser");
		driver = new ChromeDriver();
		System.out.println("Load URL");
		driver.get(url);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		je = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
	}

	public static void close() {
		System.out.println("Closing the browser");
		driver.quit();
	}

	protected static void scrollTo(WebElement e) {
//		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView(true);", e);
	}

	protected void visibilityOfElement(WebElement e) {
		wait.until(ExpectedConditions.visibilityOf(e));
	}

	protected void waitforElementToBeClickable(WebElement e) {
		wait.until(ExpectedConditions.elementToBeClickable(e));
	}
	
	protected void refreshAndWaitForVisibility(WebElement e) {
		  wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(e)));
	}

	protected void waitForElementWithText(WebElement e) {
		wait.until(driver -> !e.getText().trim().isEmpty());
	}
	
	protected boolean isElementDisplayed(String locatorType, String locatorValue, boolean isWaitRequired) {
		try {
			WebElement e = getElement(locatorType, locatorValue, isWaitRequired);
			if (e.isDisplayed()) {
				return true;
			} else {
				scrollTo(e);
				return e.isDisplayed();
			}
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	protected boolean isElementDisplayed(WebElement e, boolean isWaitRequired) {
		try {
			if (isWaitRequired) {
				if (e.isDisplayed()) {
					return true;
				} else {
					scrollTo(e);
					return e.isDisplayed();
				}
			} else {
				return e.isDisplayed();
			}

		} catch (NoSuchElementException ne) {
			return false;
		}
	}

	protected WebElement waitForVisibilityOfElement(WebElement e) {
		return wait.until(ExpectedConditions.visibilityOf(e));
	}

	protected List<WebElement> waitForVisibilityOfList(List<WebElement> e) {
		return wait.until(ExpectedConditions.visibilityOfAllElements(e));
	}
	
	protected int sizeOfList(List<WebElement> list) {
		int size = list.size();
		return size;
	}
	
//	protected void waitForVisibilityOfList(String locatorValue) {
//		List<WebElement> e = wait.until(ExpectedConditions.visibilityOfAllElements(locatorValue));
//	}
	
	public void clickOnElementUsingJS(WebElement e){
		je.executeScript("arguments[0].click();", e);
	}

	
	public void clickOnElement(WebElement e, boolean isWaitRequired){
		if(isWaitRequired){
			visibilityOfElement(e);
			try {
				e.click();
			}
			catch(ElementClickInterceptedException ce){
				scrollTo(e);
				clickOnElementUsingJS(e);
			}
		}else {
			e.click();
		}
	}
	
//	public void clickonelement(String locatorType, String locatorValue, Boolean isWaitRequired){
//		WebElement e = getElement(locatorType, locatorValue, isWaitRequired);
//		try{
//			e.click();
//		}catch(ElementClickInterceptedException ce){
//		//	scrollto(e);
//			clickonelementusingJS(e);
//		}
//	}
	
	public void clickOnElement(String locatorType, String locatorValue, boolean isWaitRequired){
		WebElement e = getElement(locatorType, locatorValue, isWaitRequired);
		clickOnElement(e, false);
	}
	
	public void waitABit(int milisecond){
		try{
			Thread.sleep(milisecond);
		}catch(InterruptedException ie){
			System.out.println(ie.getMessage());
		}
	}
	
	//method for extracting text from a webelement
	protected String getElementText(WebElement e, boolean isWaitRequired) {
//		wait.until(ExpectedConditions.visibilityOf(e));
		waitForVisibilityOfElement(e);
		return e.getText();
	}
		
	protected String getElementText(String locatorType, String locatorValue, boolean isWaitRequired) {
		WebElement e = getElement(locatorType, locatorValue, isWaitRequired);
		return e.getText();
	}
	
	// method to add text
	
	public void setText(WebElement e, String text, boolean isWaitRequired){
		if(isWaitRequired){
			wait.until(ExpectedConditions.visibilityOf(e));
		}
		e.sendKeys(text);
	}

	public void setText(String locatorType, String locatorValue, String text, boolean isWaitRequired){
		WebElement e = getElement(locatorType, locatorValue, isWaitRequired);
		setText(e, text, false);
	}


	public void selectElementFromDropdown(WebElement e, String selectBy, String value, boolean isWaitRequired, boolean isElementClickable) {
		Select select = new Select(e);
		switch (selectBy.toUpperCase()) {
        case "TEXT":
        	if(isWaitRequired) {
        		if(isElementClickable) {
        			waitforElementToBeClickable(e);
        			select.selectByVisibleText(value);
        		}else {
        			waitForVisibilityOfElement(e);
        			select.selectByVisibleText(value);
        		}
        	}
        	select.selectByVisibleText(value);
            break;

        case "INDEX":
        	if(isWaitRequired) {
        		if(isElementClickable) {
        			waitforElementToBeClickable(e);
                    select.selectByIndex(Integer.parseInt(value)); // Convert string to int
        		}else {
        			waitForVisibilityOfElement(e);
                    select.selectByIndex(Integer.parseInt(value)); // Convert string to int
        		}
        	}
        	select.selectByIndex(Integer.parseInt(value)); // Convert string to int
            break;

        case "VALUE":
        	if(isWaitRequired) {
        		if(isElementClickable) {
        			waitforElementToBeClickable(e);
                    select.selectByValue(value);
        		}else {
        			waitForVisibilityOfElement(e);
                    select.selectByValue(value);
        		}
        	}
            select.selectByValue(value);
            break;
            
        case "FIRST":
        	if(isWaitRequired) {
        		if(isElementClickable) {
        			waitforElementToBeClickable(e);
                	select.getFirstSelectedOption();
        		}else {
                	waitForVisibilityOfElement(e);
                	select.getFirstSelectedOption();
        		}
        	}
        	select.getFirstSelectedOption();
        	break;
            
        default:
            System.out.println("Invalid selection type: " + selectBy);
		}
	} 

	
	public boolean isElementFromListVisible(List<WebElement> list, String elementText) {
		boolean elementFoundFlag = false;
		for(WebElement e : list) {
			String actualText = getElementText(e, true);
			if(actualText.equals(elementText)) {
				elementFoundFlag = true;
				System.out.println("Account number is in the list and is verified");
				break;
			}
		}
		return elementFoundFlag;
	}
	
	public void selectElementFromListIfEqual(List<WebElement> list, String selectBy, String expectedValue) {
		
		System.out.println("Inside selectElementFromListIfEqual");
		for (WebElement e : list) {
			String actualValue = e.getText();
			System.out.println("Element text: " + actualValue);
			if (actualValue.equals(expectedValue)) {
				System.out.println("actual is : " + actualValue);
				System.out.println("expected is : " +expectedValue);
				WebElement selectElement = e.findElement(By.xpath("./ancestor::select"));
				selectElementFromDropdown(selectElement, selectBy, expectedValue, true, true);
				System.out.println("selected the element ");
//				selectElementFromDropdown(e, selectBy, expectedValue, true, true);
//				Select fromDropdownSelect = new Select(selectFrom);
//				fromDropdownSelect.selectByVisibleText(option);
				break;
			}
		}
		
	}
	
	public void clickOnElementIfValuesAreEqual(List<WebElement> list, String expectedValue) {
		String actualValue = "";
		for(WebElement e : list) {
			actualValue = getElementText(e, true);
			if(actualValue.equals(expectedValue)) {
				e.click();
				break;
			}
		}
	}
	
	public void clickOnElementIfContains(List<WebElement> list, String expectedValue) {
		String actualValue = "";
		for(WebElement e : list) {
			actualValue = getElementText(e, true);
			if(actualValue.contains(expectedValue)) {
				e.click();
				break;
			}
		}
	}
	
	public boolean areValuesEqual(String actualValue, String expectedValue) {
		if(actualValue.equals(expectedValue)) {
			return true;
		}else
			return false;
	}
	
	protected boolean isElementSelected(String locatorType, String locatorValue,boolean isWaitRequired) {
		WebElement e = getElement(locatorType, locatorValue, isWaitRequired);
		return e.isSelected();
	}
	
	protected boolean isElementSelected(WebElement e,boolean isWaitRequired) {
		if(isWaitRequired)
			waitForVisibilityOfElement(e);
		return e.isSelected();
	}
	
	


//	public void tearDown(ITestResult result) {
//		if(result.getStatus() == ITestResult.FAILURE) {
//			System.out.println(result.getMethod());
//			takeScreenShot(result.getName());
//		}
//	}

	public static void takeScreenShot(String fileName) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File(ConstantPath.SCREENSHOT + fileName + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static WebElement getElement(String locatorType, String locatorValue, boolean isWaitRequired) {
		WebElement e = null;
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		switch (locatorType.toUpperCase()) {

		case "XPATH":
			if (isWaitRequired) {
				e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
			} else {
				e = driver.findElement(By.xpath(locatorValue));
			}
			break;

		case "ID":
			if (isWaitRequired) {
				e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
			} else {
				e = driver.findElement(By.id(locatorValue));
			}
			break;

		case "NAME":
			if (isWaitRequired) {
				e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorValue)));
			} else {
				e = driver.findElement(By.name(locatorValue));
			}
			break;

		case "CLASS":
			if (isWaitRequired) {
				e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locatorValue)));
			} else {
				e = driver.findElement(By.className(locatorValue));
			}
			break;

		case "LINKTEXT":
			if (isWaitRequired) {
				e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locatorValue)));
			} else {
				e = driver.findElement(By.linkText(locatorValue));
			}
			break;

		case "PARTIALLINK":
			if (isWaitRequired) {
				e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(locatorValue)));
			} else {
				e = driver.findElement(By.partialLinkText(locatorValue));
			}
			break;

		default:
			throw new IllegalArgumentException(
					"Valid locators are XPATH, ID, NAME, CLASS, LINKTEXT, PARTIALLINK... But you provided: "
							+ locatorType);
		}

		return e;
	}
	
	
	
	public static WebElement getElement(String locatorType, String locatorValue, boolean isWaitRequired,
			boolean waitForClickable) {
		WebElement e = null;

		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); //
		// Assuming wait is already initialized elsewhere

		switch (locatorType.toUpperCase()) {

		case "XPATH":
			if (isWaitRequired) {
				if (waitForClickable) {
					e = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locatorValue))); // Wait for
																										// visibility
																										// and
																										// clickability
				} else {
					e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue))); // Wait for
																											// visibility
																											// only
				}
			} else {
				e = driver.findElement(By.xpath(locatorValue));
			}
			break;

		case "ID":
			if (isWaitRequired) {
				if (waitForClickable) {
					e = wait.until(ExpectedConditions.elementToBeClickable(By.id(locatorValue))); // Wait for visibility
																									// and clickability
				} else {
					e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue))); // Wait for
																										// visibility
																										// only
				}
			} else {
				e = driver.findElement(By.id(locatorValue));
			}
			break;

		case "NAME":
			if (isWaitRequired) {
				if (waitForClickable) {
					e = wait.until(ExpectedConditions.elementToBeClickable(By.name(locatorValue))); // Wait for
																									// visibility and
																									// clickability
				} else {
					e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorValue))); // Wait for
																											// visibility
																											// only
				}
			} else {
				e = driver.findElement(By.name(locatorValue));
			}
			break;

		case "CLASS":
			if (isWaitRequired) {
				if (waitForClickable) {
					e = wait.until(ExpectedConditions.elementToBeClickable(By.className(locatorValue))); // Wait for
																											// visibility
																											// and
																											// clickability
				} else {
					e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locatorValue))); // Wait
																												// for
																												// visibility
																												// only
				}
			} else {
				e = driver.findElement(By.className(locatorValue));
			}
			break;

		case "LINKTEXT":
			if (isWaitRequired) {
				if (waitForClickable) {
					e = wait.until(ExpectedConditions.elementToBeClickable(By.linkText(locatorValue))); // Wait for
																										// visibility
																										// and
																										// clickability
				} else {
					e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locatorValue))); // Wait
																												// for
																												// visibility
																												// only
				}
			} else {
				e = driver.findElement(By.linkText(locatorValue));
			}
			break;

		case "PARTIALLINK":
			if (isWaitRequired) {
				if (waitForClickable) {
					e = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(locatorValue))); // Wait
																												// for
																												// visibility
																												// and
																												// clickability
				} else {
					e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(locatorValue))); // Wait
																														// for
																														// visibility
																														// only
				}
			} else {
				e = driver.findElement(By.partialLinkText(locatorValue));
			}
			break;

		default:
			throw new IllegalArgumentException(
					"Valid locators are XPATH, ID, NAME, CLASS, LINKTEXT, PARTIALLINK... But you provided: "
							+ locatorType);
		}
		return e;
	}

}
