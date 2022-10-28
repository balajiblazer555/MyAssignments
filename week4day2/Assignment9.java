package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment9 {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(opt);
		
		//1) Open https://www.myntra.com/
		driver.get("https://www.myntra.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		
		//2) Mouse hover on MeN
		WebElement men = driver.findElement(By.xpath("(//div/a[text()='Men'])[1]"));
		Actions act=new Actions(driver);
		act.moveToElement(men).perform();
		
		//3) Click Jackets
		driver.findElement(By.xpath("(//li/a[text()='Jackets'])[1]")).click();
		
		//4) Find the total count of item 
		String count = driver.findElement(By.xpath("//span[@class='title-count']")).getText();
		System.out.println("Total count of item "+count);
		
		
		//5) Validate the sum of categories count matches
		String jacket = driver.findElement(By.xpath("(//span[@class='categories-num'])[1]")).getText();
		String rainjacket = driver.findElement(By.xpath("(//span[@class='categories-num'])[2]")).getText();
		String text1=jacket.replaceAll("\\D", "");
		int a=Integer.parseInt(text1);
		String text2=rainjacket.replaceAll("\\D", "");
		int b=Integer.parseInt(text2);
		int total=a+b;
		String s=Integer.toString(total);
		System.out.println(total);
		if(count.contains(s)) {
			System.out.println("Count matches");
		}else {
			System.out.println("Count does not matches");
		}
		
		//6.Check jackets
		driver.findElement(By.xpath("(//div[@class='common-checkboxIndicator'])[1]")).click();
		
		//7. Click + More option under BRAND
		driver.findElement(By.xpath("//div[@class='brand-more']")).click();
		
		//8. Type Duke and click checkbox 
		driver.findElement(By.xpath("//input[@class='FilterDirectory-searchInput']")).sendKeys("Duke");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//ul/li/label[@class=' common-customCheckbox'])[1]")).click();
		
		//9) Close the pop-up x
		driver.findElement(By.xpath("//div[@class='FilterDirectory-titleBar']/span")).click();
		
		//10.Confirm all the Coats are of brand Duke
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='product-productMetaInfo']/h3"));
		List<String> brand=new ArrayList<String>();
		for(int i=1; i<=list.size();i++) {
			String namelist = driver.findElement(By.xpath("(//div[@class='product-productMetaInfo']/h3)["+i+"]")).getText();
			brand.add(namelist);
		}
		Set<String> dup=new LinkedHashSet<String>(brand);
		if(dup.contains("Duke")) {
			System.out.println("All the Coats are of brand Duke");
		}else {
			System.out.println("All the Coats are not of brand Duke");
		}
		
		//11. Sort by Better Discount
		WebElement sort = driver.findElement(By.xpath("//div[@class='sort-sortBy']"));
		act.moveToElement(sort).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='discount']/parent::label")).click();
		Thread.sleep(2000);
		
		//12.Find the price of first displayed item
		String price = driver.findElement(By.xpath("(//span[@class='product-discountedPrice'])[1]")).getText();
		System.out.println("The price of first displayed item : "+price);
		driver.findElement(By.xpath("(//div[@class='product-productMetaInfo'])[1]")).click();
		
		//13. Take a screen shot
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> window1=new ArrayList<String>(windowHandles);
		driver.switchTo().window(window1.get(1));
		File ele = driver.getScreenshotAs(OutputType.FILE);
		 File des = new File("./snap/coats.jpg");
		 FileUtils.copyFile(ele, des);
		 
		 //14. Click on WishList Now
		 driver.findElement(By.xpath("(//a[@class='desktop-wishlist']/span)[2]")).click();
		 
		 //15. Close Browser
		driver.quit();
		
	}
}