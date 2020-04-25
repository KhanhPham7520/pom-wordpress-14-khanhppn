package commons;

public class GlobalConstants {

	public static final String rootFolderPath = System.getProperty("user.dir");

	// Firefox driver path
	public static final String FIREFOX_DRIVER_SYSTEM_KEY = "webdriver.gecko.driver";
	public static final String FIREFOX_DRIVER_SYSTEM_VALUE = rootFolderPath + "/browserDrivers/geckodriver";

	// Chrome driver path
	public static final String CHROME_DRIVER_SYSTEM_KEY = "webdriver.chrome.driver";
	public static final String CHROME_DRIVER_SYSTEM_VALUE = rootFolderPath + "/browserDrivers/chromedriver.exe";
	public static final String CHROME_DRIVER_SYSTEM_VALUE_LOCAL = "/Users/apple/Desktop/chromedriver";

	// Common message in Search Product Page
	public static final String NO_PRODUCT_WERE_FOUND_CRITERIA_MESSAGE = "No products were found that matched your criteria.";
	public static final long SHORT_TIMEOUT = 5;

	// Login official Info
	public static final String CORRECT_USERNAME = "phamphannhatkhanh7520@gmail.com";
	public static final String CORRECT_PASSWORD = "foster1994";

	// Link Bank Guru
	public static final String LOGIN_PAGE_URL_BANKGURU = "http://demo.guru99.com/v4/";
}
