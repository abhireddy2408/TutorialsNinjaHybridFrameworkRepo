package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

	
	WebDriver driver;
	
	//Create WebElement 
	@FindBy(linkText="Edit your account information")
	WebElement editYourAccountInformationText;

	
	
	//Get driver using constructor and initelements
	
	public AccountPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public  boolean accountInformationDisplayed() {
		
		boolean value = editYourAccountInformationText.isDisplayed();	
		
		return value;
	}
	
}
