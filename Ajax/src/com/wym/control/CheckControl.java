package com.wym.control;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="/CheckControl",urlPatterns = {"/check"})
public class CheckControl extends HttpServlet {
    private String[] users={"wym","jfb","mc","jj"};
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String flag="false";
        for(String u : users){
            if(username.equals(u)){
                flag="true";
            }
        }
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        PrintWriter outt=resp.getWriter();
        outt.print(flag);
        outt.flush();
        outt.close();
        //System.out.println(username);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
