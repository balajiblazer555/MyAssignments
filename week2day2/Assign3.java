package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assign3 {

	public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        ChromeDriver driver=new ChromeDriver();
        driver.get("http://leaftaps.com/opentaps/control/main");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("demosalesManager");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
        driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'SFA')]")).click();
        driver.findElement(By.xpath("//div/a[contains(text(),'Leads')]")).click();
        driver.findElement(By.xpath("//li/a[contains(text(),'Find Leads')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Phone')]")).click();
        driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("9876543210");
        driver.findElement(By.xpath("//em/button[text()='Find Leads']")).click();
        Thread.sleep(3000);
        String text = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).getText();
        System.out.println ("lead ID of First Resulting lead :"+text);
        driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Delete')]")).click();
        driver.findElement(By.xpath("//li/a[contains(text(),'Find Leads')]")).click();
        driver.findElement(By.xpath("//div/input[contains(@name,'id')]")).sendKeys(text);
        driver.findElement(By.xpath("//em/button[text()='Find Leads']")).click();
        
        String verify = driver.findElement(By.xpath("//table/following-sibling::div[contains(text(),'No records to display')]")).getText();
        
        if(verify.contains("No records to display")) {
        	System.out.println("Succesful deletion of Lead");
        }
        else {
        	System.out.println("Lead is not deleted");
        }
        driver.close();
	}

}
