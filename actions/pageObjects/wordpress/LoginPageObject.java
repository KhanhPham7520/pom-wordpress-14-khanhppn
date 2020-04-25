package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.LoginPageUI;

public class LoginPageObject extends AbstractPage {

	public LoginPageObject(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private WebDriver driver;

	public void inputToEmailTextbox(String inputValue) {
		sendKeyToElement(LoginPageUI.EMAIL_TEXTBOX, inputValue);
	}

	public void clickToContinueButton() {
		clickToElement(LoginPageUI.CONTINUE_BUTTON);
	}

	public void clickToLoginButton() {
		clickToElement(LoginPageUI.LOGIN_BUTTON);
	}

	public String getEmailErrorMessage() {
		return getTextElement(LoginPageUI.VALIDATION_ERROR_MSG);
	}

	public boolean isDisplayMessageError() {
		return isElementDisplay(LoginPageUI.VALIDATION_ERROR_MSG);
	}

	public void inputToPasswordTextbox(String passwordValue) {
		sendKeyToElement(LoginPageUI.PASSWORD_TEXTBOX, passwordValue);
	}

}
