package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment6 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//1.Go to https://www.nykaa.com/
		driver.get("https://www.nykaa.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		
		//2.Mousehover on Brands and Search L'Oreal Paris
		WebElement brand = driver.findElement(By.xpath("(//a[@class='css-1mavm7h'])[2]"));
		Actions act = new Actions(driver);
		act.moveToElement(brand).perform();
		driver.findElement(By.id("brandSearchBox")).sendKeys("L'Oreal Paris");
		Thread.sleep(2000);
		
		//3.Click L'Oreal Paris
		driver.findElement(By.xpath("(//div[@class='css-ov2o3v']//a)[1]")).click();
		
		//4.Check the title contains L'Oreal Paris(Hint-GetTitle)
		System.out.println(driver.getTitle());
		
		//5.Click sort By and select customer top rated
		driver.findElement(By.xpath("//div/button[@class=' css-n0ptfk']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='control-value'])[4]")).click();
		
		//6.Click Category and click Hair->Click haircare->Shampoo
		driver.findElement(By.xpath("//div[@class='filter-open css-1kwl9pj']")).click();
		driver.findElement(By.xpath("//div[@class=' css-b5p5ep']")).click();
		driver.findElement(By.xpath("//span[@class='filter-name ']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='title']")).click();
		Thread.sleep(2000);
		
		//7.Click->Concern->Color Protection
		driver.findElement(By.xpath("//div/div/span[text()='Concern']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label//span[text()='Color Protection']")).click();
		Thread.sleep(2000);
		
		//8.check whether the Filter is applied with Shampoo
		String filter = driver.findElement(By.xpath("//span[@class='filter-value']")).getText();
		System.out.println("The Filter is applied with " + filter);
		Thread.sleep(2000);
		
		//9.Click on L'Oreal Paris Colour Protect Shampoo
		driver.findElement(By.xpath("//div/div[@class='css-xrzmfa']")).click();
		
		//10.GO to the new window and select size as 175ml
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> window1 = new ArrayList<String>(windowHandles);
		driver.switchTo().window(window1.get(1));
		WebElement source = driver.findElement(By.className("css-2t5nwu"));
		Select opt = new Select(source);
		opt.selectByIndex(1);
		
		//11.Print the MRP of the product
		String mrp = driver.findElement(By.xpath("(//span[@class='css-1jczs19'])[1]")).getText();
		System.out.println("MRP of the product : " + mrp);
		
		//12.Click on ADD to BAG
		driver.findElement(By.xpath("//div[@class='css-vp18r8']/button")).click();
		
		//13.Go to Shopping Bag
		driver.findElement(By.xpath("//div[@class='css-0 e1ewpqpu1']/button")).click();
		
		//14.Print the Grand Total amount
		WebElement frame = driver.findElement(By.xpath("//div[@id='portal-root']//iframe"));
		driver.switchTo().frame(frame);
		String total1 = driver.findElement(By.xpath("//span[contains(@class,'css-n8gwxi')]")).getText();
		System.out.println("Grand Total amount-1 : " + total1);

		//15.Click Proceed
		driver.findElement(By.xpath("//div[@class='css-ltzjhp e25lf6d7']")).click();

		//16. Click on Continue as Guest
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();

		//17. Check if this grand total is the same in step 14
		String total2 = driver.findElement(By.xpath("(//div[contains(@class,'payment-details-tbl ')]/div)[2]"))
				.getText();
		System.out.println("Grand Total amount-2 : " + total2);

		if (total1.equals(total2)) {
			System.out.println("Both grand totals are same");
			driver.quit();
		} else {
			System.out.println("Both grand totals are not same");
		}
		
		//18. Close all windows
		driver.quit();
	}
}