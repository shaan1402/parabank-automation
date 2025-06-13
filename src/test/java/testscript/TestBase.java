package testscript;

import java.io.File;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import base.ControlActions;
import pages.HomePage;
import pages.LoginPage;
import path.ConstantPath;
import utility.PropOperations;

public class TestBase {
	
	public static HomePage homePage;
	public static PropOperations propOperations;
	public RegisterTest registerTest;
	
	private String url;
	
	//commented for xml purpose you can comment off in case of individual class running
//	@BeforeTest
//	public void initialize() {
//		propOperations = new PropOperations("."+File.separator+"resources"+File.separator+"config.properties");
//		url = propOperations.getValue("url");
//		ControlActions.start(url);
//		RegisterTest rt = new RegisterTest();
//		rt.verifyRegistration();
//		ControlActions.close();
//	}
	
	@BeforeClass
	public void startSetup() {
		
		propOperations = new PropOperations(ConstantPath.CONFIGFILEPATH);
		url = propOperations.getValue("url");
		ControlActions.start(url);
//		ControlActions.start("https://parabank.parasoft.com/parabank/register.htm");
		LoginPage logP = new LoginPage();
		logP.login("Shanu@14");
		
//		OpenAccountTest openAcc = new OpenAccountTest();
//		openAcc.verifyOpenAccount();
	}
	
	
//	@AfterMethod
//	public void endLogout() {
//		HomePage hp = new HomePage();
//		hp.clickOnLogoutBtn();
//	}
	
	@AfterMethod
	public void tearDown( ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			System.out.println(result.getMethod());
			ControlActions.takeScreenShot(result.getName());
		}
		ControlActions.close();
	}

}
