package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment4 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		
		//Launch the URL https://html.com/tags/table/
		driver.get("https://html.com/tags/table/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		
		//Get the count of number of rows
		List<WebElement> row = driver.findElements(By.xpath("//table[@class='attributes-list']/tbody/tr"));
		System.out.println("The count of number of rows : " + row.size());

		//Get the count of number of columns
		List<WebElement> column = driver.findElements(By.xpath("//table[@class='attributes-list']/tbody/tr[2]/td"));
		System.out.println("The count of number of columns : " + column.size());
	}
}