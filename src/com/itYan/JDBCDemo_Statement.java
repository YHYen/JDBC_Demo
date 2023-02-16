package com.itYan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.junit.jupiter.api.Test;

/*
 * JDBC API: Statement
 * */
public class JDBCDemo_Statement {
	
	
	/**
	 * execute DML query
	 * @throws Exception
	 * */
	@Test
	public void testDML() throws Exception {
		String url = "jdbc:mysql://127.0.0.1:3306/db1";
		String username = "root";
		String password = "12345678";
		Connection conn = DriverManager.getConnection(url, username, password);
		
		String sql = "update account set money = 3000 where id = 1";
		
		Statement statement = conn.createStatement();
		
		int count = statement.executeUpdate(sql);
		
		if (count > 0) {
			System.out.println("Modified successful.");
		} else {
			System.out.println("fail to edit.");
		}
		
		statement.close();
		conn.close();
	}
	
	/**
	 * execute DDL query
	 * @throws Exception
	 * */
	@Test
	public void testDDL() throws Exception {
		String url = "jdbc:mysql://127.0.0.1:3306/db1";
		String username = "root";
		String password = "12345678";
		Connection conn = DriverManager.getConnection(url, username, password);
		
		String sql = "drop database db2";
		
		Statement statement = conn.createStatement();
		
		int count = statement.executeUpdate(sql);
		
//		if (count > 0) {
//			System.out.println("Modified successful.");
//		} else {
//			System.out.println("fail to edit.");
//		}
		
		System.out.println(count); // may be 0
		
		statement.close();
		conn.close();
	}
}
