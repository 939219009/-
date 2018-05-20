package com.wym.db;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.activation.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class Druid {
    private static javax.sql.DataSource ds=null;
    static{
        Properties pro=new Properties();
        try {
            pro.load(Druid.class.getClassLoader().getResourceAsStream("druid.ini"));

            try {
                ds= DruidDataSourceFactory.createDataSource(pro);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        Connection conn=null;
        try {
            conn=ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
