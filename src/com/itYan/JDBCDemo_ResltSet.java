package com.itYan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.itYan.POJO.Account;

/*
 * JDBC API: Statement
 * */
public class JDBCDemo_ResltSet {
    /**
     * execute DQL query
     * @throws Exception
     * */
    @Test
    public void testResultSet() throws Exception {
        String url = "jdbc:mysql://127.0.0.1:3306/db1";
        String username = "root";
        String password = "12345678";
        Connection conn = DriverManager.getConnection(url, username, password);

        //3. define sql query
        String sql = "select * from account";

        //4. get the statement to execute sql query
        Statement statement = conn.createStatement();

        //5. execute sql query, return the set of result
        ResultSet resultSet = statement.executeQuery(sql);

        //6.1. print result set
		/*while (resultSet.next()) {
			int id = resultSet.getInt(1);
			String name = resultSet.getString(2);
			int money = resultSet.getInt(3);
			
			System.out.printf("%d %s %d%n--------%n", id, name, money);
			
		}*/

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("Name");
            int money = resultSet.getInt("money");

            System.out.printf("%d %s %d%n--------%n", id, name, money);

        }

        //7. release resources
        resultSet.close();
        statement.close();
        conn.close();
    }

    /**
     * execute DQL query and package to Account
     * 1. define class Account
     * 2. execute sql query and package to Account
     * 3. save account to arraylist
     * @throws Exception
     * */
    @Test
    public void testResultSet_ArrayList() throws Exception {
        String url = "jdbc:mysql://127.0.0.1:3306/db1";
        String username = "root";
        String password = "12345678";
        Connection conn = DriverManager.getConnection(url, username, password);

        //3. define sql query
        String sql = "select * from account";

        //4. get the statement to execute sql query
        Statement statement = conn.createStatement();

        //5. execute sql query, return the set of result
        ResultSet resultSet = statement.executeQuery(sql);

        //6. get result set and package to account
        List<Account> list = new ArrayList<>();

        while (resultSet.next()) {
            Account account = new Account();

            int id = resultSet.getInt("id");
            String name = resultSet.getString("Name");
            int money = resultSet.getInt("money");

            account.setID(id);
            account.setName(name);
            account.setMoney(money);

            list.add(account);

        }

        System.out.println(list);

        //7. release resources
        resultSet.close();
        statement.close();
        conn.close();
    }
}
