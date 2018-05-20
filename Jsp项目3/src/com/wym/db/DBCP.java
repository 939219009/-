package com.wym.db;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.activation.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DBCP {
     private static BasicDataSource myDataSource=null;
     static{
         Properties pro=new Properties();
         try {
             pro.load(DBCP.class.getClassLoader().getResourceAsStream("dbcp.ini"));
             myDataSource=BasicDataSourceFactory.createDataSource(pro);

         } catch (Exception e) {
             e.printStackTrace();
         }
     }
     public static Connection getConnection(){
         Connection conn=null;
         try {
             conn=myDataSource.getConnection();
         } catch (SQLException e) {
             e.printStackTrace();
         }
         return conn;
     }
}
