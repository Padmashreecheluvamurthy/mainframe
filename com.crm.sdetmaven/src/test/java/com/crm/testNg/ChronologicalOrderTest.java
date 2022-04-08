package com.crm.testNg;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ChronologicalOrderTest {
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("establish database connection1");
	}


@BeforeSuite
public void beforeSuite1() {
	System.out.println("establish database connection2");
}


@BeforeSuite
public void beforeSuite2() {
	System.out.println("establish database connection3");
}


@BeforeSuite
public void beforeSuite3() {
	System.out.println("establish database connection4");
}

@BeforeTest
public void beforeTest()
{
	System.out.println("exceute in parallel mode1");
}

@BeforeTest
public void beforeTest1()
{
	System.out.println("exceute in parallel mode2");
}
@BeforeTest
public void beforeTest2()
{
	System.out.println("exceute in parallel mode3");
}
@BeforeTest
public void beforeTest3()
{
	System.out.println("exceute in parallel mode4");
}

@BeforeMethod
public void beforeMethod1()
{
	System.out.println("before method 1");
}

@BeforeMethod
public void beforeMethod2()
{
	System.out.println("before method 1");
}
@BeforeMethod
public void beforeMethod5()
{
	System.out.println("before method 1");
}
@BeforeMethod
public void beforeMethod3()
{
	System.out.println("before method 1");
}
@BeforeMethod
public void beforeMethod4()
{
	System.out.println("before method 1");
}

@Test
public void test1()
{
	System.out.println("test1");

	
}
}


