package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ControlActions;

public class HomePage extends ControlActions {
	
	@FindBy(xpath = "//div[@id='leftPanel']/p/b")
	WebElement welcomeFieldLocator;

	@FindBy(xpath = "//a[text()='Log Out']")
	WebElement logoutFieldLocator;
	
	private String menuLocator = "//a[text()='%s']";
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	

	public boolean isHomePageDisplayed() {
//		WebElement welcomeField = driver.findElement(By.xpath(welcomeFieldLocator));
//		waitForVisibilityOfElement(welcomeFieldLocator);
//		return welcomeFieldLocator.isDisplayed();
		return isElementDisplayed(welcomeFieldLocator, true);
	}
	
	public boolean isLogoutDisplayed() {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		WebElement logoutField = wait
//				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(logoutFieldLocator)));
//		return logoutFieldLocator.isDisplayed();
		return isElementDisplayed(logoutFieldLocator, true);
	}
	
	public void clickOnLogoutBtn() {
//		WebElement logoutField = wait
//				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(logoutFieldLocator)));
//		logoutFieldLocator.click();
		clickOnElement(logoutFieldLocator, true);
		
	}
	
	public void navigateTo(String menuText) {
//		String menuLocator = "//a[text()='"+menuText+"']"; 
		String locator = String.format(menuLocator, menuText);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(menuLocator)));
//		as we have get method in controlactions that can apply wait for us by giving type, path and condition
		
//		WebElement menuElement = driver.findElement(By.xpath(menuLocator));
//		WebElement menuElement = getElement("XPATH", locator, true, true);
//		menuElement.click();
		clickOnElement("XPATH", locator, true);
	}
	
	public boolean isMenuDisplayed(String menuText) {
		String locator = String.format(menuLocator, menuText);
		return isElementDisplayed("XPATH", locator, true);
	}

}
