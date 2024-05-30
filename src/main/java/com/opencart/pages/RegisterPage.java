package com.opencart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	WebDriver driver;
	
	@FindBy (xpath="//*[@name='firstname']")
	private WebElement fNameField;
	
	@FindBy (xpath="//*[@name='lastname']")
	private WebElement lNameField;
	
	@FindBy (xpath="//*[@name='email']")
	private WebElement emailAddressField;
	
	@FindBy (xpath="//*[@name='telephone']")
	private WebElement telephoneNumberField;
	
	@FindBy (xpath="//*[@name='password']")
	private WebElement passwordField;
	
	@FindBy (xpath="//*[@name='confirm']")
	private WebElement confirmPasswordField;
	
	@FindBy (xpath="//*[@name='agree']")
	private WebElement privacyPolicyField;
	
	@FindBy (xpath="//input[@name=\"newsletter\"][@value='1']")
	private WebElement newsLetterCheckBox;
	
	@FindBy (xpath="//input[@type=\"submit\"]")
	private WebElement continueButton;
	
	@FindBy(xpath="//div[@class=\"alert alert-danger alert-dismissible\"]")
	private WebElement privacyPolicyErrorMessage;
	
	@FindBy (xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement duplicateEmailAddress;
	
	@FindBy (xpath="//input[@id=\"input-firstname\"]/following-sibling::div")
	private WebElement fNameErrorMessage;
	
	@FindBy (xpath="//input[@name='lastname']/following-sibling::div")
	private WebElement lNameErrorMessage;
	
	@FindBy (xpath="//input[@name='email']/following-sibling::div")
	private WebElement emailAddressErrorMessage;
	
	@FindBy (xpath="//input[@name='telephone']/following-sibling::div")
	private WebElement telephoneErrorMessage;
	
	@FindBy (xpath="//input[@name='password']/following-sibling::div")
	private WebElement passwordErrorMessage;
	
	
	//Constructor
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public void enterFirstName(String fNameText){
		fNameField.sendKeys(fNameText);
	}
	
	public void enterLastName(String lNameText) {
		lNameField.sendKeys(lNameText);
	}
	
	public void enterEmailAddress(String emailAddressText) {
		emailAddressField.sendKeys(emailAddressText);
	}
	
	public void enterTelephoneNumber(String telephoneText) {
		telephoneNumberField.sendKeys(telephoneText);	
	}

	public void enterPassword(String passwordText) {
		passwordField.sendKeys(passwordText);
	}
	
	public void enterConfirmPassword(String PasswordText) {
		confirmPasswordField.sendKeys(PasswordText);
	}
	
	public void clickPrivacyPolicyOption() {
		privacyPolicyField.click();
	}
	
	public AccountSuccessPage clickContinueButton() {
		continueButton.click();
		return new AccountSuccessPage(driver);
	}
	
		public void selectNewsLetterCheckBox() {
		newsLetterCheckBox.click();
	}
		
		public String duplicateEmailAddressErrorMessage() {
			String duplicateEmailWarning = duplicateEmailAddress.getText();
			return duplicateEmailWarning;
		}
		
	public AccountSuccessPage registerWithMandatoryFields(String fNameText, String lNameText, String emailAddressText, String telephoneText, String passwordText) {
		fNameField.sendKeys(fNameText);
		lNameField.sendKeys(lNameText);
		emailAddressField.sendKeys(emailAddressText);
		telephoneNumberField.sendKeys(telephoneText);
		passwordField.sendKeys(passwordText);
		confirmPasswordField.sendKeys(passwordText);
		privacyPolicyField.click();
		continueButton.click();
		return new AccountSuccessPage(driver);
	}
	
	public AccountSuccessPage registeringByEnteringAllFields(String fNameText, String lNameText, String emailAddressText, String telephoneText, String passwordText) {
		fNameField.sendKeys(fNameText);
		lNameField.sendKeys(lNameText);
		emailAddressField.sendKeys(emailAddressText);
		telephoneNumberField.sendKeys(telephoneText);
		passwordField.sendKeys(passwordText);
		confirmPasswordField.sendKeys(passwordText);
		newsLetterCheckBox.click();
		privacyPolicyField.click();
		continueButton.click();
		return new AccountSuccessPage(driver);
		
	}
	
	public boolean displayStatusOfWarningMessages(String expectedPrivacyPolicyWarning, String expectedFnameWarning, String expectedLNameWarning, String expectedEmailAddressWarning, String expectedTelephoneWarning, String expectedPasswordWarning) {
		
		//String privacyPolicyWarningText = privacyPolicyErrorMessage.getText();
		boolean actualPrivacyPolicyWarningText = privacyPolicyErrorMessage.getText().equals(expectedPrivacyPolicyWarning);
		
		//String fNameWarningText = fNameErrorMessage.getText();
		boolean actualFNameWarningText = fNameErrorMessage.getText().equals(expectedFnameWarning);
		
		//String lNameWarningText = lNameErrorMessage.getText();
		boolean actualLnameWarningText = lNameErrorMessage.getText().equals(expectedLNameWarning);
		
		//String emailAddressWarningText = emailAddressErrorMessage.getText();
		boolean actualEmailWarningText = emailAddressErrorMessage.getText().equals(expectedEmailAddressWarning);
		
		//String telephoneWarningText = telephoneErrorMessage.getText();
		boolean actualTelephoneWarningText = telephoneErrorMessage.getText().equals(expectedTelephoneWarning);
		
		//String passwordWarningText = passwordErrorMessage.getText();
		boolean actualPasswordWarningText = passwordErrorMessage.getText().equals(expectedPasswordWarning);
		
		return actualPrivacyPolicyWarningText && actualFNameWarningText && actualLnameWarningText && actualEmailWarningText && actualTelephoneWarningText && actualPasswordWarningText;
		
		
	}
	/*

	public String retrievePrivacyPolicyWarning() {
		String privacyPolicyWarningText = privacyPolicyErrorMessage.getText();
		return privacyPolicyWarningText;
	}
	
	public String retrieveFirstNameWarningText() {
		String fNameWarningText = fNameErrorMessage.getText();
		return fNameWarningText;
	}
	
	public String retrieveLastWarningText() {
		String lNameWarningText = lNameErrorMessage.getText();
		return lNameWarningText;	
	}
	
	public String retrieveEmailAddressWarningText() {
		String emailAddressWarningText = emailAddressErrorMessage.getText();
		return emailAddressWarningText;	
	}
	
	public String retrieveTelephoneWarningText() {
		String telephoneWarningText = telephoneErrorMessage.getText();
		return telephoneWarningText;
	}
	
	public String retrievePasswordWarningText() {
		String passwordWarningText = passwordErrorMessage.getText();
		return passwordWarningText;
	}
	*/
}
