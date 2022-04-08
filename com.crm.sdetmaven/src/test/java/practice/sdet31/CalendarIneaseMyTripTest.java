package practice.sdet31;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarIneaseMyTripTest {
	public static void main(String[] args) {

		String month = "May 2022";
		String date="30";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.easemytrip.com/");
		
		/*
		 * Actions action = new Actions(driver); action.moveByOffset(20,
		 * 20).click().perform();
		 * 
		 * //driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		 */		
		
		driver.findElement(By.xpath("//input[@placeholder='Departure']")).click();
		
		String calendarxpath="//div[text()='"+month+"']/ancestor::div[@class='main']/descendant::li[text()='"+date+"']";
		for(;;)
		{
		
		try {
			driver.findElement(By.xpath(calendarxpath)).click();
			break;
			
		}
		catch(Exception e)
		{
			
			driver.findElement(By.xpath("//img[@id='img2Nex']")).click();
				
			
			
		}
		
		}
		
		
		driver.close();
		
		System.out.println("Thankyou for using");
		
		driver.quit();
		
		
		
		
		
		

	}


}
