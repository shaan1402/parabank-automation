package testscript;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.ControlActions;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;
import utility.ExcelOperations;

public class RegisterTest {
	
	
	
	@BeforeMethod
	public void setup() {
//		PropOperations propOperations = new PropOperations(ConstantPath.CONFIGFILEPATH);
//		String env = System.getProperty("env") == null? "qa" : System.getProperty("env");
//		String url = propOperations.getValue(env + ".url");
//		ControlActions.start(url);
		ControlActions.start("https://parabank.parasoft.com/parabank/register.htm");
	}
	
//	public int getRandomNum() {
//		Random random = new Random();
//		return random.nextInt(1000);
//	}
//
//	public String getNewUsername() {
//		String newUser = "shaan" + getRandomNum();
//		return newUser;
//	}
	
	
	@Test(priority = 1)
	public void verifyRegistration() {
				
		System.out.println(
				"VERIFY : that first name, last name, address, city, state, zipcode, phone number, ssn, username, password and confirm password field is displayed and enabled");
//		WebElement firstName = driver.findElement(By.xpath("//input[@id='customer.firstName']"));
		RegisterPage registerPage = new RegisterPage();
		boolean firstnameFieldFlag = registerPage.isFirstNameFieldDisplayed();
		
//		WebElement lastName = driver.findElement(By.xpath("//input[@id='customer.lastName']"));
		boolean lastNameFieldFlag = registerPage.isLastNameFieldDisplayed();
		
//		WebElement address = driver.findElement(By.xpath("//input[@id='customer.address.street']"));
		boolean addressFieldFlag = registerPage.isAddressFieldDisplayed();
		
//		WebElement city = driver.findElement(By.xpath("//input[@id='customer.address.city']"));
		boolean cityFieldFlag = registerPage.isCityFieldDisplayed();
		
//		WebElement state = driver.findElement(By.xpath("//input[@id='customer.address.state']"));
		boolean stateFieldFlag = registerPage.isStateFieldDisplayed();
		
//		WebElement zipCode = driver.findElement(By.xpath("//input[@id='customer.address.zipCode']"));
		boolean zipCodeFieldFlag = registerPage.isZipCodeFieldDisplayed();
		
//		WebElement phoneNum = driver.findElement(By.xpath("//input[@id='customer.phoneNumber']"));
		boolean phoneNumFieldFlag = registerPage.isPhoneFieldDisplayed();
		
//		WebElement ssn = driver.findElement(By.xpath("//input[@id='customer.ssn']"));
		boolean ssnFieldFlag = registerPage.isSSNFieldDisplayed();
		
//		WebElement userName = driver.findElement(By.xpath("//input[@id='customer.username']"));
		boolean userNameFieldFlag = registerPage.isUserNameFieldDisplayed();
		
//		WebElement password = driver.findElement(By.xpath("//input[@id='customer.password']"));
		boolean passwordFieldFlag = registerPage.isPasswordFieldDisplayed();
		
//		WebElement conPassword = driver.findElement(By.xpath("//input[@id='repeatedPassword']"));
		boolean conPasswordFieldFlag = registerPage.isConfirmPasswordFieldDisplayed();
		
//		WebElement register = driver.findElement(By.xpath("//input[@value='Register']"));
		boolean registerFieldFlag = registerPage.isRegisterFieldDisplayed();
		
		// scrollToRegister(register);

		SoftAssert sa = new SoftAssert();
		sa.assertTrue(firstnameFieldFlag,"First Name is either not displayed or not enabled");
		sa.assertTrue(lastNameFieldFlag,"last Name is either not displayed or not enabled");
		sa.assertTrue(addressFieldFlag, "Address is either not displayed or not enabled");
		sa.assertTrue(cityFieldFlag, "City is either not displayed or not enabled");
		sa.assertTrue(stateFieldFlag, "State is either not displayed or not enabled");
		sa.assertTrue(zipCodeFieldFlag, "Zip Code is either not displayed or not enabled");
		sa.assertTrue(phoneNumFieldFlag,"Phone Number is either not displayed or not enabled");
		sa.assertTrue(ssnFieldFlag, "SSN is either not displayed or not enabled");
		sa.assertTrue(userNameFieldFlag,"User Name is either not displayed or not enabled");
		sa.assertTrue(passwordFieldFlag,"Password is either not displayed or not enabled");
		sa.assertTrue(conPasswordFieldFlag,"Confirm Password is either not displayed or not enabled");
		sa.assertTrue(registerFieldFlag,"Register is either not displayed or not enabled");
		sa.assertAll();
		System.out.println("All the fields are displayed");
		
		System.out.println("Enter valid details to register");
		
//		firstName.sendKeys("Shanu");
		registerPage.enterFirstName("Shanu");
		
//		lastName.sendKeys("Mahajan");
		registerPage.enterLastName("Mahajan");
		
//		address.sendKeys("19/2 clerk colony");
		registerPage.enterAddress("19/2 clerk colony");
		
//		city.sendKeys("indore");
		registerPage.enterCity("indore");
		
//		state.sendKeys("Madhya Pradesh");
		registerPage.enterState("Madhya Pradesh (India)");
		
//		zipCode.sendKeys("452003");
		registerPage.enterZipCode("452003");
		
//		phoneNum.sendKeys("9999900000");
		registerPage.enterPhone("9999900000");
		
//		ssn.sendKeys("1234567890");
		registerPage.enterSSN("1234567890");
		
//		userName.sendKeys(getNewUsername());
		registerPage.enterUserName();
//		String username = "shaan" + RegisterPage.getRandomNum();
//		registerPage.enterUserName(username);
		
//		password.sendKeys("Shanu@14");
		registerPage.enterPassword("Shanu@14");
		
//		conPassword.sendKeys("Shanu@14");
		registerPage.enterConfirmPassword("Shanu@14");
		
//		register.click();
		registerPage.clickOnRegisterBtn();
		
		System.out.println("Registered Succeessfully");

//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		WebElement logout = wait
//				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Log Out']")));
//		logout.click();
		
		System.out.println("click on logout button");
		HomePage homePage = new HomePage();
		boolean logoutBtnFlag = homePage.isLogoutDisplayed();
		sa.assertTrue(logoutBtnFlag, "Logout button is not displayed");
		sa.assertAll();
		homePage.clickOnLogoutBtn();
		System.out.println("logout successfully");
		
	}

	public static List<String[]> credentials = new ArrayList<>();
	
	
	@Test(priority = -1,enabled = false)
	public void verifyRegistrationForMultipleUser() {
		
		for(int i = 1; i<=5; i++) {
		
		
		System.out.println(
				"VERIFY : that first name, last name, address, city, state, zipcode, phone number, ssn, username, password and confirm password field is displayed and enabled");
		
		RegisterPage registerPage = new RegisterPage();
		
		boolean firstnameFieldFlag = registerPage.isFirstNameFieldDisplayed();
		
		boolean lastNameFieldFlag = registerPage.isLastNameFieldDisplayed();
		
		boolean addressFieldFlag = registerPage.isAddressFieldDisplayed();
		
		boolean cityFieldFlag = registerPage.isCityFieldDisplayed();
		
		boolean stateFieldFlag = registerPage.isStateFieldDisplayed();
		
		boolean zipCodeFieldFlag = registerPage.isZipCodeFieldDisplayed();
		
		boolean phoneNumFieldFlag = registerPage.isPhoneFieldDisplayed();
		
		boolean ssnFieldFlag = registerPage.isSSNFieldDisplayed();
		
		boolean userNameFieldFlag = registerPage.isUserNameFieldDisplayed();
		
		boolean passwordFieldFlag = registerPage.isPasswordFieldDisplayed();
		
		boolean conPasswordFieldFlag = registerPage.isConfirmPasswordFieldDisplayed();
		
		boolean registerFieldFlag = registerPage.isRegisterFieldDisplayed();

		SoftAssert sa = new SoftAssert();
		sa.assertTrue(firstnameFieldFlag,"First Name is either not displayed or not enabled");
		sa.assertTrue(lastNameFieldFlag,"last Name is either not displayed or not enabled");
		sa.assertTrue(addressFieldFlag, "Address is either not displayed or not enabled");
		sa.assertTrue(cityFieldFlag, "City is either not displayed or not enabled");
		sa.assertTrue(stateFieldFlag, "State is either not displayed or not enabled");
		sa.assertTrue(zipCodeFieldFlag, "Zip Code is either not displayed or not enabled");
		sa.assertTrue(phoneNumFieldFlag,"Phone Number is either not displayed or not enabled");
		sa.assertTrue(ssnFieldFlag, "SSN is either not displayed or not enabled");
		sa.assertTrue(userNameFieldFlag,"User Name is either not displayed or not enabled");
		sa.assertTrue(passwordFieldFlag,"Password is either not displayed or not enabled");
		sa.assertTrue(conPasswordFieldFlag,"Confirm Password is either not displayed or not enabled");
		sa.assertTrue(registerFieldFlag,"Register is either not displayed or not enabled");
		sa.assertAll();
		System.out.println("All the fields are displayed");
		
		System.out.println("Enter valid details to register");
		
		//+ i to have unique data for mulitple entries
		registerPage.enterFirstName("Shanu "+ i);
		
		registerPage.enterLastName("Mahajan"+ i);
		
		registerPage.enterAddress("19/2 clerk colony"+ i);
		
		registerPage.enterCity("indore");
		
		registerPage.enterState("Madhya Pradesh");
		
		registerPage.enterZipCode("452003");
		
		registerPage.enterPhone("999990000"+ i);
		
		registerPage.enterSSN("1234567890"+ i);
		
		String username = "shaan" + RegisterPage.getRandomNum();
		registerPage.enterUserName(username);
		
		String password = "Shanu@14";
		registerPage.enterPassword(password);
		
		registerPage.enterConfirmPassword(password);
		
		registerPage.clickOnRegisterBtn();
		
		System.out.println("Registered Succeessfully");

		credentials.add(new String[] {username, password});
		
		System.out.println("Registered User: " + username);
        System.out.println("Stored Username and Password for DataProvider");
		
		System.out.println("click on logout button");
		HomePage homePage = new HomePage();
		boolean logoutBtnFlag = homePage.isLogoutDisplayed();
		sa.assertTrue(logoutBtnFlag, "Logout button is not displayed");
		sa.assertAll();
		homePage.clickOnLogoutBtn();
		System.out.println("logout successfully");
		
		LoginPage loginP = new LoginPage();
		
		boolean registerBtnFlag = loginP.isRegisterBtnDisplayed();
		sa.assertTrue(registerBtnFlag, "Register button is not displayed");
		sa.assertAll();
		
		loginP.clickOnRegisterBtn();
		
	}
}


	@Test(priority = -1, enabled = false)
	public void verifyRegistrationForMultipleUser2() throws IOException {

		// ✅ Step 1: Clear existing data from Excel
		ExcelOperations.clearExcelData("LoginData");

		for (int i = 1; i <= 5; i++) {

			System.out.println(
					"VERIFY : that first name, last name, address, city, state, zipcode, phone number, ssn, username, password and confirm password field is displayed and enabled");

			RegisterPage registerPage = new RegisterPage();

			boolean firstnameFieldFlag = registerPage.isFirstNameFieldDisplayed();

			boolean lastNameFieldFlag = registerPage.isLastNameFieldDisplayed();

			boolean addressFieldFlag = registerPage.isAddressFieldDisplayed();

			boolean cityFieldFlag = registerPage.isCityFieldDisplayed();

			boolean stateFieldFlag = registerPage.isStateFieldDisplayed();

			boolean zipCodeFieldFlag = registerPage.isZipCodeFieldDisplayed();

			boolean phoneNumFieldFlag = registerPage.isPhoneFieldDisplayed();

			boolean ssnFieldFlag = registerPage.isSSNFieldDisplayed();

			boolean userNameFieldFlag = registerPage.isUserNameFieldDisplayed();

			boolean passwordFieldFlag = registerPage.isPasswordFieldDisplayed();

			boolean conPasswordFieldFlag = registerPage.isConfirmPasswordFieldDisplayed();

			boolean registerFieldFlag = registerPage.isRegisterFieldDisplayed();

			SoftAssert sa = new SoftAssert();
			sa.assertTrue(firstnameFieldFlag, "First Name is either not displayed or not enabled");
			sa.assertTrue(lastNameFieldFlag, "last Name is either not displayed or not enabled");
			sa.assertTrue(addressFieldFlag, "Address is either not displayed or not enabled");
			sa.assertTrue(cityFieldFlag, "City is either not displayed or not enabled");
			sa.assertTrue(stateFieldFlag, "State is either not displayed or not enabled");
			sa.assertTrue(zipCodeFieldFlag, "Zip Code is either not displayed or not enabled");
			sa.assertTrue(phoneNumFieldFlag, "Phone Number is either not displayed or not enabled");
			sa.assertTrue(ssnFieldFlag, "SSN is either not displayed or not enabled");
			sa.assertTrue(userNameFieldFlag, "User Name is either not displayed or not enabled");
			sa.assertTrue(passwordFieldFlag, "Password is either not displayed or not enabled");
			sa.assertTrue(conPasswordFieldFlag, "Confirm Password is either not displayed or not enabled");
			sa.assertTrue(registerFieldFlag, "Register is either not displayed or not enabled");
			sa.assertAll();
			System.out.println("All the fields are displayed");

			System.out.println("Enter valid details to register");

			// + i to have unique data for mulitple entries
			registerPage.enterFirstName("Shanu " + i);

			registerPage.enterLastName("Mahajan" + i);

			registerPage.enterAddress("19/2 clerk colony" + i);

			registerPage.enterCity("indore");

			registerPage.enterState("Madhya Pradesh");

			registerPage.enterZipCode("452003");

			registerPage.enterPhone("999990000" + i);

			registerPage.enterSSN("1234567890" + i);

			String username = "shaan" + RegisterPage.getRandomNum();
			registerPage.enterUserName(username);

			String password = "Shanu@14";
			registerPage.enterPassword(password);

			registerPage.enterConfirmPassword(password);

			registerPage.clickOnRegisterBtn();

			System.out.println("Registered Succeessfully");


			ExcelOperations.writeDataToExcel("LoginData", i - 1, username, password);
            System.out.println("Data written to Excel for user: " + username);

			
//			credentials.add(new String[] { username, password });
//			System.out.println("Registered User: " + username);
//			System.out.println("Stored Username and Password for DataProvider");

			System.out.println("click on logout button");
			HomePage homePage = new HomePage();
			boolean logoutBtnFlag = homePage.isLogoutDisplayed();
			sa.assertTrue(logoutBtnFlag, "Logout button is not displayed");
			sa.assertAll();
			homePage.clickOnLogoutBtn();
			System.out.println("logout successfully");

			LoginPage loginP = new LoginPage();

			boolean registerBtnFlag = loginP.isRegisterBtnDisplayed();
			sa.assertTrue(registerBtnFlag, "Register button is not displayed");
			sa.assertAll();

			loginP.clickOnRegisterBtn();

		}
	}


	@AfterMethod
	public void tearDown(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			System.out.println(result.getMethod());
			ControlActions.takeScreenShot(result.getName());
		}
		ControlActions.close();
	}
}
//	
//	public void takeScreenShot(String fileName) {
//		TakesScreenshot ts = (TakesScreenshot)driver;
//		File srcFile = ts.getScreenshotAs(OutputType.FILE);
//		try {
//			FileUtils.copyFile(srcFile, new File(".//src/assignment/screenshots/" + fileName +".png"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
