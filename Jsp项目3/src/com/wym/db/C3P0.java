package com.wym.db;

import com.mchange.v2.c3p0.ComboPooledDataSource;


import java.sql.Connection;
import java.sql.SQLException;

public class C3P0 {
      private static ComboPooledDataSource cs=null;
      static{
          cs=new ComboPooledDataSource("mysql");
      }
      public static Connection getConnection(){
          Connection conn=null;
          try {
              conn=cs.getConnection();
          } catch (SQLException e) {
              e.printStackTrace();
          }
          return conn;
      }
}
