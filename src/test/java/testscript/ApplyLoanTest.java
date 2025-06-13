package testscript;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.ControlActions;
import pages.AccountOverviewPage;
import pages.ApplyLoanPage;
import pages.HomePage;
import pages.LoginPage;

public class ApplyLoanTest{
	
	@BeforeClass
	public void startSetup() {
		
		ControlActions.start("https://parabank.parasoft.com/parabank/register.htm");
		
		LoginPage logP = new LoginPage();
		logP.login("Shanu@14");
		
		// Fetch and store the main account number
        AccountOverviewPage accPage = new AccountOverviewPage();
        LoginPage.mainAccNum = accPage.getMainAccountNumber();
		
		OpenAccountTest openAcc = new OpenAccountTest();
		openAcc.verifyOpenAccount();
		
//		HomePage hp = new HomePage();
//		hp.navigateTo("Accounts Overview");
//		
//		AccountOverviewPage acc = new AccountOverviewPage();
//		acc.isMainAccountVisible();
	}
	
	@Test
	public void verifyLoanRequest() {
			
			System.out.println("1. Click on Request Loan link.");
//			WebElement requestLoanLink = driver.findElement(By.xpath("//a[text()='Request Loan']"));
//			requestLoanLink.click();
			
			SoftAssert sa = new SoftAssert();
			HomePage homeP = new HomePage();
			homeP.navigateTo("Accounts Overview");
			
			AccountOverviewPage acc = new AccountOverviewPage();
			
			boolean mainAccountField = acc.isMainAccNumberDisplayed();
			sa.assertTrue(mainAccountField, "main acc number is not displayed");
			sa.assertAll();

			
			
			
			homeP.navigateTo("Request Loan");
			
			System.out.println("2.Verify that folowing fields are displayed:");
			System.out.println(" Loan Amount - Down Payment - From Account - Apply Now");
			
//			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
			
//			WebElement loanAmt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='amount']")));
//			WebElement downPay = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='downPayment']")));
//			WebElement fromAcc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='fromAccountId']")));
//			WebElement applyNow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Apply Now']")));
			
			ApplyLoanPage applyLoan = new ApplyLoanPage();
			
			boolean loanAmtFlag = applyLoan.isloanAmtLocatorDisplayed();
			boolean downPayFlag = applyLoan.isdownPayLocatorDisplayed();
			boolean fromAccFlag = applyLoan.isfromAccLocatorDisplayed();
			boolean applyNowFlag = applyLoan.isapplyNowLocatorDisplayed();
			
			sa.assertTrue(loanAmtFlag, " Loan Amount field is not displayed and enabled");
			sa.assertTrue(downPayFlag, " Down Payment field is not displayed and enabled");
			sa.assertTrue(fromAccFlag, " From Account field is not displayed and enabled");
			sa.assertTrue(applyNowFlag, " Apply Now Button is not displayed and enabled");
			sa.assertAll();
			System.out.println("All the fields are displayed");
			
			System.out.println("3.Select/Entered the following fields:");
			System.out.println(" Loan Amount - Down Payment - From Account - Apply Now");
//			loanAmt.sendKeys("1000");
//			downPay.sendKeys("100");
			
			applyLoan.setLoanAmount("1000");
			applyLoan.setDownPayAmount("250");
			
			
			
//			Select select = new Select(fromAcc);
//			select.selectByVisibleText(mainAccNum);
			
			
			applyLoan.selectAccountFromDropdown(LoginPage.mainAccNum);
			
			
			System.out.println("4. Click on Apply Loan button.");
//			applyNow.click();
			applyLoan.clickOnApplyNow();
			
			System.out.println("User should be able to apply for the Loan successfully.");
			
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='loanRequestApproved']/p")));
			String actualSuccessText = applyLoan.getLoanReqApprovedMessage();
			String expectedSuccessText = "Congratulations, your loan has been approved.";
			sa.assertEquals(actualSuccessText, expectedSuccessText);
			sa.assertAll();
			System.out.println("loan applied successfully");
		}
		
	}
	

