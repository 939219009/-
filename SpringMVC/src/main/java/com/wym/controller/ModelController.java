package com.wym.controller;

import com.wym.po.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.soap.SOAPBinding;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping({"/model"})//后往前传值时的目录名称1
public class ModelController  {
    @RequestMapping({"/go"})
    public String go(@ModelAttribute(value = "user") User user){
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        return "hello";
    }
    @RequestMapping({"/ok"})//后往前传值时的目录名称2
    public @ModelAttribute(value = "user") User ok(@ModelAttribute(value = "user") User user){
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        return user;
    }
    @RequestMapping({"/oklist"})//后往前传值时的目录名称2
    public @ModelAttribute List<String> oklist(){

        return Arrays.asList("黑龙江","北京");
    }
    @RequestMapping({"/okmap"})//后往前传值时的目录名称2
    public @ModelAttribute Map<String,User> okmap(){
        Map<String,User> map=new HashMap<String, User>();
//        map.put("A",new User("吴云明","9999"));
//        map.put("B",new User("王熙彤","999999"));
        return map;
    }
}
