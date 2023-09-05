package com.Blazemeter.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
WebDriver driver;
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);		}
	//PageFactory
	@FindBy (xpath="(//a[@data-title='Login'])[2]")
	WebElement Login_opt;
	
	public void ClickLogin() {
		Login_opt.click();
	}


}
