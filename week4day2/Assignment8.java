package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment8 {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//1.Load the URL https://www.amazon.in/
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		
		//2.Search as oneplus 9 pro 
		driver.findElement(By.name("field-keywords")).sendKeys("oneplus 9 pro", Keys.ENTER);
		
		//3.Get the price of the first product
		String price = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
		System.out.println("The price of the first product : ₹"+price);
		Thread.sleep(4000);
		
		//4. Print the number of customer ratings for the first displayed product
		String ratings = driver.findElement(By.xpath("(//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style']/span)[2]")).getText();
		System.out.println("The number of customer ratings : "+ratings);
		
		//5. Mouse Hover on the stars
		WebElement stars = driver.findElement(By.xpath("(//a[@class='a-popover-trigger a-declarative'])[1]"));
		Actions act=new Actions(driver);
		act.moveToElement(stars).click().perform(); 
		
		//6. Get the percentage of ratings for the 5 star.
		String fivestar = driver.findElement(By.xpath("(//span[@class='a-size-base'])[2]/a")).getText();
		System.out.println("Percentage of ratings for the 5 star : "+fivestar);
		
		//7. Click the first text link of the first image
		driver.findElement(By.xpath("(//a/span[contains(@class,'a-text-normal')])[1]")).click();
		Thread.sleep(2000);
		
		//8. Take a screen shot of the product displayed
		File ele = driver.getScreenshotAs(OutputType.FILE);
		 File des = new File("./snap/mobile.jpg");
		 FileUtils.copyFile(ele, des);
		 
		 //9. Click 'Add to Cart' button
		 Set<String> windowHandles = driver.getWindowHandles();
		List<String> window1 = new ArrayList<String>(windowHandles);
		driver.switchTo().window(window1.get(1));
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		Thread.sleep(5000);
		
		//10. Get the cart subtotal and verify if it is correct.
		WebElement carttotal = driver.findElement(By.xpath("(//span[@id='attach-accessory-cart-subtotal'])[1]"));
		String cart = carttotal.getText();
		System.out.println("Cart subtotal : "+cart);
		
		if(cart.contains(price)) {
			System.out.println("Price and cart total is correct");
		}else {
			System.out.println("Price and cart total is incorrect");
		}
		
	}
}