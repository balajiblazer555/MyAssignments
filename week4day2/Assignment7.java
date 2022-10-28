package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment7 {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();

		// 1.Launch https://www.snapdeal.com/
		driver.findElement(By.xpath("//button[@id='pushDenied']")).click();

		// 2.Go to Mens Fashion
		WebElement mens = driver.findElement(By.xpath("//span[@class='catText']"));
		Actions act = new Actions(driver);
		act.moveToElement(mens);

		// 3.Go to Sports Shoes
		WebElement shoes = driver.findElement(By.xpath("//span[@class='linkTest']"));
		act.moveToElement(shoes).click().perform();

		// 4.Get the count of the sports shoes
		WebElement findElements = driver.findElement(By.xpath("//input[@id='numberFound']"));
		String total = findElements.getAttribute("value");
		System.out.println("Total count of the sports shoes : " + total);

		// 5.Click Training shoes
		driver.findElement(By.xpath("(//div[@class='child-cat-name '])[2]")).click();

		// 6.Sort by Low to High
		driver.findElement(By.xpath("//div[@class='sort-drop clearfix']")).click();
		driver.findElement(By.xpath("(//ul[@class='sort-value']/li)[2]")).click();

		// 7.Check if the items displayed are sorted correctly
		WebElement sort = driver.findElement(By.xpath("//div[@class='sort-selected']"));
		String sortorder = sort.getText();
		System.out.println("Sorting Order is now : " + sortorder);

		// 8.Select the price range (900-1200)
		WebElement low = driver.findElement(By.xpath("//input[@name='fromVal']"));
		WebElement high = driver.findElement(By.xpath("//input[@name='toVal']"));
		low.click();
		low.clear();
		low.sendKeys("900");
		high.click();
		high.clear();
		high.sendKeys("1200");
		driver.findElement(By.xpath("//div[contains(text(),'GO')]")).click();
		Thread.sleep(3000);

		// 9.Filter with color yellow
		WebElement colour = driver.findElement(By.xpath("//div/label[@for='Color_s-Yellow']/a"));
		act.click(colour).perform();
		Thread.sleep(2000);

		// 10. Verify the all applied filters
		List<WebElement> size = driver.findElements(By.xpath("(//div[@class='filters'])[1]/div/a"));
		List<String> filterList = new ArrayList<String>();
		for (int i = 1; i <= size.size(); i++) {
			String filters = driver.findElement(By.xpath("(//div[@class='filters'])[1]/div[" + i + "]")).getText();
			filterList.add(filters);
		}
		System.out.println("Filters Applied : " + filterList);

		// 11.Mouse Hover on first resulting Training shoes
		WebElement shoe = driver.findElement(By.xpath("(//div/a/p)[1]"));
		act.moveToElement(shoe).perform();

		// 12.Click QuickView button
		driver.findElement(By.xpath("//div[contains(text(),'Quick View')]")).click();

		// 13. Print the cost and the discount percentage
		String price = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
		System.out.println("The Shoe cost : ₹" + price);
		String discount = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
		System.out.println("Discount : " + discount);

		// 14. Take the snapshot of the shoes
		WebElement image = driver.findElement(By.xpath("(//ul[@class='clearfix']/li/img)[1]"));
		File ele = image.getScreenshotAs(OutputType.FILE);
		File des = new File("./snap/shoe.jpg");
		FileUtils.copyFile(ele, des);

		// 15. Close the current window
		driver.findElement(By.xpath("//div[@class='close close1 marR10']")).click();

		// 16. Close the main window
		driver.close();
	}
}