package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Pageobject model uses the help of page factory model design pattern which was created by selenium to avoid the staleElementReferenceException(breaks driver.findElement path

public class LoginPage {

	WebDriver driver;
	//Create WebElements
	@FindBy(id="input-email")
	private WebElement emailField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginConfirmButton;
	
	@FindBy(xpath="//div[contains(@class, 'alert alert-danger alert-dismissible')]")
	private WebElement emailPasswordNotMatchingWarning;
	
	
	// Get driver using constructor and initElements
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions
	
	public void enterEmailText(String email) {
		
		emailField.sendKeys(email);
	}
	
	public void enterPassword(String password) {
		
		passwordField.sendKeys(password);
	}
	
	public void clickLoginConfirmButton() {
		
		loginConfirmButton.click();
	}
	
	public WebElement retrieveEmailPasswordNotMatchingWarningMessageText() {
		
		WebElement warningText = emailPasswordNotMatchingWarning;
		
		return warningText;
		
	}
}





