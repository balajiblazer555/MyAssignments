package week6.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class CreateServiceNow extends ProjectSpecific {
	
	@Test(dataProvider="fetchData")
	public void runCreate(String incident, String mand) throws InterruptedException {
		
		Shadow dom=new Shadow(driver);
		dom.setImplicitWait(15);
		WebElement all = dom.findElementByXPath("//div[text()='All']");
		all.click();
		WebElement filter = dom.findElementByXPath("//input[@id='filter']");
		filter.sendKeys("Incident");
		Thread.sleep(3000);
		filter.sendKeys(Keys.ENTER);
		WebElement frame = dom.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(frame);
		
		driver.findElement(By.xpath("//button[text()='New']")).click();
		driver.findElement(By.xpath("//input[@id='incident.number']")).sendKeys(incident);
		driver.findElement(By.xpath("//input[@id='incident.short_description']")).sendKeys(mand);
		driver.findElement(By.xpath("//button[@id='sysverb_insert_bottom']")).click();
		
		driver.findElement(By.xpath("//input[@id='incident_table_header_search_control']")).sendKeys(incident, Keys.ENTER);
		String text = driver.findElement(By.xpath("//td[@class='vt']/a")).getText();
		System.out.println(text);
		if(text.contains("INS001")) {
			System.out.println("Created Incident is matching");
		}else {
			System.out.println("Created Incident is not matching");
		}
		
	}
	@DataProvider
	public String[][] fetchData() {
		String[][] data = new String[1][2];
		data[0][0]="INS001";
		data[0][1]="Creating Incident";
		return data;
		
	}
}
