package com.wym;

import com.wym.service.IUserService;
import com.wym.service.IUserServiceImpl;
import com.wym.vo.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="usercontrol",urlPatterns = "/user")
public class UserControl extends HttpServlet{
    private IUserService service=new IUserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         //System.out.println("ok");
        RequestDispatcher dispatcher=null;//协作
        User user=null;
        String action=req.getParameter("action");
        if(action.equals("add")) {//增加
            dispatcher=req.getRequestDispatcher("/user?action=queryall");
            user=new User();
            String username=new String(req.getParameter("user").
                    getBytes("ISO8859-1"),"utf-8");
            String password=req.getParameter("pwd");
            user.setUsername(username);
            user.setPassword(password);
            add(user,req);
        }else if(action.equals("del")){//删除
            dispatcher=req.getRequestDispatcher("/user?action=queryall");
            String id=req.getParameter("id");
            if(service.del(Integer.parseInt(id))){
                req.setAttribute("msg","删除成功！");
            }else {
                req.setAttribute("msg","删除失败！");
            }
        }else if(action.equals("queryid")){//定位
            dispatcher=req.getRequestDispatcher("/user?action=queryall");
            user=new User();
            String id=req.getParameter("id");
            user=service.queryUserById(Integer.parseInt(id));
            req.setAttribute("user",user);
        }else if(action.equals("edit")){//修改
            dispatcher=req.getRequestDispatcher("/user?action=queryall");
            user=new User();
            String id=req.getParameter("id");
            user.setId(Integer.parseInt(id));
            String username=new String(req.getParameter("user").
                    getBytes("ISO8859-1"),"utf-8");
            String password=req.getParameter("pwd");
            user.setUsername(username);
            user.setPassword(password);
            service.update(user);
            if(service.update(user)){
                req.setAttribute("msg","修改成功！");
            }else {
                req.setAttribute("msg","修改失败！");
            }
        }else if(action.equals("queryall")){//查询
            dispatcher=req.getRequestDispatcher("submit.jsp");
            List<User> list =service.queryAll();
            req.setAttribute("list",list);
        }
        dispatcher.forward(req,resp);//转向
    }
    public void add(User user,HttpServletRequest req){
        if(service.add(user)){
            req.setAttribute("msg","注册成功！");
        }else {
            req.setAttribute("msg","注册失败！");
        }
        
    }
    @Override
    public String getInitParameter(String name) {
        return super.getInitParameter(name);
    }
}
