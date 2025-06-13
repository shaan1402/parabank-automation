package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ControlActions;

public class AccountDetailsPage extends ControlActions{
	
	@FindBy(xpath = "//div[@id='accountDetails']/table/tbody/tr/td[@id='accountId']")
	WebElement accNumberLocator;
	
	@FindBy(xpath = "//select[@id='month']")
	WebElement monthSelectLocator;
	
	@FindBy(xpath = "//select[@id='transactionType']")
	WebElement transactionTypeLocator;
	
	@FindBy(xpath = "//input[@value='Go']")
	WebElement goBtnLocator;
	
	@FindBy(xpath = "//table[@id='transactionTable']")
	WebElement transactionTable;
	
	@FindBy(xpath = "//h1[contains(text(),'Transaction Details')]")
	WebElement transactionDetailLocator;
	
	@FindBy(xpath = "//td[contains(text(),'Bill Payment to Yash')]")
	WebElement descriptionLocator;
	
	@FindBy(xpath = "//table[@id='transactionTable']")
	WebElement table;
	
	@FindBy(xpath = "//table[@id='transactionTable']/tbody/tr/td[2]")
	List<WebElement> listOfTransaction;
	
//	String accNumberLocator = "//div[@id='accountDetails']/table/tbody/tr/td[@id='accountId']";
//	String monthSelectLocator = "//select[@id='month']";
//	String transactionTypeLocator = "//select[@id='transactionType']";
//	String goBtnLocator = "//input[@value='Go']";
//	String transactionTable = "//table[@id='transactionTable']";
//	String transactionDetailLocator = "//h1[contains(text(),'Transaction Details')]";
//	String descriptionLocator = "//td[contains(text(),'Bill Payment to Yash')]";
	
	public AccountDetailsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean isAccNumberDisplayed() {
//		WebElement accNumberField = getElement("XPATH", accNumberLocator , true, false);
		return isElementDisplayed(accNumberLocator, true);
	}
	
	public String getAccNumberValue() {
		System.out.println("Waiting for account number element...");

	    // Wait until the element is visible
//	    WebElement accNumberField = wait.until(ExpectedConditions.refreshed(
//	        ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@id='accountId']"))));
		
		refreshAndWaitForVisibility(accNumberLocator);

	    // Wait for the text to be present
//	    wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//td[@id='accountId']"), "1"));
//	    wait.until(driver -> !driver.findElement(By.xpath("//td[@id='accountId']")).getText().trim().isEmpty());
//	    wait.until(driver -> !accNumberLocator.getText().trim().isEmpty());
	    waitForElementWithText(accNumberLocator);
	    
	    // Trim text and return
//	    String accountNumber = accNumberField.getText().trim();
//	    String accountNumber = accNumberField.getText();
	    String accountNumber = getElementText(accNumberLocator, true);
	    System.out.println("Retrieved Account Number: '" + accountNumber + "'");

	    if (accountNumber.isEmpty()) {
	        System.err.println("ERROR: Account number is empty!");
	    }
	    return accountNumber;
	}
	
	public boolean isMonthFieldDisplayed() {
//		WebElement monthtField = getElement("XPATH", monthSelectLocator, true, true);
//		return monthtField.isDisplayed();
		return isElementDisplayed(monthSelectLocator, true);
	}
	
	public boolean istransactionTypeFieldDisplayed() {
//		WebElement transactionTypeField = getElement("XPATH", transactionTypeLocator, true, true);
//		return transactionTypeField.isDisplayed();
		return isElementDisplayed(transactionTypeLocator, true);
	}
	
	public boolean isGoBtnDisplayed() {
//		WebElement goButton = getElement("XPATH", goBtnLocator, true, true);
//		return goButton.isDisplayed();
		return isElementDisplayed(goBtnLocator, true);
	}
	
	public boolean isTransactionTableDisplayed() {
//		WebElement tableField = getElement("XPATH", transactionTable, true, true);
//		return tableField.isDisplayed();
		return isElementDisplayed(transactionTable, true);
	}
	
	public void selectMonth() {
//		WebElement monthtField = getElement("XPATH", monthSelectLocator, true, true);
//		Select monthSelect = new Select(monthtField);
//		monthSelect.selectByValue("March");
		
		selectElementFromDropdown(monthSelectLocator, "VALUE", "May", true, true);
	}
	
	public void selectTransactionType() {
//		WebElement transactionTypeField = getElement("XPATH", transactionTypeLocator, true, true);
//		Select typeSelect = new Select(transactionTypeField);
//		typeSelect.selectByValue("Debit");
		
		selectElementFromDropdown(transactionTypeLocator, "VALUE", "Debit", true, true);
	}
	
	public void clickOnGoBtn() {
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(goBtnLocator)));
//		WebElement goButton = getElement("XPATH", goBtnLocator, true, true);
//		goButton.click();
//		
		clickOnElement(goBtnLocator, true);
	}
	
	public void getTransactionDetail() throws InterruptedException {
//		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table[@id='transactionTable']")));
		
//		List<WebElement> listOfTransaction = driver.findElements(By.xpath("//table[@id='transactionTable']/tbody/tr/td[2]"));
//		for(WebElement e : listOfTransaction) {
//			String transaction = e.getText();
//			if(transaction.contains("Yash")) {
//				e.click();
//				break;
//			}
//		}
//		waitForVisibilityOfList(listOfTransaction);
		
//		waitForVisibilityOfElement(table);
		Thread.sleep(3000);
		clickOnElementIfContains(listOfTransaction, "Yash");
	}
	
	public boolean isTransactionFieldDisplayed() {
//		WebElement transactionDetailField = getElement("XPATH", transactionDetailLocator, true, false);
//		return transactionDetailField.isDisplayed();
//		
		return isElementDisplayed(transactionDetailLocator, true);
	}
	
	public String getDescriptionMessage() {
//		WebElement descriptionField = getElement("XPATH", descriptionLocator, true, true);
//		return descriptionField.getText();
//		
//		String expectedDescriptionText = "Bill Payment to Yash";
		
		return getElementText(descriptionLocator, true);
	}
	
	public void scrollToTable() {
//		WebElement tableField = getElement("XPATH", transactionTable, true, true);
//		scrollTo(tableField);
		
		scrollTo(transactionTable);
	}

}
