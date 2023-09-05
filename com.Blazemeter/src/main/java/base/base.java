package base;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class base {
		WebDriver driver;

public base(WebDriver driver) {
		// TODO Auto-generated constructor stub
	this.driver=driver;
	}
public void WaiteForElementToAppear(By findby) {
	WebDriverWait w = new WebDriverWait(driver, Duration.ofMinutes(4));
	w.until(ExpectedConditions.presenceOfElementLocated(findby));
	
}
public void WaiteForPageLoad() {
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
}
}
