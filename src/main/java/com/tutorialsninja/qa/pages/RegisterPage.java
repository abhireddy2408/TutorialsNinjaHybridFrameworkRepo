package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	WebDriver driver;

	@FindBy(id="input-firstname")
	WebElement firstNameField;
	
	@FindBy(id="input-lastname")
	WebElement lastNameField;
	
	@FindBy(id="input-email")
	WebElement emailField;
	
	@FindBy(id="input-telephone")
	WebElement telephoneField;
	
	@FindBy(id="input-password")
	WebElement passwordField;
	
	@FindBy(id="input-confirm")
	WebElement confirmPasswordField;
	
	@FindBy(xpath="//input[@name='newsletter'][@value='0']")
	WebElement newsletterRadioCheck;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement privacyPolicyCheckBox;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement continueButton;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement duplicateEmailRegisterWarning;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement privacyPolicyRequiredWarningText;
	
	@FindBy(xpath="//input[@name='firstname']/following-sibling::div")
	WebElement firstNameRequiredWarningText;
	
	@FindBy(xpath="//input[@name='lastname']/following-sibling::div")
	WebElement lastNameRequiredWarningText;
	
	@FindBy(xpath="//input[@name='email']/following-sibling::div")
	WebElement emailRequiredWarningText;
	
	@FindBy(xpath="//input[@name='telephone']/following-sibling::div")
	WebElement telephoneRequiredWarningText;
	
	@FindBy(xpath="//input[@name='password']/following-sibling::div")
	WebElement passwordRequiredWarningText;

	
	
	//Get the driver  by creating constructor and initElements using Page Factory
	
	public RegisterPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//Actions
	
	public void enterFirstName(String fName) {
		
		firstNameField.sendKeys(fName);
	}
	
	public void enterLastName(String lName) {
		
		lastNameField.sendKeys(lName);
		
	}
	
	public void enterEmail(String email) {
		
		emailField.sendKeys(email);
		
	}
	
	public void enterTelephone(String tel ) {
		
		telephoneField.sendKeys(tel);
	}
	
	public void enterPassword(String pass) {
		
		passwordField.sendKeys(pass);
	}
	
	public void enterConfirmPassword(String confirmPass) {
		
		confirmPasswordField.sendKeys(confirmPass);
		
	}
	
	public void newsletterRadioCheckM() {
		
		newsletterRadioCheck.click();
		
	}
	
	public void privacyPolicyCheckoption() {
		
		privacyPolicyCheckBox.click();
		
	}
	
	public AccountSuccessPage continueButtonOption() {
		
		continueButton.click();
		return new AccountSuccessPage(driver);
		
	}
	
	public String duplicateEmailRegisterWarningM() {
		
		String text = duplicateEmailRegisterWarning.getText();
		
		return text;
	}
	
	
	public String privacyPolicyRequiredWarningTextM() {
		
		String text = privacyPolicyRequiredWarningText.getText();
		
		return text;
	}
	
	public String firstNameRequiredWarningTextM() {
		
		String text = firstNameRequiredWarningText.getText();
		
		return text;
	}
	public String lastNameRequiredWarningTextM() {
		
		String text = lastNameRequiredWarningText.getText();
		
		return text;
	}
	public String emailRequiredWarningTextM() {
		
		String text = emailRequiredWarningText.getText();
		
		return text;
	}
	public String telephoneRequiredWarningTextM() {
		
		String text = telephoneRequiredWarningText.getText();
		
		return text;
	}
	public String passwordRequiredWarningTextM() {
		
		String text = passwordRequiredWarningText.getText();
		
		return text;
	}

	
}




















