package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.DashboardPageUI;

public class DashboardPageObject extends AbstractPage {
	WebDriver driver;

	public DashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isHeaderTextDisplayed() {
		return isElementDisplay(driver, DashboardPageUI.HEADER_DASHBOARD);
	}

}
