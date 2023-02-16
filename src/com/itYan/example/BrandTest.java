package com.itYan.example;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.itYan.POJO.Brand;

/*
 * Brand data CRUD
 * */
public class BrandTest {

	/**
	 * selectAll
	 * Sql query: select * from tb_brand
	 * argument: no required
	 * @return List<Brand>
	 * */
	@Test
	public void testSelectAll() throws Exception {
		//1. loading configuration file
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/com/itYan/druid.properties"));
		//2. get connection pool
		DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
		
		//3. get Database connection
		Connection connection = dataSource.getConnection();
		
		//4. define sql query
		String sql = "select * from tb_brand";
		
		//5. get preparedStatement
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		//6. set argument
		
		//7. execute sql query, return ResltSet
		ResultSet resultSet = preparedStatement.executeQuery();
		
		//8. processing result, package resultSet to List<Brand>
		List<Brand> brands = new ArrayList<>();
		Brand brand = null;
		while(resultSet.next()) {
			brand = new Brand();
			
		    Integer id = resultSet.getInt("id"); 
		    String brandName = resultSet.getString("brand_name");
		    String companyName = resultSet.getString("company_name");
		    Integer ordered = resultSet.getInt("ordered");
		    String description = resultSet.getString("description");
		    Integer status = resultSet.getInt("status");
		    
		    brand.setId(id);
		    brand.setBrandName(brandName);
		    brand.setCompanyName(companyName);
		    brand.setOrdered(ordered);
		    brand.setDescription(description);
		    brand.setStatus(status);
		    
		    brands.add(brand);
		}
		
		System.out.println(brands);
		
		//9. release resource
		resultSet.close();
		preparedStatement.close();
		connection.close();
		
	}
	
	/**
	 * insert data
	 * Sql query: insert into tb_brand (brand_name, company_name, ordered, description, status) values (?, ?, ?, ?, ?)
	 * argument: brand:String, companyName:String, ordered:Integer, description:String, status:Integer
	 * @return boolean, insert successful or not
	 * */
	@Test
	public void testInsertData() throws Exception {
		//0. get Data from Web
		String brandName = "全聯福利中心";
		String companyName = "全聯股份有限公司";
		int ordered = 1000;
		String description = "實在真便宜";
		int status = 1;
		
		//1. loading configuration file
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/com/itYan/druid.properties"));
		//2. get connection pool
		DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
		
		//3. get Database connection
		Connection connection = dataSource.getConnection();
		
		//4. define sql query
		String sql = "insert into tb_brand (brand_name, company_name, ordered, description, status) values (?, ?, ?, ?, ?)";
		
		//5. get preparedStatement
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		//6. set argument
		preparedStatement.setString(1, brandName);
		preparedStatement.setString(2, companyName);
		preparedStatement.setInt(3, ordered);
		preparedStatement.setString(4, description);
		preparedStatement.setInt(5, status);
		
		//7. execute sql query, return ResltSet
		int count = preparedStatement.executeUpdate();
		
		//8. processing result
		if (count > 0) {
			System.out.println("Successful");
		} else {
			System.out.println("failed");
		}
		
		
		//9. release resource
		preparedStatement.close();
		connection.close();
		
	}
	
	/**
	 * Update Data
	 * Sql query: 
	 update tb_brand 
		 set brand_name = ?, 
		 company_name = ?, 
		 ordered = ?, 
		 description = ?, 
		 status = ? 
	 where id = ?
	 * argument: brand:String, companyName:String, ordered:Integer, description:String, status:Integer, id:Integer
	 * @return boolean, update successful or not
	 * */
	@Test
	public void testUpdateData() throws Exception {
		//0. get Data from Web
		String brandName = "全聯福利中心";
		String companyName = "全聯股份有限公司";
		int ordered = 1;
		String description = "實在不便宜";
		int status = 1;
		int id = 4;
		
		//1. loading configuration file
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/com/itYan/druid.properties"));
		//2. get connection pool
		DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
		
		//3. get Database connection
		Connection connection = dataSource.getConnection();
		
		//4. define sql query
		String sql = "update tb_brand \r\n"
				+ "		 set brand_name = ?, \r\n"
				+ "		 company_name = ?, \r\n"
				+ "		 ordered = ?, \r\n"
				+ "		 description = ?, \r\n"
				+ "		 status = ? \r\n"
				+ "	 where id = ?";
		
		//5. get preparedStatement
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		//6. set argument
		preparedStatement.setString(1, brandName);
		preparedStatement.setString(2, companyName);
		preparedStatement.setInt(3, ordered);
		preparedStatement.setString(4, description);
		preparedStatement.setInt(5, status);
		preparedStatement.setInt(6, id);
		
		//7. execute sql query, return ResltSet
		int count = preparedStatement.executeUpdate();
		
		//8. processing result
		if (count > 0) {
			System.out.println("Successful");
		} else {
			System.out.println("failed");
		}
		
		
		//9. release resource
		preparedStatement.close();
		connection.close();
		
	}
	
	/**
	 * Delete Data
	 * Sql query: 
	 delete from tb_brand  
	 where id = ?
	 * argument: id:int
	 * @return boolean, delete successful or not
	 * */
	@Test
	public void testDeleteData() throws Exception {
		//0. get Data from Web
		int id = 4;
		
		//1. loading configuration file
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/com/itYan/druid.properties"));
		//2. get connection pool
		DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
		
		//3. get Database connection
		Connection connection = dataSource.getConnection();
		
		//4. define sql query
		String sql = "delete from tb_brand  \r\n"
				+ "	 where id = ?";
		
		//5. get preparedStatement
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		//6. set argument
		preparedStatement.setInt(1, id);
		
		//7. execute sql query, return ResltSet
		int count = preparedStatement.executeUpdate();
		
		//8. processing result
		if (count > 0) {
			System.out.println("Successful");
		} else {
			System.out.println("failed");
		}
		
		
		//9. release resource
		preparedStatement.close();
		connection.close();
		
	}
}
