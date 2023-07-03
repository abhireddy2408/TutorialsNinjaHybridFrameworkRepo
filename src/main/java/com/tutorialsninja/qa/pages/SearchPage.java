package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	WebDriver driver;
	
	@FindBy(linkText="HP LP3065")
	private WebElement validHPProduct;
	
	@FindBy(xpath="//input[@id='button-search']/following::p")
	private WebElement noProductMessage;

	// get driver using constructor and init elements
	public SearchPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// Actions
	
	public boolean displayProductTitleText() {
		
		boolean status = validHPProduct.isDisplayed();
		
		return status;
	}
	
	public boolean noProductMessageText() {
		
		boolean status = noProductMessage.isDisplayed();
		
		return status;
	}
}
