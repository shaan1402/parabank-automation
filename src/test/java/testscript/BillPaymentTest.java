package testscript;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.ControlActions;
import pages.AccountOverviewPage;
import pages.BillPaymentPage;
import pages.HomePage;
import pages.LoginPage;

public class BillPaymentTest extends TestBase{
	
//	@BeforeMethod
//	public void startSetup() {
//		ControlActions.start("https://parabank.parasoft.com/parabank/register.htm");
//		LoginPage logP = new LoginPage();
//
//		//just take password as parameter
//		logP.login("Shanu@14");
//	}
	
	@Test()
	public void verifyPayBill() throws InterruptedException {

		System.out.println("1.Click on Bill Pay link");


		HomePage homeP = new HomePage();
		homeP.navigateTo("Bill Pay");
		System.out.println("clicked");

		BillPaymentPage billPay = new BillPaymentPage();
		
		System.out.println(
				"2.Verify that following fields are displayed: Name, address, city, state,zipCode, phone, account, verifyAccount, amount, from Account, Send pay button.");
		boolean payeeNameField = billPay.isPayeeFieldDisplayed();
		boolean addressField = billPay.isAddressFieldDisplayed();
		boolean cityField = billPay.isCityFieldDisplayed();
		boolean stateField = billPay.isStateFieldDisplayed() ;
		boolean zipcodeField = billPay.isZipcodeFieldDisplayed();
		boolean phoneField = billPay.isPhoneFieldDisplayed();
		boolean accountField = billPay.isAccountFieldDisplayed();
		boolean verifyAccountField = billPay.isVerifyAccountFieldDisplayed();
		boolean amountField = billPay.isAmountDisplayed();
		boolean fromAccDropdown = billPay.isFromAccountFieldDisplayed();
		boolean sendPayBtn = billPay.isSendPaymentBtnFieldDisplayed();

		SoftAssert sa = new SoftAssert();
		sa.assertTrue(payeeNameField, " Name field is not displayed and enabled");
		sa.assertTrue(addressField, " address field is not displayed and enabled");
		sa.assertTrue(cityField, " city field is not displayed and enabled");
		sa.assertTrue(stateField, " state field is not displayed and enabled");
		sa.assertTrue(zipcodeField, " zipCode field is not displayed and enabled");
		sa.assertTrue(phoneField, " phone field is not displayed and enabled");
		sa.assertTrue(accountField, " account field is not displayed and enabled");
		sa.assertTrue(verifyAccountField, " verifyAccount field is not displayed and enabled");
		sa.assertTrue(amountField, " amount field is not displayed and enabled");
		sa.assertTrue(fromAccDropdown, " from Account Dropdown field is not displayed and enabled");
		sa.assertTrue(sendPayBtn," Send pay button is not displayed and enabled");
		sa.assertAll();
		System.out.println("all the fields are displayed");

		System.out.println("Enter text in the respective field.");
		billPay.enterPayeeName("Yash");
		billPay.enterAddress("Mahalaxmi nagar");
		billPay.enterCity("Indore");
		billPay.enterState("Madhya pradesh");
		billPay.enterZipcode("452011");
		billPay.enterPhoneNum("9999900000");

		String accountNum = "90797";
		billPay.enterAccountNum(accountNum);
		billPay.enterVerifyAccountNum(accountNum);
		billPay.enterAmount("75");
		billPay.selectFromAccount();
		billPay.clickOnSendPayment();


		
		System.out.println("User should be able to make the Bill payment.");

		boolean billPaySuccessField = billPay.isPaymentSuccessTextDisplayed();
		sa.assertTrue(billPaySuccessField, "payment message is not displayed");
		sa.assertAll();
		System.out.println("Payment is Successfully done");
		
		homeP.navigateTo("Accounts Overview");
//		
		AccountOverviewPage accOver = new AccountOverviewPage();
		accOver.clickOnBillPaidAcc();
		
		
		
		AccountDetailsTest accDetail = new AccountDetailsTest();
		accDetail.verifyAccountDetails();
		
		

	}

}
