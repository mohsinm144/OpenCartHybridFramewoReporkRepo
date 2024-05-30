package com.opencart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccessPage {
	
	WebDriver driver;
	
	@FindBy (xpath="//div[@id=\"content\"]/h1")
	private WebElement accountCreatedHeaderMessage;
	
	//Constructor
	public AccountSuccessPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//Actions
	public String displayAccountSuccessMessage() {
		String actualHeaderMessage = accountCreatedHeaderMessage.getText();
		return actualHeaderMessage;
	}
}
