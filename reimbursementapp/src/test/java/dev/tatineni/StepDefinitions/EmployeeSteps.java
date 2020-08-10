package dev.tatineni.StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class EmployeeSteps {
	
	WebDriver driver = null;

	@Given("^browser is opened$")
	public void browser_is_opened() throws Throwable {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Raj\\eclipse-workspace\\reimbursementapp\\src\\test\\resources\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(25,TimeUnit.SECONDS );
	   
	}

	@And("^user is on the login page$")
	public void user_is_on_the_login_page() throws Throwable {
		driver.navigate().to("http://localhost:7000/");
	}

	@When("^user enters username and password and selects employee login$")
	public void user_enters_username_and_password_and_selects_employee_login() throws Throwable {
		  // Enter username
		driver.findElement(By.id("txtUsername")).sendKeys("user2");
				// Enter password
		driver.findElement(By.id("txtPassword")).sendKeys("password2");

				// Select login as Employee
		WebElement element = driver.findElement(By.id("employeeLogin"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();
	}

	
	@And("^user clicks on login btn$")
	public void user_clicks_on_login_btn() throws Throwable {
		// btnLogin
		Thread.sleep(5000);
		driver.findElement(By.id("btnLogin")).click();
		
	}

	@When("^user fills out form and submits$")
	public void user_fills_out_form_and_submits() throws Throwable {
		Thread.sleep(2000);
		
		// Enter Reason
		driver.findElement(By.id("txtReason")).sendKeys("I have the flu");

		// Enter Amount
		driver.findElement(By.id("txtAmount")).sendKeys("200");

		Thread.sleep(2000);
		
		// Submit Reimbursement
		driver.findElement(By.id("btnReimbursement")).click();
		
		Thread.sleep(5000);
		

	}

	@Then("^browser is closed$")
	public void browser_is_closed() throws Throwable {
		
		Thread.sleep(5000);
		driver.close();
		driver.quit();
		
	   
	}



}
