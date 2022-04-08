package practice.sdet31;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LastCheckListClickTest {
	public static void main(String[] args) throws Throwable {
		 WebDriverManager.chromedriver().setup();
		 WebDriver driver= new ChromeDriver();
		 
		 driver.manage().window().maximize();
		 
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		 driver.get("http://localhost:8888");
		 
			//enter credentials and login
			driver.findElement(By.name("user_name")).sendKeys("admin");
			driver.findElement(By.name("user_password")).sendKeys("admin");
			driver.findElement(By.id("submitButton")).click();
			
			
			//create organization
			driver.findElement(By.linkText("Organizations")).click();
			
		List<WebElement> checkbox =driver.findElements(By.xpath("//input[@name='selected_id']"));
		
		  int lastCheckBox = checkbox.size()-1;
		  checkbox.get(lastCheckBox).click();
			
		
			
			
			
		
		
		driver.close();
		
		 
		 

	}
}





