package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;
	
	// ThreadLocal is used if you want to run in Parallel mode
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
		
	/**
	 * This method is used to initialize the threadlocal driver on the basis of given
	 * @param browser
	 * @return tl_driver
	 */
	public WebDriver initDriver(String browser) {
		
		System.out.println("Browser is " + browser);
		
		if(browser.equals("edge")) {		
			WebDriverManager.edgedriver().setup();
			tlDriver.set(new EdgeDriver());			
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		} else if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
		} else {
			System.out.println("Please pass the correct browser " + browser);
		}
		
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}
	
	/**
	 * This is used to get the driver with ThreadLocal
	 * @return
	 */
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
	
}
