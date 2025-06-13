package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.AccountDetailsPage;
import pages.OpenAccountPage;

public class AccountDetailsTest {
	
	@Test
	public void verifyAccountDetails() throws InterruptedException {
		
		AccountDetailsPage accDetails = new AccountDetailsPage();
		
		boolean accNumerField = accDetails.isAccNumberDisplayed();
		boolean monthDropdownField = accDetails.isMonthFieldDisplayed();
		boolean transactionTypeField = accDetails.istransactionTypeFieldDisplayed();
		boolean goBtnField = accDetails.isGoBtnDisplayed();
		boolean transactionTableField = accDetails.isTransactionTableDisplayed();
		
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(accNumerField, "Account number is not displayed");
		sa.assertTrue(monthDropdownField, "Month field is not displayed or enabled");
		sa.assertTrue(transactionTypeField, "Transaction type dropdown is not displayed or enabled");
		sa.assertTrue(goBtnField, "button is not displayed or enabled");
		sa.assertTrue(transactionTableField, "Table is not displayed");
		sa.assertAll();
		System.out.println("All the fields are displayed");
		
//		accDetails.waitForElementToBeVisible();
		String actualAccNum = accDetails.getAccNumberValue();
		System.out.println(actualAccNum);
		String expectedAccNum = OpenAccountPage.newAccNumber;
		System.out.println(expectedAccNum);
		sa.assertEquals(actualAccNum, expectedAccNum);
		sa.assertAll();
		System.out.println("Account number verified");
		
		accDetails.selectMonth();
		accDetails.selectTransactionType();
		accDetails.clickOnGoBtn();
		
		accDetails.scrollToTable();
		accDetails.getTransactionDetail();
		
		boolean transactionDetailsField = accDetails.isTransactionFieldDisplayed();
		sa.assertTrue(transactionDetailsField, "Not displayed");
		sa.assertAll();
		System.out.println("Details displayed");
		
		String actualDescriptionText = accDetails.getDescriptionMessage();
		String expectedDescriptionText = "Bill Payment to Yash";
		Assert.assertEquals(actualDescriptionText, expectedDescriptionText);
		System.out.println("Transaction verified");
		
		
	}

}
