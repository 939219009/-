package com.wym.service;

import com.wym.mapper.UserMapper;
import com.wym.model.User;
import com.wym.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl {
    @Autowired
    private UserMapper dao;

    public int insert(User user){
        return dao.insert(user);
    }
    public List<User> selectByExample(){
        UserExample example=new UserExample();
        example.createCriteria().andIdIsNotNull();
        return dao.selectByExample(example);
    }
    public int deleteByPrimaryKey(Integer id){
        return dao.deleteByPrimaryKey(id);
    }
    public int updateByPrimaryKey(User record){
        return dao.updateByPrimaryKey(record);
    }
    public User selectByPrimaryKey(Integer id){
        return dao.selectByPrimaryKey(id);
    }
}
