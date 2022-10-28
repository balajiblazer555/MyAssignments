package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment5 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Launch the URL https://html.com/tags/table/
		driver.get("https://html.com/tags/table/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();

		// You have to print the respective values based on given Library
		// (hint: if the library was absolute usage, then print all its value)
		List<WebElement> row = driver.findElements(By.xpath("//div[@class='render']/table//tbody/tr"));
		List<WebElement> column = driver.findElements(By.xpath("//div[@class='render']/table//tbody/tr[1]/td"));

		for (int i = 1; i <= row.size(); i++) {
			for (int j = 1; j <= column.size(); j++) {
			String text = driver.findElement(By.xpath("//div[@class='render']/table//tbody/tr[" + i + "]/td[" + j + "]")).getText();
				System.out.println(text);
			}
		}
	}
}