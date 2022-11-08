package week6.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class DeleteServiceNow extends ProjectSpecific {

	@Test(dependsOnMethods="week6.day2.UpdateServiceNow.runUpdate", dataProvider="fetchData")
	public void runDelete(String inci, String incno) throws InterruptedException {
		
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
		
		driver.findElement(By.xpath("(//button[text()='Delete'])[1]")).click();
		driver.findElement(By.xpath("(//button[text()='Delete'])[3]")).click();
		
		
		driver.findElement(By.xpath("//input[@id='incident_table_header_search_control']")).sendKeys(Keys.ENTER);
		String confirm = driver.findElement(By.xpath("//div[@class='list2_empty-state-list']")).getText();
		if(confirm.contains("No records")) {
			System.out.println("Incident is deleted");
		}else {
			System.out.println("Incident is not deleted");
		}
	}
	@DataProvider
	public String[][] fetchData() {
		String[][] data=new String[1][2];
		data[0][0]="Incident";
		data[0][1]="INS001";
		return data;
	}
}