package practice.sdet31;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTripEndToEndScenarioTest {

	public static void main(String[] args) {
		
		 LocalDateTime dateAndTime= LocalDateTime.now();
		 String month = dateAndTime.getMonth().toString();
		 int date=dateAndTime.getDayOfMonth();
		 int year=dateAndTime.getYear();
		 String actualMonth= month.substring(0,1)+month.substring(1).toLowerCase();
		 
		 String monthAndYear = actualMonth+" "+year;
		 
		 
		 
		 WebDriverManager.chromedriver().setup();
		 WebDriver driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		  
		  driver.get("https://www.makemytrip.com/");
		  
		 Actions action = new Actions(driver); 
		 action.moveByOffset(20,20).click().perform();
		  
		 driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		  
		  driver.findElement(By.xpath("//span[@class='chNavIcon appendBottom2 chSprite chFlights active']")).click();
		  
		  driver.findElement(By.xpath("//span[text()='From']")).click();
		  driver.findElement(By.xpath("//div[text()='CCU']")).click();
		  
		  driver.findElement(By.xpath("//span[text()='To']")).click();
		  driver.findElement(By.xpath("//div[text()='KTM']")).click();
		  
		  driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		  
		  driver.findElement(By.xpath("//div[text()='"+monthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']")).click();
		 
		  driver.findElement(By.xpath("//a[text()='Search']")).click(); 
		  
		 List<WebElement> listOfFlights = driver.findElements(By.xpath("//span[@class='boldFont blackText airlineName']"));
		 for (WebElement ele : listOfFlights) 
		 {
			 
			 System.out.println(ele.getText());
			 
			
		}
		 
		 driver.close();
		 driver.quit();
		 
	}

}
