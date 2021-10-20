package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLeads {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		//Launch the browser
		driver.get("http://leaftaps.com/opentaps");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Enter the username
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		
		//Enter the password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		//Click Login
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//Click crm/sfa link
		driver.findElement(By.xpath("//a[contains(text(),'CRM')]")).click();
		
		//Click Leads link
		driver.findElement(By.linkText("Leads")).click();
		
		//Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
		
		//Click on Phone
		driver.findElement(By.xpath("//span[contains(text(),'Phone')]")).click();
		
		//Clear the Country Code
		driver.findElement(By.name("phoneCountryCode")).clear();
		
		//Enter phone number
		driver.findElement(By.xpath("//input[@name=\"phoneNumber\"]")).sendKeys("9000000011");
		
		//Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(1000);
		
		//Capture lead ID of First Resulting lead
		WebElement lead = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		String id = lead.getText();
		System.out.println("Lead ID is : " +id);

		Thread.sleep(1000);
		
		//Click First Resulting lead
		lead.click();
		
		//Click Delete
		driver.findElement(By.className("subMenuButtonDangerous")).click();
		
		//Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
		
		//Enter captured lead ID
		driver.findElement(By.xpath("//label[text()='Lead ID:']/following::input[1]")).sendKeys(id);
		
		//Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		//Verify message "No records to display" in the Lead List. This message confirms the successful deletion
		String textValue = driver.findElement(By.xpath("//div[text()='No records to display']")).getText();
		
		if(textValue.equalsIgnoreCase("No records to display"))
		{
			System.out.println("Record is deleted successfully");
		}
		else
		{
			System.out.println("Record not deleted");
		}
		
		//Close the browser (Do not log out)
		driver.close();
		
		
		
		
		
	}

}
