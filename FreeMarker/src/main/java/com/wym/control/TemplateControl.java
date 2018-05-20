package com.wym.control;


import com.wym.po.User;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "TemplateControl",urlPatterns = {"*.do"})
public class TemplateControl extends javax.servlet.http.HttpServlet {
    private Configuration cfg;
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
         String path= request.getServletPath();
        // System.out.println(path); 得到路径
        int p=path.lastIndexOf(".");
        String name=path.substring(1,p);
       // System.out.println(name);  得到文件名
         List<User> list=new ArrayList<User>();
         list.add(new User("邢子一",21));
         list.add(new User("何佳林",21));
         list.add(new User("金凡博",21));

         Map map=new HashMap();
         map.put("user","吴云明");
         map.put("user1",list);
         map.put("user2","<h2>吴云明</h2>");

         Template template=cfg.getTemplate(name+".ftl");
         response.setCharacterEncoding("utf-8");//不然乱码 默认ISO8859-1
         response.setContentType("text/html,charset="+template.getEncoding());
         PrintWriter out= response.getWriter();

        try {
            //template.process(null,out);
            template.process(map,out);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    public void init() throws ServletException {
        cfg=new Configuration(Configuration.VERSION_2_3_23);
        cfg.setServletContextForTemplateLoading(this.getServletContext(),"template");
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
    }
}
