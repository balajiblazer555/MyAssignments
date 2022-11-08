package week6.day2;


import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateLead extends ProjectSpecificMethod {

	@Test(dataProvider="sendData")
	public void runCreate(String cname, String fname, String lname) {
		System.out.println("Running CreateLead");
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cname);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lname);
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("99");
		driver.findElement(By.name("submitButton")).click();
}
	@DataProvider
	public String[][] sendData() {
		String[][] data=new String [2][3];
		
		data[0][0]="TestLeaf";
		data[0][1]="Hari";
		data[0][2]="R";
		
		data[1][0]="TestLeaf";
		data[1][1]="Vidya";
		data[1][2]="S";
		return data;
	}
}