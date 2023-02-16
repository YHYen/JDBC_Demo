package com.itYan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/*
 * JDBC
 * */
public class JDBCDemo {
	public static void main(String[] args) throws Exception {
		//1. register driver
		/*
		 * if version is better than mysql5
		 * can not write
		 * */
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//2. get connection
		/*
		 * if use localhost mysql and the port numebr is 3306
		 * can be abbreviated as "jdbc:mysql:///db1";
		 * */
		// if don't want to use ssl can be abbreviated as "jdbc:mysql://127.0.0.1:3306/db1?useSSL=false"
		String url = "jdbc:mysql://127.0.0.1:3306/db1";
		String username = "root";
		String password = "12345678";
		Connection conn = DriverManager.getConnection(url, username, password);
		
		//3. define sql query
		String sql = "update account set money = 2000 where id = 1";
		
		//4. get the statement to execute sql query
		Statement statement = conn.createStatement();
		
		//5. execute sql query, return the number of affected rows
		int count = statement.executeUpdate(sql);
		
		//6. print the result
		System.out.println(count);
		
		//7. release resources
		statement.close();
		conn.close();
	}
}
