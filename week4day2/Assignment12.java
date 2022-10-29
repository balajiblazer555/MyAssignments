package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment12 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/resizable");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		
		Actions act=new Actions(driver);
		WebElement scroll = driver.findElement(By.xpath("//li/a[text()='Checkboxradio']"));
		act.scrollToElement(scroll).perform();
		
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frame);
		
		WebElement handle = driver.findElement(By.xpath("(//div[@id='resizable']/div)[1]"));
		act.moveToElement(handle).clickAndHold().moveByOffset(200, 0).release().perform();
	}
}
