import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class inputs {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Inputs")).click();
		WebElement inputbox = driver.findElement(By.xpath("//input"));
		inputbox.click();
		for (int i = 20; i >= 0; i--)
			inputbox.sendKeys(Keys.ARROW_UP);

		Thread.sleep(3000);

		for (int i = 30; i >= 0; i--)
			inputbox.sendKeys(Keys.ARROW_DOWN);

		Thread.sleep(3000);
		driver.quit();

	}

}
