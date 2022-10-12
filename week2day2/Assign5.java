package week2.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assign5 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/button.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//1.Click and Confirm title.
		WebElement title = driver.findElement(By.xpath("//span[contains(text(),'Click')]"));
		title.click();
		if(driver.getTitle().contains("Dashboard")) {
			System.out.println("1.Title is Confirmed");
		} else {System.out.println("Title mismatch");}
		driver.get("https://www.leafground.com/button.xhtml");
		
		//2.Confirm if the button is disabled
		WebElement disbutton = driver.findElement(By.xpath("//div/button[contains(@disabled,'disabled')]"));
		System.out.println("2.The button is enabled : "+disbutton.isEnabled() );
		
		//3.Find the position of the Submit button
		WebElement position = driver.findElement(By.xpath("(//button/span[contains(text(),'Submit')])[1]"));
		System.out.println("3.The position of the submit button : "+position.getLocation());
		
		//4.Find the Save button color
		WebElement color = driver.findElement(By.xpath("//h5[contains(text(),'Find the Save button color')]/following-sibling::button"));
		System.out.println("4.The Color of the Save button : "+ color.getCssValue("background-color"));
		
		//5.Find the height and width of this button
		WebElement handw = driver.findElement(By.xpath("(//button/span[contains(text(),'Submit')])[2]"));
		System.out.println("5.The height and width of the button is : "+handw.getSize());
		
		//6.Mouse over and confirm the color changed
		WebElement cssValue = driver.findElement(By.xpath("//button[contains(@class,'raised ui-button-success')]"));
		String color1=cssValue.getCssValue("background-color");
		
		WebElement colorconfirm = driver.findElement(By.xpath("//button[contains(@class,'raised ui-button-success')]"));
		Actions action = new Actions(driver);
		action.moveToElement(colorconfirm).perform();
		Thread.sleep(3000);
		String color2 = driver.findElement(By.xpath("//button/span[contains(@style,'background-color: salmon')]")).getCssValue("background-color");
		if(color1!=color2) {
			System.out.println("6.Colour Change is confirmed");
		}
		
		//7.Click Image Button and Click on any hidden button
		WebElement image = driver.findElement(By.xpath("//button/span[text()='Image']"));
		image.click();
		driver.findElement(By.xpath("//button[contains(@class,'ui-state-hover')]")).click();
		Thread.sleep(2000);
		System.out.println("7.Hidden button is clicked");
		
		//8.How many rounded buttons are there?
		List<WebElement> button = driver.findElements(By.xpath("//h5[contains(text(),'rounded')]/following-sibling::button"));
		int button1=button.size();
		System.out.println("8."+button1);
		
	
		
		
	}
}
