package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment13 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/selectable");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		
		driver.switchTo().frame(0);
		Actions act=new Actions(driver);
		act.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();
		act.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();
		
		WebElement item1 = driver.findElement(By.xpath("//ol/li[text()='Item 1']"));
		WebElement item5 = driver.findElement(By.xpath("//ol/li[text()='Item 5']"));
		act.scrollToElement(item5).perform();
		act.keyDown(Keys.CONTROL).click(item1).click(item5).keyUp(Keys.CONTROL).perform();
	}

}
