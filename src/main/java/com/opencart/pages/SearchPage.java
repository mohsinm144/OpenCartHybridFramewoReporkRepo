package com.opencart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	WebDriver driver;
	
	
	@FindBy (linkText="iMac")
	WebElement productIsDisplayed;
	
	@FindBy (xpath="//input[contains(@id,\"button-search\")]/following-sibling::p")
	WebElement noProductMatch;
	
	//Constructor
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//Actions
	
	
	public boolean checkProductIsDisplayed() {
		boolean productAvailable = productIsDisplayed.isDisplayed();
		return productAvailable;
	}
	
	public String noProductMatchMessage() {
		String noProductSearchMessage = noProductMatch.getText();
		return noProductSearchMessage;
	}


}
