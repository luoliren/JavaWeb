package cn.itcast.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter("/*")
public class FilterDemo3 implements Filter {
    /**
     * 在服务器关闭之后，Filter对象被销毁，如果服务器是正常的关闭，则会执行destroy，执行一次 ，用于释放资源
     */
    public void destroy() {
        System.out.println("destory.............");
    }

    /**
     * 每一次请求资源被拦截时，会执行，执行多次
     * @param req
     * @param resp
     * @param chain
     * @throws ServletException
     * @throws IOException
     */
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("doFilter...........");
        chain.doFilter(req, resp);
    }

    /**
     * 在服务器启动后，创建Filter，然后调用init方法，执行一次 ，用于加载资源
     * @param config
     * @throws ServletException
     */
    public void init(FilterConfig config) throws ServletException {
        System.out.println("init..........");
    }

}
