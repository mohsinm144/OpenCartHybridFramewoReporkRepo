package com.opencartproject.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.opencart.pages.HomePage;
import com.opencart.pages.SearchPage;
import com.opencartproject.qa.base.Base;

public class SearchTest extends Base {
	
	HomePage homePage;
	SearchPage searchPage;
	
	public SearchTest() {
		super();
	}
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setup() {

		driver = initializeBrowserAndOpenAppUrl(prop.getProperty("browserName"));
		homePage = new HomePage(driver);
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority=1)
	public void verifySearchUsingProductName() {
		
		searchPage = homePage.searchForProduct(dataProp.getProperty("validProduct"));
		Assert.assertTrue(searchPage.checkProductIsDisplayed(), "No product is displayed");
		
		//homePage.enterProductTextInSearchBox(dataProp.getProperty("validProduct"));
		//driver.findElement(By.xpath("//*[@name=\"search\"]")).sendKeys(dataProp.getProperty("validProduct"));
		
		//searchPage = homePage.clickSearchButton();
		//driver.findElement(By.xpath("//*[@class=\"input-group-btn\"]")).click();
		
		
		
		
	}
	
	@Test(priority=2)
	public void verifySearchWithNonExistingProduct() {
		
		searchPage = homePage.searchForProduct(dataProp.getProperty("invalidProduct"));
		Assert.assertEquals( searchPage.noProductMatchMessage(),dataProp.getProperty("noProductMatch"),"No product message is not displayed");
		
		//driver.findElement(By.xpath("//*[@name=\"search\"]")).sendKeys(dataProp.getProperty("invalidProduct"));
		
		//searchPage = homePage.clickSearchButton();
		//driver.findElement(By.xpath("//*[@class=\"input-group-btn\"]")).click();
		
		
		//String actualSearchResult = searchPage.noProductMatchMessage();
									//driver.findElement(By.xpath("//input[contains(@id,\"button-search\")]/following-sibling::p")).getText();
		
	}
	
	@Test(priority=3)
	public void verifyWithEmptySearchBar() {
		
		searchPage = homePage.clickSearchButton();
		Assert.assertEquals(searchPage.noProductMatchMessage(),dataProp.getProperty("noProductMatch"),"No product message is not displayed");
		
		//driver.findElement(By.xpath("//*[@class=\"input-group-btn\"]")).click();
		
		//String actualSearchResult = searchPage.noProductMatchMessage();
									//driver.findElement(By.xpath("//input[contains(@id,\"button-search\")]/following-sibling::p")).getText();
		
	}
	
}
