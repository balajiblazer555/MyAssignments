package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assign7 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/checkbox.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//1.Basic Checkbox.
		driver.findElement(By.xpath("//span[text()='Basic']")).click();
		
		//2.Notification.
		driver.findElement(By.xpath("//span[text()='Ajax']")).click();
		
		//3.Choose your favorite language(s).
		driver.findElement(By.xpath("//label[text()='Java']")).click();
		driver.findElement(By.xpath("//label[text()='Javascript']")).click();
		
		//4.Tri State Checkbox.
		WebElement tri = driver.findElement(By.xpath("//div[contains(@data-iconstates,'closethick')]"));
		tri.click();
		tri.click();
		tri.click();
		
		//5.Toggle Switch.
		driver.findElement(By.xpath("//div[@class='ui-toggleswitch ui-widget']")).click();
		
		//6.Verify if check box is disabled
		WebElement check = driver.findElement(By.xpath("(//div[@class='col-12']/div)[4]"));
		System.out.println("Does check box is disabled :"+check.isDisplayed());
		
		//7.Select Multiple.
		driver.findElement(By.xpath("//ul[@data-label='Cities']")).click();
		driver.findElement(By.xpath("//li/label[text()='London']")).click();
		driver.findElement(By.xpath("//li/label[text()='Rome']")).click();
		driver.findElement(By.xpath("//li/label[text()='Amsterdam']")).click();
		driver.findElement(By.xpath("//a[@aria-label=\"Close\"]/span")).click();
		

	}

}
