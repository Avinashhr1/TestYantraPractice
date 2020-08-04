package com.Ty.crm.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseLib {
/*
 * 
 * @author Avinash
 * 
 */
	
	Connection con;
	Statement state;
	PropertyFileLib prop = new PropertyFileLib();
	
	public void conectToDatabase() throws Throwable{
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);
		con = DriverManager.getConnection(prop.getPropertyFileData("dbUrl"),prop.getPropertyFileData("dbUsername"),prop.getPropertyFileData("dbPassword"));
		state = con.createStatement();
	
	}
	
	
//	public void executeQuery(String query) throws Throwable {
//		/*step1: register the database driver  */
//		Driver driverref = new Driver();
//		DriverManager.registerDriver(driverref);
//		
//		
//		/*step2: connect to database */
//		con = DriverManager.getConnection(prop.getPropertyFileData("dbUrl"),prop.getPropertyFileData("dbUsername"),prop.getPropertyFileData("dbPassword"));
//		
//		/*step3: create statement */
//		state = con.createStatement();
//		
//		/*step4: execute the query */
//		ResultSet result = state.executeQuery(query);
//		
//		/*display the result*/
//		while(result.next()) {
//			System.out.println(result.getString("firstname") + " " + result.getString("email"));
//			//System.out.println(result.getInt(1) + "/t" + result.getString(2) + "/t"+ result.getString(3) + "/t" + result.getString(4));
//		}
//		
//		/*step5: disconnect the database */
//		con.close();
//		
//	}
	
	public ResultSet executeSelectQuery(String query) throws Throwable {
		ResultSet result = state.executeQuery(query);
		while(result.next()) {
			System.out.println(result.getString(1)+"\t"+result.getString(2));
		}
		return result;
	}
	
	
	public int executeNonSelectQuery(String query) throws SQLException {
		  int result = state.executeUpdate(query);
			System.out.println(result);
		return result;
		
		
	}

	public void closeDBConnection() throws SQLException {
		con.close();
	}
	
	
	
}
