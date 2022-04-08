package practice.sdet31;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.autodesk.genericUtilities.ExcelUtility;
import com.crm.autodesk.genericUtilities.JavaUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrganizationSearchingManuallyTest {
	public static void main(String[] args) throws Throwable{
		 WebDriverManager.chromedriver().setup();
		 WebDriver driver= new ChromeDriver();
		 
		 ExcelUtility eil = new ExcelUtility();
		 JavaUtility jil= new JavaUtility();
		 
		 String org1 = eil.getDataFromExcel("org", 1, 1);
		 String orgName=org1+ jil.getRandomNumber();
		 
		 driver.manage().window().maximize();
		 
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		 driver.get("http://localhost:8888");
		 
			//enter credentials and login
			driver.findElement(By.name("user_name")).sendKeys("admin");
			driver.findElement(By.name("user_password")).sendKeys("admin");
			driver.findElement(By.id("submitButton")).click();
			
			
			//create organization
			driver.findElement(By.linkText("Organizations")).click();
			
			
			
			//navigate to create organization
			driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			
			//create a new org
		driver.findElement(By.name("accountname")).sendKeys(orgName);
			
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
			 String headerText = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			 
			 String createdOrg = headerText.split(" ")[3];	 
			 
			 
			 // click on organizations link to get organization list page
			 driver.findElement(By.linkText("Organizations")).click();
			
			 List<WebElement> listOfOrgs = driver.findElements(By.xpath("//a[@title='"+createdOrg+"']"));
			 for (WebElement ele : listOfOrgs)
			 {
				 System.out.println(ele.getText());
				
			  }
			 	 
			for(;;) 
			{
				
				try {
					 		
						driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]//a[text()='"+createdOrg+"']")).click();	
						break;
					}	
		  catch(Exception e)
			 {
				 driver.findElement(By.xpath("//img[@src='themes/images/next.gif']")).click();
			 }
			}
			
			driver.findElement(By.name("Delete")).click();
			driver.switchTo().alert().accept();
			
			
			driver.quit();
			
			}
			 
	 		
		
}
	
	
				
				
					 
					 
			    
				
				


			 
			
				 
			 
					


