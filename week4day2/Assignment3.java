package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		//Launch the URL https://www.chittorgarh.com/
		driver.get("https://www.chittorgarh.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		
		//2. Click on stock market
		driver.findElement(By.id("navbtn_stockmarket")).click();
		
		//3. Click on NSE bulk Deals
		driver.findElement(By.xpath("//a[@href='/newportal/stock-nse-bulk-deals.asp']")).click();
		
		//4. Get all the Security names
		List<WebElement> secname = driver
				.findElements(By.xpath("//table[contains(@class,'table-striped')]/tbody/tr/td[3]"));
		System.out.println(secname.size());
		List<String> securityNames = new ArrayList<String>();

		for (int i = 1; i <= secname.size(); i++) {
			String list = driver.findElement(By.xpath("//table[contains(@class,'table-striped')]/tbody/tr[" + i + "]/td[3]")).getText();
			securityNames.add(list);
		}
		System.out.println(securityNames);
		System.out.println(securityNames.size());
		
		//5. Ensure whether there are duplicate Security names
		Set<String> duplicate = new LinkedHashSet<String>(securityNames);
		System.out.println(duplicate);
		System.out.println(duplicate.size());
	}
}