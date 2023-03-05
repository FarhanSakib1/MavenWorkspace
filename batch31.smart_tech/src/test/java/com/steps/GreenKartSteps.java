package com.steps;



import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.pages.GreenKartPages;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GreenKartSteps {
	WebDriver driver; 
	List<Integer> prices = new ArrayList<Integer>();
	GreenKartPages pf;
		
	@Given("^User go to the GreenKart Home Page$")
	public void user_go_to_the_GreenKart_Home_Page() throws Throwable {
		driver = new ChromeDriver();
		driver.get(" https://rahulshettyacademy.com/seleniumPractise/#/");
	    driver.manage().window().maximize();
	    pf = new GreenKartPages(driver);
	    
	}

	@Given("^User Verify the page title$")
	public void user_Verify_the_page_title() throws Throwable {
		String actual = driver.getTitle();
		String expected = "GreenKart - veg and fruits kart";
		//System.out.println(actual);
	   Assert.assertTrue("The title doesnt match", actual.contains(expected));
	}

	@When("^User capture all items from page$")
	public void user_capture_all_items_from_page() throws Throwable {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		List<WebElement> elements = pf.getAllPrices();//driver.findElements(By.xpath("//p[@class='product-price']|//h1")); //driver.findElements(By.xpath("//p[@class='product-price']|//h1"));//p[@class='product-price']|//h1     //div/div/div/div/p //*[@class='product-price']
		for (WebElement element : elements) {
			String price = element.getText();
			int priceInt = Integer.parseInt(price);
			prices.add(priceInt);
		}
	   
	}

	@When("^Print sorted prices in descending order$")
	public void print_sorted_prices_in_descending_order() throws Throwable {
		Collections.sort(prices, Collections.reverseOrder());
		System.out.println(prices); 
	   
	}

	@When("^Add second and third items into cart$")
	public void add_second_and_third_items_into_cart() throws Throwable {
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   int secondprice = prices.get(1);
	   int thirdprice = prices.get(2);
	   WebElement etwo = driver.findElement(By.xpath(("//*[contains(@class, 'product-price') and contains( text(),'" + secondprice +"'  )]/following-sibling::*/button")));
	   WebElement ethree = driver.findElement(By.xpath(("//*[contains(@class, 'product-price') and contains( text(),'" + thirdprice +"'  )]/following-sibling::*/button")));
		etwo.click();
		ethree.click();
	   
	}

	@Then("^User go to cart page$")
	public void user_go_to_cart_page() throws Throwable {
	  pf.getCartIcon().click(); //driver.findElement(By.xpath("//*[@class='cart-icon']")).click();
	  pf.getCheckout().click(); //driver.findElement(By.xpath("//*[contains(text(), 'PROCEED TO CHECKOUT')]")).click();
	   
	}

	@Then("^User Verify total price$")
	public void user_Verify_total_price() throws Throwable {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		int secondprice = prices.get(1);
		int thirdprice = prices.get(2);
	   String totalprice = pf.getTotAmt(); //driver.findElement(By.xpath("//*[@class='totAmt']")).getText(); 
	   int totPrice = Integer.parseInt(totalprice);
	   int totAdd = secondprice + thirdprice;
//	   System.out.println(totPrice);
//	   System.out.println(totAdd);
	   
   
	   if (totPrice == totAdd) {
		    System.out.println("Prices are equal.");
		} else {
		    System.out.println("Prices are not equal.");
		}
	   
	}

	@Then("^User go to next page to select country \"([^\"]*)\"$")
	public void user_go_to_next_page_to_select_country(String arg1) throws Throwable {
		pf.getOrder().click();//driver.findElement(By.xpath("//*[contains(text(), 'Place Order')]")).click();
		pf.getCountry().click();//driver.findElement(By.xpath("//*[@value='United States']")).click();
		pf.getCheck().click();//driver.findElement(By.xpath("//*[@type='checkbox']")).click();
		pf.getCont().click();//driver.findElement(By.xpath("//button[text()='Proceed']")).click();
		
			}
	@Then("^User verify item was successfully shipped \"([^\"]*)\"$")
	public void user_verify_item_was_successfully_shipped(String arg1) throws Throwable {
	    
	    
	
//	@Then("^User verify item was successfully shipped$")
//	public void user_verify_item_was_successfully_shipped() throws Throwable {
//		Thread.sleep(3000);
		String verify = pf.getFin();//driver.findElement(By.xpath("//*[contains(text(), 'Thank you, your order has been placed successfully')]")).getText().trim();
//		WebElement verify = driver.findElement(By.xpath("//*[contains(text(), 'Thank you, your order has been placed successfully')]"));
//		String  text = verify.getText();
//		Thread.sleep(3000);
//		System.out.println(verify);
//		Assert.assertEquals(verify,"Thank you, your order has been placed successfully\r\n"
//				+ "You'll be redirected to Home page shortly!!");
//		System.out.println("Thank you, your order has been placed successfully");
//		System.out.println(verify);
//		Assert.assertTrue("The Order has not been placed",verify.contains(arg1));
		

		 if (arg1.contains("Thank you, your order has been placed successfully")) {
	            System.out.println("Order Placed Successfully");
	        } 
		 else {
	            System.out.println("Order Placed unsuccessfully");
	        }
		 
   driver.close();
	   
	}
}


