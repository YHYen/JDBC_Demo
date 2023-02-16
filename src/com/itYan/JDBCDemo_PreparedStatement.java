package com.itYan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.jupiter.api.Test;

/*
 * JDBC API: PreparedStatement
 * */
public class JDBCDemo_PreparedStatement {
	
	/*
	 * user login test with preparedStatement
	 * @throws Exception
	 * */
	@Test
	public void testLogin() throws Exception {
		String url = "jdbc:mysql://127.0.0.1:3306/db1?useServerPrepStmts=true";
		String username = "root";
		String password = "12345678";
		Connection conn = DriverManager.getConnection(url, username, password);
		
		//3. get username and password
		String name = "zhangsan";
		String pwd = "'or '1' = '1";
		//String pwd = "123";
		
		//4. define sql query
		String sql = "select * from tb_user where username = ? and password = ?";
		 

		//4. get the preparedStatement to execute sql query
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		
		//5. set the value of the ?
		preparedStatement.setString(1, name);
		preparedStatement.setString(2, pwd);
		
		//6. execute sql query
		ResultSet resultSet = preparedStatement.executeQuery();
		
		//6. Determine whether the login is successful
		if(resultSet.next()) {
			System.out.println("Login successful");
		} else {
			System.out.println("Login failed");
		}
		
		
		//7. release resources
		resultSet.close();
		preparedStatement.close();
		conn.close();
	}
}
