package practice.sdet31.testNgPractice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultipleDataTest {
	/**
	 * to execute multiple data using@DataProvider annotation
	 * @param name
	 * @param company
	 * @param emailID
	 * @param empID
	 */
	@Test(groups="smokeTest",dataProvider="getdata")
	 public void multipleData(String name, String company, String emailID, String empID)
	 {
		System.out.println(name);
		System.out.println(company);
		System.out.println(emailID);
		System.out.println(empID);
		
		System.out.println("=============================================================");
		
	 }
	
	@DataProvider
	public Object[][] getdata()
	{
		Object[][] objArray = new Object[2][4];
		objArray[0][0]="Padmashree";
		objArray[0][1]="TYSS Bangalore";
		objArray[0][2]="padmashree@gmail.com";
		objArray[0][3]="EMP001";
		
		objArray[1][0]="Padma";
		objArray[1][1]="TYSS Bangalore";
		objArray[1][2]="Padma@gmail.com";
		objArray[1][3]="EMP002";
		
		return objArray;
	}
	

}
