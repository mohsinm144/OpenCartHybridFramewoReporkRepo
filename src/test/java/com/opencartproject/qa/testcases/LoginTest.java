package com.opencartproject.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencart.pages.AccountPage;
import com.opencart.pages.HomePage;
import com.opencart.pages.LoginPage;
import com.opencartproject.qa.base.Base;
import com.opencartproject.qa.utils.Utilities;


public class LoginTest extends Base{
	

	LoginPage loginPage;
	AccountPage accountPage;
	
	public LoginTest() {
		super();
	}
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		driver = initializeBrowserAndOpenAppUrl(prop.getProperty("browserName"));
		HomePage homePage = new HomePage(driver);
		
		loginPage = homePage.navigateToLoginPage();
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		
	}
	
	
	
	@Test(priority=1, dataProvider = "validCredentialsSupplier")
	public void verifyWithLoginCred(String email, String password) {
		
		accountPage = loginPage.login(email, password);
		Assert.assertTrue(accountPage.getDisplayOfEditYourAccountInformation(),"Edit your account information is incorrect");
		/*
		loginPage.enterEmailId(email);
		//driver.findElement(By.xpath("//*[@name=\"email\"]")).sendKeys(email);
		
		loginPage.enterPassword(password);
		//driver.findElement(By.xpath("//*[@name=\"password\"]")).sendKeys(password);
		
		accountPage = loginPage.clickOnLoginButton();
		//driver.findElement(By.xpath("//input[@value='Login']")).click();
		*/
		
		
		
	}
	
	@DataProvider (name="validCredentialsSupplier") //give the name for dataProvider other wise method name.
	public Object[][] supplyTestData() {
		Object[][] data = Utilities.getTestDataFromExcel("sheet");  //"sheet" is the sheet name in the excel sheet.
		return data;
	}

	
	@Test(priority=2)
	public void verifyWithInvalidCred () {
		
		accountPage = loginPage.login(Utilities.generateDateStamp(), dataProp.getProperty("invalidPassword"));
		Assert.assertTrue(loginPage.getDisplayEmailPasswordWarningMessage().contains(dataProp.getProperty("EmailPasswordNotMatching")), "Expected Warning not displayed");

		/*
		//LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmailId(Utilities.generateDateStamp());
		//driver.findElement(By.xpath("//*[@name=\"email\"]")).sendKeys(Utilities.generateDateStamp());
		
		loginPage.enterPassword(dataProp.getProperty("invalidPassword"));
		//driver.findElement(By.xpath("//*[@name=\"password\"]")).sendKeys(dataProp.getProperty("invalidPassword"));
		
		loginPage.clickLoginButton();
		//driver.findElement(By.xpath("//input[@value='Login']")).click();
		*/
		
		//String actWarningMsg = loginPage.getDisplayEmailPasswordWarningMessage();
		//String expectedWarningMsg = dataProp.getProperty("EmailPasswordNotMatching");
		
		
	}
	
	@Test(priority=3)
	public void verifyWithInvalidEmailId () {
		
		
		accountPage = loginPage.login(Utilities.generateDateStamp(),prop.getProperty("Password"));
		Assert.assertTrue(loginPage.getDisplayEmailPasswordWarningMessage().contains( dataProp.getProperty("EmailPasswordNotMatching")), "Expected Warning not displayed");
		/*
		//LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmailId(Utilities.generateDateStamp());
		//driver.findElement(By.xpath("//*[@name=\"email\"]")).sendKeys(Utilities.generateDateStamp());
		
		loginPage.enterPassword(prop.getProperty("Password"));
		//driver.findElement(By.xpath("//*[@name=\"password\"]")).sendKeys(prop.getProperty("Password"));
		
		loginPage.clickLoginButton();
		//driver.findElement(By.xpath("//input[@value='Login']")).click();
		*/
		//String actWarningMsg = loginPage.getDisplayEmailPasswordWarningMessage();
		//String expectedWarningMsg = dataProp.getProperty("EmailPasswordNotMatching");
		
		

	}
	
		@Test(priority=4)
		public void verifyWithValidEmailInvalidPassword(){
		
			accountPage = loginPage.login(prop.getProperty("validEmail"), dataProp.getProperty("invalidPassword"));
			Assert.assertTrue(loginPage.getDisplayEmailPasswordWarningMessage().contains(dataProp.getProperty("EmailPasswordNotMatching")), "Expected Warning not displayed");

			/*
			//LoginPage loginPage = new LoginPage(driver);
			loginPage.enterEmailId(prop.getProperty("validEmail"));
			
			//driver.findElement(By.xpath("//*[@name=\"email\"]")).sendKeys(prop.getProperty("validEmail"));
			
			loginPage.enterPassword(dataProp.getProperty("invalidPassword"));
			//driver.findElement(By.xpath("//*[@name=\"password\"]")).sendKeys(dataProp.getProperty("invalidPassword"));	
			
			loginPage.clickLoginButton();
			//driver.findElement(By.xpath("//input[@value='Login']")).click();
			*/
			
			//String actWarningMsg = loginPage.getDisplayEmailPasswordWarningMessage();
			//String expectedWarningMsg = dataProp.getProperty("EmailPasswordNotMatching");
			
			
			driver.quit();
		}
		
		@Test(priority=5)
		public void verifyWithoutCred() {
			
	
			loginPage.clickOnLoginButton();
			Assert.assertTrue(loginPage.getDisplayEmailPasswordWarningMessage().contains("Warning: No match for E-Mail Address and/or Password."), "Expected Warning not displayed");

			//driver.findElement(By.xpath("//input[@value='Login']")).click();

			
			//String actWarningMsg = loginPage.getDisplayEmailPasswordWarningMessage();
			//String expectedWarningMsg = "Warning: No match for E-Mail Address and/or Password.";
			
		}
		

}
