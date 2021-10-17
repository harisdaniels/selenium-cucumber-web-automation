# This Is My Sample Project of Web Automation Testing Using Java, Selenium, and Cucumber

## Project Information
For this project, i use: 
- Java Programming Language (https://www.oracle.com/java/)
- Selenium Framework (https://www.selenium.dev/)
- Cucumber Software Tool (https://cucumber.io/docs)
- JUnit (https://junit.org/junit4/)
- Eclipse IDE (https://www.eclipse.org/ide/)
- Website (https://admin-demo.nopcommerce.com/login)

### Java Programming Language
Java is the #1 programming language and development platform. It reduces costs, shortens development timeframes, drives innovation, and improves application services. 
With millions of developers running more than 51 billion Java Virtual Machines worldwide, Java continues to be the development platform of choice for enterprises and developers.

### Selenium Framework
Selenium is a portable framework for testing web applications. 
Selenium provides a playback tool for authoring functional tests without the need to learn a test scripting language.

### Cucumber Software Tool
Cucumber is a software tool that supports behavior-driven development. 
Central to the Cucumber BDD approach is its ordinary language parser called Gherkin. 
It allows expected software behaviors to be specified in a logical language that customers can understand.

### JUnit
JUnit is a simple framework to write repeatable tests. It is an instance of the xUnit architecture for unit testing frameworks.

### Eclipse IDE
The Eclipse IDE is famous for our Java Integrated Development Environment (IDE), but we have a number of pretty cool IDEs, including our C/C++ IDE, JavaScript/TypeScript IDE, PHP IDE, and more.
You can easily combine multiple languages support and other features into any of our default packages, and the Eclipse Marketplace allows for virtually unlimited customization and extension.

## Preparation

### Clone Repo
- Clone from this repo https://github.com/harisdaniels/selenium-cucumber-web-automation.git
- The steps of cloning Github Repository to your Eclipse IDE can be found [here](https://www.youtube.com/watch?v=z8BKGUxFdM4)

## Test Structure
- Use Gherkin syntax: a set of special [keywords](https://cucumber.io/docs/gherkin/reference/#keywords) to give structure and meaning to executable specifications.
  Each keyword is translated to many spoken languages; in this reference I will use English.
  Either spaces or tabs may be used for indentation. The recommended indentation level is two spaces. Here is an example:
  
  ```
  Feature: Login page feature admin-demo.nopcommerce.com

  Background: Steps to Login Page
    Given Admin opens URL "https://admin-demo.nopcommerce.com/login"

  Scenario: Successful Login Because Admin Inputs Valid Credentials (Positive)
    When Admin inputs Email as "admin@yourstore.com" and Password as "admin"
    And Admin clicks Checkbox also clicks on Login button
    Then Page title should be "Dashboard / nopCommerce administration"
    When Admin clicks on Logout link
    Then Page title should be "Your store. Login"
  ```
  
- Use Step Definition is a Java method with an [expression](https://cucumber.io/docs/cucumber/step-definitions/#expressions) that links it to one or more Gherkin steps. 
When Cucumber executes a Gherkin step in a scenario, it will look for a matching step definition to execute.
To illustrate how this works, look at the following Gherkin Scenario step definition:

  ```
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

	@And("Admin clicks Checkbox also clicks on Login button")
	public void admin_clicks_checkbox_also_clicks_on_login_button() {
	   loginPage.clickRememberMeCheckBox();
	   loginPage.clickLoginButton();
	}
	
	@Then("Page title should be {string}")
	public void page_title_should_be(String expectedTitle) {
	   Assert.assertEquals(expectedTitle, DriverFactory.getDriver().getTitle());
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
  ```
- Use `TestRunner` class. To [run](https://support.smartbear.com/testleft/docs/bdd/tutorial/cucumber/get-stubs.html) your BDD test, you must use one of the available runners. In this project, I will use JUnit, but you can use any other.
  - Create a new JUnit class And Add the following annotations to the class:
  
  ```
  package TestRunners;
  
  import org.junit.runner.RunWith;
  
  import io.cucumber.junit.Cucumber;
  import io.cucumber.junit.CucumberOptions;
  
  @RunWith(Cucumber.class)
  @CucumberOptions(
      features = {"src/test/resources/features/"},
      glue = {"hooks", "stepdefinitions"},
      plugin = {"pretty"},
      dryRun = false,
      monochrome = true
      )
  public class TestRunner {
  
  }
  ```

## Run Test

In Eclipse IDE, run your test and generating Cucumber Report at once, you can hover your cursor to `TestRunner.java` file, then right-click, click `Run As 1 JUnit Test`.
![Screenshot_1](https://user-images.githubusercontent.com/74105380/130410878-c7007df7-9543-42d9-b193-f44601234426.jpg)

### The Test will run
![Screenshot_3](https://user-images.githubusercontent.com/74105380/130412424-3a484e97-c050-41f0-93d4-fc0deed31acd.jpg)



## Test Report by Cucumber Report

After run the test, you can also see the result of the test by copy-paste the link in the console.
![Screenshot_4](https://user-images.githubusercontent.com/74105380/130412739-203ce828-40df-4827-b19b-78ee515f26cc.jpg)


### Test Report Sample
![Screenshot_7](https://user-images.githubusercontent.com/74105380/130414584-7ef56858-697c-4537-966a-77c924eaaefc.jpg)
The result will be like this.



# All is Done!
