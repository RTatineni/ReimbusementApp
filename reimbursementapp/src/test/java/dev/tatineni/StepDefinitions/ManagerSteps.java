package dev.tatineni.StepDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ManagerSteps {
	
	WebDriver driver = null;
	
	@Given("^browser is open$")
	public void browser_is_open() throws Throwable {
	   System.setProperty("webdriver.chrome.driver","C:\\Users\\Raj\\eclipse-workspace\\reimbursementapp\\src\\test\\resources\\Drivers\\chromedriver.exe");
	   driver = new ChromeDriver();
	   driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	   driver.manage().timeouts().pageLoadTimeout(25,TimeUnit.SECONDS );
	   
	}

	@And("^user is on login page$")
	public void user_is_on_login_page() throws Throwable {
	   driver.navigate().to("http://localhost:7000/");
	}

	@When("^user enters username and password and selects login type$")
	public void user_enters_username_and_password_and_selects_login_type() throws Throwable {
	    // Enter username
		driver.findElement(By.id("txtUsername")).sendKeys("user1");
		// Enter password
		driver.findElement(By.id("txtPassword")).sendKeys("password1");

		// Select login as Manager
		WebElement element = driver.findElement(By.id("managerLogin"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();

	}

	@And("^user clicks on login$")
	public void user_clicks_on_login() throws Throwable {
		// btnLogin
		Thread.sleep(5000);
		driver.findElement(By.id("btnLogin")).click();
		
	}
	
	@And("^user approves form and note and submits approval$")
	public void user_approves_form_and_note_and_sumbits_approval() throws Throwable{
		// selecting approve radio button
		
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.cssSelector("input[class='approvalSelect'"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();
	
		Thread.sleep(5000);
	
		// Adding a note
		
		driver.findElement(By.cssSelector("input[class='validate'")).sendKeys("this is a valid reason");
		//Actions actionsNote = new Actions(driver);
		//actionsNote.moveToElement(elementNote).click().build().perform();
		
		Thread.sleep(5000);
		
		// submitting the approval
		driver.findElement(By.id("submitApproval")).click();

		
		Thread.sleep(2000);
		
//		WebElement element = driver.findElement(By.id("managerLogin"));
//		Actions actions = new Actions(driver);
//		actions.moveToElement(element).click().build().perform();
		

	}

	@Then("^user navigates to the employee or manager page$")
	public void user_navigates_to_the_employee_or_manager_page() throws Throwable {
		driver.close();
		driver.quit();
	    
	}
}
