package com.wym.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    private static Connection conn=null;
    private static String url="jdbc:mysql://127.0.0.1:3306/" +
            "javaweb?useUnicode=true&characterEncoding=utf-8";
    private static String user="root";
    private static String pwd="root";
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                conn=DriverManager.getConnection(url,user,pwd);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }
    public static void closeConnection()
    {
        if(conn!=null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
