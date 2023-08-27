import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class checkbox {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Checkboxes")).click();
		if(driver.findElement(By.xpath("//form[@id='checkboxes']/child::input[1]")).isSelected())
			System.out.println("Checkbox 1 is selected");
		else
			System.out.println("Checkbox 1 is not selected");
			
		if(driver.findElement(By.xpath("//form[@id='checkboxes']/child::input[2]")).isSelected())
			System.out.println("Checkbox 2 is selected");
		else
			System.out.println("Checkbox 2 is not selected");
		
		driver.findElement(By.xpath("//form[@id='checkboxes']/child::input[1]")).click();
		Thread.sleep(5000);
		driver.quit();

	}

}
