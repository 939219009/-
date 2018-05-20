package com.wym.controller;

import com.wym.po.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import javax.xml.ws.RespectBinding;
import java.util.Map;

@Controller
@RequestMapping("/vc")
public class VelidatorController {
    @RequestMapping("/show")
    public String show(Map map){
        User user=new User();
        map.put("user",user);
        return "validator";
    }
    @RequestMapping(value = "/val",method = RequestMethod.GET)
    public String validator(@Valid User user, BindingResult result,Model model){
        if(result.hasErrors()){
            return "validator";
        }else{
            return "success";
        }
    }
}
