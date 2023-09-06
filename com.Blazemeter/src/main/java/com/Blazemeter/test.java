package com.Blazemeter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Blazemeter.PageObjects.LandingPage;
import com.Blazemeter.PageObjects.LogInPage;
import com.Blazemeter.PageObjects.WorkDashboardPage;

import base.base;
import io.github.bonigarcia.wdm.WebDriverManager;

public class test extends base {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://www.blazemeter.com/");
		WaiteForPageLoad(driver);

		LandingPage landingpage = new LandingPage(driver);
		landingpage.ClickLogin();

		LogInPage loginpage = new LogInPage(driver);
		loginpage.LogInApplication("businesscorridor29@gmail.com", "Ankit@123");

		WorkDashboardPage workdashboardpage = new WorkDashboardPage(driver);
		workdashboardpage.CreateTest();

		workdashboardpage.RunTest();
		workdashboardpage.OpenApiMonitoring();
		workdashboardpage.Logout();
		driver.quit();

		// driver.findElement(By.xpath("(//a[@data-title='Login'])[2]")).click();
		// https://www.blazemeter.com/

		// Login xpath: //a[@data-title="Login"]
		// driver.findElement(By.id("username")).sendKeys("businesscorridor29@gmail.com");
		// driver.findElement(By.id("password")).sendKeys("Ankit@123");

		// id :businesscorridor29@gmail.com password: Ankit@123

		// id (id- username) pass(id- password)
		// driver.findElement(By.id("kc-login")).click();
		// signin (id- kc-login)

		// driver.findElement(By.xpath("//button[contains(text(),'Close')]")).click();
		// maybe windowhandel close button(xpath: //button[contains(text(),"Close")])

		// driver.findElement(By.xpath("//span[contains(text(),'Projects')]")).click();
		// click on project (xpath: //span[contains(text(),"Projects")])
		// driver.findElement(By.xpath("//a[contains(text(),'Default
		// project')]")).click();
		// click on default project (xpath: //a[contains(text(),"Default project")])

		// click on performance ??(xpath:
		// driver.findElement(By.xpath("//button[@class='blazemeter-button is-round
		// is-round medium primary']")).click();
		// creat new test ( xpzth: //button[@class="blazemeter-button is-round is-round
		// medium primary"])
		// driver.findElement(By.xpath(
		// "//button[@class='btn create-test-button btn-v4-test create-new-test
		// js-create-new-single-test create-new-test-v4 btn btn-default']"))
		// .click();
		// select performance test btn create-test-button btn-v4-test create-new-test
		// js-create-new-single-test create-new-test-v4 btn btn-default
		// driver.findElement(By.xpath("//button[@class='shared-folders-link btn
		// btn-link']")).click();
		// driver.findElement(By.xpath("//input[@id=\"select-folder-checkbox\"]")).click();
		// upload script FirstScriptTest.java //input[@id="select-folder-checkbox"]
		// driver.findElement(By.xpath("//button[@class='accept-shared-folders btn
		// btn-primary']")).click();
		// click on accept button //button[@class='accept-shared-folders btn
		// btn-primary']
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// WebElement inputbox =
		// driver.findElement(By.xpath("(//input[@class='slider-value-input
		// form-control'])[2]"));
		// for (int i = 20; i > 1; i--)
		// inputbox.sendKeys(Keys.ARROW_DOWN);

		// driver.findElement(By.xpath("//span[@class='cell-true-false-toggler
		// send-email-toggle js-checked']")).click();
		// turn of email notification //span[@class='cell-true-false-toggler
		// send-email-toggle js-checked']

		// driver.findElement(By.xpath("//button[@class='action-button btn btn-success
		// btn-sm']")).click();

		// run test //button[contains(text(),'Run Test')]
		// driver.findElement(By.xpath("//button[contains(text(),'Launch
		// Servers')]")).click();
		// launch server //button[contains(text(),'Launch Servers')]
		// WebDriverWait w = new WebDriverWait(driver, Duration.ofMinutes(4));
		// presenceOfElementLocated condition
		// w.until(ExpectedConditions
		// .presenceOfElementLocated(By.xpath("//span[contains(text(),'Set Report as a
		// Baseline')]")));
		// waite until report is created
		// Shadow shadow = new Shadow(driver);

		// shadow.findElementByXPath("//span[contains(text(),'API
		// Monitoring')]").click();
		// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// shadow.findElementByXPath("//div[@class='account-name-container']").click();
		// shadow.findElementByXPath("//a[contains(text(),'Log Out')]").click();
		// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// navigate to api monitering //span[contains(text(),'API Monitoring')]
//exit browsre

	}

}
