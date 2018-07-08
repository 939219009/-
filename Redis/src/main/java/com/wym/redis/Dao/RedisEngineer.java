package com.wym.redis.Dao;

import com.wym.redis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public class RedisEngineer {
     @Autowired
     private RedisTemplate<Serializable,Serializable> redisTemplate;
     @Autowired
     private RedisTemplate<String,String> redisTemplate1;

     public void saveHash(String name,String key,Object value){
         HashOperations hash=redisTemplate.opsForHash();
         hash.put(name,key,value);
     }
     public List<Object> findAll(String name){
         HashOperations hash=redisTemplate.opsForHash();
         List<Object> list=hash.values(name);
         return list;
     }
     public void del(String name,String key){
         HashOperations hash=redisTemplate.opsForHash();
         hash.delete(name,key);
     }
    public Object findId(String name,String key){
        HashOperations hash=redisTemplate.opsForHash();
        return hash.get(name,"user"+key);
    }
}
