package seleniumcourse;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBus {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("redBus")).click();
		driver.findElement(By.xpath("//input[contains(@placeholder,'FROM')]")).sendKeys("Chennai");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[contains(@placeholder,'FROM')]")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//input[contains(@placeholder,'TO')]")).sendKeys("Bangalore");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[contains(@placeholder,'TO')]")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("txtOnwardCalendar")).click();
		driver.findElement(By.xpath("(//ul/li[@data-date='14'])[2]")).click();
		driver.findElement(By.xpath("//button[text()='Search Buses']")).click();
		String bus = driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText();
		System.out.println("Total number of buses shown as results :"+bus);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div/i[@class='icon icon-close']")).click();
		driver.findElement(By.xpath("//label[@title='SLEEPER']")).click();
		String name = driver.findElement(By.xpath("(//div[@class='column-two p-right-10 w-30 fl'])[2]")).getText();
		System.out.println("Name of the second resultig bus : "+name);
		driver.findElement(By.xpath("(//div[text()='View Seats'])[2]")).click();
	}
}
