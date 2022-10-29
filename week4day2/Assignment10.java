package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment10 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/draggable");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		Actions act=new Actions(driver);
		
		WebElement scroll = driver.findElement(By.xpath("//li/a[text()='Controlgroup']"));
		act.scrollToElement(scroll).perform();
		
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frame);
		
		WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']/p"));
		act.moveToElement(drag).clickAndHold().dragAndDropBy(drag, 250, 0).release().perform();
	}
}
