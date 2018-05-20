package com.wym.service;

import com.wym.model.User;
import com.wym.model.UserExample;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

public class UserService {
    private SqlSessionFactory ssf=null;
    public UserService(){
        InputStream is= this.getClass().getClassLoader().getResourceAsStream("mybatis.cfg.xml");
        ssf=new SqlSessionFactoryBuilder().build(is);
    }
    @Test
    public void add(){
       SqlSession session=ssf.openSession();
       User user=new User();
       user.setUsername("吴云明");
       user.setPassword("93921909");
       session.insert("com.wym.mapper.UserMapper.insert",user);
       session.commit();;
       session.close();
    }
    @Test
    public void del(){
        SqlSession session=ssf.openSession();
        User user=new User();
        user.setId(1);
        session.delete("com.wym.mapper.UserMapper.deleteByPrimaryKey",user);
        session.commit();
        session.close();
    }
    @Test
    public void update(){
        SqlSession session=ssf.openSession();
        User user=new User();
        user.setUsername("MIKE");
        user.setPassword("999999");
        user.setId(2);
        session.update("com.wym.mapper.UserMapper.updateByPrimaryKey",user);
        session.commit();
        session.close();
    }
    @Test
    public void query(){
        SqlSession session=ssf.openSession();
        UserExample example=new UserExample();
        example.createCriteria().andUsernameLike("吴%");
        List<User> list=session.selectList("com.wym.mapper.UserMapper.selectByExample",example);

        Iterator<User> iterator=list.iterator();
        while(iterator.hasNext()){
           User use=new User();
           use=iterator.next();
           System.out.println(use.getUsername()+"---"+use.getPassword());
        }
        session.commit();
        session.close();
    }
}
