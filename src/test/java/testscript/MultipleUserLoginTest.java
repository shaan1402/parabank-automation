package testscript;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.ControlActions;
import pages.HomePage;
import pages.LoginPage;
import utility.ExcelOperations;

public class MultipleUserLoginTest {
	
public RegisterTest registerTest;
	
	@BeforeClass
	public void initialize() throws IOException {
		ControlActions.start("https://parabank.parasoft.com/parabank/register.htm");
		registerTest = new RegisterTest();
		registerTest.verifyRegistrationForMultipleUser2();
	}
	
	@BeforeMethod
	public void startUp() {
		ControlActions.start("https://parabank.parasoft.com/parabank/register.htm");
	}
	
	@Test(dataProvider = "loginDataProvider", priority = -1)
	public void verifyLoginWithMultipleUsers(String username, String password) {

	    LoginPage loginPage = new LoginPage();

	    loginPage.login(username, password);

	    HomePage homePage = new HomePage();
	    
	    boolean homePageFlag = homePage.isHomePageDisplayed();
	    Assert.assertTrue(homePageFlag, "Login failed for user: " + username);

	    homePage.clickOnLogoutBtn();
	}
	
		@DataProvider(name = "loginDataProvider")
		public Object[][] getLoginData() throws IOException{
			
			Object[][] data = ExcelOperations.getDataFromFile();
//			for(int i = 0; i <credentialsData.size(); i++ ) {
//				data[i][0] = credentialsData.get(i)[0]; //username
//				data[i][1] = credentialsData.get(i)[1];	//password
//			}
			return data;
		}
		
	@AfterMethod
	public void terminateBrowser() {
		ControlActions.close();
	}
	
	@AfterClass
	public void terminateAll() {
		ControlActions.close();
	}

}
