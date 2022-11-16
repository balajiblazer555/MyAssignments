package week6.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class UpdateServiceNow extends ProjectSpecific  {

	@Test(dependsOnMethods="week6.day2.CreateServiceNow.runCreate",dataProvider="sendData")
	public  void runUpdate(String inci, String incno) throws InterruptedException {
		
		Shadow dom=new Shadow(driver);
		dom.setImplicitWait(15);
		WebElement all = dom.findElementByXPath("//div[text()='All']");
		all.click();
		WebElement filter = dom.findElementByXPath("//input[@id='filter']");
		filter.sendKeys(inci);
		Thread.sleep(3000);
		filter.sendKeys(Keys.ENTER);
		WebElement frame = dom.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(frame);
		
		driver.findElement(By.xpath("//input[@id='incident_table_header_search_control']")).sendKeys(incno, Keys.ENTER);
		driver.findElement(By.xpath("(//td[@class='vt']/a)[1]")).click();
		WebElement urgency= driver.findElement(By.xpath("(//select[@class='form-control'])[1]"));
		Select select1=new Select(urgency);
		select1.selectByVisibleText("1 - High");
		
		
		WebElement state= driver.findElement(By.xpath("(//select[@class='form-control'])[2]"));
		Select select2=new Select(state);
		select2.selectByValue("2");
		
		String text = driver.findElement(By.xpath("(//select/option[@selected='SELECTED'])[1]")).getText();
		System.out.println(text);
		if(text.contains("High")) {
			System.out.println("Priority is set to HIGH");
		}else {
			System.out.println("Priority is not set to HIGH");
		}
		
		String text2 = driver.findElement(By.xpath("(//select/option[@selected='SELECTED'])[2]")).getText();
		System.out.println(text2);
		if(text2.contains("Progress")) {
			System.out.println("State is set to In Progress");
		}else {
			System.out.println("State is not set to In Progress");
		}
		
		
		driver.findElement(By.xpath("(//button[text()='Update'])[1]")).click();
		
	}
	
	@BeforeTest
	public void setFile() {
		filename="servicenow";
		sheetno=1;
	
	}
}
