package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment11 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();

		Actions act = new Actions(driver);
		WebElement scroll = driver.findElement(By.xpath("//li/a[text()='Checkboxradio']"));
		act.scrollToElement(scroll).perform();

		WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frame);

		WebElement source = driver.findElement(By.xpath("//div[@id='draggable']/p"));
		WebElement target = driver.findElement(By.xpath("//div[@id='droppable']/p"));
		act.dragAndDrop(source, target).perform();
	}
}
