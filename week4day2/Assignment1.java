package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1 {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		//Step:1-Launch the url (https://www.redbus.in/)
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		
		//Step:2-Enter From -Madiwala Bangalore
		driver.findElement(By.id("redBus")).click();
		driver.findElement(By.xpath("//input[contains(@placeholder,'FROM')]")).sendKeys("Madiwala");
		Thread.sleep(1000);
		
		//Step:3-Enter To Koyambedu Chennai
		driver.findElement(By.xpath("//input[contains(@placeholder,'FROM')]")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//input[contains(@placeholder,'TO')]")).sendKeys("Koyambedu");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[contains(@placeholder,'TO')]")).sendKeys(Keys.ENTER);
		
		//Step:4-Select the Date 30-September-2022
		driver.findElement(By.id("txtOnwardCalendar")).click();
		driver.findElement(By.xpath("(//li[@class='weekend'])[2]")).click();
		driver.findElement(By.xpath("//button[contains(@class,'search_btn')]")).click();
		Thread.sleep(3000);
		
		//Step:5-Print the Title of the page
		System.out.println(driver.getTitle());
	}
}