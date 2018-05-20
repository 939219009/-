package com.wym.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
@WebFilter(urlPatterns ={ "/*"},
        initParams = @WebInitParam(name = "encoder",value = "UTF-8")
)
public class Encodingfilter implements Filter {
    private  String encoder="";
    public void init(FilterConfig filterConfig) throws ServletException {
         encoder=filterConfig.getInitParameter("encoder");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
         servletRequest.setCharacterEncoding(encoder);
         filterChain.doFilter(servletRequest,servletResponse);//传入到下个过滤器或服务器资源
    }

    public void destroy() {

    }
}
