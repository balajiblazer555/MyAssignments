package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assign1 {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(By.xpath("//a[text()='Create New Account']")).click();
		driver.findElement(By.xpath("//input[contains(@name,'firstname')]")).sendKeys("Serena");
		driver.findElement(By.xpath("//input[contains(@name,'lastname')]")).sendKeys("Williams");
		driver.findElement(By.xpath("//div[text()='Mobile number or email address']/following-sibling::input")).sendKeys("9876543210");
		driver.findElement(By.xpath("//div[text()='New password']/following-sibling::input")).sendKeys("testleaf@123");
		
		WebElement d = driver.findElement(By.id("day"));
		Select day=new Select(d);
		day.selectByIndex(24);
		
		WebElement m = driver.findElement(By.id("month"));
		Select month=new Select(m);
		month.selectByVisibleText("May");
		
		WebElement y = driver.findElement(By.id("year"));
		Select year=new Select(y);
		year.selectByValue("1990");
		
		driver.findElement(By.xpath("//label[contains(text(),'Female')]")).click();
		
		driver.close();

	}

}
