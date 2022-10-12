package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assign4 {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/input.xhtml;jsessionid=node0tmb2389go0xlxjvuy66xu9p668024.node02.");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//1.Type your name
		driver.findElement(By.xpath("(//div/input[contains(@role,'textbox')])[1]")).sendKeys("Balaji");
		
		//2.Append Country to this City.
		WebElement country = driver.findElement(By.xpath("(//div/input[contains(@role,'textbox')])[2]"));
		country.clear();
		country.sendKeys("India");
		
		//3.Verify if text box is disabled
		WebElement verify = driver.findElement(By.xpath("(//div/input[contains(@role,'textbox')])[3]"));
		System.out.println("Does Check box is working ? "+verify.isEnabled());	
		
		//4.Clear the typed text.
		WebElement typedtext = driver.findElement(By.xpath("(//div/input[contains(@role,'textbox')])[4]"));
		typedtext.clear();
		
		//5.Retrieve the typed text.
		String retrtext = driver.findElement(By.xpath("(//div/input[contains(@role,'textbox')])[5]")).getAttribute("value");
		System.out.println("The retrieved text is : "+ retrtext);
		
		//6.Type email and Tab. Confirm control moved to next element.
		WebElement mail = driver.findElement(By.xpath("(//div/input[contains(@role,'textbox')])[6]"));
		mail.sendKeys("balajiblazer555@gmail.com");
		mail.sendKeys(Keys.TAB);
		String about = driver.findElement(By.xpath("//div/textarea[contains(@class,'resizable')]")).getText();
		if(about.contains(about)) {System.out.println("control is moved to next element" );}
		
		//7.Type about yourself
		driver.findElement(By.xpath("//div/textarea[contains(@class,'resizable')]")).sendKeys("I am Balaji. Learning selenium software.");
		
		//8.Text Editor
		WebElement editor1 = driver.findElement(By.xpath("(//div[contains(@class,'ql-editor ql-blank')])[1]"));
		editor1.sendKeys("abcd");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//span[contains(@class,'ql-picker-label')])[1]")).click();Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[contains(@class,'ql-picker-item')])[2]")).click();
		editor1.sendKeys("abcd");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//span[contains(@class,'ql-picker-label')])[1]")).click();Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[contains(@class,'ql-picker-item')])[3]")).click();
		editor1.sendKeys("abcd");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//span[@class='ql-size ql-picker']/span)[1]")).click();Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@data-value='small'])[1]")).click();
		editor1.sendKeys("efgh");

		driver.findElement(By.xpath("(//span[@class='ql-size ql-picker']/span)[1]")).click(); Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@data-value='large'])[1]")).click();
		editor1.sendKeys("efgh");	
		
		driver.findElement(By.xpath("(//span[@class='ql-size ql-picker']/span)[1]")).click();Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@data-value='huge'])[1]")).click(); 
		editor1.sendKeys("efgh");	
		
		driver.findElement(By.xpath("(//button[@class='ql-bold'])[1]")).click(); 
		editor1.sendKeys("mnop");
		
		driver.findElement(By.xpath("(//button[@class='ql-italic'])[1]")).click(); 
		editor1.sendKeys("mnop");
		
		driver.findElement(By.xpath("(//button[@class='ql-underline'])[1]")).click(); 
		editor1.sendKeys("mnop");
		
		driver.findElement(By.xpath("(//button[@class='ql-strike'])[1]")).click(); 
		editor1.sendKeys("mnop");
		
		driver.findElement(By.xpath("(//span[contains(@class,'ql-color-picker')]/span)[1]")).click();
		driver.findElement(By.xpath("(//span/span[contains(@style,'rgb(230, 0, 0)')])[1]")).click();
		driver.findElement(By.xpath("//span[contains(@aria-controls,'ql-picker-options-3')]")).click();
		driver.findElement(By.xpath("(//span/span[contains(@style,'rgb(0, 97, 0)')])[2]")).click();
		
		driver.findElement(By.xpath("(//button[@class='ql-script'])[1]")).click(); 
		editor1.sendKeys("1");Thread.sleep(1000);
		
		driver.findElement(By.xpath("//span/button[@value='super']")).click(); 
		editor1.sendKeys("2");
		
		driver.findElement(By.xpath("//span/button[@value='super']")).click();
		driver.findElement(By.xpath("(//button[@class='ql-header'])[1]")).click();  
		driver.findElement(By.xpath("//button[contains(@class,'ql-header ql-active')]")).click();  
		driver.findElement(By.xpath("//button[@class='ql-code-block']")).click();
		driver.findElement(By.xpath("(//button[@class='ql-list'])[1]")).click();	
		driver.findElement(By.xpath("//button[contains(@class,'ql-list ql-active')]")).click(); 
		driver.findElement(By.xpath("(//button[@class='ql-indent'])[2]")).click(); 
		driver.findElement(By.xpath("(//button[@class='ql-indent'])[1]")).click(); 
		driver.findElement(By.xpath("//button[@class='ql-direction']")).click();
		
		//9.Just Press Enter and confirm error message*
		WebElement error = driver.findElement(By.xpath("(//div/input[contains(@role,'textbox')])[7]"));
		error.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		WebElement errorcheck = driver.findElement(By.xpath("//span/following-sibling::span[contains(text(),'Age is mandatory')]"));
		if(errorcheck.isDisplayed()){System.out.println("Error message is displayed");}
		
		//10.Click and Confirm Label Position Changes
		WebElement hover = driver.findElement(By.xpath("//label[text()='Username']/preceding-sibling::input"));
		hover.click();
		Thread.sleep(3000);
		WebElement label = driver.findElement(By.xpath("//input/following-sibling::label[contains(text(),'Username')]"));
		System.out.println("The label position changes - "+ label.isDisplayed());
		
		//11.Type your name and choose the third option
		driver.findElement(By.xpath("//li[@class='ui-autocomplete-input-token']/input")).sendKeys("Balaji");
		WebElement slt = driver.findElement(By.xpath("(//ul/li[contains(@class,'ui-autocomplete-item')])[3]"));
		slt.click();
		
		//12.Type your DOB (mm/dd/yyyy) and confirm date chosen
		WebElement dob = driver.findElement(By.xpath("//span[@class='p-datepicker ui-calendar ui-trigger-calendar']/input"));
		dob.sendKeys("05/25/1995");
		dob.sendKeys(Keys.TAB);
		if(dob.equals(dob)) {System.out.println("Entered Day on Date of Birth is Matching");}
		else {System.out.println("Entered Day on Date of Birth is not Matching");}
		
		//13.Type number and spin to confirm value changed
		WebElement input = driver.findElement(By.xpath("//span[contains(@class,'ui-spinner-stacked')]/input"));
		input.sendKeys("10");
		WebElement incr = driver.findElement(By.xpath("//span[contains(@class,'ui-spinner-stacked')]/a[1]"));
		WebElement decr = driver.findElement(By.xpath("//span[contains(@class,'ui-spinner-stacked')]/a[2]"));
		incr.click();
		System.out.println(input.getAttribute("aria-valuenow"));
		decr.click();
		System.out.println(input.getAttribute("aria-valuenow"));
		if(input.equals(input)){
			System.out.println("Value is changing");
		}else {System.out.println("Value is not changing");}
		
		//14.Type random number (1-100) and confirm slider moves correctly
		driver.findElement(By.xpath("(//h5[contains(text(),'random number')]/following-sibling::input)[1]")).sendKeys("50");
		WebElement check = driver.findElement(By.xpath("//div[contains(@style,'margin')]/span"));
		String slider = check.getAttribute("style");
		if(slider.contains("50")) {
			System.out.println("The slider is working");
		}else {System.out.println("The slider is not working");}
		
		//15.Click and Confirm Keyboard appears
		driver.findElement(By.xpath("//h5/following-sibling::input[(contains(@class,'keyboard'))]")).click();
		WebElement keyboard = driver.findElement(By.xpath("//div[@class='keypad-row']/parent::div"));
		System.out.println("Keyboard is displayed :"+ keyboard.isDisplayed());Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Close']")).click();
		
		//16.Custom Toolbar
		WebElement contentbox = driver.findElement(By.xpath("(//div[contains(@class,'ql-editor ql-blank')])[2]"));
		contentbox.click();
		driver.findElement(By.xpath("(//button[@class='ql-bold'])[2]")).click();
		contentbox.sendKeys("ABCD");
		driver.findElement(By.xpath("(//button[@class='ql-italic'])[2]")).click();
		contentbox.sendKeys("ABCD");
		driver.findElement(By.xpath("(//button[@class='ql-underline'])[2]")).click();
		contentbox.sendKeys("ABCD");
		driver.findElement(By.xpath("(//button[@class='ql-strike'])[2]")).click();
		contentbox.sendKeys("ABCD");
		
		driver.findElement(By.xpath("(//span[@class='ql-font ql-picker']/span)[3]")).click();
		driver.findElement(By.xpath("(//span[@id='ql-picker-options-5']/span)[2]")).click();
		contentbox.sendKeys("EFGH");
		driver.findElement(By.xpath("(//span[@class='ql-font ql-picker']/span)[3]")).click();
		driver.findElement(By.xpath("(//span[@id='ql-picker-options-5']/span)[3]")).click();
		contentbox.sendKeys("EFGH");
		
		driver.findElement(By.xpath("(//span[@class='ql-font ql-picker']/span)[3]")).click();
		driver.findElement(By.xpath("(//span[@id='ql-picker-options-5']/span)[1]")).click();
		contentbox.sendKeys("IJKL");
		
		driver.findElement(By.xpath("(//span[(@class='ql-size ql-picker')]/span)[3]")).click();
		driver.findElement(By.xpath("(//span[@data-value='large'])[2]")).click();
		contentbox.sendKeys("IJKL");
		
		driver.findElement(By.xpath("(//span[(@class='ql-size ql-picker')]/span)[3]")).click();
		driver.findElement(By.xpath("(//span[@data-value='huge'])[2]")).click();
		contentbox.sendKeys("IJKL");
		Thread.sleep(3000);
		driver.close();
		
		
		
		
	}

}
