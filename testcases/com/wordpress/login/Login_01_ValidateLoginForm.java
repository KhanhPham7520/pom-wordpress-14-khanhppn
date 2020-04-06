package com.wordpress.login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login_01_ValidateLoginForm {
	private WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "/Users/apple/Desktop/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	}

	@BeforeMethod
	public void beforeMethod() {
		driver.get("https://automationfc.wordpress.com/wp-admin");
	}

	@Test
	public void Validate_01_EmptyEmail() {
	}

	@Test
	public void Validate_02_InvalidEmail() {
	}

	@Test
	public void Validate_03_EmailNotExist() {
	}

	@Test
	public void Validate_04_EmptyPassword() {
	}

	@Test
	public void Validate_05_PasswordLessThan6Chars() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
