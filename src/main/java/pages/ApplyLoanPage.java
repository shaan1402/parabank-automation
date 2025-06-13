package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ControlActions;
//import testscript.LoginTest;

public class ApplyLoanPage extends ControlActions{
	
	@FindBy(xpath = "//input[@id='amount']")
	WebElement loanAmtLocator;
	
	@FindBy(xpath = "//input[@id='downPayment']")
	WebElement downPayLocator;
	
	@FindBy(xpath = "//select[@id='fromAccountId']")
	WebElement fromAccLocator;
	
	@FindBy(xpath = "//input[@value='Apply Now']")
	WebElement applyNowLocator;
	
	@FindBy(xpath = "//div[@id='loanRequestApproved']/p")
	WebElement requestApproved;
	
//	public static String acc =  LoginPage.mainAccNum;
	
	public ApplyLoanPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean isloanAmtLocatorDisplayed() {
		return isElementDisplayed(loanAmtLocator, true);
	}
	
	public boolean isdownPayLocatorDisplayed() {
		return isElementDisplayed(downPayLocator, true);
	}
	
	public boolean isfromAccLocatorDisplayed() {
		return isElementDisplayed(fromAccLocator, true);
	}
	
	public boolean isapplyNowLocatorDisplayed() {
		return isElementDisplayed(applyNowLocator, true);
	}
	
	public void setLoanAmount(String amount) {
		setText(loanAmtLocator, amount, true);
	}
	
	public void setDownPayAmount(String amount) {
		setText(downPayLocator, amount, true);
	}
	
	public void selectAccountFromDropdown(String accountNumber) {
		waitForVisibilityOfElement(fromAccLocator);
		selectElementFromDropdown(fromAccLocator, "TEXT",accountNumber, true, true);
	}
	
	public void clickOnApplyNow() {
		clickOnElement(applyNowLocator, true);
	}
	
	public String getLoanReqApprovedMessage() {
		waitForVisibilityOfElement(requestApproved);
		return getElementText(requestApproved, true);
	}
}
