package practice.sdet31;

import java.util.Random;

public class GetRandomDataTest {
	public static void main(String[] args)
	{
		Random ran = new Random();
		int rannum = ran.nextInt(1000);
		System.out.println(rannum);
		
		
	}

}
