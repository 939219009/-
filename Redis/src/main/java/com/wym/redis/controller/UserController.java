package com.wym.redis.controller;

import com.wym.redis.model.User;
import com.wym.redis.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl service;
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResponseEntity<Void> add(@RequestBody User user){
        service.add(user);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    @RequestMapping(value = "/show",method = RequestMethod.GET)
    public ResponseEntity<List<User>> show(){
        List list=service.findAll();
        return new ResponseEntity<List<User>>(list,HttpStatus.OK);
    }
    @RequestMapping(value = "/del/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Void> del(@PathVariable String id){
        service.del(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    @RequestMapping(value = "/query/{id}",method = RequestMethod.GET)
    public ResponseEntity<User> query(@PathVariable String id){
        User user=(User) service.findId(id);
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }
    @RequestMapping(value = "/put",method = RequestMethod.PUT)
    public ResponseEntity<User> put(@RequestBody User user){
        service.put(user);
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }
}
