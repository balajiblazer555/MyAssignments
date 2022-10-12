package week2.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assign8 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.navigate().to("https://www.leafground.com/link.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//1.Take me to dashboard.
		WebElement dash = driver.findElement(By.xpath("(//a[text()='Go to Dashboard'])[1]"));
		dash.click();
		if(driver.getTitle().contains("Dashboard")) {
			System.out.println("Page is in Dashboard");
		} else {System.out.println("Page is not in Dashboard");}
		
		
		
		//2.Find my destination.
		driver.navigate().back();
		WebElement url = driver.findElement(By.xpath("//a[contains(text(),'Find the URL')]"));
		System.out.println("The destination URL is : "+url.getAttribute("href"));
		
		//3.Am I broken link?
		driver.findElement(By.xpath("//a[text()='Broken?']")).click();
		String title=driver.getTitle();
		if(title.contains("404"))
		{
			System.out.println("Page is broken");
		} 
		else{
		    System.out.println("Page is not broken");
		}
		driver.navigate().back();
		
		//4.Duplicate Link.
		WebElement dashdup = driver.findElement(By.xpath("(//a[text()='Go to Dashboard'])[1]"));
		dashdup.click();
		driver.navigate().back();
		
		//5.Count Links.
		List<WebElement> linknum = driver.findElements(By.tagName("a"));
		int linkcount= linknum.size();
		System.out.println("Total number of Links in this page is :"+linkcount);
		
		//6.Count Layout Links.
		List<WebElement> links = driver.findElements(By.xpath("//h5[text()='Count Layout Links']"));
		int linkscount= links.size();
		System.out.println("Total number of Links in this Layout is :"+linkscount);
		
		
		

	}

}
