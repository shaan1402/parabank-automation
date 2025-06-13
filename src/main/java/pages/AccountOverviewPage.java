package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ControlActions;
//import testscript.LoginTest;

public class AccountOverviewPage extends ControlActions{
	
	@FindBy(xpath = "//div[@id='showOverview']/h1")
	WebElement accountOverviewTextLocator;
	
	@FindBy(xpath = "//table[@id='accountTable']")
	WebElement accountFieldTableLocator;
	
	@FindBy(xpath = "//div[@id='accountDetails']/table/tbody/tr")
	List<WebElement> listOfAccDetail;
	
	@FindBy(xpath = "//div[@id='accountDetails']/table/tbody/tr[1]/td[2]")
	WebElement accountNumberFieldLocator;
	
	@FindBy(xpath = "//table[@id='transactionTable']/tbody/tr/td[2]")
	List<WebElement> listOfTransaction;
	
	@FindBy(xpath = "//tbody/tr/td/a")
	List<WebElement> listOfAccountsField;
	
//	String newAccListField = "//tbody/tr/td[1]";
	
	@FindBy(xpath = "//table[@id='accountTable']/tbody//a")
	List<WebElement> listOfLinksField;
	
//	String newAccLinkListField = "//table[@id='accountTable']/tbody//a";
	@FindBy(xpath = "//table[@id='accountTable']/tbody/tr[1]/td[1]/a")
	WebElement mainAccLocator;
	
//	public static String mainAccNum = "";
	
	String latestTransactionField = "//table[@id='transactionTable']/tbody/tr['%d']/td[2]'";
	
	public AccountOverviewPage() {
		PageFactory.initElements(driver, this);
	}
	
	 public String getMainAccountNumber() {
	        waitForVisibilityOfElement(mainAccLocator);
	        return getElementText(mainAccLocator, true);
	 }
	
//	public String getMainAccNumber() {
////		LoginTest login = new LoginTest();
//		
//		String mainAccNum = getElementText(mainAccLocator, true);
//		return mainAccNum;
//	}
	
//	public boolean isMainAccountNumberDisplayed() {
//		waitForVisibilityOfElement(mainAccLocator);
//		return isElementDisplayed(mainAccLocator, true);
//	}
	
	public boolean isMainAccNumberDisplayed() {
//		waitForVisibilityOfList(listOfAccountsField);
		String account = LoginPage.mainAccNum;
		System.out.println(account);
		waitForVisibilityOfList(listOfAccountsField);
		return isElementFromListVisible(listOfAccountsField, account);
	}
	
	public boolean isAccountOverviewFieldDisplayed() {
//		WebElement accountOverviewField = driver.findElement(By.xpath("//div[@id='showOverview']/h1"));
//		waitForVisibilityOfElement(accountOverviewTextLocator);
//		return accountOverviewTextLocator.isDisplayed();
		waitForVisibilityOfElement(accountOverviewTextLocator);
		return isElementDisplayed(accountOverviewTextLocator, true);
	}
	
	public boolean isAccountTableDisplayed()	{
//		WebElement accountFieldTable = getElement("XPATH", "//table[@id='accountTable']", true, true);
//		elementToBeClickable(accountFieldTableLocator);
//		return accountFieldTableLocator.isDisplayed();
		
		return isElementDisplayed(accountFieldTableLocator, true);
	}
	
	public boolean isNewAccNumDisplayed() {
//		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(newAccListField)));
		waitForVisibilityOfList(listOfAccountsField);
		
//		List<WebElement> listOfAcc = driver.findElements(By.xpath(newAccListField));
		
		
//		boolean accFoundFlag = false;
//		for(WebElement e : newAccListField) {
//			String accNum = e.getText();
//			if(accNum.equals(OpenAccountPage.newAccNumber)) {
//				accFoundFlag = true;
//				System.out.println("new account number has been added and verified");
//				break;
//			}
//		}
//		return accFoundFlag;
		
		return isElementFromListVisible(listOfAccountsField, OpenAccountPage.newAccNumber);
	}
	
	
	public void clickOnBillPaidAcc() {
//		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(newAccListField)));
		waitForVisibilityOfList(listOfAccountsField);

		clickOnElementIfValuesAreEqual(listOfLinksField, OpenAccountPage.newAccNumber);
		
//		String accountNum = "";
////		List<WebElement> listOfAcc = driver.findElements(By.xpath(newAccLinkListField));
//		for(WebElement e : listOfLinksField) {
//			accountNum = e.getText();
//			if(accountNum.equals(OpenAccountPage.newAccNumber)) {
//				e.click();
//				break;
//			}
//		}
	}
	
	
	
	
	public void verifyaccountTransaction() {
//		getElement("XPATH", "//table[@id='accountTable']", false, true);
//		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//tbody/tr/td[1]")));
//
//		
//		String accountNum = "";
//		List<WebElement> listOfAcc = driver.findElements(By.xpath("//table[@id='accountTable']/tbody//a"));
//		for(WebElement e : listOfAcc) {
//			accountNum = e.getText();
//			if(accountNum.equals(OpenAccountPage.newAccNumber)) {
//				e.click();
//				break;
//			}
//		}
		
		//table[@id='transactionTable']/tbody/tr/td[2]
		
//		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='rightPanel']")));
//		
//		WebElement accountDetailsField = getElement("XPATH", "//div[@id='accountDetails']/h1", false, true);
//		Assert.assertTrue(accountDetailsField.isDisplayed(), "not displayed");
//		WebElement accountNumberField = getElement("XPATH", "//div[@id='accountDetails']/table/tbody/tr[1]/td[2]", true, false);
////		WebElement transactionTable = getElement("XPATH", "//table[@id='transactionTable']", false, true);
//		WebElement locationField = getElement("XPATH", "//div[@id='footerPanel']/ul/li[5]/a", true, true);
//		scrollTo(locationField);
//		
//		if(accountDetailsField.isDisplayed()) {
//			String accountNumberText = accountNumberField.getText();
//			if(accountNumberText.equals(OpenAccountPage.newAccNumber)) {
//				List<WebElement> transactions = driver.findElements(By.xpath("//table[@id='transactionTable']/tbody/tr/td[2]"));
//				int index = transactions.size();
//				WebElement latestTransaction = driver.findElement(By.xpath("//table[@id='transactionTable']/tbody/tr["+index+"]/td[2]"));
//				latestTransaction.click();
//				WebElement transactionDetailsText = getElement("XPATH", "//h1[contains(text(),'Transaction Details')]", false, true);
//				if(transactionDetailsText.isDisplayed()) {
//					WebElement description = getElement("XPATH", "//div[@id='rightPanel']/table/tbody/tr[3]/td[contains(text(),'Bill Payment to')]", true, false);
//					String actualDesText = description.getText();
//					String expectedDesText = "Bill Payment to Yash";
//					Assert.assertEquals(actualDesText, expectedDesText);
//					WebElement amount = getElement("XPATH", "//div[@id='rightPanel']/table/tbody/tr[5]/td[2]", false, true);
//					String actualAmtText = amount.getText();
//					String expectedAmtText = "$75.00";
//					Assert.assertEquals(actualAmtText, expectedAmtText);
//					System.out.println("Transaction has been verified and sent successfully to Yash");
//				}
//			}
//		}
		
		System.out.println("now check details");

//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		List<WebElement> accDetailsList = driver.findElements(By.xpath("//div[@id='accountDetails']/table/tbody/tr"));
//		wait.until(ExpectedConditions.visibilityOfAllElements(listOfAccDetail));
		
		waitForVisibilityOfList(listOfAccDetail);
		
//		JavascriptExecutor je = (JavascriptExecutor) driver;
//		WebElement accountNumberField = getElement("XPATH", "//div[@id='accountDetails']/table/tbody/tr[1]/td[2]", true, true);
//		je.executeScript("arguments[0].scrollIntoView(true)", accountNumberFieldLocator);
		scrollTo(accountNumberFieldLocator);
		
		isElementDisplayed(accountNumberFieldLocator, true);
//		Assert.assertTrue(accountNumberFieldLocator.isDisplayed(), "Not Displayed");
		System.out.println("displayed");
		
//		String accountNumberText = accountNumberFieldLocator.getText();
		String accountNumberText = getElementText(accountNumberFieldLocator, true);
		
//		if(accountNumberText.equals(OpenAccountPage.newAccNumber)) {
		if(areValuesEqual(accountNumberText, OpenAccountPage.newAccNumber)) {
//			List<WebElement> transactions = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table[@id='transactionTable']/tbody/tr/td[2]")));
			waitForVisibilityOfList(listOfAccDetail);
//			int index = listOfTransaction.size();
			int index = sizeOfList(listOfTransaction);
//			WebElement latestTransaction = driver.findElement(By.xpath("//table[@id='transactionTable']/tbody/tr["+index+"]/td[2]"));
			String finalTransaction = String.format(latestTransactionField, index);
			WebElement latestTransaction = getElement("XPATH", finalTransaction, true, true);
			clickOnElement(latestTransaction, true);
//			latestTransaction.click();
		}
		
		
	}


}
