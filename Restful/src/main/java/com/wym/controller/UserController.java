package com.wym.controller;

import com.wym.model.User;
import com.wym.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Size;
import java.util.List;

@RestController
@CrossOrigin//跨域进行申请
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl service;

    @RequestMapping(value = "/reg",method = RequestMethod.PUT)
    public ResponseEntity<Void> reg(@RequestBody User user){
        if(service.insert(user)>0){
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        }else{
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        //System.out.println(user.getUsername());
    }
    @RequestMapping(value = "/show",method = RequestMethod.GET)
    public ResponseEntity<List<User>> show(){
       List<User> list=service.selectByExample();
       return new ResponseEntity<List<User>>(list,HttpStatus.OK);
    }
    @RequestMapping(value = "/del/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Void> del(@PathVariable Integer id){
        if(service.deleteByPrimaryKey(id)>0){
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        }else{
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
    }
    @RequestMapping(value = "/queryid/{id}",method = RequestMethod.GET)
    public ResponseEntity<User> queryUserById(@PathVariable Integer id){
        User user=service.selectByPrimaryKey(id);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public ResponseEntity<Void> update(@RequestBody User user){

        if(service.updateByPrimaryKey(user)>0){
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        }else{
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        //System.out.println(user.getUsername());
    }

}
