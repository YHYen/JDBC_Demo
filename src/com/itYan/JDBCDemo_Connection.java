package com.itYan;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/*
 * JDBC API: Connection
 * */
public class JDBCDemo_Connection {
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url = "jdbc:mysql://127.0.0.1:3306/db1";
		String username = "root";
		String password = "12345678";
		Connection conn = DriverManager.getConnection(url, username, password);
		
		String sql1 = "update account set money = 3000 where id = 1";
		String sql2 = "update account set money = 3000 where id = 2";
		
		Statement statement = conn.createStatement();
		
		
		try {
			// Open transaction
			conn.setAutoCommit(false);;
			
			//execute sql query
			int count1 = statement.executeUpdate(sql1);
			System.out.println(count1);
			
			//int i = 3/0;
			
			int count2 = statement.executeUpdate(sql2);
			System.out.println(count2);
			
			// Commit transaction
			conn.commit();
		} catch (Exception e) {
			// roll back transaction
			conn.rollback();
			e.printStackTrace();
		}
		
		
		statement.close();
		conn.close();
	}
}
