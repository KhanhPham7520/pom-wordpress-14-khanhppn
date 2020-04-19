package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.DashboardPageUI;

public class DashboardPageObject extends AbstractPage {

	public DashboardPageObject(WebDriver driver) {
		super(driver);
	}

	private WebDriver driver;

	public boolean isHeaderTextDisplayed() {
		return isElementDisplay(DashboardPageUI.HEADER_DASHBOARD);
	}

}
