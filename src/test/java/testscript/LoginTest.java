package testscript;

import org.testng.Assert;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.ControlActions;
import pages.AccountOverviewPage;
import pages.HomePage;
import pages.LoginPage;


public class LoginTest{
	
	public RegisterTest registerTest;
	public static LoginPage loginPage;
	
//	public static String mainAccNum;
	
	@BeforeClass
	public void initialize() {
		ControlActions.start("https://parabank.parasoft.com/parabank/register.htm");
		registerTest = new RegisterTest();
		registerTest.verifyRegistration();
//		loginPage = new LoginPage();
//		loginPage.login("Shanu@14");
//		mainAccNum = loginPage.getMainAccountNumber();
//		System.out.println(mainAccNum);
	}
	
	@BeforeMethod
	public void startUp() {
		ControlActions.start("https://parabank.parasoft.com/parabank/register.htm");
	}
	
	@Test(priority = 1)
	public void verifyLogin() {
//		RegisterTest rt = new RegisterTest();
//		rt.verifyRegistration();
		System.out.println("2.Verify that UserName and Password fields are displayed.");
		
		LoginPage loginPage = new LoginPage();
		
//		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		boolean loginField = loginPage.isUsernameFieldDisplayed();
		
//		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		boolean passwordField = loginPage.isPasswordDisplayed();
		
//		WebElement login = driver.findElement(By.xpath("//input[@value='Log In']"));
		boolean loginBtnElement = loginPage.isLoginBtnDisplayed();
		
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(loginField, "username field is not displayed");
		sa.assertTrue(passwordField, "password filed is not displayed");
		sa.assertTrue(loginBtnElement, "login button is not displayed");
		sa.assertAll();
		System.out.println("UserName and Password fields are displayed.");

//		System.out.println("Enter the Valid UserName.");
//		loginPage.enterUserName();
//
//		System.out.println("Enter the Valid Password.");
//		loginPage.enterPassword("Shanu@141");
//
//		loginPage.clickOnLoginBtn();
		System.out.println("verify login with username and password");
		loginPage.login("Shanu@14");
		System.out.println("logged in");
		
		AccountOverviewPage accPage = new AccountOverviewPage();
		boolean accountOverviewField = accPage.isAccountOverviewFieldDisplayed();
		boolean mainAccountField = loginPage.isMainAccNumberDisplayed();
		sa.assertTrue(accountOverviewField, "Account Overview Text is not displayed");
		sa.assertTrue(mainAccountField, "Mainn Account number is not displayed");
		sa.assertAll();
		System.out.println("both fields are visible");
		
		HomePage homePage = new HomePage();
		sa.assertTrue(homePage.isHomePageDisplayed(), "Home page is not displayed");
		System.out.println("logged in");
		System.out.println("Home page displayed");
		
//		mainAccNum = loginPage.getMainAccountNumber();
		String mainAccNum = loginPage.getMainAccountNumber();
		
		System.out.println(mainAccNum);

		System.out.println("verify logout");
		boolean logoutBtnFlag = homePage.isLogoutDisplayed();
		sa.assertTrue(logoutBtnFlag, "Logout button is not displayed");
		sa.assertAll();
		homePage.clickOnLogoutBtn();
		System.out.println("logout succesfull");
	}
	
	@Test(priority = 2)
	public void verifyInvalidAuthentication() {
		LoginPage loginPage = new LoginPage();
		
		System.out.println("Enter invalid Username");
		//username has been made static and public in RegisterPage class as it is dynamic and called in enterUserName method of LoginPage class.
		loginPage.enterInvalidUserName();
		
		System.out.println("Enter invalid password");
		loginPage.enterPassword("invalid@12");
		
		System.out.println("Click on Login Button");
		loginPage.clickOnLoginBtn();
		
		System.out.println("VERIFY - alert text with error message");
		String actualAlertMsg = loginPage.getAlertMsg();
		String expectedAlertMsg = "The username and password could not be verified.";
		
		Assert.assertEquals(actualAlertMsg, expectedAlertMsg);
		
		//VERIFY - login page is visible
		System.out.println("VERIFY - login page is visible");
		Assert.assertTrue(loginPage.isLoginBtnDisplayed(), "login button was not displayed");
		
	}
	
//	@Test(dataProvider = "loginDataProvider", priority = -1, enabled = false)
//	public void verifyLoginWithMultipleUsers(String username, String password) {
//
//	    LoginPage loginPage = new LoginPage();
//
//	    loginPage.login(username, password);
//
//	    HomePage homePage = new HomePage();
//	    Assert.assertTrue(homePage.isHomePageDisplayed(), "Login failed for user: " + username);
//
//	    homePage.clickOnLogoutBtn();
//	}
//	
//	@DataProvider(name = "loginDataProvider")
//	public Object[][] getLoginData(){
//		List<String[]> credentialsData = RegisterTest.credentials;
//		Object[][] data = new Object[credentialsData.size()][2];
//		for(int i = 0; i <credentialsData.size(); i++ ) {
//			data[i][0] = credentialsData.get(i)[0]; //username
//			data[i][1] = credentialsData.get(i)[1];	//password
//		}
//		return data;
//	}
	
	@AfterMethod
	public void terminateBrowser() {
		ControlActions.close();
	}
	
	@AfterClass
	public void terminateAll() {
		ControlActions.close();
	}

}
