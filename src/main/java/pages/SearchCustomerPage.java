package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.WaitHelper;

public class SearchCustomerPage {
	
	private WaitHelper waitHelper;
	private WebDriver driver;
	
	//1. By Locators
	By searchEmailField = By.id("SearchEmail");
	By searchFirstNameField = By.id("SearchFirstName");
	By searchLastNameField = By.id("SearchLastName");
	By searchButton = By.id("search-customers");
	
	
	//2. Constructor
	public SearchCustomerPage(WebDriver driver) {
		this.driver = driver;
		waitHelper = new WaitHelper(driver);
	}
	
	// 3. Page Actions
	public void searchByEmail(String email) {
		waitHelper.waitForElement(driver.findElement(searchEmailField), 30);
		driver.findElement(searchEmailField).clear();
		driver.findElement(searchEmailField).sendKeys(email);
	}
	
	public void searchByFirstName(String firstName) {
		waitHelper.waitForElement(driver.findElement(searchFirstNameField), 30);
		driver.findElement(searchFirstNameField).clear();
		driver.findElement(searchFirstNameField).sendKeys(firstName);
	}
	
	public void searchByLastName(String lastName) {
		waitHelper.waitForElement(driver.findElement(searchLastNameField), 30);
		driver.findElement(searchLastNameField).clear();
		driver.findElement(searchLastNameField).sendKeys(lastName);
	}
	
	public void clickSearchButton() {
		driver.findElement(searchButton).click();
		waitHelper.waitForElement(driver.findElement(searchButton), 30);
	}
	
	
	public boolean searchCustomerByEmail(String email) {
		WebElement table = driver.findElement(By.xpath("//table[@id='customers-grid']/tbody"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		boolean flag = false; // Not Found
		
		for (int row = 1; row <= rows.size(); row ++) {
			String getEmail = driver.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+row+"]/td[2]")).getText();
			System.out.println(getEmail);
			
			if (getEmail.equals(email)) {
				flag = true; // Found
				break;
			}			
		}
		return flag;
	}
	
	public boolean searchCustomerByName(String firstName, String lastName) {
		WebElement table = driver.findElement(By.xpath("//table[@id='customers-grid']/tbody"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		boolean flag = false;
		
		for (int row = 1; row <= rows.size(); row ++) {
			String name = driver.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+row+"]/td[3]")).getText();
			System.out.println(name);
			
			String[] names = name.split(" "); // separate first name & last name
			
			if (names[0].equals(firstName) && names[1].equals(lastName)) {
				flag = true;
				break;
			}			
		}
		return flag;
	}

}
