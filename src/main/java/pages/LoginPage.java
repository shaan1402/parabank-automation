package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ControlActions;

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
	
	public boolean isMainAccNumberDisplayed() {
		waitForVisibilityOfElement(mainAccountNumberLocator);
		return isElementDisplayed(mainAccountNumberLocator, true);
	}
	
	public String getMainAccountNumber() {
		HomePage hp = new HomePage();
		hp.navigateTo("Accounts Overview");
		waitForVisibilityOfElement(mainAccountNumberLocator);
		mainAccNum = getElementText(mainAccountNumberLocator, true);
		return mainAccNum;
	}
	
	public boolean isUsernameFieldDisplayed() {
//		WebElement usernameFieldLocator = driver.findElement(By.xpath(userNameLocator));
//		waitForVisibilityOfElement(userNameLocator);
//		return userNameLocator.isDisplayed();
		return isElementDisplayed(userNameLocator, true);
		
	}

	public boolean isPasswordDisplayed() {
//		WebElement passwordFieldLocator = driver.findElement(By.xpath(passwordLocator));
//		return passwordLocator.isDisplayed();
		return isElementDisplayed(passwordLocator, true);

	}

	public boolean isLoginBtnDisplayed() {
//		WebElement loginBtnFieldLocator = driver.findElement(By.xpath(loginBtnLocator));
//		return loginBtnLocator.isDisplayed();
		return isElementDisplayed(loginBtnLocator, true);

		
	}
	
	public boolean isRegisterBtnDisplayed() {
		return isElementDisplayed(registerBtnLocator, true);
	}
	
	public void login(String password) {
		enterUserName();
		enterPassword(password);
		clickOnLoginBtn();
	}

	
	public void login(String username,String password) {
		enterUserName(username);
		enterPassword(password);
		clickOnLoginBtn();
	}

	public void enterUserName() {
//		WebElement usernameFieldLocator = driver.findElement(By.xpath(userNameLocator));
//		waitForVisibilityOfElement(userNameLocator);
//		userNameLocator.sendKeys(RegisterPage.newUser);
		setText(userNameLocator, RegisterPage.newUser, true);
	}
	
	public void enterUserName(String username) {
		setText(userNameLocator, username, true);
	}
	
	public void enterInvalidUserName() {
//		WebElement usernameFieldLocator = driver.findElement(By.xpath(userNameLocator));
//		userNameLocator.sendKeys("Shanu14");
		setText(userNameLocator, "Shanu14", true);
	}
	
	public void enterPassword(String password) {
//		WebElement passwordFieldLocator = driver.findElement(By.xpath(passwordLocator));
//		passwordLocator.sendKeys(password);
		setText(passwordLocator, password, true);
	}

	public void clickOnLoginBtn() {
//		WebElement loginBtnFieldLocator = driver.findElement(By.xpath(loginBtnLocator));
//		loginBtnLocator.click();
		clickOnElement(loginBtnLocator, true);
	}
	
	public void clickOnRegisterBtn() {
		clickOnElement(registerBtnLocator, true);
	}
	
	public String getAlertMsg() {
//		WebElement alertMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='rightPanel']/p[@class='error']")));
		waitForVisibilityOfElement(alertMsgLocator);
		return alertMsgLocator.getText().trim();
	}

}
