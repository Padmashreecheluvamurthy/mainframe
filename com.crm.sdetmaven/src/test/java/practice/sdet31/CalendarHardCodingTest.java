package practice.sdet31;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarHardCodingTest {
public static void main(String[] args)
	 {

		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.makemytrip.com");
		Actions action = new Actions(driver);
		action.moveByOffset(20, 20).click().perform();
		
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		
		
		
		
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		
		String calendarxpath="//div[text()='March 2022']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='24']";
		driver.findElement(By.xpath(calendarxpath)).click();
		
		

	}

}
