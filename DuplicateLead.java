package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

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
		
		//Click on Email
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		
		//Enter Email
		driver.findElement(By.xpath("//input[@name=\"emailAddress\"]")).sendKeys("xyz@gmail.com");
		
		//Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(1000);
		
		//Capture name of First Resulting lead
		WebElement leadName = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a"));
		String lName = leadName.getText();
		
		Thread.sleep(1000);
		//Click First Resulting lead
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		
		//Click Duplicate Lead
		driver.findElement(By.linkText("Duplicate Lead")).click();
		
		//Verify the title as 'Duplicate Lead'
		String titleText = driver.findElement(By.xpath("//div[contains(text(),'Duplicate Lead')]")).getText();
		if(titleText.equalsIgnoreCase("Duplicate Lead"))
		{
			System.out.println("The title is : "+titleText);
		}
		else
			System.out.println("Title does not match");
		
		//Click Create Lead
		driver.findElement(By.className("smallSubmit")).click();
		
		//Confirm the duplicated lead name is same as captured name
		String dupLead = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		
		if(lName.equalsIgnoreCase(dupLead))
		{
			System.out.println("Both Name are same");
		}
		else
			System.out.println("Both Name are not same");
		
		//Close the browser (Do not log out)
		driver.close();
		
		
		
		
	}

}
