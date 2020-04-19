package cn.itcast.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter("/index.jsp")//1.具体的资源路径，/index.jsp  只有访问了index.jsp资源时，过滤器才会执行
//@WebFilter("/user/*")//2.拦截目录 ，/user/*访问/user下的所有资源时，过滤器都会被执行
//@WebFilter("*.jsp")//3.后缀名拦截：*。jsp  访问所有的受追命为jsp资源时，过滤器都会被执行
public class FilterDemo4 implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("Demo4............");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {

    }

}
