package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.LoginPageUI;

public class LoginPageObject extends AbstractPage {

	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToEmailTextbox(String inputValue) {
		sendKeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, inputValue);
	}

	public void clickToContinueButton() {
		clickToElement(driver, LoginPageUI.CONTINUE_BUTTON);
	}

	public void clickToLoginButton() {
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
	}

	public String getEmailErrorMessage() {
		return getTextElement(driver, LoginPageUI.VALIDATION_ERROR_MSG);
	}

	public boolean isDisplayMessageError() {
		return isElementDisplay(driver, LoginPageUI.VALIDATION_ERROR_MSG);
	}

	public void inputToPasswordTextbox(String passwordValue) {
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, passwordValue);
	}

}
