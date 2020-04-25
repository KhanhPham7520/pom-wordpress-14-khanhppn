package com.bankguru.login;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.bankGuru.HomePageObject;
import pageObjects.bankGuru.LoginPageObject;
import pageObjects.bankGuru.RegisterPageObject;

public class Login_01_RegisterAndLogin {
	WebDriver driver;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	HomePageObject homePage;
	String username = "mngr257649";
	String password = "arepynY";

	String userIDValue, passwordValue;
	String loginPageUrl;
	public static final String rootFolderPath = System.getProperty("user.dir");
	String randomEmail = "khanhpham" + randomNumber() + "@yopmail.com";

	// Random Method
	public static int randomNumber() {
		Random rand = new Random();
		int upperbound = 200;
		return rand.nextInt(upperbound);
	}

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "/Users/apple/Desktop/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();

		driver.get("http://demo.guru99.com/v4/");

		registerPage = new RegisterPageObject(driver);
		loginPage = new LoginPageObject(driver);

		// loginPageUrl = loginPage.getLoginPageUrl();

	}

	@Test
	public void TC_01_Register() {
		loginPage.clickToHereLink();

		// click vào Here link => Mở ra trang Register
		registerPage.inputToEmailTextbox(randomEmail);
		registerPage.clickToSubmitButton();

		userIDValue = registerPage.getUserIDText();
		System.out.println("Register UserID = " + userIDValue);
		passwordValue = registerPage.getPasswordText();
		System.out.println("Register password = " + passwordValue);

		// Từ Register Page => Mở ra trang Login -> Khởi tạo lại Login Page
		registerPage.openLoginPage("");
		loginPage = new LoginPageObject(driver);
		// khởi tạo lại Login Page
		loginPage.navigateToLoginPage();
	}

	@Test
	public void TC_02_Login() {
		loginPage.inputToUserIDTextbox(userIDValue);
		loginPage.inputToPasswordTextbox(passwordValue);
		loginPage.clickToLoginButton();
		// khởi tạo Home Page lên
		homePage = new HomePageObject(driver);

		Assert.assertTrue(homePage.isWelcomeMessageDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
