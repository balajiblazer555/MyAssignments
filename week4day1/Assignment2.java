package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.leafground.com/window.xhtml");
		driver.manage().window().maximize();
		
		//1.Click Open Multiple 
		driver.findElement(By.xpath("//span[text()='Open Multiple']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		
		//2.Get the size of available Windows
		System.out.println(windowHandles.size());
		
		//3. Switch to last window 
		List<String> window1 = new ArrayList<String>(windowHandles);
		driver.switchTo().window(window1.get(2));
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		
		//4.Get the Title of the Window
		driver.switchTo().window(window1.get(0));
		driver.close();
		
		//5.Close all the windows except last window
		driver.switchTo().window(window1.get(1));
		driver.manage().window().maximize();
		driver.close();

		driver.switchTo().window(window1.get(2));

	}
}