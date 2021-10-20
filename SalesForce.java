package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForce {

	public static void main(String[] args) {

		// Step 1: Download and set the path 
		WebDriverManager.chromedriver().setup();
		
		// Step 2: Launch the chromebrowser
		ChromeDriver driver = new ChromeDriver();
		
		// Step 3: Load the URL 
		driver.get("https://www.salesforce.com/in/form/signup/freetrial-sales/?d=70130000000Enyk");
		
		// Step 4: Maximise the window
		driver.manage().window().maximize();
		
		//Handle popup
		driver.findElement(By.xpath("//button[contains(text(),'Reject')]")).click();
		
		// Step 5: Add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		// Step 6: Fill in all the text boxes
		//FirstName
		driver.findElement(By.xpath("//input[@name='UserFirstName']")).sendKeys("Test");
		
		//LastName
		driver.findElement(By.xpath("//input[@name='UserLastName']")).sendKeys("User");
		
		//Work Email
		driver.findElement(By.xpath("//input[@name='UserEmail']")).sendKeys("testuser@gmail.com");
		
		//Company name
		driver.findElement(By.xpath("//input[@name='CompanyName']")).sendKeys("QATest");
		
		// Step 7: Handle all the dropdowns
		//Job Title
		WebElement jobTitle = driver.findElement(By.xpath("//select[@name='UserTitle']"));
		Select dropdown = new Select(jobTitle);
		dropdown.selectByIndex(3);
		
		//Employees
		WebElement employees = driver.findElement(By.xpath("//select[@name='CompanyEmployees']"));
		Select dropdown1 = new Select(employees);
		dropdown1.selectByValue("75");
		
		//Country
		WebElement country = driver.findElement(By.xpath("//select[@name='CompanyCountry']"));
		Select dropdown2 = new Select(country);
		dropdown2.selectByVisibleText("India");
		
		//State
		WebElement state = driver.findElement(By.xpath("//select[@name='CompanyState']"));
		Select dropdown3 = new Select(state);
		dropdown3.selectByVisibleText("Tamil Nadu");
		
		//Phone Number
		driver.findElement(By.xpath("//input[@name='UserPhone']")).sendKeys("9000000010");
		
		// Step 8: Click the check box
		driver.findElement(By.xpath("//input[@id='SubscriptionAgreement']/following-sibling::div[1]")).click();
		
		// Step 9: Close the browser
		driver.close();
		
	}

}
