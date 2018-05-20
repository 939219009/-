package com.wym.control;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@WebServlet(name = "BasicControl",
        urlPatterns = {"/h1","/h2"},
        initParams = {
                @WebInitParam(name = "h", value = "/head.jsp"),
                @WebInitParam(name = "f", value = "/foot.jsp"),
        }
)
public class BasicControl extends javax.servlet.http.HttpServlet {
    private Map<String,String> map=new HashMap<String,String>();
    public BasicControl(){//构造
         System.out.println("构造");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {//初始化
          String head=config.getInitParameter("h");
          String foot=config.getInitParameter("f");

          map.put("h",head);
          map.put("f",foot);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        String action=request.getParameter("action");
       // System.out.println(action);

        String p=map.get(action);//得到的p页，或者是head.jsp,或者是foot.jsp
        RequestDispatcher dispatcher=request.getRequestDispatcher(p);
        dispatcher.forward(request,response);
        /*
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        PrintWriter out =response.getWriter();
        out.print("<html>");
        out.print("<head>");
        out.print("</head>");
        out.print("<h1>一群傻逼</h1>");
        out.print("<body>");

        out.print("</body>");
        out.print("</html>");
        out.flush();
        out.close();
        */
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
