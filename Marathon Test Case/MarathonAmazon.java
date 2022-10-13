package seleniumcourse;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MarathonAmazon {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Bags");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div/div[contains(@aria-label,'boys')]")).click();
		String result = driver.findElement(By.xpath("//span[contains(text(),'30,000')]")).getText();
		if(result.contains("30,000")) {
			System.out.println("The Total number of Results is 30,000 ");
		}
		driver.findElement(By.xpath("//span[contains(text(),'American')]/preceding-sibling::div")).click();
		driver.findElement(By.xpath("//span[text()='See more']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'POLESTAR')]/preceding-sibling::div")).click();
		
		String result1 = driver.findElement(By.xpath("//span[contains(text(),'1-48 of')]")).getText();
		if(result1.contains("1-48 of")) {
			System.out.println("The Results is reduced from 30,000 to >100");
		}
		driver.findElement(By.xpath("//span[@class='a-button-text a-declarative']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Newest Arrivals']")).click();
		
		String bagname = driver.findElement(By.xpath("(//h2)[1]//span[contains(@class,'text-normal')]")).getText();
		System.out.println("First resulting bag Info : "+bagname);
		String bagprice = driver.findElement(By.xpath("(//div[@class='a-row a-size-base a-color-base'])[1]")).getText();
		System.out.println("First resulting bag price : "+bagprice);
	}
}
