package com.wordpress.testcases_demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.wordpress.DashboardPageObject;
import pageObjects.wordpress.LoginPageObject;

public class Login_04_Page_Object_Pattern {

	WebDriver driver;
	LoginPageObject loginPage;
	DashboardPageObject dashboardPage;

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "/Users/apple/Desktop/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		loginPage = new LoginPageObject(driver);
		dashboardPage = new DashboardPageObject(driver);

	}

	@BeforeMethod
	public void beforeMethod() {
		// Delete cookies after each test case
		driver.manage().deleteAllCookies();
		driver.get("https://automationfc.wordpress.com/wp-admin");
	}

	@Test
	public void Validate_01_EmptyEmail() {
		loginPage.inputToEmailTextbox("");

		loginPage.clickToContinueButton();

		Assert.assertEquals(loginPage.getEmailErrorMessage(), "Please enter a username or email address.");
	}

	@Test
	public void Validate_02_InvalidEmail() {
		loginPage.inputToEmailTextbox("a@.com");
		loginPage.clickToContinueButton();
		Assert.assertTrue(loginPage.isDisplayMessageError());
	}

	@Test
	public void Validate_03_EmailNotExist() {
		loginPage.inputToEmailTextbox("a@.com");
		loginPage.clickToContinueButton();
		Assert.assertTrue(loginPage.isDisplayMessageError());

	}

	@Test
	public void Validate_04_EmptyPassword() {
		loginPage.inputToEmailTextbox("automationeditor");

		loginPage.clickToContinueButton();

		loginPage.inputToPasswordTextbox("");

		loginPage.clickToLoginButton();

		Assert.assertTrue(loginPage.isDisplayMessageError());

	}

	@Test
	public void Validate_05_PasswordLessThan6Chars() {

	}

	@Test
	public void Validate_06_ValidPassword() {

		loginPage.inputToEmailTextbox("automationeditor");

		loginPage.clickToContinueButton();

		loginPage.inputToPasswordTextbox("automationfc");

		loginPage.clickToLoginButton();

		Assert.assertTrue(dashboardPage.isHeaderTextDisplayed());
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
