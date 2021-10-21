package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AcmeTest {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		//Load url "https://acme-test.uipath.com/login"
		driver.get("https://acme-test.uipath.com/login");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Enter email as "kumar.testleaf@gmail.com"
		driver.findElement(By.xpath("//input[@id=\"email\"]")).sendKeys("kumar.testleaf@gmail.com");
		
		//Enter Password as "leaf@12"
		driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("leaf@12");
		
		//Click login button
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		
		//Get the title of the page and print
		System.out.println(driver.getTitle());
		
		//Click on Log Out
		driver.findElement(By.linkText("Log Out"));
		
		//Close the browser (use -driver.close())
		driver.close();
	}

}
