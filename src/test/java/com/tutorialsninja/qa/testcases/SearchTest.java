package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.SearchPage;

public class SearchTest extends Base{
	
	
	SearchPage searchPage;
	
	// Calling parent class constructor 
	public SearchTest() {
		
		super();
		
	}

	public WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		
//		prop = configProperties();// calling confidProperties method
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browserName"));
		
	}

	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		
	}
	
	@Test(priority=1)
	public void verifyWithValidProductName() {
		
		HomePage homePage = new HomePage(driver);
		homePage.enterInSearchBoxField(testProp.getProperty("validProductName"));
//		homePage.clickSearchButton();
		searchPage = homePage.clickSearchButton();
//		SearchPage searchPage = new SearchPage(driver);
		Assert.assertTrue(searchPage.displayProductTitleText());
//		driver.findElement(By.xpath("//input[@name='search']")).sendKeys(testProp.getProperty("validProductName"));
//		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
//		Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());

	}
	
	@Test(priority=2)
	public void verifyWithInValidProductName() {
		
		HomePage homePage = new HomePage(driver);
		homePage.enterInSearchBoxField(testProp.getProperty("invalidProductName"));
//		homePage.clickSearchButton();
		searchPage = homePage.clickSearchButton();
//		SearchPage searchPage = new SearchPage(driver);
		Assert.assertTrue(searchPage.noProductMessageText());
		
//		driver.findElement(By.xpath("//input[@name='search']")).sendKeys(testProp.getProperty("invalidProductName"));
//		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
//		String actualText = driver.findElement(By.xpath("//input[@id='button-search']/following::p")).getText();
//		Assert.assertEquals(actualText, testProp.getProperty("invalidProductText"));

	}
	
	@Test(priority=3)
	public void verifyWithNullProductName() {
		
		HomePage homePage = new HomePage(driver);
		homePage.enterInSearchBoxField("");
//		homePage.clickSearchButton();
		searchPage = homePage.clickSearchButton();
//		SearchPage searchPage = new SearchPage(driver);
		Assert.assertTrue(searchPage.noProductMessageText());
		
//		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("");
//		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
//		String actualText = driver.findElement(By.xpath("//input[@id='button-search']/following::p")).getText();
//		Assert.assertEquals(actualText, testProp.getProperty("invalidProductText"));

	}
	
	

}
