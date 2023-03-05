package com.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class GreenKartPages {
	public GreenKartPages(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy (how =How.XPATH, using ="//p[@class='product-price']|//h1")
	private static List <WebElement> allPrices;

	@FindBy (how =How.XPATH, using ="//*[@class='cart-icon']")
	private static  WebElement cartIcon;
	
	@FindBy (how =How.XPATH, using ="//*[contains(text(), 'PROCEED TO CHECKOUT')]")
	private static  WebElement checkout;
	
	@FindBy (how =How.XPATH, using ="//*[@class='totAmt']")
	private static  WebElement totAmt;
	
	@FindBy (how =How.XPATH, using ="//*[contains(text(), 'Place Order')]")
	private static  WebElement order;
	
	@FindBy (how =How.XPATH, using ="//*[@value='United States']")
	private static  WebElement country;
	
	@FindBy (how =How.XPATH, using ="//*[@type='checkbox']")
	private static  WebElement check;
	
	@FindBy (how =How.XPATH, using ="//button[text()='Proceed']")
	private static  WebElement cont;
	
	@FindBy (how =How.XPATH, using ="//*[contains(text(), 'Thank you, your order has been placed successfully')]")
	private static  WebElement fin;
	
	
	


	
	
	public  List<WebElement> getAllPrices() {
		return allPrices;
	}
	public  void setAllPrices(List<WebElement> allPrices) {
		GreenKartPages.allPrices = allPrices;
	}
	
	
		

		public WebElement getCartIcon() {
		return cartIcon;
	}
	public static void setCartIcon(WebElement cartIcon) {
		GreenKartPages.cartIcon = cartIcon;
	}
	public  WebElement getCheckout() {
		return checkout;
	}
	public void setCheckout(WebElement checkout) {
		GreenKartPages.checkout = checkout;
	}
	public  String getTotAmt() {
		return totAmt.getText();
	}
	public void setTotAmt(WebElement totAmt) {
		GreenKartPages.totAmt = totAmt;
	}
	public  WebElement getOrder() {
		return order;
	}
	public void setOrder(WebElement order) {
		GreenKartPages.order = order;
	}
	public  WebElement getCountry() {
		return country;
	}
	public void setCountry(WebElement country) {
		GreenKartPages.country = country;
	}
	public WebElement getCheck() {
		return check;
	}
	public void setCheck(WebElement check) {
		GreenKartPages.check = check;
	}
	public WebElement getCont() {
		return cont;
	}
	public void setCont(WebElement cont) {
		GreenKartPages.cont = cont;
	}
	public String getFin() {
		return fin.getText();
	}
	public void setFin(WebElement fin) {
		GreenKartPages.fin = fin;
	}
		
	
}