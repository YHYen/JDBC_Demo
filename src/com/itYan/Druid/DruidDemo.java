package com.itYan.Druid;

import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

/*
 * Druid Database connection Pool
 * */
public class DruidDemo {
    public static void main(String[] args) throws Exception {
        //1. import jar package
        //2. define configuration file
        //3. loading configuration file
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/com/itYan/druid.properties"));
        //4. get connection pool
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        //5. get Database connection
        Connection connection = dataSource.getConnection();

        System.out.println(connection);

//		System.out.println(System.getProperty("user.dir"));
    }
}
