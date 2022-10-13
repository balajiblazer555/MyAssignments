package seleniumcourse;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BookMyShow {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://in.bookmyshow.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//div/span[text()='Hyderabad']")).click();
		String currentUrl = driver.getCurrentUrl();
		if(currentUrl.contains("hyderabad")) {
			System.out.println("Current Url :"+ currentUrl);
		}
		
		driver.findElement(By.xpath("//div/span[@class='sc-ebFjAB cCHBdM']")).click();
		driver.findElement(By.xpath("//input[@class='sc-jvEmr elijMA']")).sendKeys("Ponniyin Selvan");
		driver.findElement(By.xpath("(//span[contains(@class,'kzaUOq')])[1]")).click();
		driver.findElement(By.xpath("(//div[contains(@class,'iBonLL')])[1]")).click();
		driver.findElement(By.xpath("(//span[text()='Tamil']/following::span[text()='2D'])[1]")).click();
		String venue = driver.findElement(By.xpath("(//a[contains(@class,'venue')])[1]")).getText();
		System.out.println("Name of the first theatre displayed :"+venue);
		driver.findElement(By.xpath("(//div[text()='INFO'])[1]")).click();
		String facility = driver.findElement(By.xpath("//div[@class='venue-facilities']")).getText();
		if(facility.contains("Parking Facility")) {
		}else {System.out.println("Parking is not available");}
		driver.findElement(By.xpath("//button[text()='Not Now']")).click();
		driver.findElement(By.xpath("//div[@class='cross-container']")).click();
		driver.findElement(By.xpath("(//a[@class='showtime-pill'])[1]")).click();
		driver.findElement(By.xpath("//div[@id='btnPopupAccept']")).click();
		driver.findElement(By.xpath("//li[text()='1']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Select Seats')]")).click();
		driver.findElement(By.xpath("//div[@id='B_1_0218']")).click();
		driver.findElement(By.xpath("(//a[@id='btmcntbook'])[1]")).click();
		Thread.sleep(2000);
		String total = driver.findElement(By.xpath("//span[@id='subTT']")).getText();
		System.out.println("Sub Total = "+ total);
}
}	
