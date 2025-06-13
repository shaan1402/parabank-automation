package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ControlActions;

public class BillPaymentPage extends ControlActions {
	
	@FindBy(name = "payee.name")
	WebElement payeeLocator;
	
	@FindBy(name = "payee.address.street")
	WebElement addressLocator;
	
	@FindBy(name = "payee.address.city")
	WebElement cityLocator;
	
	@FindBy(name = "payee.address.state")
	WebElement  stateLocator;
	
	@FindBy(name = "payee.address.zipCode")
	WebElement  zipcodeLocator;
	
	@FindBy(name = "payee.phoneNumber")
	WebElement  phoneLocator;
	
	@FindBy(name = "payee.accountNumber")
	WebElement  accountLocator;
	
	@FindBy(name = "verifyAccount")
	WebElement verifyAccountLocator;
	
	@FindBy(name = "amount")
	WebElement amountLocator;
	
//	@FindBy(xpath = "//select[@name='fromAccountId']")
//	WebElement fromAccountLocator;
	private String fromAccountLocator = "//select[@name='fromAccountId']";
	
	@FindBy(xpath = "//input[@value='Send Payment']")
	WebElement sendPaymentBtnLocator;
	
	@FindBy(xpath = "//div[@id='billpayResult']/h1[text()='Bill Payment Complete']")
	WebElement paymentSuccessLocator;
	
//	String payeeLocator = "payee.name";
//	String addressLocator = "payee.address.street";
//	String cityLocator = "payee.address.city";
//	String stateLocator = "payee.address.state";
//	String zipcodeLocator = "payee.address.zipCode";
//	String phoneLocator = "payee.phoneNumber";
//	String accountLocator = "payee.accountNumber";
//	String verifyAccountLocator = "verifyAccount";
//	String amountLocator = "amount";
//	String sendPaymentBtnLocator = "//input[@value='Send Payment']";
//	String paymentSuccessLocator = "//div[@id='billpayResult']/h1[text()='Bill Payment Complete']";
	
	public BillPaymentPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean isPayeeFieldDisplayed() {
//		WebElement payeeField = getElement("NAME", payeeLocator, true, true);
//		return payeeField.isDisplayed();
		return isElementDisplayed(payeeLocator, true);
	}

	public boolean isAddressFieldDisplayed() {
//		WebElement addressField = getElement("NAME", addressLocator, true, true);
//		return addressField.isDisplayed();
		return isElementDisplayed(addressLocator, true);
	}

	public boolean isCityFieldDisplayed() {
//		WebElement cityField = getElement("NAME", cityLocator, true, true);
//		return cityField.isDisplayed();
		return isElementDisplayed(cityLocator, true);

	}

	public boolean isStateFieldDisplayed() {
//		WebElement stateField = getElement("NAME", stateLocator, true, true);
//		return stateField.isDisplayed();
		return isElementDisplayed(cityLocator, true);

	}

	public boolean isZipcodeFieldDisplayed() {
//		WebElement zipcodeField = getElement("NAME", zipcodeLocator, true, true);
//		return zipcodeField.isDisplayed();
		return isElementDisplayed(cityLocator, true);

	}

	public boolean isPhoneFieldDisplayed() {
//		WebElement phoneField = getElement("NAME", phoneLocator, true, true);
//		return phoneField.isDisplayed();
		return isElementDisplayed(cityLocator, true);

	}

	public boolean isAccountFieldDisplayed() {
//		WebElement accountField = getElement("NAME", accountLocator, true, true);
//		return accountField.isDisplayed();
		return isElementDisplayed(accountLocator, true);

	}

	public boolean isVerifyAccountFieldDisplayed() {
//		WebElement verifyAccountField = getElement("NAME", verifyAccountLocator, true, true);
//		return verifyAccountField.isDisplayed();
		return isElementDisplayed(verifyAccountLocator, true);
	}

	public boolean isAmountDisplayed() {
//		WebElement amountField = getElement("NAME", amountLocator, true, true);
//		return amountField.isDisplayed();
		return isElementDisplayed(amountLocator, true);
	}

	public boolean isFromAccountFieldDisplayed() {
//		WebElement fromAccountField = getElement("XPATH", fromAccountLocator, true, true);
//		return fromAccountField.isDisplayed();
		return isElementDisplayed("XPATH",fromAccountLocator, true);
	}

	public boolean isSendPaymentBtnFieldDisplayed() {
//		WebElement sendPaymentBtnField = getElement("XPATH", sendPaymentBtnLocator, true, true);
//		return sendPaymentBtnField.isDisplayed();
		return isElementDisplayed(sendPaymentBtnLocator, true);
	}
	
	public void enterPayeeName(String payeeName) {
//		WebElement payeeField = getElement("NAME", payeeLocator, true, true);
//		payeeField.sendKeys(payeeName);
		setText(payeeLocator, payeeName, true);
	}
	
	public void enterAddress(String address) {
//		WebElement addressField = getElement("NAME", addressLocator, true, true);
//		addressField.sendKeys(address);
		setText(addressLocator, address, true);

	}
	
	public void enterCity(String city) {
//		WebElement cityField = getElement("NAME", cityLocator, true, true);
//		cityField.sendKeys(city);
		setText(cityLocator, city, true);

	}
	
	public void enterState(String state) {
//		WebElement stateField = getElement("NAME", stateLocator, true, true);
//		stateField.sendKeys(state);
		setText(stateLocator, state, true);

	}
	
	public void enterZipcode(String zipcode) {
//		WebElement zipcodeField = getElement("NAME", zipcodeLocator, true, true);
//		zipcodeField.sendKeys(zipcode);
		setText(zipcodeLocator, zipcode, true);

	}
	
	public void enterPhoneNum(String phoneNum) {
//		WebElement phoneField = getElement("NAME", phoneLocator, true, true);
//		phoneField.sendKeys(phoneNum);
		setText(phoneLocator, phoneNum, true);

	}
	
	public void enterAccountNum(String accountNum) {
//		WebElement accountField = getElement("NAME", accountLocator, true, true);
//		accountField.sendKeys(accountNum);
		setText(accountLocator, accountNum, true);

	}
	
	public void enterVerifyAccountNum(String verifyAccountNum) {
//		WebElement verifyAccountField = getElement("NAME", verifyAccountLocator, true, true);
//		verifyAccountField.sendKeys(verifyAccountNum);
		setText(verifyAccountLocator, verifyAccountNum, true);

	}
	
	public void enterAmount(String amount) {
//		WebElement amountField = getElement("NAME", amountLocator, true, true);
//		amountField.sendKeys(amount);
		setText(amountLocator, amount, true);

	}
	
	public void selectFromAccount() {
//		WebElement fromAccountField = getElement("XPATH", fromAccountLocator, true, true);
//		Select fromAccSelect  = new Select(fromAccountField);
//		fromAccSelect.selectByValue(OpenAccountPage.newAccNumber);
		WebElement e = getElement("XPATH", fromAccountLocator, true, true);
		selectElementFromDropdown(e, "Value", OpenAccountPage.newAccNumber, true, true);
		System.out.println("Payment has been done from New account that is created");
	}
	
	
	public void clickOnSendPayment() {
//		WebElement sendPaymentBtnField = getElement("XPATH", sendPaymentBtnLocator, true, true);
//		sendPaymentBtnField.click();
		clickOnElement(sendPaymentBtnLocator, true);
	}
	
	public boolean isPaymentSuccessTextDisplayed() {
		
//		WebElement paymentSuccessField = getElement("XPATH", paymentSuccessLocator, true, false);
//		return paymentSuccessField.isDisplayed();
		waitForVisibilityOfElement(paymentSuccessLocator);
		return isElementDisplayed(paymentSuccessLocator, true);
	}
	
	
	

}
