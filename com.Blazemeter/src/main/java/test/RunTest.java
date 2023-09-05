package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Blazemeter.PageObjects.LandingPage;
import com.Blazemeter.PageObjects.LogInPage;
import com.Blazemeter.PageObjects.WorkDashboardPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RunTest {
	WebDriver driver;
	LandingPage landingpage=new LandingPage(driver);
	LogInPage loginpage=new LogInPage(driver);
	WorkDashboardPage workdashboardpage=new WorkDashboardPage(driver);

	@BeforeTest
	public void invokeBrowser() {
        WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://www.blazemeter.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test(priority = 1 )
	public void OpenloginPage() {
		landingpage.ClickLogin();
	}
	@Test(priority = 2 )
	public void LoginApplication() {
		loginpage.LogInApplication("businesscorridor29@gmail.com", "Ankit@123");
	}
	@Test(priority = 3 )
	public void SetupNewTest() {
		workdashboardpage.CreateTest();
	}
	@Test(priority = 4)
	public void RunNewTest() {
		try {
			workdashboardpage.RunTest();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test(priority = 5 )
	public void ClickonAPIMonitoring() {
		workdashboardpage.OpenApiMonitoring();
	}
	@Test(priority = 2 )
	public void LogoutApplication() {
		workdashboardpage.Logout();	
	}
	@AfterTest
	public void CloseBrowser() {
		driver.quit();

	}
	
}
