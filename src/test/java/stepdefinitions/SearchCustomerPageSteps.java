package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SearchCustomerPage;

public class SearchCustomerPageSteps {
	
	private SearchCustomerPage searchCustomer;
	
	@When("Admin inputs Customer Email")
	public void admin_inputs_customer_email() {
		searchCustomer = new SearchCustomerPage(DriverFactory.getDriver());
		searchCustomer.searchByEmail("brenda_lindgren@nopCommerce.com");
	}
	
	@When("Admin inputs Customer First Name")
	public void admin_inputs_customer_first_name() {
		searchCustomer = new SearchCustomerPage(DriverFactory.getDriver());
		searchCustomer.searchByFirstName("Arthur");
	}

	@When("Admin inputs Customer Last Name")
	public void admin_inputs_customer_last_name() {
		searchCustomer.searchByLastName("Holmes");
	}
	
	@When("Admin inputs Customer Unavailable Email {string}")
	public void admin_inputs_customer_unavailable_email(String email) {
		searchCustomer = new SearchCustomerPage(DriverFactory.getDriver());
		searchCustomer.searchByEmail(email);
	}
	
	@When("Admin inputs Customer First Name {string}")
	public void admin_inputs_customer_first_name(String firstName) {
		searchCustomer = new SearchCustomerPage(DriverFactory.getDriver());
		searchCustomer.searchByFirstName(firstName);
	}

	@When("Admin inputs Customer Last Name {string}")
	public void admin_inputs_customer_last_name(String lastName) {
		searchCustomer.searchByLastName(lastName);
	}

	@And("Admin clicks on Search button")
	public void admin_clicks_on_search_button() {
		searchCustomer.clickSearchButton();
	}

	@Then("Admin should find Email in the Search table")
	public void admin_should_find_email_in_the_search_table() {
		boolean status = searchCustomer.searchCustomerByEmail("brenda_lindgren@nopCommerce.com");
		Assert.assertEquals(true, status);
	}
	
	@Then("Admin should find their Name in the Search table")
	public void admin_should_find_their_name_in_the_search_table() {
		boolean status = searchCustomer.searchCustomerByName("Arthur", "Holmes");
		Assert.assertEquals(true, status);
	}
	
	@Then("{string} message should be displayed")
	public void message_should_be_displayed(String expectedNoDataAvailable) {
		try {
			Thread.sleep(1000);
			String actualNoDataAvailable = DriverFactory.getDriver().findElement(By.className("dataTables_empty")).getText();
			Assert.assertEquals(expectedNoDataAvailable, actualNoDataAvailable);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
