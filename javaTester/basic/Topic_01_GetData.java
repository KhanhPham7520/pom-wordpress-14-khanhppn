package basic;

import org.openqa.selenium.WebDriver;

public class Topic_01_GetData {

	public static void main(String[] args) {
		getTitle();
		getTitles();
	}

	public void openURL(WebDriver driver, String urlValue) {
		driver.get(urlValue);
	}

	public static void getTitle() {
		String title = "Automation Testing";
		System.out.println(title);
	}

	public static String getTitles() {
		String title = "Automation Testing 2";
		System.out.println(title);
		return title;
	}
}
