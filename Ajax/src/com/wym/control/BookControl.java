package com.wym.control;



import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "BookControl",urlPatterns = {"/book"})
public class BookControl extends HttpServlet {
   private Map<String,String> map=new HashMap<String,String>();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String index=request.getParameter("index");
        if(index.equals("1")){
            map.put("pic","image/1.GIF");
            map.put("desc","做你妹的程序猿");
        }else if(index.equals("2")){
            map.put("pic","image/2.GIF");
            map.put("desc","程序猿能养活我吗");
        }

        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter outt=response.getWriter();
        String Json= JSON.toJSONString(map,true);

        outt.print(Json);

        outt.flush();
        outt.close();


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
