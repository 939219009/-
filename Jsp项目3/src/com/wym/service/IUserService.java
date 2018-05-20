package com.wym.service;

import com.wym.vo.User;

import java.util.List;

public interface IUserService {
    public boolean add(User user);
    public boolean del(int id);
    public boolean update(User user);
    public List<User> queryAll();
    public User queryUserById(int id);
    public boolean queryUserByUsername(String username);
    public int online();
}
