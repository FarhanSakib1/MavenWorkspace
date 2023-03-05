package com.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;




public class OpenBrowserSteps {
	
	static WebDriver driver;
	NewToursPages pf;
	@Given("^User go to New Tours home page$")
	public void user_go_to_New_Tours_home_page() throws Throwable {
		driver = new ChromeDriver();
	    driver.get("https://demo.guru99.com/test/newtours/index.php");
	    driver.manage().window().maximize();
	    pf = new NewToursPages(driver);
	    
	}

	@Given("^User click on the user name field$")
	public void user_click_on_the_user_name_field() throws Throwable {
		//driver.findElement(By.xpath("//*[@name='userName']")).click();
	    pf.getUsername().click();
	    
	}

	@When("^User type test username in username field$")
	public void user_type_test_username_in_username_field() throws Throwable {
		//driver.findElement(By.xpath("//*[@name='userName']")).sendKeys("jahidulusa");
	    pf.getUsername().sendKeys("jahidulusa");
	    
	}

	@When("^User click on the password field$")
	public void user_click_on_the_password_field() throws Throwable {
		//driver.findElement(By.xpath("//*[@name='password']")).click();
	    pf.getPasswword().click();
	    
	}

	@When("^User type test password in password field$")
	public void user_type_test_password_in_password_field() throws Throwable {
		//driver.findElement(By.xpath("//*[@name='password']")).click();
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys("123456");
	    
	}

	@Then("^User click on the loging button$")
	public void user_click_on_the_loging_button() throws Throwable {
		driver.findElement(By.xpath("//*[@name='submit']")).click();
	    
	}

	@Then("^User verify the text \"([^\"]*)\"$")
	public void user_verify_the_text(String expectedText) throws Throwable {
		String expected = expectedText;
		String actual = driver.findElement(By.xpath("//*[contains(text(),'Login Successfully')]")).getText();
		
		Assert.assertTrue("The text does not match expected", expected.contains(actual));
	    
	}

	
}
