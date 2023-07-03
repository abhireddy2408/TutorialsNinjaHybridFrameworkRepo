package com.tutorialsninja.qa.testcases;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.AccountPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.LoginPage;
import com.tutorialsninja.qa.utils.Utilities;

public class LoginTest extends Base{
	
	
	LoginPage loginPage ;
	
//	 Calling parent class constructor 
		public LoginTest() {
			
			super();
		}
	
		public WebDriver driver;
		
	@BeforeMethod
	public void setUp() {
	
		
//		prop = configProperties();// calling confidProperties method
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browserName"));
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
//		homePage.clickLoginOption();
		loginPage = homePage.clickLoginOption();
		
//		driver.findElement(By.xpath("//span[text()='My Account']")).click();
//		driver.findElement(By.linkText("Login")).click();
		
	}

	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		
	}
	
	@Test(priority=1, dataProvider="validCredentialsSupplier")
	public void verifyLoginWithValidCredentials(String email, String password) {
		
//		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmailText(email);
		loginPage.enterPassword(password);
		loginPage.clickLoginConfirmButton();
		AccountPage accountPage = new AccountPage(driver);
		Assert.assertTrue(accountPage.accountInformationDisplayed());
		
//		driver.findElement(By.id("input-email")).sendKeys(email);
//		driver.findElement(By.id("input-password")).sendKeys(password);
//		driver.findElement(By.xpath("//input[@value='Login']")).click();
//		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());

		
	}
	
	//Data Driven Test method above i..e data sets using APACHE POI
	@DataProvider(name="validCredentialsSupplier")
	public Object[][] supplyTestData(){
		
		// read data from excel file
		Object[][] data = Utilities.getTestDataFromExcel("Login");
		
//		Object[][] data = {{"abhireddy2408@gmail.com", "Demo@123"},
//						{"amotooricap9@gmail.com", "12345"},
//						{"amotooricap1@gmail.com", "12345"}};
		
		return  data;
	}
	
	@Test(priority=2)
	public void verifyLoginWithInvalidCredentials() {
		
//		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmailText(Utilities.autoEmailGenerate());
		loginPage.enterPassword(testProp.getProperty("invalidPassword"));
		loginPage.clickLoginConfirmButton();
		WebElement actualText = loginPage.retrieveEmailPasswordNotMatchingWarningMessageText();
		Assert.assertTrue(actualText.getText().contains(testProp.getProperty("emailAndPasswordNoMatch")));
		
//		driver.findElement(By.id("input-email")).sendKeys(Utilities.autoEmailGenerate());
//		driver.findElement(By.id("input-password")).sendKeys(testProp.getProperty("invalidPassword"));
//		driver.findElement(By.xpath("//input[@value='Login']")).click();
//		WebElement actualText = driver.findElement(By.xpath("//div[contains(@class, 'alert alert-danger alert-dismissible')]"));
//		Assert.assertTrue(actualText.getText().contains(testProp.getProperty("emailAndPasswordNoMatch")));
	
	}
	
	
	@Test(priority=3)
	public void verifyLoginWithoutEmailAndWithOutPasswordCredentials() {
		
//		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmailText("");
		loginPage.enterPassword("");
		loginPage.clickLoginConfirmButton();
		WebElement actualText = loginPage.retrieveEmailPasswordNotMatchingWarningMessageText();
		Assert.assertTrue(actualText.getText().contains(testProp.getProperty("emailAndPasswordNoMatch")));
		
//		driver.findElement(By.id("input-email")).sendKeys("");
//		driver.findElement(By.id("input-password")).sendKeys("");
//		driver.findElement(By.xpath("//input[@value='Login']")).click();
//		WebElement actualText = driver.findElement(By.xpath("//div[contains(@class, 'alert alert-danger alert-dismissible')]"));
//		Assert.assertTrue(actualText.getText().contains(testProp.getProperty("emailAndPasswordNoMatch")));
	
		
	}
	

}
