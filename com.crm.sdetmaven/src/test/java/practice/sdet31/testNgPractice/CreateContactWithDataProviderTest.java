package practice.sdet31.testNgPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithDataProviderTest {
	
	@Test(groups="systemTest",dataProvider="getdata")
	public void createContacts(String lastName,String mobileNum)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,10);
		 driver.get("http://localhost:8888/");
		
		 //enter credentials and login
			driver.findElement(By.name("user_name")).sendKeys("admin");
			driver.findElement(By.name("user_password")).sendKeys("admin");
			driver.findElement(By.id("submitButton")).click();
			
			
		//create contacts
			driver.findElement(By.linkText("Contacts")).click();
			
			driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
			 driver.findElement(By.name("lastname")).sendKeys(lastName);
			 driver.findElement(By.id("mobile")).sendKeys(mobileNum);
			 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			 WebElement visibleElement = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
			 wait.until(ExpectedConditions.visibilityOf(visibleElement));
			 
			 
			 WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			 Actions action = new Actions(driver);
			 action.moveToElement(element).perform();
			 
			 driver.findElement(By.linkText("Sign Out")).click();
			 
			 driver.quit();
			 
	}


@DataProvider
public Object[][] getdata()
{
	Object[][] objArray = new Object[2][2];
	objArray[0][0]="Padmashree";
	objArray[0][1]="7894561230";
	
	
	objArray[1][0]="Padma";
	objArray[1][1]="9874561230";
	
	
	return objArray;
}
}
