package com.yhsms.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

//连接数据库进行查询
public class DBUtil {
	Connection conn;
    Statement stmt;//非预编译
    PreparedStatement pstmt;//预编译 
    
    public DBUtil() {
		//进行conn实例化操作，jdbc连接操作
    	try {
    		Properties prpo=new Properties();
    		prpo.load(new FileInputStream("prop.properties"));
			Class.forName(prpo.getProperty("classname")).newInstance();
			conn=DriverManager.getConnection(prpo.getProperty("url"),prpo.getProperty("username"),prpo.getProperty("password"));
			//提交事务
			conn.commit();
			
			
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    
	//创建增删改的方法
      //非预编译   不需要参数
    public int update(String sql) throws SQLException{
			stmt=conn.createStatement();
			return stmt.executeUpdate(sql);
		    	
    }
      //预编译   需要参数
    public int update(String sql,Object...arr) throws SQLException{
    	//创建预编译对象
    	pstmt = conn.prepareStatement(sql);
    	//给？赋值
    	for (int i = 0; i < arr.length; i++) {
			pstmt.setObject((i+1), arr[i]);
		}
    	return pstmt.executeUpdate();
    }
    
    //创建查询的方法
      //非预编译
    public ResultSet query(String sql) throws SQLException{
    	stmt=conn.createStatement();
    	return stmt.executeQuery(sql);
    }
      //预编译
     public ResultSet query(String sql,Object...arr) throws SQLException{
    	//创建预编译对象
     	pstmt = conn.prepareStatement(sql);
     	//给？赋值
     	for (int i = 0; i < arr.length; i++) {
 			pstmt.setObject((i+1), arr[i]);
 		}
     	return pstmt.executeQuery();
    }
    //创建一个关闭资源的方法
    public void close(){
    	//关闭资源
		try {
			if(pstmt!=null && !pstmt.isClosed()) pstmt.close();
			if(stmt!=null && !stmt.isClosed()) stmt.close();
			if(conn!=null && !conn.isClosed()) conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    }

