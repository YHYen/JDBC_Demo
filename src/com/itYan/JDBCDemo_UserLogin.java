package com.itYan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.jupiter.api.Test;


/*
 * JDBC: User Login
 * */
public class JDBCDemo_UserLogin {

	/**
	 * user login test
	 * @throws Exception
	 * */
	@Test
	public void testLogin() throws Exception {
		String url = "jdbc:mysql://127.0.0.1:3306/db1";
		String username = "root";
		String password = "12345678";
		Connection conn = DriverManager.getConnection(url, username, password);
		
		//3. get username and password
		String name = "zhangsan";
		String pwd = "123";
		
		String sql = "select * from tb_user where username = '" + name + "' and password = '" + pwd + "'";
		 

		//4. get the statement to execute sql query
		Statement statement = conn.createStatement();
		
		//5. execute sql query, return the set of result
		ResultSet resultSet = statement.executeQuery(sql);
		
		//6. Determine whether the login is successful
		if(resultSet.next()) {
			System.out.println("Login successful");
		} else {
			System.out.println("Login failed");
		}
		
		
		//7. release resources
		resultSet.close();
		statement.close();
		conn.close();
	}
	
	/**
	 * user login test with Sql injection
	 * @throws Exception
	 * */
	@Test
	public void testLoginInject() throws Exception {
		String url = "jdbc:mysql://127.0.0.1:3306/db1";
		String username = "root";
		String password = "12345678";
		Connection conn = DriverManager.getConnection(url, username, password);
		
		//3. get username and password
		String name = "fgsjtsfrgt";
		String pwd = "'or '1' = '1";
		
		String sql = "select * from tb_user where username = '" + name + "' and password = '" + pwd + "'";
		 

		//4. get the statement to execute sql query
		Statement statement = conn.createStatement();
		
		//5. execute sql query, return the set of result
		ResultSet resultSet = statement.executeQuery(sql);
		
		//6. Determine whether the login is successful
		if(resultSet.next()) {
			System.out.println("Login successful");
		} else {
			System.out.println("Login failed");
		}
		
		
		//7. release resources
		resultSet.close();
		statement.close();
		conn.close();
	}
	
}
