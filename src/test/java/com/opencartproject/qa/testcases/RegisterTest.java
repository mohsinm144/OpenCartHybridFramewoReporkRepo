package com.opencartproject.qa.testcases;



import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.opencart.pages.AccountSuccessPage;
import com.opencart.pages.HomePage;
import com.opencart.pages.RegisterPage;
import com.opencartproject.qa.base.Base;
import com.opencartproject.qa.utils.Utilities;

public class RegisterTest extends Base {
	

	RegisterPage registerPage;
	AccountSuccessPage accountSuccessPage;
	
	public RegisterTest() {
		super();
	}
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setup() {

		
		driver = initializeBrowserAndOpenAppUrl(prop.getProperty("browserName"));
		HomePage homePage = new HomePage(driver);
		
		registerPage = homePage.navigateToRegisterPage();
		/*
		homePage.clickOnMyAccount();
		//driver.findElement(By.xpath("//i[@class=\"fa fa-user\"]")).click();
		
		registerPage = homePage.selectRegisterOption();
		//driver.findElement(By.linkText("Register")).click();
		 */
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority=1)
	public void verifyRegisteringByMandatoryFields() {
		
		accountSuccessPage = registerPage.registerWithMandatoryFields(dataProp.getProperty("fName") , dataProp.getProperty("lName"), Utilities.generateDateStamp(), dataProp.getProperty("teleNumber"), prop.getProperty("Password") );
		Assert.assertEquals(accountSuccessPage.displayAccountSuccessMessage(),dataProp.getProperty("accountCreatedMessage"), "Account not created successfully");

		//String actualText = accountSuccessPage.displayAccountSuccessMessage();
		/*
		registerPage.enterFirstName(dataProp.getProperty("fName"));
		registerPage.enterLastName(dataProp.getProperty("lName"));
		registerPage.enterEmailAddress(Utilities.generateDateStamp());
		registerPage.enterTelephoneNumber(dataProp.getProperty("teleNumber"));
		registerPage.enterPassword(prop.getProperty("Password"));
		registerPage.enterConfirmPassword(prop.getProperty("Password"));
		registerPage.clickPrivacyPolicyOption();
		accountSuccessPage = registerPage.clickContinueButton();
		*/
		
		//driver.findElement(By.xpath("//*[@name='firstname']")).sendKeys(dataProp.getProperty("fName"));
		//driver.findElement(By.xpath("//*[@name='lastname']")).sendKeys(dataProp.getProperty("lName"));
		//driver.findElement(By.xpath("//*[@name='email']")).sendKeys(Utilities.generateDateStamp());
		//driver.findElement(By.xpath("//*[@name='telephone']")).sendKeys(dataProp.getProperty("teleNumber"));
		//driver.findElement(By.xpath("//*[@name='password']")).sendKeys(prop.getProperty("Password"));
		//driver.findElement(By.xpath("//*[@name='confirm']")).sendKeys(prop.getProperty("Password"));
		//driver.findElement(By.xpath("//*[@name='agree']")).click();
		//driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
		
		
		
		
		
		
	}
	
	@Test(priority=2)
	public void verifyRegisteringByEnteringAllFields() {
		
		accountSuccessPage = registerPage.registeringByEnteringAllFields(dataProp.getProperty("fName") , dataProp.getProperty("lName"), Utilities.generateDateStamp(), dataProp.getProperty("teleNumber"), prop.getProperty("Password") );
		Assert.assertEquals(accountSuccessPage.displayAccountSuccessMessage(),dataProp.getProperty("accountCreatedMessage"), "Account not created successfully");

		//String actualText = accountSuccessPage.displayAccountSuccessMessage();
		
		/*
		registerPage.enterFirstName(dataProp.getProperty("fName"));
		registerPage.enterLastName(dataProp.getProperty("lName"));
		registerPage.enterEmailAddress(Utilities.generateDateStamp());
		registerPage.enterTelephoneNumber(dataProp.getProperty("teleNumber"));
		registerPage.enterPassword(prop.getProperty("Password"));
		registerPage.enterConfirmPassword(prop.getProperty("Password"));
		registerPage.selectNewsLetterCheckBox();
		registerPage.clickPrivacyPolicyOption();
		accountSuccessPage = registerPage.clickContinueButton();
		*/
		
		//driver.findElement(By.xpath("//*[@name='firstname']")).sendKeys(dataProp.getProperty("fName"));
		//driver.findElement(By.xpath("//*[@name='lastname']")).sendKeys(dataProp.getProperty("lName"));
		//driver.findElement(By.xpath("//*[@name='email']")).sendKeys(Utilities.generateDateStamp());
		//driver.findElement(By.xpath("//*[@name='telephone']")).sendKeys(dataProp.getProperty("teleNumber"));
		//driver.findElement(By.xpath("//*[@name='password']")).sendKeys(prop.getProperty("Password"));
		//driver.findElement(By.xpath("//*[@name='confirm']")).sendKeys(prop.getProperty("Password"));
		//driver.findElement(By.xpath("//input[@name=\"newsletter\"][@value='1']")).click();
		//driver.findElement(By.xpath("//*[@name='agree']")).click();
		//driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
		
		
	}
	@Test(priority=3)
	public void veryRegisteringByEnteringInvalidEmail() {
		
		accountSuccessPage = registerPage.registeringByEnteringAllFields(dataProp.getProperty("fName"), dataProp.getProperty("lName"), prop.getProperty("validEmail"), dataProp.getProperty("teleNumber"), prop.getProperty("Password"));
		Assert.assertEquals(registerPage.duplicateEmailAddressErrorMessage(), dataProp.getProperty("emailDuplicateWarning"),"Account created successfully");

		//String ActualErrorMsg = registerPage.duplicateEmailAddressErrorMessage();
		
		/*
		registerPage.enterFirstName(dataProp.getProperty("fName"));
		registerPage.enterLastName(dataProp.getProperty("lName"));
		registerPage.enterEmailAddress(prop.getProperty("validEmail"));
		registerPage.enterTelephoneNumber(dataProp.getProperty("teleNumber"));
		registerPage.enterPassword(prop.getProperty("Password"));
		registerPage.enterConfirmPassword(prop.getProperty("Password"));
		registerPage.selectNewsLetterCheckBox();
		registerPage.clickPrivacyPolicyOption();
		registerPage.clickContinueButton();
		*/
		
		/*
		driver.findElement(By.xpath("//*[@name='firstname']")).sendKeys(dataProp.getProperty("fName"));
		driver.findElement(By.xpath("//*[@name='lastname']")).sendKeys(dataProp.getProperty("lName"));
		driver.findElement(By.xpath("//*[@name='email']")).sendKeys(prop.getProperty("validEmail"));
		driver.findElement(By.xpath("//*[@name='telephone']")).sendKeys(dataProp.getProperty("teleNumber"));
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys(prop.getProperty("Password"));
		driver.findElement(By.xpath("//*[@name='confirm']")).sendKeys(prop.getProperty("Password"));
		driver.findElement(By.xpath("//input[@name=\"newsletter\"][@value='1']")).click();
		driver.findElement(By.xpath("//*[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
		*/
		
		
	}
	@Test(priority=4)
	public void verifyRegisteringWithoutEnteringFields() {
		
		registerPage.clickContinueButton();
		Assert.assertTrue(registerPage.displayStatusOfWarningMessages(dataProp.getProperty("privacyPolicyWarning"), dataProp.getProperty("fNameWarning"), dataProp.getProperty("lNameWarning"), dataProp.getProperty("emailWarning"), dataProp.getProperty("teleNumberWarning"), dataProp.getProperty("passwordWarning")));
		
		/*
		
		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
		 
		String actualPrivacyPolicyErrorMsg = registerPage.duplicateEmailAddressErrorMessage();
		Assert.assertEquals(privacyPolicyWarningTxt, dataProp.getProperty("privacyPolicyWarning"), "Privacy Policy warning message is not displayed");
		
		String fNameWarningTxt = registerPage.retrieveFirstNameWarningText();
		Assert.assertEquals(fNameWarningTxt, dataProp.getProperty("fNameWarning"), "First name warning message is not displayed");
		
		String lNameErrorTxt = registerPage.retrieveLastWarningText();
		Assert.assertEquals(lNameErrorTxt, dataProp.getProperty("lNameWarning"), "Last name warning message is not displayed");
		
		String emailErrorTxt = registerPage.retrieveEmailAddressWarningText();
		Assert.assertEquals(emailErrorTxt, dataProp.getProperty("emailWarning"), "Email warning message is not displayed");
		
		String teleErrorTxt = registerPage.retrieveTelephoneWarningText();
		Assert.assertEquals(teleErrorTxt, dataProp.getProperty("teleNumberWarning"), "Telephone warning message is not displayed");
		
		String passwordErrorTxt = registerPage.retrievePasswordWarningText();
		Assert.assertEquals(passwordErrorTxt, dataProp.getProperty("passwordWarning"), "Password warning message is not displayed");
		*/
		
		
	}

}









