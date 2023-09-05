import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Add_and_Remove {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Add/Remove Elements")).click();
		// add 5 elements
		for (int i = 0; i < 5; i++)
			driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();

		Thread.sleep(3000);
		// delete two elements
		driver.findElement(By.xpath("//div[@id='elements']//child::button[5]")).click();

		driver.findElement(By.xpath("//div[@id='elements']//child::button[4]")).click();
		Thread.sleep(3000);
		driver.quit();

	}

}
