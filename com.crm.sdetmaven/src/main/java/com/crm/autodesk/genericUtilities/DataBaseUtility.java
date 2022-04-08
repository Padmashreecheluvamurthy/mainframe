package com.crm.autodesk.genericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

/**
 * This class is used to store the database related methods
 * @author Padmashree
 *
 */
public class DataBaseUtility {
	Connection connection;
	
	/**
	 * method used to register the database and connect it with the driver of mysql.cj.jdbc.driver
	 */
	public void connectToDB()
	{
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			connection=DriverManager.getConnection(IPathConstants.DATABASE_URL,IPathConstants.DB_USERNAME,IPathConstants.DB_PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 *method used  to insert the data to the database and validate the process
	 * @param query
	 * @return boolean
	 */
	public boolean insertData(String query)
	{
		try {
			int result=connection.createStatement().executeUpdate(query);
			boolean flag=false;
			if(result==1) 
			{
				System.out.println("data is added");
				flag=true;
				return flag;
				}
			else {
				System.out.println("data is not added");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
	/**
	 * method used to get all data from the table
	 * @param query
	 * @return ResultSet
	 */
	
	public ResultSet getAllData(String query)
	{
		try {
			ResultSet result = connection.createStatement().executeQuery(query);
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * this method will close the database connection
	 */
	public void closeDB()
	{
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	

}
