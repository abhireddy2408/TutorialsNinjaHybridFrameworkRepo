package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
Page Object Model design pattern used with the help of Page Factory design pattern created by selenium to support POM
to avoid StaleElementReferenceException(because breaking Webelement driver.findElement -path)
*
**/

public class HomePage {
	
	WebDriver driver;
	
	//Create WebElements with locators value
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	@FindBy(linkText="Register")
	private WebElement registerOption;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchBoxField;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	private WebElement searchButton;
	
	
	//Get driver using constructor and initialize the elements using PageFactory
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions
	
	public void clickOnMyAccount() {
		
		myAccountDropMenu.click();
		
	}
	
	public LoginPage clickLoginOption() {
		
		loginOption.click();
		return new LoginPage(driver);
		
	}
	
	public RegisterPage clickRegisterOption() {
		
		registerOption.click();
		return new RegisterPage(driver);
	}
	
	public void enterInSearchBoxField(String t) {
		
		searchBoxField.sendKeys(t);
	}
	
	public SearchPage clickSearchButton() {
		
		searchButton.click();
		return new SearchPage(driver);
	}
	

}












