package cn.itcast.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * cookie快速入门
 */
@WebServlet("/cookieDemo4")
public class CookieDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //1.创建Cookie对象
        Cookie c1 = new Cookie("msg","sexMaxAge");
     //设置cookies的存活时间
     //   c1.setMaxAge(30);//将cookies持久化到硬盘，30秒或会自动删除cookies
     //   c1.setMaxAge(-1);
        c1.setMaxAge(300);
        c1.setMaxAge(0);
    //2.发送Cookie
        response.addCookie(c1);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
