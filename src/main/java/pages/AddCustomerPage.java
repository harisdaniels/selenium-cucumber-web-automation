package pages;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.WaitHelper;

public class AddCustomerPage {

	private WaitHelper waitHelper;
	private WebDriver driver;
	
	//1. Locators
	By linkCustomersMenu = By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/a");
	By linkCustomersMenuItem = By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/ul/li[1]/a");
	
	By addNewCustomerButton = By.xpath("/html/body/div[3]/div[1]/form[1]/div/div/a");
	By customerInfo = By.xpath("//*[@id=\"customer-info\"]/div[1]/div[2]/button");
	
	By textEmail = By.xpath("//*[@id=\"Email\"]");
	By textPassword = By.xpath("//*[@id=\"Password\"]");
	
	By firstName = By.id("FirstName");
	By lastName = By.id("LastName");
	
	By genderMale = By.id("Gender_Male");
	By genderFemale = By.id("Gender_Female");
	
	By DOB = By.xpath("//*[@id=\"DateOfBirth\"]");
	By companyName = By.xpath("//*[@id=\"Company\"]");
	
	By taxExempt = By.xpath("//*[@id=\"IsTaxExempt\"]");
	
	By newsLetters = By.xpath("//*[@id=\"customer-info\"]/div[2]/div[9]/div[2]/div/div[1]/div/div");
	By yourStoreName = By.xpath("//li[contains(text(), 'Your store name')]");
	By testStore2 = By.xpath("//li[contains(text(), 'Test store 2')]");
	
	
	By customerRoles = By.xpath("//*[@id=\"customer-info\"]/div[2]/div[10]/div[2]/div/div[1]/div/div");
	By listItemGuests = By.xpath("//li[contains(text(), 'Guests')]");
	By listItemRegistered = By.xpath("//li[contains(text(), 'Registered')]");
	By listItemAdministrators = By.xpath("//li[contains(text(), 'Administrators')]");
	By listItemForumModerators = By.xpath("//li[contains(text(), 'Forum Moderators')]");
	By listItemVendors = By.xpath("//li[contains(text(), 'Vendors')]");
	
	By dropDownManagerVendor = By.xpath("//*[@id='VendorId']");	
	
	By adminComment = By.xpath("//*[@id=\"AdminComment\"]");
	By buttonSave = By.xpath("//button[@name='save']");
	
	

	//2. Constructor
	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
		waitHelper = new WaitHelper(driver);
	}
	
	//3. Page Actions
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public void clickCustomerMenu() {
		waitHelper.waitForElement(driver.findElement(linkCustomersMenu), 30);
		driver.findElement(linkCustomersMenu).click();
	}
	
	public void clickCustomerMenuItem() {
		waitHelper.waitForElement(driver.findElement(linkCustomersMenuItem), 30);
		driver.findElement(linkCustomersMenuItem).click();
	}
	
	public void clickAddNewButton() {
		waitHelper.waitForElement(driver.findElement(addNewCustomerButton), 30);
		driver.findElement(addNewCustomerButton).click();
	}
	
	public void inputEmail(String email) {
		waitHelper.waitForElement(driver.findElement(textEmail), 30);
		driver.findElement(textEmail).sendKeys(email);
	}
	
	public void inputPassword(String password) {
		waitHelper.waitForElement(driver.findElement(textPassword), 30);
		driver.findElement(textPassword).sendKeys(password);
	}
	
	public void inputFirstName(String first_name) {
		waitHelper.waitForElement(driver.findElement(firstName), 30);
		driver.findElement(firstName).sendKeys(first_name);
	}
	
	public void inputLastName(String last_name) {
		waitHelper.waitForElement(driver.findElement(lastName), 30);
		driver.findElement(lastName).sendKeys(last_name);
	}
	
	public void chooseGender(String gender) {
		
		if(gender.toLowerCase().equals("Male".toLowerCase())) {
			driver.findElement(genderMale).click();
		}
		else if(gender.toLowerCase().equals("Female".toLowerCase())) {
			driver.findElement(genderFemale).click();
		}
		else {
			driver.findElement(genderMale).click();//Default
		}
		
	}
	
	public void setDOB(String dob) {
		waitHelper.waitForElement(driver.findElement(DOB), 30);
		driver.findElement(DOB).sendKeys(dob);
	}
	
	public void inputCompanyName(String compName) {
		waitHelper.waitForElement(driver.findElement(companyName), 30);
		driver.findElement(companyName).sendKeys(compName);
	}
	
	public void clickTaxExempt() {
		waitHelper.waitForElement(driver.findElement(taxExempt), 30);
		driver.findElement(taxExempt).click();
	}
	
	public void chooseNewsLetter(String newsLetter) {
		
		driver.findElement(newsLetters).click();
		
		WebElement listOfNewsLetter;
		
		try {
			Thread.sleep(2000);
			if (newsLetter.toLowerCase().equals("Your store name".toLowerCase())) {
				listOfNewsLetter = driver.findElement(yourStoreName);
			} else if (newsLetter.toLowerCase().equals("Test store 2".toLowerCase())){
				listOfNewsLetter = driver.findElement(testStore2);
			} else {
				listOfNewsLetter = driver.findElement(testStore2);
			}
			//listOfNewsLetter.click();
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", listOfNewsLetter);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void chooseCustomerRoles(String role) {
		
		driver.findElement(By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[2]")).click();	
		
		driver.findElement(customerRoles).click();
		
		WebElement listOfRoles;
		
		try {
			Thread.sleep(2000);
			if (role.toLowerCase().equals("Guests".toLowerCase())) {
				listOfRoles = driver.findElement(listItemGuests);
			} else if (role.toLowerCase().equals("Registered".toLowerCase())) {
				listOfRoles = driver.findElement(listItemRegistered);
			} else if (role.toLowerCase().equals("Administrators".toLowerCase())) {
				listOfRoles = driver.findElement(listItemAdministrators);
			} else if (role.toLowerCase().equals("Forum Moderators".toLowerCase())) {
				listOfRoles = driver.findElement(listItemForumModerators);
			} else if (role.toLowerCase().equals("Vendors".toLowerCase())) {
				listOfRoles = driver.findElement(listItemVendors);
			} else {
				listOfRoles = driver.findElement(listItemGuests);
			}
			
			//listOfRoles.click();
			//Thread.sleep(3000);
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", listOfRoles);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void chooseManagerVendor(String value) {
		waitHelper.waitForElement(driver.findElement(dropDownManagerVendor), 30);
		Select dropDown = new Select(driver.findElement(dropDownManagerVendor));
		dropDown.selectByVisibleText(value);
	}
	
	public void setAdminComment(String comment) {
		waitHelper.waitForElement(driver.findElement(adminComment), 30);
		driver.findElement(adminComment).sendKeys(comment);
	}
	
	public void clickOnSaveButton() {
		driver.findElement(buttonSave).click();
	}
	
	
	
	// For generating random string for email
	public String randomString() {
		String generateString = RandomStringUtils.randomAlphabetic(5);
		return generateString.toLowerCase();
	}
	
}
