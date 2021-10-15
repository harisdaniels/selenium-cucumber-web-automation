package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddCustomerPage;

public class AddCustomerPageSteps {
	
	private AddCustomerPage addCustomer;

	@Then("Admin can view {string} page")
	public void admin_can_view_the_page(String expectedTitle) {
	    addCustomer = new AddCustomerPage(DriverFactory.getDriver());
	    Assert.assertEquals(expectedTitle, addCustomer.getTitle());
	}

	@When("Admin clicks on Customers Menu")
	public void admin_clicks_on_customers_menu() {
	    addCustomer.clickCustomerMenu();
	}

	@And("Admin clicks on Customers Menu Item")
	public void admin_clicks_on_customers_menu_item() {
	    addCustomer.clickCustomerMenuItem();
	}

	@When("Admin clicks on Add New button")
	public void admin_clicks_on_add_new_button() {
		addCustomer.clickAddNewButton();
	}

	@When("Admin inputs customer info")
	public void admin_input_customer_info() {
		String email = addCustomer.randomString() + "@gmail.com";
	    addCustomer.inputEmail(email);
	    addCustomer.inputPassword("test123");
	    
	    addCustomer.inputFirstName("Otong");
	    addCustomer.inputLastName("Surotong");
	    addCustomer.chooseGender("Male");
	    addCustomer.setDOB("1/1/1970");
	    addCustomer.inputCompanyName("Otong inc");
	    addCustomer.clickTaxExempt();
	    addCustomer.chooseNewsLetter("test sToRe 2");
	    addCustomer.chooseCustomerRoles("gUeSts");
	    addCustomer.chooseManagerVendor("Vendor 1");
	    addCustomer.setAdminComment("This is for Testing");
	}
	
	@When("Admin inputs customer info with registered email {string}")
	public void admin_input_customer_info_with_registered_email(String email) {
		addCustomer.inputEmail(email);
	    addCustomer.inputPassword("test123");
	    
	    addCustomer.inputFirstName("Victoria");
	    addCustomer.inputLastName("Terces");
	    addCustomer.chooseGender("Female");
	    addCustomer.setDOB("12/31/1980");
	    addCustomer.inputCompanyName("test ltd");
	    addCustomer.clickTaxExempt();
	    addCustomer.chooseNewsLetter("Test store 2");
	    addCustomer.chooseCustomerRoles("regIsTered");
	    addCustomer.chooseManagerVendor("Vendor 2");
	    addCustomer.setAdminComment("This is for Testing");
	}
	
	@When("Admin inputs customer info without inputing email")
	public void admin_input_customer_info_without_inputing_email() {
		
		addCustomer.inputPassword("test123");
	    
	    addCustomer.inputFirstName("Ucup");
	    addCustomer.inputLastName("Surucup");
	    addCustomer.chooseGender("Male");
	    addCustomer.setDOB("12/1/1970");
	    addCustomer.inputCompanyName("Ucup ltd");
	    addCustomer.clickTaxExempt();
	    addCustomer.chooseNewsLetter("Your sTore naMe");
	    addCustomer.chooseCustomerRoles("regIsTered");
	    addCustomer.chooseManagerVendor("Not a vendor");
	    addCustomer.setAdminComment("This is for Testing");
	}
	
	@When("Admin inputs customer info with inputing Wrong email format")
	public void admin_input_customer_info_with_inputing_wrong_email_format() {
		String wrongEmailFormat = addCustomer.randomString();
	    addCustomer.inputEmail(wrongEmailFormat);
	    addCustomer.inputPassword("test123");
	    
	    addCustomer.inputFirstName("Otong");
	    addCustomer.inputLastName("Surotong");
	    addCustomer.chooseGender("Male");
	    addCustomer.setDOB("12/11/1977");
	    addCustomer.inputCompanyName("Otong inc");
	    addCustomer.clickTaxExempt();
	    addCustomer.chooseNewsLetter("Test store 2");
	    addCustomer.chooseCustomerRoles("Guests");
	    addCustomer.chooseManagerVendor("Vendor 1");
	    addCustomer.setAdminComment("This is for Testing");
	}
	
	@When("Admin inputs customer info with Wrong Customer Role")
	public void admin_input_customer_info_with_wrong_customer_role() {
		String email = addCustomer.randomString() + "@gmail.com";
	    addCustomer.inputEmail(email);
	    addCustomer.inputPassword("test123");
	    
	    addCustomer.inputFirstName("Otong");
	    addCustomer.inputLastName("Surotong");
	    addCustomer.chooseGender("Male");
	    addCustomer.setDOB("1/1/1970");
	    addCustomer.inputCompanyName("Otong inc");
	    addCustomer.clickTaxExempt();
	    addCustomer.chooseNewsLetter("Test store 2");
	    addCustomer.chooseCustomerRoles("Forum Moderators");
	    addCustomer.chooseManagerVendor("Vendor 1");
	    addCustomer.setAdminComment("This is for Testing");
	}

	@And("Admin clicks on Save button")
	public void admin_clicks_on_save_button() {
		addCustomer.clickOnSaveButton();
	}

	@Then("Admin can view confirmation message {string}")
	public void admin_can_view_confirmation_message(String expectedMessage) {
	    String actualMessage = DriverFactory.getDriver().findElement(By.className("alert")).getText().trim();
	    System.out.println(actualMessage);
	    Assert.assertTrue(actualMessage.contains(expectedMessage));	    
	}
	
	@Then("Admin can view Error message {string}")
	public void admin_can_view_error_message(String expectedMessage) {
		String actualMessage = DriverFactory.getDriver().findElement(By.className("validation-summary-errors")).getText().trim();
		System.out.println(actualMessage);
		Assert.assertEquals(expectedMessage, actualMessage);
	}
	
	@Then("Admin can view Error message {string} and {string}")
	public void admin_can_view_error_message_and(String expectedMessage, String expectedValidationError) {
		String actualMessage = DriverFactory.getDriver().findElement(By.className("alert")).getText().trim();
	    System.out.println(actualMessage);
	    Assert.assertTrue(actualMessage.contains(expectedMessage));
	    
	    String actualValidationError = DriverFactory.getDriver().findElement(By.className("field-validation-error")).getText();
	    System.out.println(actualValidationError);
	    Assert.assertEquals(expectedValidationError, actualValidationError);
	}
	
}
