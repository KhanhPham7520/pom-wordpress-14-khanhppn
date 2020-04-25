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

	public void openUrl(WebDriver driver, String urlValue) {
		driver.get(urlValue);
	}

	public String getSelectedItemInDropdown() {
		return null;
	}

	public By byXpathLocator(String locator) {
		return By.xpath(locator);
	}

	public WebElement findElementByXpath(WebDriver driver, String locator) {
		return driver.findElement(byXpathLocator(locator));
	}

	public void sendKeyToElement(WebDriver driver, String locator, String inputValue) {
		waitForElementVisible(driver, locator);
		clearExistedValue(driver, locator);
		findElementByXpath(driver, locator).sendKeys(inputValue);
	}

	public void clickToElement(WebDriver driver, String locator) {
		waitForElementClickable(driver, locator);
		findElementByXpath(driver, locator).click();
	}

	public String getAttributeValue(WebElement elementValue, String locator, String attributeType) {
		elementValue = findElementByXpath(driver, locator);
		return elementValue.getAttribute(attributeType);
	}

	public void selectItemInDropdown(WebDriver driver, String locator, String selectValue) {
		select = new Select(findElementByXpath(driver, locator));
		select.selectByVisibleText(selectValue);
	}

	public String getTextElement(WebDriver driver, String locator) {
		return findElementByXpath(driver, locator).getText();
	}

	public void checkTheCheckbox(WebDriver driver, String locator) {
		boolean checkTheCheckbox = findElementByXpath(driver, locator).isSelected();
		if (!checkTheCheckbox) {
			findElementByXpath(driver, locator).click();
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

	public void clearExistedValue(WebDriver driver, String locator) {
		findElementByXpath(driver, locator).clear();
	}

	public boolean isElementDisplay(WebDriver driver, String locator) {
		waitForElementVisible(driver, locator);
		return findElementByXpath(driver, locator).isDisplayed();
	}

}
