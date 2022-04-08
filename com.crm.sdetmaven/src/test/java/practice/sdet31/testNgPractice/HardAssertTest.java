package practice.sdet31.testNgPractice;

import java.util.ArrayList;
//import java.util.Collection;
import java.util.HashSet;

import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertTest {
	@Test
	public void hardAssert()
	{
		String name1="Padmashree";
		String name2="Padmashree";
		Assert.assertEquals(name1, name2);
		
		int a=20;
		int b=20;
		Assert.assertEquals(a, b);
		
		Set<String> str1= new HashSet<String>();
		str1.add("testyantra");
		str1.add("banashankari");
		
		Set<String> str2= new HashSet<String>();
		str2.add("testyantra");
		str2.add("banashankari");
		
		Assert.assertEquals(str1, str2);
		
		
		
		ArrayList<Integer> arr1= new ArrayList<Integer>();
		arr1.add(10);
		arr1.add(20);
		
		ArrayList<Integer> arr2= new ArrayList<Integer>();
		arr2.add(10);
		arr2.add(20);
		Assert.assertEquals(arr1, arr2);
			
		
		int a1[]= {10,20,30,40};
		int b1[]= {10,20,30,40};		
		Assert.assertEquals(a1, b1);
	
		
		
		char ch1='a';
		char ch2='a';
		Assert.assertEquals(ch1, ch2);
		
		
		double d1=123.5;
		double d2=123.5;
		Assert.assertEquals(d1, d2);
				
		boolean value1= true;
		boolean value2=true;
		Assert.assertEquals(value1, value2);
		
	
		
		
		
		
		
		
		
		
		
		
			
	}

}
