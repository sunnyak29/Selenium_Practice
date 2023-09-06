package base;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class base {
	WebDriver driver;
	public ExtentReports report = Util.ExtentReportManager.getReportInstance();
	public ExtentTest logger;

	// Function to show the failed test cases in the report
	public void reportFail(String report) {
		logger.log(Status.FAIL, report);
		Assert.fail(report);
	}

	// Function to show the passed test cases in the report
	public void reportPass(String report) {
		logger.log(Status.PASS, report);
	}

	// To input all data to the report
	public void endReport() {
		System.out.println("endreport");
		report.flush();

	}

	public static void WaiteForElementToAppear(WebDriver driver, By findby) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofMinutes(4));
		w.until(ExpectedConditions.presenceOfElementLocated(findby));

	}

	public static void WaiteForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
}
