package testscript;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.ControlActions;
import pages.AccountOverviewPage;
import pages.HomePage;
import pages.LoginPage;

public class AccountOverviewTest extends TestBase{
	
	//commented for xml purpose
//	@BeforeMethod
//	public void startSetup() {
//		ControlActions.start("https://parabank.parasoft.com/parabank/register.htm");
//		LoginPage logP = new LoginPage();
//
//		//just take password as parameter
//		logP.login("Shanu@14");
//	}
	
	@Test()
	public void verifyAccountOverview() {
		System.out.println("1.Click on Account Overview link.");
		HomePage homeP = new HomePage();
		homeP.navigateTo("Accounts Overview");
		System.out.println("clicked");

		AccountOverviewPage accOvr = new AccountOverviewPage();
		
		System.out.println("Verify that Account Overview page is displayed.");
		boolean accOverviewField = accOvr.isAccountOverviewFieldDisplayed();

		System.out.println("verify if Account and Amount table is visible or not");
		boolean accTableField = accOvr.isAccountTableDisplayed();
		System.out.println("2.Verify that user is able to view the new account number in account summary page.");
		boolean newAccNumField = accOvr.isNewAccNumDisplayed();
		
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(accOverviewField, "Account Overview Message is not displayed");
		sa.assertTrue(accTableField, "Table is not displayed");
		sa.assertTrue(newAccNumField, "New Account Number is not displayed");
		sa.assertAll();
		
		System.out.println("All the fields are displayed");
		System.out.println("Account Overview page displayed");
		System.out.println("Table is displayed");
		System.out.println("New account number is visible");
			

	}

}
