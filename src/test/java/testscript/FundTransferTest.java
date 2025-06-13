package testscript;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.ControlActions;
import pages.FundTransferPage;
import pages.HomePage;
import pages.LoginPage;

public class FundTransferTest extends TestBase{
	
//	@BeforeMethod
//	public void startSetup() {
//		ControlActions.start("https://parabank.parasoft.com/parabank/register.htm");
//		LoginPage logP = new LoginPage();
//
//		//just take password as parameter
//		logP.login("Shanu@14");
//	}
	
	@Test()
	public void verifyFundTransfer() {

		System.out.println("1.Click on Transfer Funds link.");
		
		
		
		HomePage homeP = new HomePage();
		homeP.navigateTo("Transfer Funds");
		
		System.out.println("Clicked");
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//
//		WebElement transferFundLink = wait
//				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='leftPanel']/ul/li[3]/a")));
//		SoftAssert sa = new SoftAssert();
//		sa.assertTrue(transferFundLink.isDisplayed() && transferFundLink.isEnabled(),
//				"link is neither displayed nor enabled");
//		sa.assertAll();
//		transferFundLink.click();
		
//		String actualText = wait
//				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='showForm']/h1"))).getText();
//		String expectedText = "Transfer Funds";
//
//		sa.assertEquals(actualText, expectedText);
//		sa.assertAll();
		
		System.out.println("verify if transfer fund page is visible");

		FundTransferPage ftp = new FundTransferPage();

		boolean transferFundField = ftp.isTransferFundFieldDisplayed();
		
		System.out.println("2.Verify that following fields are displayed:");
		System.out.println("a)Amount");
		boolean amountField = ftp.isAmountFieldDisplayed();
		System.out.println("b) from Account and to Account fields are displayed");
		boolean fromAccountField = ftp.isFromAccountFieldDisplayed();
		boolean toAccountField = ftp.isToAccountFieldDisplayed();
		System.out.println("verify if transfer button is displayed");
		boolean transferBtnField = ftp.isTransferBtnDisplayed();

		SoftAssert sa = new SoftAssert();
		sa.assertTrue(transferFundField, "Transfer fund message field is not displayed");
		sa.assertTrue(amountField, "Amount field is not displayed");
		sa.assertTrue(fromAccountField, "From Account field is not displayed");
		sa.assertTrue(toAccountField, "To Account field is not displayed");
		sa.assertTrue(transferBtnField, "Button is not displayed");
		sa.assertAll();
		
		System.out.println("Transfer Funds message page is displayed.");
		System.out.println("Amount field is displayed");
		System.out.println("From Account field is displayed");
		System.out.println("To Account field is displayed");
		System.out.println("Transfer Button is displayed");

//		WebElement amountField = wait
//				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@id='transferForm']/p/b")));
		
		
//		WebElement fromAccToAccField = wait
//				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@id='transferForm']//div")));

		
//		sa.assertTrue(amountField.isDisplayed(), "amount field is displayed");
//		sa.assertTrue(fromAccToAccField.isDisplayed(), "fromAccToAccField is displayed");
//		sa.assertAll();

//		WebElement transferBtn = wait
//				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Transfer']")));
		
//		sa.assertTrue(transferBtn.isDisplayed(), "Transfer button is not displayed");

		System.out.println("all the fields are displayed");
		
		System.out.println("3.Enter/Select the following fields:");
		System.out.println(" a)Amount");
		
		ftp.enterAmount();
		ftp.selectFromAccount();
		ftp.selectToAccount();
		ftp.clickOnTransferBtn();
		

//		WebElement amount = wait.until(ExpectedConditions.elementToBeClickable(By.id("amount")));
//		sa.assertTrue(amount.isDisplayed() && amount.isEnabled(), "amount is neither displayed nor enabled");
//		sa.assertAll();
//		amount.sendKeys("50");
//
//		WebElement fromDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("fromAccountId")));
//		Select fromDropdownSelect = new Select(fromDropdown);
//
//		List<WebElement> optionsFromDropdown = fromDropdownSelect.getOptions();
//		for (WebElement e : optionsFromDropdown) {
//			String option = e.getText();
//			if (option.equals(mainAccNum)) {
//				System.out.println(option);
//				System.out.println(mainAccNum);
//				fromDropdownSelect.selectByVisibleText(option);
//				break;
//			}
//		}
//
//		WebElement toDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("toAccountId")));
//		Select toDropdownSelect = new Select(toDropdown);
//
//		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("toAccountId")));
//		List<WebElement> optionstoDropdown = toDropdownSelect.getOptions();
//		for (WebElement e : optionstoDropdown) {
//			String option = e.getText();
//			if (!option.equals(mainAccNum)) {
//				System.out.println(option);
//				System.out.println(mainAccNum);
//				toDropdownSelect.selectByVisibleText(option);
//				break;
//			}
//		}
//
//		System.out.println("4. Click on the Transfer button.");
//		sa.assertTrue(transferBtn.isDisplayed() && transferBtn.isEnabled(),
//				"transfer button is neither displayed nor enabled");
//		transferBtn.click();

		System.out.println("4.verify that Fund Transfer successfully message should be displayed.");
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='showResult']/h1")));
//		String actualTransferText = driver.findElement(By.xpath("//div[@id='showResult']/h1")).getText();
//		String expectedTransferText = "Transfer Complete!";
//		sa.assertEquals(actualTransferText, expectedTransferText);
//		sa.assertAll();
		
		boolean transferSuccessField = ftp.isTransferSuccessMsgDisplayed();
		sa.assertTrue(transferSuccessField, "Field is not displayed");
		
		System.out.println("Transfer successfully message displayed");

	}

}
