package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.AccountSuccessPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.RegisterPage;
import com.tutorialsninja.qa.utils.Utilities;

public class RegisterTest extends Base{
	
	
	RegisterPage registerPage;
	AccountSuccessPage accountSuccessPage;
	
	// Calling parent class constructor 
		public RegisterTest() {
			
			super();
		}

		public WebDriver driver;
		
	@BeforeMethod
	public void setUp() {
		
//		prop = configProperties();// calling confidProperties method
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browserName"));
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
//		homePage.clickRegisterOption();
		registerPage = homePage.clickRegisterOption();
		
		

//		driver.findElement(By.xpath("//span[text()='My Account']")).click();
//		driver.findElement(By.linkText("Register")).click();
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	
	@Test(priority=1)
	public void verifyRegisterAccountWithMandatory() {
		
//		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.enterFirstName(testProp.getProperty("firstName"));
		registerPage.enterLastName(testProp.getProperty("lastName"));
		registerPage.enterEmail(Utilities.autoEmailGenerate());
		registerPage.enterTelephone(testProp.getProperty("telphoneNumber"));
		registerPage.enterPassword("Demo@123");
		registerPage.enterConfirmPassword("Demo@123");
		registerPage.privacyPolicyCheckoption();
//		registerPage.continueButtonOption();
		accountSuccessPage = registerPage.continueButtonOption();
//		AccountSuccessPage accountSuccessPage = new AccountSuccessPage(driver);
		String actualHeading = accountSuccessPage.accountSuccessfulCreatedWarningTextM();
		
//		driver.findElement(By.id("input-firstname")).sendKeys(testProp.getProperty("firstName"));
//		driver.findElement(By.id("input-lastname")).sendKeys(testProp.getProperty("lastName"));
//		driver.findElement(By.id("input-email")).sendKeys(Utilities.autoEmailGenerate());
//		driver.findElement(By.id("input-telephone")).sendKeys(testProp.getProperty("telphoneNumber"));
//		driver.findElement(By.id("input-password")).sendKeys("Demo@123");
//		driver.findElement(By.id("input-confirm")).sendKeys("Demo@123");
//		driver.findElement(By.xpath("//input[@name='agree']")).click();
//		driver.findElement(By.xpath("//input[@value='Continue']")).click();
//		String actualHeading = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
		Assert.assertEquals(actualHeading,testProp.getProperty("accountSuccessfulCreatedWarning"));		
	}
	
	@Test(priority=2)
	public void verifyRegisterAccountWithAllFields() {

//		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.enterFirstName(testProp.getProperty("firstName"));
		registerPage.enterLastName(testProp.getProperty("lastName"));
		registerPage.enterEmail(Utilities.autoEmailGenerate());
		registerPage.enterTelephone(testProp.getProperty("telphoneNumber"));
		registerPage.enterPassword("Demo@123");
		registerPage.enterConfirmPassword("Demo@123");
		registerPage.newsletterRadioCheckM();
		registerPage.privacyPolicyCheckoption();
//		registerPage.continueButtonOption();
		accountSuccessPage = registerPage.continueButtonOption();
//		AccountSuccessPage accountSuccessPage = new AccountSuccessPage(driver);
		String actualHeading = accountSuccessPage.accountSuccessfulCreatedWarningTextM();
		Assert.assertEquals(actualHeading,testProp.getProperty("accountSuccessfulCreatedWarning"));
		
//		driver.findElement(By.id("input-firstname")).sendKeys(testProp.getProperty("firstName"));
//		driver.findElement(By.id("input-lastname")).sendKeys(testProp.getProperty("lastName"));
//		driver.findElement(By.id("input-email")).sendKeys(Utilities.autoEmailGenerate());
//		driver.findElement(By.id("input-telephone")).sendKeys(testProp.getProperty("telphoneNumber"));
//		driver.findElement(By.id("input-password")).sendKeys("Demo@123");
//		driver.findElement(By.id("input-confirm")).sendKeys("Demo@123");
//		driver.findElement(By.xpath("//input[@name='newsletter'][@value='0']")).click();
//		driver.findElement(By.xpath("//input[@name='agree']")).click();
//		driver.findElement(By.xpath("//input[@value='Continue']")).click();
//		String actualHeading = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
		
	}
	
	@Test(priority=3)
	public void verifyRegisterAccountWithExistingAccount() {
		
//		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.enterFirstName(testProp.getProperty("firstName"));
		registerPage.enterLastName(testProp.getProperty("lastName"));
		registerPage.enterEmail(prop.getProperty("validEmail"));
		registerPage.enterTelephone(testProp.getProperty("telphoneNumber"));
		registerPage.enterPassword(prop.getProperty("validPass"));
		registerPage.enterConfirmPassword(prop.getProperty("validPass"));
		registerPage.newsletterRadioCheckM();
		registerPage.privacyPolicyCheckoption();
		registerPage.continueButtonOption();
		String actualHeading = registerPage.duplicateEmailRegisterWarningM();
		Assert.assertEquals(actualHeading,testProp.getProperty("accountSuccessfulCreatedWarning"));//testing enable below one to work
		//Assert.assertEquals(actualHeading,testProp.getProperty("duplicateEmailWarning"));
		
		
//		driver.findElement(By.id("input-firstname")).sendKeys(testProp.getProperty("firstName"));
//		driver.findElement(By.id("input-lastname")).sendKeys(testProp.getProperty("lastName"));
//		driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmail"));
//		driver.findElement(By.id("input-telephone")).sendKeys(testProp.getProperty("telphoneNumber"));
//		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPass"));
//		driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPass"));
//		driver.findElement(By.xpath("//input[@name='newsletter'][@value='0']")).click();
//		driver.findElement(By.xpath("//input[@name='agree']")).click();
//		driver.findElement(By.xpath("//input[@value='Continue']")).click();
//		String actualHeading = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		//Assert.assertTrue(actualHeading.contains("Warning: E-Mail Address is already registered!");
	
	}
	
	@Test(priority=4,dependsOnMethods={"verifyRegisterAccountWithExistingAccount"})
	public void verifyRegisterAccountWithOutFillingDetails() {
		
//		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.continueButtonOption();
		String actualHeading = registerPage.privacyPolicyRequiredWarningTextM();
//		driver.findElement(By.xpath("//input[@value='Continue']")).click();
//		String actualHeading = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		Assert.assertTrue(actualHeading.contains(testProp.getProperty("privacyPolicyWarning")));
		
		String fNameWarning = registerPage.firstNameRequiredWarningTextM();
//		String fNameWarning = driver.findElement(By.xpath("//input[@name='firstname']/following-sibling::div")).getText();
		Assert.assertEquals(fNameWarning, testProp.getProperty("firstNameWarning"));
		
		String lNameWarning = registerPage.lastNameRequiredWarningTextM();
//		String lNameWarning = driver.findElement(By.xpath("//input[@name='lastname']/following-sibling::div")).getText();
		Assert.assertEquals(lNameWarning, testProp.getProperty("lastNameWarning"));
		
		String emailWarning = registerPage.emailRequiredWarningTextM();
//		String emailWarning = driver.findElement(By.xpath("//input[@name='email']/following-sibling::div")).getText();
		Assert.assertEquals(emailWarning, testProp.getProperty("emailWarning"));
		
		String telephoneWarning = registerPage.telephoneRequiredWarningTextM();
//		String telephoneWarning = driver.findElement(By.xpath("//input[@name='telephone']/following-sibling::div")).getText();
		Assert.assertEquals(telephoneWarning, testProp.getProperty("telephoneWarning"));
		
		String passwordWarning = registerPage.passwordRequiredWarningTextM();
//		String passwordWarning = driver.findElement(By.xpath("//input[@name='password']/following-sibling::div")).getText();
		Assert.assertEquals(passwordWarning, testProp.getProperty("passwordWarning"));
	}

}
