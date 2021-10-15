package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginPageSteps {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	
	@Given("Admin opens URL {string}")
	public void admin_opens_url(String url) {
		DriverFactory.getDriver().get(url);
	}

	@When("Admin inputs Email as {string} and Password as {string}")
	public void admin_input_email_as_and_password_as(String email, String password) {
		loginPage.clearEmailField();
	    loginPage.enterEmail(email);
	    
	    loginPage.clearPasswordField();
	    loginPage.enterPassword(password);
	}

	@When("Admin clicks on Logout link")
	public void admin_clicks_on_logout_link() {
		try {
			Thread.sleep(3000);
			loginPage.clickLogoutLink();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@When("Admin inputs Valid Email as {string} and does NOT input Password")
	public void admin_input_email_as_and_does_not_input_password(String email) {
		loginPage.clearEmailField();
	    loginPage.enterEmail(email);
	    
	    loginPage.clearPasswordField();
	}
	
	@When("Admin inputs Invalid Email as {string} and does NOT input Password")
	public void admin_input_invalid_email_as_and_does_not_input_password(String email) {
		loginPage.clearEmailField();
	    loginPage.enterEmail(email);
	    
	    loginPage.clearPasswordField();
	}
	
	@When("Admin does NOT input anything on Email field and Password field")
	public void admin_does_not_input_anything_on_email_field_and_password_field() {
		loginPage.clearEmailField();
		loginPage.clearPasswordField();
	}
	
	@When("Admin does NOT input Email but inputs Password as {string}")
	public void admin_does_not_input_email_but_inputs_password_as(String password) {
		loginPage.clearEmailField();
	    
	    loginPage.clearPasswordField();
	    loginPage.enterPassword(password);
	}
	
	@When("Admin inputs wrong Email Format but inputs Valid Password as {string}")
	public void admin_inputs_wrong_email_format_but_input_valid_password_as(String password) {
	    loginPage.clearEmailField();
	    
	    String wrongEmailFormat = loginPage.randomString();
	    loginPage.enterEmail(wrongEmailFormat);
	    
	    loginPage.clearPasswordField();
	    loginPage.enterPassword(password);
	}

	@And("Admin clicks Checkbox also clicks on Login button")
	public void admin_clicks_checkbox_also_clicks_on_login_button() {
	    loginPage.clickRememberMeCheckBox();
	    loginPage.clickLoginButton();
	}
	
	@Then("Page title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		Assert.assertEquals(expectedTitle, DriverFactory.getDriver().getTitle());
	}
	
	@Then("Error message {string} should be displayed")
	public void error_message_should_be_displayed(String expectedMessageError) {
		try {
			Thread.sleep(1000);
			String messageError = DriverFactory.getDriver().findElement(By.className("message-error")).getText();
			String actualMessageError = messageError.replace("\n", " ");
			System.out.println(actualMessageError);
			Assert.assertEquals(expectedMessageError, actualMessageError);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Then("Email error message {string} should be displayed")
	public void email_error_message_should_be_displayed(String expectedEmailError) {
		try {
			Thread.sleep(1000);
			String actualEmailError = DriverFactory.getDriver().findElement(By.id("Email-error")).getText();
			System.out.println(actualEmailError);
			Assert.assertEquals(expectedEmailError, actualEmailError);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
