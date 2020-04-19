package commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
	WebDriver driver;
	WebDriverWait driverWait;
	private Select select;
	long timeOut = 15;

	public AbstractPage(WebDriver driver) {
		this.driver = driver;
	}

	public void openUrl(WebDriver driver, String urlValue) {
		driver.get(urlValue);
	}

	public String getSelectedItemInDropdown() {
		return null;
	}

	public By byXpathLocator(String locator) {
		return By.xpath(locator);
	}

	public WebElement findElementByXpath(String locator) {
		return driver.findElement(byXpathLocator(locator));
	}

	public void sendKeyToElement(String locator, String inputValue) {
		waitForElementVisible(driver, locator);
		clearExistedValue(locator);
		findElementByXpath(locator).sendKeys(inputValue);
	}

	public void clickToElement(String locator) {
		waitForElementClickable(driver, locator);
		findElementByXpath(locator).click();
	}

	public String getAttributeValue(WebElement elementValue, String locator, String attributeType) {
		elementValue = findElementByXpath(locator);
		return elementValue.getAttribute(attributeType);
	}

	public void selectItemInDropdown(String locator, String selectValue) {
		select = new Select(findElementByXpath(locator));
		select.selectByVisibleText(selectValue);
	}

	public String getTextElement(String locator) {
		return findElementByXpath(locator).getText();
	}

	public void checkTheCheckbox(String locator) {
		boolean checkTheCheckbox = findElementByXpath(locator).isSelected();
		if (!checkTheCheckbox) {
			findElementByXpath(locator).click();
		}
	}

	// Wait
	public void waitForElementPresence(WebDriver driver, String locator) {
		driverWait = new WebDriverWait(driver, timeOut);
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(byXpathLocator(locator)));
	}

	public void waitForElementClickable(WebDriver driver, String locator) {
		driverWait = new WebDriverWait(driver, timeOut);
		driverWait.until(ExpectedConditions.elementToBeClickable(byXpathLocator(locator)));
	}

	public void waitForElementVisible(WebDriver driver, String locator) {
		driverWait = new WebDriverWait(driver, timeOut);
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(byXpathLocator(locator)));
	}

	public void clearExistedValue(String locator) {
		findElementByXpath(locator).clear();
	}

	public boolean isElementDisplay(String locator) {
		waitForElementVisible(driver, locator);
		return findElementByXpath(locator).isDisplayed();
	}

}
