package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3 {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		//1.Launch the browser.
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		//2.Load the url.
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		
		//3.Enter the username. 
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		
		//4.Enter the password.
		driver.findElement(By.id("password")).sendKeys("Password#123");
		
		//5.click on the login button.
		driver.findElement(By.id("Login")).click();
		Thread.sleep(7000);
		
		//6.click on the learn more option in the Mobile publisher.
		driver.findElement(By.xpath("(//button/span[@class=' label bBody'])[2]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> window1 = new ArrayList<String>(windowHandles);
		
		//7.Switch to the next window using Windowhandles.
		driver.switchTo().window(window1.get(1));
		
		//8.click on the confirm button in the redirecting page.
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		
		//9.Get the title.
		System.out.println(driver.getTitle());
		
		//10.Get back to the parent window.
		driver.switchTo().window(window1.get(0));
		
		//11.close the browser.
		driver.quit();
	}
}