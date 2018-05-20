package com.wym.controller;

import com.wym.po.User;
import org.jboss.logging.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
@RequestMapping({"/h1","/h2"})
@SessionAttributes({"realname","username"})
public class HelloWorldController  {
    @RequestMapping({"/go"})
    public String handleRequest(User user, Map map) throws Exception {
        //map model modelmap等价
        map.put("username",user.getUsername());
        map.put("password",user.getPassword());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());

        return "hello";
    }
    @RequestMapping({"/go2"})
    public ModelAndView handlerRequest(HttpServletRequest request,HttpServletResponse response){

        ModelAndView modelAndView=new ModelAndView();

        modelAndView.addObject("username","wym");
        modelAndView.setViewName("hello");
        return modelAndView;
    }
    @RequestMapping({"/ok"})
    public String ok(@RequestParam String username){

        System.out.println(username);
        return "hello";
    }
    @RequestMapping({"/ok1"})
    public String ok1(@RequestParam(value = "role",required = true) String[] username){

        System.out.println(username[0]);
        System.out.println(username[1]);
        return "hello";
    }
    @RequestMapping(value= {"/ant/username/{username}"})
    public String ant( @PathVariable(value ="username") String username){
        System.out.println(username);
        return "hello";
    }
    @RequestMapping({"cookie"})
    public String Cookie(@CookieValue(value = "count",defaultValue ="0" ) Long count,HttpServletResponse response){
        count++;
        Cookie cookie=new Cookie("count",count.toString());
        response.addCookie(cookie);
        return "cookie";
    }
    @RequestMapping({"session"})
    public String session(Model model){

        model.addAttribute("username","MIKE");
        return "session";
    }
}
