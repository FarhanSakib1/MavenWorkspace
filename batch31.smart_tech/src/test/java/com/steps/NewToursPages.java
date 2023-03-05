package com.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class NewToursPages {
	
		public NewToursPages(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		@FindBy (how =How.XPATH, using ="//*[@name='userName']")
		private static WebElement username;
		
		public  WebElement getUsername() {
			return username;
		}

		public  void setUsername(WebElement username) {
			NewToursPages.username = username;
		}

		public static WebElement getPasswword() {
			return passwword;
		}

		public  void setPasswword(WebElement passwword) {
			NewToursPages.passwword = passwword;
		}

		@FindBy (how =How.XPATH, using ="//*[@name='password']")
		private static WebElement passwword;
}
