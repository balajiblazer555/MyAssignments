package week6.day2;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import seleniumcourse.ReadExcelData;

public class ProjectSpecific {

	public ChromeDriver driver;
	public String filename;
	public int sheetno;
	
	@Parameters({"url","uname","pwd"})
	@BeforeMethod
	public void PreCondition(String url, String uname, String pwd) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("user_name")).sendKeys(uname);
		driver.findElement(By.id("user_password")).sendKeys(pwd);
		driver.findElement(By.id("sysverb_login")).click();
	}
	@AfterMethod
	public void PostCondition() {
		driver.close();
	}
	@DataProvider(name="sendData")
	public String[][] sendData() throws IOException {		
		return ReadExcelData.fetchData(filename,sheetno);
	}
}
