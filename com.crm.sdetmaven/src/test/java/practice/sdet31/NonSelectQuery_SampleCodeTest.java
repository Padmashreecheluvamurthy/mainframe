package practice.sdet31;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class NonSelectQuery_SampleCodeTest {

		public static void main(String[] args) throws Throwable {
			
			Connection conn = null;
			int result =0;
					
		try
		{
			Driver driverRef = new Driver();
			
			//step1 : load /register  the database
			DriverManager.registerDriver(driverRef);
			
			//step 2 : connect to database
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testyantra", "root","root");
			System.out.println("connection is done");
			
			// Step 3: create query statement
			
			Statement stat=conn.createStatement();
			String query="insert into students_info values(6,'nitesh', 'bharadhwaj' ,'k')";
			
			
			//step 4: execute the query
			 result = stat.executeUpdate(query);
			 
			  }
		catch(Exception e) {
		}
		
		finally {
			
			if (result ==1)
			{
				System.out.println("Project inserted succesfully");
			}
			else
			{
				System.err.println("project is not inserted--!");
			}
			
			
			//step5 : close the connection
			conn.close();
			System.out.println("====== close db connection======");
		}
			 }
			
			
			
			
		 
		

	}

