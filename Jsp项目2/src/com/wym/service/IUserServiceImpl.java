package com.wym.service;

import com.wym.dao.IUserDAO;
import com.wym.dao.UserDaoImpl;
import com.wym.vo.User;

import java.util.List;

public class IUserServiceImpl implements IUserService{
    private IUserDAO dao= new UserDaoImpl();
    @Override
    public boolean add(User user) {
        return dao.add(user);
    }

    @Override
    public boolean del(int id) {
        return dao.del(id);
    }

    @Override
    public boolean update(User user) {
        return dao.update(user);
    }

    @Override
    public List<User> queryAll() {
        return dao.queryAll();
    }

    @Override
    public User queryUserById(int id) {
        return dao.queryUserById(id);
    }
    public boolean queryUserByUsername(String username){
        return dao.queryUserByUsername(username);
    }
}
