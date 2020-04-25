package pageObjects.bankGuru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.bankGuru.RegisterPageUI;

public class RegisterPageObject extends AbstractPage {
	WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToEmailTextbox(String inputValue) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_ID_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.EMAIL_ID_TEXTBOX, inputValue);
	}

	public void clickToSubmitButton() {
		waitForElementClickable(driver, RegisterPageUI.SUBMIT_BUTTON);
		clickToElement(driver, RegisterPageUI.SUBMIT_BUTTON);
	}

	public String getUserIDText() {
		return getTextElement(driver, RegisterPageUI.USER_ID_TEXT);
	}

	public String getPasswordText() {
		return getTextElement(driver, RegisterPageUI.PASSWORD_TEXT);
	}

	public void openLoginPage(String string) {
		// TODO Auto-generated method stub

	}

}
