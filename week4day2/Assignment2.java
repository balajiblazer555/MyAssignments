package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		
		//Launch the url: https://www.leafground.com/menu.xhtml
		driver.get("https://www.leafground.com/menu.xhtml");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		
		//Menu Bar -Do click on shipment 
		Actions act=new Actions(driver);
		driver.findElement(By.xpath("//span[text()='Shipments']")).click();
		
		//Mousehover on Tracker and Do rightClick on Tracker
		WebElement tracker = driver.findElement(By.xpath("(//ul/li/a/span[text()='Tracker'])[1]"));
		act.moveToElement(tracker).contextClick().perform();
		
		//Slide Menu -Do click Orders and click Back 
		WebElement orders = driver.findElement(By.xpath("(//ul/li/a/span[text()='Orders'])[1]"));
		act.clickAndHold(orders).perform();
		act.click(orders).perform();
		
		//Launch the url : https://www.leafground.com/drag.xhtml
		driver.get("https://www.leafground.com/drag.xhtml");
		Thread.sleep(2000);
		
		//Draggable Columns-Move the Column Name to Column Quantity 
		WebElement name = driver.findElement(By.xpath("(//tr[@role='row']/th)[1]"));
		WebElement quantity = driver.findElement(By.xpath("(//tr[@role='row']/th)[3]"));
		act.clickAndHold(name).moveToElement(quantity).release(quantity).perform();
		
		//-Get the Toaster message to confirm it
		WebElement alert = driver.findElement(By.xpath("//span[@class='ui-growl-title']"));
		System.out.println(alert.getText());
		Thread.sleep(3000);
		
		//Draggable Rows -Move the row 3 to row 4
		WebElement row4 = driver.findElement(By.xpath("(//table[@role='grid']/tbody//tr[4])[2]"));
		act.moveToElement(row4).perform();
		Thread.sleep(3000);
		act.clickAndHold().perform();
		Thread.sleep(3000);
		act.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();
		Thread.sleep(3000);
		act.moveByOffset(0, -45).release().perform();
		Thread.sleep(3000);
		
		//-Get the Toaster message to confirm it
		WebElement alert1 = driver.findElement(By.xpath("//div[@id='form:msgs_container']/div/div"));
		System.out.println(alert1.getText());
		
		//Resize Image -Resize the message and Verify it
		WebElement image = driver.findElement(By.xpath("//div/img[@id='form:logo']"));
		Dimension size = image.getSize();
		System.out.println("Unchanged size of image :"+size);
		WebElement handle = driver.findElement(By.xpath("//div/div[@class='ui-resizable-handle ui-resizable-e']"));
		act.clickAndHold(handle).moveByOffset(50, 0).release().perform();
		Thread.sleep(2000);
		WebElement alert2 = driver.findElement(By.xpath("//div/div[@class='ui-growl-message']"));
		System.out.println(alert2.getText());
		System.out.println("Changed size of image :"+image.getSize());
		
		//Range Slider -Give a range between 10 and 80
		WebElement slider = driver.findElement(By.xpath("(//span[contains(@class,'ui-slider-handle')])[1]"));
		act.clickAndHold(slider).moveByOffset(-80, 0).release().perform();	
	}
}