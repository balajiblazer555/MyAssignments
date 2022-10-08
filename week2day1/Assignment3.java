package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3 {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("demosalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Create Contact")).click();
		driver.findElement(By.id("firstNameField")).sendKeys("Balaji");
		driver.findElement(By.id("lastNameField")).sendKeys("Shanmugam");
		driver.findElement(By.name("submitButton")).click();
		
		String text = driver.findElement(By.id("viewContact_firstName_sp")).getText();
		
		System.out.println("The Given First name is "+ text);
		
		System.out.println("The Browser title is "+ driver.getTitle());
		
		driver.close();
		
	}

}
