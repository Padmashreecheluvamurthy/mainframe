package practice.sdet31;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * program to book a room in bangalore
 * @author Padmashree
 *
 */
public class GoibiboHotelBookkingTest {
	public static void main(String[] args) throws Throwable{
		 WebDriverManager.chromedriver().setup();
		 WebDriver driver= new ChromeDriver();
		 
		 driver.manage().window().maximize();
		 
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		 
		 
		 driver.get("https://www.goibibo.com/hotels/");
		 
		 driver.findElement(By.xpath("//h4[text()='India']/preceding-sibling::input[@type='radio']")).click();
		 
		 driver.findElement(By.cssSelector("input[placeholder='e.g. - Area, Landmark or Hotel Name']")).sendKeys("Bengaluru");
		 driver.findElement(By.cssSelector("input[placeholder='e.g. - Area, Landmark or Hotel Name']")).sendKeys(Keys.ARROW_DOWN);
		 driver.findElement(By.cssSelector("input[placeholder='e.g. - Area, Landmark or Hotel Name']")).sendKeys(Keys.ENTER);
		 
		driver.findElement(By.xpath("//div[@data-testid='openCheckinCalendar']")).click();
		driver.findElement(By.xpath("//span[@data-testid='date_31_2_2022']")).click();
		
		
		driver.findElement(By.xpath("//span[@data-testid='date_31_2_2022']")).click();
		
		driver.findElement(By.xpath("//span[@data-testid='date_1_3_2022']")).click();
		
		// adding 3 children
		driver.findElement(By.xpath("//input[@class='SearchBlockUIstyles__CitySearchInput-sc-fity7j-12 uGGSH']")).click();
		driver.findElement(By.xpath("//span[text()='Children']/following::span[text()='+']")).click();
		driver.findElement(By.xpath("//span[text()='Children']/following::span[text()='+']")).click();
		driver.findElement(By.xpath("//span[text()='Children']/following::span[text()='+']")).click();
		
	
	// adding age 	
		
		String select="//p[@class='PaxWidgetstyles__SelectedChildAgeErrorText-sc-gv3w6r-12 cvwGUW']/ancestor::div[@class='dwebCommonstyles__CenteredDivWrap-sc-112ty3f-1 PaxWidgetstyles__ContentItemWrapperDiv-sc-gv3w6r-2 ibYPGm fAmNIr']/div";
		   List<WebElement> selectAge= driver.findElements(By.xpath(select));
		 
		    for (WebElement ele : selectAge) {
			  ele.click();
			   driver.findElement(By.xpath("//ul[@class='PaxWidgetstyles__ChildDropdownWrap-sc-gv3w6r-9 cuOfFa']/li[text()='1']")).click();
	}
		    driver.findElement(By.xpath("//button[text()='Done']")).click();
		    
		    //used to click on search hotel button
		    driver.findElement(By.xpath("//button[text()='Search Hotels']")).click();
		   
		    
		   //print all hotels name using for each loop
		     
		    List<WebElement> allHotels = driver.findElements(By.xpath("//h4[@itemprop='name']"));
		    
		    for (WebElement webElement : allHotels) {
		    	System.out.println("hotel name :: "+webElement.getText());
				
			}
	}
	

		
		
		
		 
		 
		 
	

}

