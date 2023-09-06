package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Blazemeter.PageObjects.LandingPage;
import com.Blazemeter.PageObjects.LogInPage;
import com.Blazemeter.PageObjects.WorkDashboardPage;

import base.base;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RunTest extends base {
	WebDriver driver;

	@BeforeTest
	public void invokeBrowser() {
		// invoke browser
		logger = report.createTest("Invoke Brower");
		try {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();

			reportPass("Browser is invoked sucessfully");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}

		// open website
		logger = report.createTest("Open Blazemeter website");
		try {
			driver.get("https://www.blazemeter.com/");
			WaiteForPageLoad(driver);

			reportPass("Website Opened");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}

	}

	@Test(priority = 1)
	public void OpenloginPage() {
		LandingPage landingpage = new LandingPage(driver);
		// Open LogIn page
		logger = report.createTest("Open LogIn page");
		try {
			landingpage.ClickLogin();

			reportPass("LogIn page loaded sucessfully");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}

	}

	@Test(priority = 2)
	public void LoginApplication() {
		LogInPage loginpage = new LogInPage(driver);
		// Login Application
		logger = report.createTest("LogIn application with valid credentials");
		try {
			loginpage.LogInApplication("businesscorridor29@gmail.com", "Ankit@123");

			reportPass("Application LogIn sucessfully");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	@Test(priority = 3)
	public void SetupNewTest() {
		WorkDashboardPage workdashboardpage = new WorkDashboardPage(driver);
		// SetUp Test
		logger = report.createTest("Create a performance test");
		try {
			workdashboardpage.CreateTest();

			reportPass("Test setup sucessfully");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}

		// Run Test
		logger = report.createTest("Run test");
		try {
			try {
				workdashboardpage.RunTest();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			reportPass("Test executed sucessfully");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}

		// Click on API Monitoring
		logger = report.createTest("Click on API Monitoring(Shadow DOM)");
		try {
			workdashboardpage.OpenApiMonitoring();

			reportPass("API Monitoring Clicked Sucessfully");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}

		// Logout Application
		logger = report.createTest("LogOut Application");
		try {
			workdashboardpage.OpenApiMonitoring();

			reportPass("Application LogOut");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	@AfterTest
	public void CloseBrowser() {
		driver.quit();

	}

}
