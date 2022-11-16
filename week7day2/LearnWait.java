package seleniumcourse;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnWait {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/waits.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		
		//1
		WebElement visibility = driver.findElement(By.xpath("(//span[text()='Click'])[1]"));
		visibility.click();
		
		WebElement iAmHere = driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[2]"));
		
		WebElement until2 = wait.until(ExpectedConditions.visibilityOf(iAmHere));
		
		
		//2
		WebElement invisibility = driver.findElement(By.xpath("(//span[text()='Click'])[2]"));
		invisibility.click();
		
		WebElement hide = driver.findElement(By.xpath("//span[text()='I am about to hide']"));
		
		Boolean until = wait.until(ExpectedConditions.invisibilityOf(hide));
		
		System.out.println(until);
		
		//3
		WebElement clickability = driver.findElement(By.xpath("//span[text()='Click First Button']"));
		clickability.click();
		
		WebElement click = driver.findElement(By.xpath("//span[text()='Click Second']"));
		
		wait.until(ExpectedConditions.elementToBeClickable(click));
		
		System.out.println(click.getText());
		
		//4
		WebElement textchange = driver.findElement(By.xpath("(//span[text()='Click'])[3]"));
		textchange.click();
		
		WebElement changed = driver.findElement(By.xpath("//span[text()='Did you notice?']"));
		
		String text2 = changed.getText();
		
		wait.until(ExpectedConditions.textToBePresentInElement(changed, text2));
		if((changed.getText()).contains(text2)) {
			System.out.println("Text change is confirmed");
		}else {
			System.out.println("Text change is not confirmed");
		}
	}
}