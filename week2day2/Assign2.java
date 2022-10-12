package week2.day2;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assign2 {

public static void main(String[] args) throws InterruptedException {
			    
	         WebDriverManager.chromedriver().setup();
	         ChromeDriver driver=new ChromeDriver();
	         driver.get("http://leaftaps.com/opentaps/control/main");
	         driver.manage().window().maximize();
	         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	         driver.findElement(By.xpath("//input[@id='username']")).sendKeys("demosalesManager");
	         driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
	         driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
	         driver.findElement(By.xpath("//a[contains(text(),'SFA')]")).click();
	         driver.findElement(By.xpath("//div/a[contains(text(),'Leads')]")).click();
	         driver.findElement(By.xpath("//li/a[contains(text(),'Find Leads')]")).click();
	         driver.findElement(By.xpath("//label[text()='First name:']/following::input[contains(@name,'firstName')][3]")).sendKeys("Balaji");
	         driver.findElement(By.xpath("//em/button[contains(text(),'Find Leads')]")).click();
	         Thread.sleep(3000);
	         driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
	         
	         System.out.println("The title is "+driver.getTitle());
	         if(driver.getTitle().contains("View Lead")) {
	        	 System.out.println("I confirm the title");
	         }
	         
	         driver.findElement(By.xpath("//a[contains(text(),'Edit')]")).click();
	         WebElement company = driver.findElement(By.xpath("//td/input[contains(@name,'companyName')]"));
	         company.clear();
	         company.sendKeys("Leaf Test");
	         
	         driver.findElement(By.xpath("//input[contains(@value,'Update')]")).click();
	         
	         
	         String namechange = driver.findElement(By.xpath("//span[contains(text(),'Leaf Test')]")).getText();
	         
	         if(namechange.contains("Leaf Test")) {
	        	 System.out.println("Company name is changed");
	        	 
	         }	    
	         driver.close();
	        	 
	         }	         
}
		
