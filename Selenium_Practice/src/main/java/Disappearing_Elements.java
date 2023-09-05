import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Disappearing_Elements {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Disappearing Elements")).click();
		
		List<WebElement> wbelemts=driver.findElements(By.xpath("//ul"));
		
			System.out.print(wbelemts.size());
		
		Thread.sleep(3000);
		driver.navigate().refresh();
		
		List<WebElement> wbelemts1=driver.findElements(By.xpath("//ul"));
		
			System.out.print(wbelemts1.size());
		
		driver.quit();
		
	}

}
