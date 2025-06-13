package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.ControlActions;
//import testscript.LoginTest;

public class FundTransferPage extends ControlActions {
	
	@FindBy(xpath = "//div[@id='showForm']/h1")
	private WebElement tranferFundfieldLocator;
	
	@FindBy(xpath = "//input[@id='amount']")
	private WebElement amountFieldLocator;
	
	@FindBy(xpath = "//select[@id='fromAccountId']")
	private WebElement fromAccountFieldLocator;
	
	@FindBy(xpath = "//select[@id='fromAccountId']/option")
	private List<WebElement> listOfFromOption;
	
	@FindBy(xpath = "//select[@id='toAccountId']")
	private WebElement toAccountFieldLocator;
	
	
	@FindBy(xpath = "//select[@id='toAccountId']/option")
	private List<WebElement> listOfToOption;
	
	@FindBy(xpath = "//input[@value='Transfer']")
	private WebElement transferBtnLocator;
	
	@FindBy(xpath = "//div[@id='showResult']/h1")
	private WebElement successMessageLocator;
	
//	public String tranferFundfieldLocator = "//div[@id='showForm']/h1";
//	public String amountFieldLocator = "//input[@id='amount']";
//	public String fromAccountFieldLocator = "//select[@id='fromAccountId']";
//	public String toAccountFieldLocator = "//select[@id='toAccountId']";
//	public String transferBtnLocator = "//input[@value='Transfer']";
//	public String successMessageLocator = "//div[@id='showResult']/h1";
	
	public FundTransferPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean isTransferFundFieldDisplayed() {
//		WebElement transferFundField = getElement("XPATH", tranferFundfieldLocator , true, true);
		waitForVisibilityOfElement(tranferFundfieldLocator);
		return tranferFundfieldLocator.isDisplayed();
	}
	
	public boolean isAmountFieldDisplayed() {
//		WebElement amountField = getElement("XPATH", amountFieldLocator, true, true);
		waitforElementToBeClickable(amountFieldLocator);
		return amountFieldLocator.isDisplayed();
	}
	
	public boolean isFromAccountFieldDisplayed() {
//		WebElement fromAccountField = getElement("XPATH", fromAccountFieldLocator, true, true);
		waitforElementToBeClickable(fromAccountFieldLocator);
		return fromAccountFieldLocator.isDisplayed();
	}
	
	public boolean isToAccountFieldDisplayed() {
//		WebElement toAccountField = getElement("XPATH", toAccountFieldLocator, true, true);
		waitforElementToBeClickable(toAccountFieldLocator);
		return toAccountFieldLocator.isDisplayed();
	}
	
	public boolean isTransferBtnDisplayed() {
//		WebElement transferBtn = getElement("XPATH", transferBtnLocator, true, true);
		waitforElementToBeClickable(transferBtnLocator);
		return transferBtnLocator.isDisplayed();
	}

	public boolean isTransferSuccessMsgDisplayed() {
//		WebElement successMsgField = getElement("XPATH", successMessageLocator, true, true);
		waitForVisibilityOfElement(successMessageLocator);
		return successMessageLocator.isDisplayed();
	}
	
	public void enterAmount() {
//		WebElement amountField = getElement("XPATH", amountFieldLocator, true, true);
		waitforElementToBeClickable(amountFieldLocator);
		amountFieldLocator.sendKeys("100");
	}
	
	public void selectFromAccount() {
//		WebElement fromAccountField = getElement("XPATH", fromAccountFieldLocator, true, true);

//		List<WebElement> optionsFromDropdown = fromDropdownSelect.getOptions();
//		for (WebElement e : listOfFromOption) {
//			String option = e.getText();
//			if (option.equals(AccountOverviewPage.mainAccNum)) {
//				System.out.println(option);
//				System.out.println(AccountOverviewPage.mainAccNum);
//				Select fromDropdownSelect = new Select(fromAccountFieldLocator);
//				fromDropdownSelect.selectByVisibleText(option);
//				break;
//			}
//		}
//		selectElementFromListIfEqual(listOfFromOption, "Text", AccountOverviewPage.mainAccNum);
		
		
//		System.out.println(listOfFromOption);
		
		try {
			System.out.println("select from acc");
		    selectElementFromListIfEqual(listOfFromOption, "Text", LoginPage.mainAccNum);
		} catch (Exception e) {
		    System.out.println("Exception caught: " + e.getMessage());
		    System.out.println("selected");
		}
		
		
		
		
	}
	
	public void selectToAccount() {
//		WebElement toAccountField = getElement("XPATH", toAccountFieldLocator, true, true);

		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("toAccountId")));
//		List<WebElement> optionstoDropdown = toDropdownSelect.getOptions();
//		for (WebElement e : listOfToOption) {
//			String option = e.getText();
//			if (option.equals(OpenAccountPage.newAccNumber)) {
//				System.out.println(option);
//				System.out.println(OpenAccountPage.newAccNumber);
//				Select toDropdownSelect = new Select(toAccountFieldLocator);
//				toDropdownSelect.selectByVisibleText(option);
//				break;
//			}
//		}
		
		selectElementFromListIfEqual(listOfToOption, "TEXT", OpenAccountPage.newAccNumber);
	}
	
	public void clickOnTransferBtn() {
//		WebElement transferBtn = getElement("XPATH", transferBtnLocator, true, true);
//		waitforElementToBeClickable(transferBtnLocator);
//		transferBtnLocator.click();
		clickOnElement(transferBtnLocator, true);
	}
	
	
	
	

}
