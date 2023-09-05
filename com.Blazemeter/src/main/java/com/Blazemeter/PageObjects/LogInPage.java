package com.Blazemeter.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
	WebDriver driver;

	public LogInPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//PageFactory
		@FindBy (id="username")
		WebElement userid;
		
		@FindBy (id="password")
		WebElement passwordele;
		
		@FindBy (id="kc-login")
		WebElement login_btn;
		public void LogInApplication(String email,String password) {
			userid.sendKeys(email);
			passwordele.sendKeys(password);
			login_btn.click();
			
		}
		
		



}
