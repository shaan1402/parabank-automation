package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.ControlActions;
import io.qameta.allure.Step;

public class OpenAccountPage extends ControlActions {

	@FindBy(xpath = "//h1[text()='Open New Account']")
	WebElement openNewAccountLocator;
	
	@FindBy(xpath = "//select[@id='type']")
	WebElement accountTypeLocator;
	
	@FindBy(xpath = "//select[@id='fromAccountId']" )
	WebElement accountsLocator;
	
	@FindBy(xpath = "//input[@type='button' and @value='Open New Account']")
	WebElement openNewAccBtnLocator;
	
//	@FindBy(xpath = "//input[@value='Open New Account']")
//	WebElement openAccBtnLocator;
	
//	@FindBy(xpath = "//select[@id='fromAccountId']")
//	WebElement selectAccountsLocator;
	
//	@FindBy(xpath = "//select[@id='fromAccountId']/option")
//	WebElement accountsOptionLocator;
	
	
	
//	String openNewAccountLocator = "//h1[text()='Open New Account']";
//	String accountTypeLocator = "//select[@id='type']";
//	String accountsLocator = "//select[@id='fromAccountId']";
//	String openAccBtnLocator = "//input[@value='Open New Account']";
//	String selectAccountsLocator = "//select[@id='fromAccountId']";
	String accountsOptionLocator = "//select[@id='fromAccountId']/option";
//	String openNewAccLocator = "//input[@type='button' and @value='Open New Account']";

//	public static String mainAccNumber = "";
	
	public static String newAccNumber = "";
	
	public OpenAccountPage() {
		PageFactory.initElements(driver, this);
	}

	@Step("Is Open New Acc DIsplayed")
	public boolean isOpenNewAccountFieldDisplayed() {
//		WebElement openNewAccountField = driver.findElement(By.xpath(openNewAccountLocator));
//		waitForVisibilityOfElement(openNewAccountLocator);
//		return openNewAccountLocator.isDisplayed();
		return isElementDisplayed(openNewAccountLocator, true);
	}

	@Step("Is Acc Type DIsplayed")
	public boolean isAccountTypeFieldDisplayed() {
//		WebElement accountTypeField = driver.findElement(By.xpath(accountTypeLocator));
//		waitForVisibilityOfElement(accountTypeLocator);
//		return accountTypeLocator.isDisplayed();
		return isElementDisplayed(accountTypeLocator, true);

	}

	@Step("Is Acc Field DIsplayed")
	public boolean isAccountsFieldDisplayed() {
//		WebElement accountsField = driver.findElement(By.xpath(accountsLocator));
//		waitForVisibilityOfElement(accountsLocator);
//		return accountsLocator.isDisplayed();
		return isElementDisplayed(accountsLocator, true);

	}

	@Step("Is Open New Acc Btn DIsplayed")
	public boolean isOpenNewAccBtnDisplayed() {
//		WebElement openAccButton = driver.findElement(By.xpath(openAccBtnLocator));
//		waitForVisibilityOfElement(openNewAccBtnLocator);
//		return openNewAccBtnLocator.isDisplayed();
		return isElementDisplayed(openNewAccBtnLocator, true);

	}

	@Step("Select Acc Type")
	public void selectAccType() {	
//		WebElement accType = driver.findElement(By.xpath(accountTypeLocator));
//		Select accTypeSelect = new Select(accountTypeLocator);
//		accTypeSelect.selectByVisibleText("SAVINGS");
		selectElementFromDropdown(accountTypeLocator, "TEXT", "SAVINGS", true, true);
	}

	@Step("Select Acccounts")
	public void selectAccounts() {
//		WebElement accounts = getElement("XPATH", selectAccountsLocator, true, true);

//		WebDriverWait waitForOptions = new WebDriverWait(driver, Duration.ofSeconds(10));
//		waitForOptions.until(
//				ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath()));
		
		Select fromAccountSelect = new Select(accountsLocator);
		WebElement accounts = getElement("XPATH", accountsOptionLocator, true, true);
		waitforElementToBeClickable(accounts);
		fromAccountSelect.getFirstSelectedOption();
//		selectElementFromDropdown(accountsLocator, "FIRST", "", true, true);
//		mainAccNumber = fromAccountSelect.getFirstSelectedOption().getText();
	}
	
	@Step("CLick on Open New Acc Btn")
	public void clickOnOpenNewAccBtn() {
		
//		WebElement openNewAccButton = getElement("XPATH", openNewAccLocator, true, true);
		waitforElementToBeClickable(openNewAccBtnLocator);

		// Scroll to the element to ensure it's in the viewport
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].scrollIntoView(true);", openNewAccButton);
		scrollTo(openNewAccBtnLocator);

		// Ensure the button is clickable by waiting for it
//		wait.until(ExpectedConditions.elementToBeClickable(openNewAccButton));
		waitforElementToBeClickable(openNewAccBtnLocator);
		// Now attempt to click the button using JavascriptExecutor to bypass potential
		// overlay issues
		
//		je.executeScript("arguments[0].click();", openNewAccBtnLocator);
		clickOnElementUsingJS(openNewAccBtnLocator);

		// Alternatively, you can use WebDriver's click method after making sure the
		// element is in the viewport
//		openNewAccBtnLocator.click();
		clickOnElement(openNewAccBtnLocator, true);
	}
	
	@Step("Get New Acc Number")
	public void getNewAccNum() {
//		WebElement newAccNum1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("newAccountId")));
		
		WebElement newAccNum = getElement("ID", "newAccountId", true, true);
		
		newAccNumber = getElementText(newAccNum, true);
		
		System.out.println("New Account number is " + newAccNumber);
	}
}
