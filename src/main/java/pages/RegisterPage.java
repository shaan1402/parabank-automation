package pages;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ControlActions;

public class RegisterPage extends ControlActions {
	
	@FindBy(xpath= "//input[@id='customer.firstName']")
	private WebElement firstNameLocator;
	
	@FindBy(xpath= "//input[@id='customer.lastName']")
	private WebElement lastNameLocator;
	
	@FindBy(xpath= "//input[@id='customer.address.street']")
	private WebElement addressLocator;
	
	@FindBy(xpath= "//input[@id='customer.address.city']")
	private WebElement cityLocator;
	
	@FindBy(xpath= "//input[@id='customer.address.state']")
	private WebElement stateLocator;
	
	@FindBy(xpath= "//input[@id='customer.address.zipCode']")
	private WebElement zipCodeLocator;
	
	@FindBy(xpath= "//input[@id='customer.phoneNumber']")
	private WebElement phoneNumLocator;
	
	@FindBy(xpath= "//input[@id='customer.ssn']")
	private WebElement ssnLocator;
	
	@FindBy(xpath= "//input[@id='customer.username']")
	private WebElement userNameLocator;
	
	@FindBy(xpath= "//input[@id='customer.password']")
	private WebElement passwordLocator;
	
	@FindBy(xpath= "//input[@id='repeatedPassword']")
	private WebElement conPasswordLocator;
	
	@FindBy(xpath= "//input[@value='Register']")
	private WebElement registerLocator;
	
//	String firstNameLocator = "//input[@id='customer.firstName']";
//	String laststNameLocator = "//input[@id='customer.lastName']";
//	String addressLocator = "//input[@id='customer.address.street']";
//	String cityLocator = "//input[@id='customer.address.city']";
//	String stateLocator = "//input[@id='customer.address.state']";
//	String zipCodeLocator = "//input[@id='customer.address.zipCode']";
//	String phoneNumLocator = "//input[@id='customer.phoneNumber']";
//	String ssnLocator = "//input[@id='customer.ssn']";
//	String userNameLocator = "//input[@id='customer.username']";
//	String passwordLocator = "//input[@id='customer.password']";
//	String conPasswordLocator = "//input[@id='repeatedPassword']";
//	String registerLocator = "//input[@value='Register']";
	
	public static int getRandomNum() {
		Random random = new Random();
		return random.nextInt(10000);
	}

	public static String newUser = "shaan" + getRandomNum();
	
	public RegisterPage() {
		PageFactory.initElements(driver, this);
	}
		

	public boolean isFirstNameFieldDisplayed() {
//		WebElement firstNameFieldLocator = driver.findElement(By.xpath(firstNameLocator));
//		return firstNameLocator.isDisplayed();
		return isElementDisplayed(firstNameLocator, true);
	}

	public boolean isLastNameFieldDisplayed() {
//		WebElement lastNameFieldLocator = driver.findElement(By.xpath(laststNameLocator));
//		return lastNameLocator.isDisplayed();
		return isElementDisplayed(lastNameLocator, true);
	}

	public boolean isAddressFieldDisplayed() {
//		WebElement addressFieldLocator = driver.findElement(By.xpath(addressLocator));
//		return addressLocator.isDisplayed();
		return isElementDisplayed(addressLocator, true);
	}

	public boolean isCityFieldDisplayed() {
//		WebElement cityFieldLocator = driver.findElement(By.xpath(cityLocator));
//		return cityLocator.isDisplayed();
		return isElementDisplayed(cityLocator, true);
	}

	public boolean isStateFieldDisplayed() {
//		WebElement stateFieldLocator = driver.findElement(By.xpath(stateLocator));
//		return stateLocator.isDisplayed();
		return isElementDisplayed(stateLocator, true);
	}

	public boolean isZipCodeFieldDisplayed() {
//		WebElement zipCodeFieldLocator = driver.findElement(By.xpath(zipCodeLocator));
//		return zipCodeLocator.isDisplayed();
		return isElementDisplayed(zipCodeLocator, true);
	}

	public boolean isPhoneFieldDisplayed() {
//		WebElement phoneNumFieldLocator = driver.findElement(By.xpath(phoneNumLocator));
//		return phoneNumLocator.isDisplayed();
		return isElementDisplayed(phoneNumLocator, true);
	}

	public boolean isSSNFieldDisplayed() {
//		WebElement ssnFieldLocator = driver.findElement(By.xpath(ssnLocator));
//		return ssnLocator.isDisplayed();
		return isElementDisplayed(ssnLocator, true);
	}

	public boolean isUserNameFieldDisplayed() {
//		WebElement userNameFieldLocator = driver.findElement(By.xpath(userNameLocator));
//		return userNameLocator.isDisplayed();
		return isElementDisplayed(userNameLocator, true);
	}

	public boolean isPasswordFieldDisplayed() {
//		WebElement passwordFieldLocator = driver.findElement(By.xpath(passwordLocator));
//		return passwordLocator.isDisplayed();
		return isElementDisplayed(passwordLocator, true);
	}

	public boolean isConfirmPasswordFieldDisplayed() {
//		WebElement conPasswordFieldLocator = driver.findElement(By.xpath(conPasswordLocator));
//		return conPasswordLocator.isDisplayed();
		return isElementDisplayed(conPasswordLocator, true);
	}

	public boolean isRegisterFieldDisplayed() {
//		WebElement registerFieldLocator = driver.findElement(By.xpath(registerLocator));
//		return registerLocator.isDisplayed();
		return isElementDisplayed(registerLocator, true);
	}

	public void enterFirstName(String firstName) {
//		WebElement firstNameFieldLocator = driver.findElement(By.xpath(firstNameLocator));
//		firstNameLocator.sendKeys(firstName);
		setText(firstNameLocator, firstName, true);
	}

	public void enterLastName(String lastName) {
//		WebElement lastNameFieldLocator = driver.findElement(By.xpath(laststNameLocator));
//		lastNameLocator.sendKeys(lastName);
		setText(lastNameLocator, lastName, true);
	}

	public void enterAddress(String address) {
//		WebElement addressFieldLocator = driver.findElement(By.xpath(addressLocator));
//		addressLocator.sendKeys(address);
		setText(addressLocator, address, true);
	}

	public void enterCity(String city) {
//		WebElement cityFieldLocator = driver.findElement(By.xpath(cityLocator));
//		cityLocator.sendKeys(city);
		setText(cityLocator, city, true);
	}

	public void enterState(String state) {
//		WebElement stateFieldLocator = driver.findElement(By.xpath(stateLocator));
//		stateLocator.sendKeys(state);
		setText(stateLocator, state, true);
	}

	public void enterZipCode(String zipCode) {
//		WebElement zipCodeFieldLocator = driver.findElement(By.xpath(zipCodeLocator));
//		zipCodeLocator.sendKeys(zipCode);
		setText(zipCodeLocator, zipCode, true);
	}

	public void enterPhone(String phone) {
//		WebElement phoneNumFieldLocator = driver.findElement(By.xpath(phoneNumLocator));
//		phoneNumLocator.sendKeys(phone);
		setText(phoneNumLocator, phone, true);
	}

	public void enterSSN(String ssn) {
//		WebElement ssnFieldLocator = driver.findElement(By.xpath(ssnLocator));
//		ssnLocator.sendKeys(ssn);
		setText(ssnLocator, ssn, true);
	}

	public void enterUserName() {
//		WebElement userNameFieldLocator = driver.findElement(By.xpath(userNameLocator));
//		userNameLocator.sendKeys(newUser);
		setText(userNameLocator, newUser, true);
	}
	
	public void enterUserName(String username) {
		setText(userNameLocator, username, true);
	}
	
//	public String enterUserName() {
////		WebElement userNameFieldLocator = driver.findElement(By.xpath(userNameLocator));
////		userNameLocator.sendKeys(newUser);
//		setText(userNameLocator, newUser, true);
//		return 
//	}

	public void enterPassword(String password) {
//		WebElement passwordFieldLocator = driver.findElement(By.xpath(passwordLocator));
//		passwordLocator.sendKeys(password);
		setText(passwordLocator, password, true);
	}

	public void enterConfirmPassword(String conPassword) {
//		WebElement conPasswordFieldLocator = driver.findElement(By.xpath(conPasswordLocator));
//		conPasswordLocator.sendKeys(conPassword);
		setText(conPasswordLocator, conPassword, true);
	}
	
	public void clickOnRegisterBtn() {
//		WebElement registerFieldLocator = driver.findElement(By.xpath(registerLocator));
//		registerLocator.click();
		clickOnElement(registerLocator, true);
	}

}
