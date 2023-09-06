package com.Blazemeter.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.base;
import io.github.sukgu.Shadow;

public class WorkDashboardPage extends base {
	WebDriver driver;

	public WorkDashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// PageFactory
	@FindBy(xpath = "//span[contains(text(),'Projects')]")
	WebElement project_opt;

	@FindBy(xpath = "//a[contains(text(),'Default project')]")
	WebElement dfltproject_opt;

	@FindBy(xpath = "//button[@class='blazemeter-button is-round is-round medium primary']")
	WebElement createtest_btn;

	@FindBy(xpath = "//button[@class='btn create-test-button btn-v4-test create-new-test js-create-new-single-test create-new-test-v4 btn btn-default']")
	WebElement performance_opt;

	@FindBy(xpath = "//button[@class='shared-folders-link btn btn-link']")
	WebElement sharedfolder_opt;

	@FindBy(xpath = "//input[@id='select-folder-checkbox']")
	WebElement scriptcheckbox;

	@FindBy(xpath = "//button[@class='accept-shared-folders btn btn-primary']")
	WebElement accept_btn;

	@FindBy(xpath = "(//input[@class='slider-value-input form-control'])[2]")
	WebElement duration;

	@FindBy(xpath = "//span[@class='cell-true-false-toggler send-email-toggle js-checked']")
	WebElement emailradio_btn;

	@FindBy(xpath = "//button[@class='action-button btn btn-success btn-sm']")
	WebElement run_btn;

	@FindBy(xpath = "//button[contains(text(),'Launch Servers')]")
	WebElement launchserver_btn;

	// @FindBy (xpath="//span[contains(text(),'Set Report as a Baseline')]")
	// WebElement verification_txt;

	By verification_txt = By.xpath("//span[contains(text(),'Set Report as a Baseline')]");

	public void CreateTest() {
		project_opt.click();
		dfltproject_opt.click();
		createtest_btn.click();
		performance_opt.click();
		sharedfolder_opt.click();
		scriptcheckbox.click();
		accept_btn.click();

		WaiteForPageLoad(driver);
		for (int i = 20; i > 1; i--)
			duration.sendKeys(Keys.ARROW_DOWN);

		emailradio_btn.click();
	}

	public void RunTest() throws InterruptedException {
		Thread.sleep(3000);
		run_btn.click();
		launchserver_btn.click();
		WaiteForElementToAppear(driver, verification_txt);
	}

	public void OpenApiMonitoring() {
		Shadow shadow = new Shadow(driver);
		shadow.findElementByXPath("//span[contains(text(),'API Monitoring')]").click();
		WaiteForPageLoad(driver);
	}

	public void Logout() {
		Shadow shadow = new Shadow(driver);
		shadow.findElementByXPath("//div[@class='account-name-container']").click();
		shadow.findElementByXPath("//a[contains(text(),'Log Out')]").click();
		WaiteForPageLoad(driver);

	}

}
