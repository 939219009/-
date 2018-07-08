package com.wym.redis.service;

import com.wym.redis.Dao.RedisEngineer;
import com.wym.redis.mapper.UserMapper;
import com.wym.redis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl {
    @Autowired
    private RedisEngineer rdao;

    @Autowired
    private UserMapper udao;

    public void add(User user){
        //保存到mysql
        udao.insert(user);
        int id=user.getId();//新数据主键
        //保存到redis内存
        rdao.saveHash("user","user"+id,user);
    }
    public List<Object> findAll(){
        return rdao.findAll("user");
    }
    public void del(String id){
        rdao.del("user","user"+id);
        udao.deleteByPrimaryKey(Integer.parseInt(id));
    }
    public Object findId(String key){
        return rdao.findId("user",key);
    }
    public void put(User user){
        //redis修改 先删再加
        rdao.del("user","user"+user.getId());
        rdao.saveHash("user","user"+user.getId(),user);
        udao.updateByPrimaryKey(user);
    }
}
