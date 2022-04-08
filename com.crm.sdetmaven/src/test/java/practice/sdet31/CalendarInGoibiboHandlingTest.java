package practice.sdet31;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarInGoibiboHandlingTest {
	
	public static void main(String[] args) {

		String monthAndDate = "May 2022";
		String date="30";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.goibibo.com/");
		
		Actions action = new Actions(driver);
		action.moveByOffset(20, 20).click().perform();
		
		//driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		
		
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		
		String calendarxpath="//div[text()='"+monthAndDate+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']";
		for(;;)
		{
		
		try {
			driver.findElement(By.xpath(calendarxpath)).click();
			break;
			
		}
		catch(Exception e)
		{
			
			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
				
			
			
		}
		
		}
		
		
		driver.close();
		
		System.out.println("Thankyou for using");
		
		driver.quit();
		
		
		
		
		
		

	}

}




