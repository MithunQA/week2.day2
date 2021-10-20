package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

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
		
		//Enter first name
		driver.findElement(By.xpath("//label[contains(text(),'Lead ID:')]/following::input[2]")).sendKeys("FName");
		
		//Click Find leads button
		driver.findElement(By.linkText("Find Leads")).click();
		Thread.sleep(1000);
		
		//Click on first resulting lead
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		
		//Verify title of the page
		String titleText = driver.findElement(By.xpath("//div[contains(text(),'View Lead')]")).getText();
		if(titleText.equalsIgnoreCase("View Lead"))
		{
			System.out.println("The title is : "+titleText);
		}
		else
			System.out.println("Title does not match");
		
		//Click Edit
		driver.findElement(By.xpath("//a[text()=\"Edit\"]")).click();
		
		//Change the company name
		String editName = "EditedCompName";
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(editName);
		
		//Click Update
		driver.findElement(By.xpath("(//input[@class=\"smallSubmit\"])[1]")).click();
		
		//Confirm the changed name appears
		String newValue = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		String[] value = newValue.split(" ");
		String value1="";
		for (int i = 0; i < value.length; i++) {
			value1=value[0].trim();
			System.out.println(value1);
			break;
		}
		
		if(editName.equalsIgnoreCase(value1))
		{
			System.out.println("Both are same Name");
		}
		else
			System.out.println("Name are not same");
		
		//Close the browser (Do not log out)
		//driver.close();
		
	}

}
