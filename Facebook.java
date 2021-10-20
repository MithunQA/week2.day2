package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {

	public static void main(String[] args) {

		// Step 1: Download and set the path 
		WebDriverManager.chromedriver().setup();
		
		// Step 2: Launch the chromebrowser
		ChromeDriver driver = new ChromeDriver();
		
		// Step 3: Load the URL https://en-gb.facebook.com/
		driver.get("https://en-gb.facebook.com/");
		
		// Step 4: Maximise the window
		driver.manage().window().maximize();
		
		//Handling popup
		driver.findElement(By.xpath("//button[contains(@title,'Allow')]")).click();
		
		// Step 5: Add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		// Step 6: Click on Create New Account button
		driver.findElement(By.xpath("//a[contains(text(),'Forgotten password')]/following::a")).click();
		
		// Step 7: Enter the first name
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("FName");
		
		// Step 8: Enter the last name
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("LName");
		
		// Step 9: Enter the mobile number
		driver.findElement(By.xpath("//div[contains(text(),'Mobile')]/following-sibling::input")).sendKeys("9000000001");
		
		// Step 10: Enter the password
		driver.findElement(By.xpath("//div[contains(text(),'New password')]/following-sibling::input")).sendKeys("password");
		
		// Step 11: Handle all the three drop downs
		//Handling Days Dropdown
		WebElement dayDD = driver.findElement(By.id("day"));
		Select dropdownD = new Select(dayDD);
		dropdownD.selectByIndex(20);
		
		//Handling Months Dropdown
		WebElement monthDD = driver.findElement(By.id("month"));
		Select dropdownM = new Select(monthDD);
		dropdownM.selectByValue("11");
		
		//Handling Years Dropdown
		WebElement yearDD = driver.findElement(By.id("year"));
		Select dropdownY = new Select(yearDD);
		dropdownY.selectByVisibleText("1990");
		
		// Step 12: Select the radio button "Female" 
		driver.findElement(By.xpath("//label[contains(text(),'Female')]/following-sibling::input")).click();
		

	}

}
