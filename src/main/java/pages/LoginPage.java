package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ControlActions;
import io.qameta.allure.Step;

public class LoginPage extends ControlActions {
	
	@FindBy(xpath="//input[@name='username']")
	WebElement userNameLocator;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement passwordLocator;
	
	@FindBy(xpath="//input[@value='Log In']")
	WebElement loginBtnLocator;
	
	@FindBy(xpath = "//div[@id='rightPanel']/p[@class='error']")
	WebElement alertMsgLocator;
	
	@FindBy(xpath = "//div[@id='loginPanel']//a[text()='Register']")
	WebElement registerBtnLocator;
	
	@FindBy(xpath = "//table[@id='accountTable']/tbody/tr/td/a")
	public WebElement mainAccountNumberLocator;
	
	public static String mainAccNum;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@Step("Is MainAcc Number Displayed")
	public boolean isMainAccNumberDisplayed() {
		waitForVisibilityOfElement(mainAccountNumberLocator);
		return isElementDisplayed(mainAccountNumberLocator, true);
	}
	
	@Step("get Main Acc Num")
	public String getMainAccountNumber() {
		HomePage hp = new HomePage();
		hp.navigateTo("Accounts Overview");
		waitForVisibilityOfElement(mainAccountNumberLocator);
		mainAccNum = getElementText(mainAccountNumberLocator, true);
		return mainAccNum;
	}
	
	@Step("Is Username Displayed")
	public boolean isUsernameFieldDisplayed() {
//		WebElement usernameFieldLocator = driver.findElement(By.xpath(userNameLocator));
//		waitForVisibilityOfElement(userNameLocator);
//		return userNameLocator.isDisplayed();
		return isElementDisplayed(userNameLocator, true);
		
	}

	@Step("Is Password Displayed")
	public boolean isPasswordDisplayed() {
//		WebElement passwordFieldLocator = driver.findElement(By.xpath(passwordLocator));
//		return passwordLocator.isDisplayed();
		return isElementDisplayed(passwordLocator, true);

	}

	@Step("Is LoginBtn Displayed")
	public boolean isLoginBtnDisplayed() {
//		WebElement loginBtnFieldLocator = driver.findElement(By.xpath(loginBtnLocator));
//		return loginBtnLocator.isDisplayed();
		return isElementDisplayed(loginBtnLocator, true);

		
	}
	
	@Step("Is RegisterBtn Displayed")
	public boolean isRegisterBtnDisplayed() {
		return isElementDisplayed(registerBtnLocator, true);
	}
	
	@Step("click on login : {0}")
	public void login(String password) {
		enterUserName();
		enterPassword(password);
		clickOnLoginBtn();
	}

	
	@Step("click on Login : {0} and {1}")
	public void login(String username,String password) {
		enterUserName(username);
		enterPassword(password);
		clickOnLoginBtn();
	}

	@Step("Enter UserName")
	public void enterUserName() {
//		WebElement usernameFieldLocator = driver.findElement(By.xpath(userNameLocator));
//		waitForVisibilityOfElement(userNameLocator);
//		userNameLocator.sendKeys(RegisterPage.newUser);
		setText(userNameLocator, RegisterPage.newUser, true);
	}
	
	@Step("Enter UserName : {0}")
	public void enterUserName(String username) {
		setText(userNameLocator, username, true);
	}
	
	@Step("Enter Invalid UserName")
	public void enterInvalidUserName() {
//		WebElement usernameFieldLocator = driver.findElement(By.xpath(userNameLocator));
//		userNameLocator.sendKeys("Shanu14");
		setText(userNameLocator, "Shanu14", true);
	}
	
	@Step("Enter Password : {0}")
	public void enterPassword(String password) {
//		WebElement passwordFieldLocator = driver.findElement(By.xpath(passwordLocator));
//		passwordLocator.sendKeys(password);
		setText(passwordLocator, password, true);
	}

	@Step("Click On Login")
	public void clickOnLoginBtn() {
//		WebElement loginBtnFieldLocator = driver.findElement(By.xpath(loginBtnLocator));
//		loginBtnLocator.click();
		clickOnElement(loginBtnLocator, true);
	}
	
	@Step("Click On Register Btn")
	public void clickOnRegisterBtn() {
		clickOnElement(registerBtnLocator, true);
	}
	
	@Step("Get Alert Msg")
	public String getAlertMsg() {
//		WebElement alertMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='rightPanel']/p[@class='error']")));
		waitForVisibilityOfElement(alertMsgLocator);
		return alertMsgLocator.getText().trim();
	}

}
