package com.wym.dao;

import com.wym.db.DB;
import com.wym.vo.User;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements IUserDAO{
    public Connection conn=null;
    public UserDaoImpl(){
        conn= DB.getConnection();
    }
    public boolean add(User user) {
        PreparedStatement pstmt = null;
        boolean flag = false;
        String sql = "insert into user (username,password) VALUES (?,?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            flag = pstmt.executeUpdate() > 0 ? true : false;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
         //   DB.closeConnection();
        }

        return flag;
    }
    @Override
    public boolean del(int id) {
        boolean flag=false;
        PreparedStatement pstmt=null;
        String sql="delete from user where id=?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            flag=pstmt.executeUpdate()>0?true:false;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(pstmt!=null)
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
        return flag;
    }

    @Override
    public boolean update(User user) {
        boolean flag=false;
        PreparedStatement pstmt=null;
        String sql="update user set username=?,password=? where id=?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,user.getUsername());
            pstmt.setString(2,user.getPassword());
            pstmt.setInt(3,user.getId());

            flag=pstmt.executeUpdate()>0?true:false;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(pstmt!=null)
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    @Override
    public List<User> queryAll() {
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        List<User> list=new ArrayList<User>();
        String sql="select * from user order by id desc";
        try {
            pstmt=conn.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while (rs.next()){
                User user=new User();
                user.setId(rs.getInt("id"));
                try {
                    user.setUsername(new String(rs.getString("username").
                            getBytes("ISO8859-1"),"UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                user.setPassword(rs.getString("password"));

               list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(rs!=null)
                rs.close();
            if(pstmt!=null)
             pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
           // DB.closeConnection();
        }
        return list ;
    }

    @Override
    public User queryUserById(int id) {
        User user = null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        String sql="select * from user where id=?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            rs=pstmt.executeQuery();
            if(rs.next()){
                user=new User();
                user.setId(rs.getInt("id"));
                try {
                    user.setUsername(new String(rs.getString("username").
                            getBytes("ISO8859-1"),"UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                user.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
              try {
                  if(rs!=null){
                    rs.close();
                   }
                   if(pstmt!=null)
                       pstmt.close();
                //  DB.closeConnection();
                 }catch (SQLException e){
                  e.printStackTrace();
              }
        }
        return user;
    }
    public boolean queryUserByUsername(String username){
        User user = null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        boolean flag=false;
        String sql="select * from user where username=?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,username);
            rs=pstmt.executeQuery();
            if(rs.next()){
               flag=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(rs!=null){
                    rs.close();
                }
                if(pstmt!=null)
                    pstmt.close();
                //  DB.closeConnection();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return flag;
    }
}
