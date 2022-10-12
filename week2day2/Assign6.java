package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assign6 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/select.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//1.Which is your favorite UI Automation tool?
		WebElement favtool = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
		Select tool=new Select(favtool);
		tool.selectByVisibleText("Selenium");
		
		//2.Choose your preferred country.
		driver.findElement(By.xpath("//label[text()='Select Country']")).click();
		driver.findElement(By.xpath("//li[text()='India']")).click();
		Thread.sleep(1000);
		
		//3.Confirm Cities belongs to Country is loaded.
		driver.findElement(By.xpath("//label[text()='Select City']")).click();
		driver.findElement(By.xpath("//li[text()='Bengaluru']")).click();
		
		//4.Choose the Course.
		driver.findElement(By.xpath("//button[contains(@class,'ui-corner-right ui-button-icon-only')]")).click();
		driver.findElement(By.xpath("//li[text()='Selenium WebDriver']")).click();
		driver.findElement(By.xpath("//button[contains(@class,'ui-corner-right ui-button-icon-only')]")).click();Thread.sleep(2000);
		driver.findElement(By.xpath("//li[text()='Appium']")).click();
		
		//5.Choose language randomly.
		driver.findElement(By.xpath("//label[text()='Select Language']")).click();
		driver.findElement(By.xpath("//li[text()='English']")).click();
		
		//6.Select 'Two' irrespective of the language chosen.
		driver.findElement(By.xpath("//label[text()='Select Values']")).click();
		driver.findElement(By.xpath("//li[text()='Two']")).click();
		Thread.sleep(3000);
		driver.close();

	}

}
