package testscript;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.ControlActions;
import pages.HomePage;
import pages.LoginPage;
import pages.OpenAccountPage;

public class OpenAccountTest extends TestBase{
	
	public RegisterTest registerTest;
	
//	@BeforeClass
//	public void initialize() {
//		ControlActions.start("https://parabank.parasoft.com/parabank/register.htm");
//		RegisterTest rt = new RegisterTest();
//		rt.verifyRegistration();
//	}
//	
//	@BeforeMethod
//	public void startSetup() {
//		ControlActions.start("https://parabank.parasoft.com/parabank/register.htm");
//		LoginPage logP = new LoginPage();
//
//		//just take password as parameter
//		logP.login("Shanu@14");
//	}
	
	@Test
	public void verifyOpenAccount() {
		
		
		
		System.out.println("3. Click on Open New Account link");

		// Wait until the 'Open New Account' link is clickable and click it
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		WebElement openAcc = wait
//				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Open New Account']")));
//		openAcc.click();
		
		HomePage homeP = new HomePage();
		homeP.navigateTo("Open New Account");
		

		// Validate that we navigated to the "Open New Account" page
//		String actualText = "Open New Account";
//		String expectedText = driver.findElement(By.xpath("//h1[text()='Open New Account']")).getText();
//		sa.assertEquals(actualText, expectedText);
//		sa.assertAll();
		
		OpenAccountPage open = new OpenAccountPage();
		boolean openAccField = open.isOpenNewAccountFieldDisplayed();
		boolean accountTypeField = open.isAccountTypeFieldDisplayed();
		boolean accountsField = open.isAccountsFieldDisplayed();
		boolean openAccBtnField = open.isOpenNewAccBtnDisplayed();

		System.out.println("Verify that following fields are displayed:");
		System.out.println("a) What type of Account would you like to open?");
		System.out.println("Account type field is displayed.");
		System.out.println("b) A minimum of $100.00 must be deposited into this account at time of opening...");

		SoftAssert sa = new SoftAssert();
		sa.assertTrue(openAccField, "Open Account Field is not visible");
		sa.assertTrue(accountTypeField, "Account type field is not displayed");
		sa.assertTrue(accountsField, "Accounts field is not displayed");
		sa.assertTrue(openAccBtnField,"Open New Account button is not displayed or enabled.");
		sa.assertAll();
		
		System.out.println("Open New Account field displayed.");
		System.out.println("Account type field is displayed.");
		System.out.println("Accounts field is displayed.");
		System.out.println("c) Open new account button is displayed?");
		

		// Wait for the specific fields to be displayed
//		String field1ActualText = "What type of Account would you like to open?";
//		String field1ExpectedText = driver
//				.findElement(By.xpath(
//						"//div[@id='openAccountForm']/form/p/b[text()='What type of Account would you like to open?']"))
//				.getText();
//		sa.assertEquals(field1ActualText, field1ExpectedText);
//		sa.assertAll();
		
		

//		String field2ActualText = "A minimum of $100.00 must be deposited into this account at time of opening. Please choose an existing account to transfer funds into the new account.";
//		String field2ExpectedText = driver.findElement(By.xpath("//div[@id='openAccountForm']/form/p[2]/b")).getText();
//		sa.assertEquals(field2ActualText, field2ExpectedText);
//		sa.assertAll();

		

		// Select Account type from dropdown
//		WebElement dropdown1 = driver.findElement(By.xpath("//select[@id='type']"));
//		Select typeSelect = new Select(dropdown1);
//		typeSelect.selectByVisibleText("SAVINGS");
		
		open.selectAccType();

		// If there are multiple accounts in the second dropdown, handle it
//		WebElement dropdown2 = wait
//				.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='fromAccountId']")));
//		Select fromAccountSelect = new Select(dropdown2);
//
//		WebDriverWait waitForOptions = new WebDriverWait(driver, Duration.ofSeconds(10));
//		waitForOptions.until(
//				ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//select[@id='fromAccountId']/option")));
//		fromAccountSelect.getFirstSelectedOption();
//
//		mainAccNum = fromAccountSelect.getFirstSelectedOption().getText();
		
		open.selectAccounts();

		// Wait for the "Open New Account" button to be clickable
		
		/*WebElement openAccButton1 = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//input[@type='button' and @value='Open New Account']")));

		// Scroll to the element to ensure it's in the viewport
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", openAccButton1);

		// Ensure the button is clickable by waiting for it
		wait.until(ExpectedConditions.elementToBeClickable(openAccButton1));

		// Now attempt to click the button using JavascriptExecutor to bypass potential
		// overlay issues
		js.executeScript("arguments[0].click();", openAccButton1);

		// Alternatively, you can use WebDriver's click method after making sure the
		// element is in the viewport
		openAccButton1.click();
		*/
		open.clickOnOpenNewAccBtn();
		System.out.println("Open New Account button clicked.");

		open.getNewAccNum();
		
		
	}


}

