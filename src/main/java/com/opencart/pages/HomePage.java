package com.opencart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	@FindBy (xpath="//i[@class=\"fa fa-user\"]")
	private WebElement myAccountDropDownMenu;
	
	@FindBy (linkText="Login")
	private WebElement LoginOption;
	
	@FindBy(linkText="Register")
	private WebElement RegisterOption;
	
	@FindBy (xpath="//*[@name=\"search\"]")
	private WebElement searchBoxField;
	
	@FindBy (xpath="//*[@class=\"input-group-btn\"]")
	private WebElement searchButton;
	
	
	//constructor
	public HomePage(WebDriver driver) {   
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	//Action
	/*
	public void clickOnMyAccount() {
		myAccountDropDownMenu.click();
	}
	
	public LoginPage selectLogin() {
		LoginOption.click();
		return new LoginPage(driver);
	}    */
	
	public LoginPage navigateToLoginPage() {
		myAccountDropDownMenu.click();
		LoginOption.click();
		return new LoginPage(driver);
	}
	/*
	public RegisterPage selectRegisterOption() {
		RegisterOption.click();
		return new RegisterPage(driver);
	}
	*/
	public RegisterPage navigateToRegisterPage() {
		myAccountDropDownMenu.click();
		RegisterOption.click();
		return new RegisterPage(driver);
	}
	/*
	public void enterProductTextInSearchBox(String productText) {
		  searchBoxField.sendKeys(productText);
	}
	*/
	public SearchPage clickSearchButton() {
		searchButton.click();
		return new SearchPage(driver);
	}
	
	public SearchPage searchForProduct(String productText) {
		searchBoxField.sendKeys(productText);
		searchButton.click();
		return new SearchPage(driver);
	}
	
}


