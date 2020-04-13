package cn.itcast.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RequestDemo4")
public class RequestDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //演示获取请求数据:referer
    String referer = request.getHeader("referer");
    System.out.println(referer);//http://localhost/day14/login.html

    //防盗链
    if(referer != null) {
        if(referer.contains("/day14")) {
            //正常访问
            response.setContentType("text/html;charset = utf-8");
            response.getWriter().write("播放电影。。。。");
            System.out.println("播放电影。。。。");
        } else {
            response.setContentType("text/html;charset = utf-8");
            response.getWriter().write("想看电影吗？来优酷。。。");
            System.out.println("想看电影吗？来优酷。。。。");
        }
    }
    }
}
