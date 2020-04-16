package cn.itcast.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 在服务器中的Servlet判断是否有一个名为lastTime的Cookie
 *   1.有：不是第一次访问
 *      1.响应数据：欢迎回来，您上次访问的时间为：2019年10月28日15：33：20
 *      2.写回Cookie：lastTime = 2019年10月28日15：33：20
 *   2.没有：是第一次访问
 *      1.响应数据：您好，欢迎您首次访问
 *      2.协会Cookie：LastTime = 2019年10月28日15：33：20
 */

@WebServlet("/cookieTest")
public class CookieTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //设置响应的消息体的数据格式以及编码
        response.setContentType("text/html;charset=utf-8");

    //1.获取所有的Cookie
        Cookie[] cookies = request.getCookies();
        boolean flag = false;//没有cookie为lastTime
    //2.遍历cookies数组
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie:cookies) {
                //3.获取cookie的名称
                String name = cookie.getName();
                //4.判断名称是否是LastTime
                if ("lastTime".equals(name)) {
                    //有该cookie，不是第一次访问

                    flag = true;//有lastTime的cookie

                    //设置Cookie的value
                    //获取当前时间的字符串，重新设置Cookie的值，重新发送cookie
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String str_data = sdf.format(date);
                    System.out.println("编码前："+str_data);
                    //URL编码
                    str_data = URLEncoder.encode(str_data,"utf-8");
                    System.out.println("编码后："+str_data);
                    String value = cookie.getValue();
                    cookie.setValue(str_data);
                    //设置cookie的存活时间
                    //cookie.setMaxAge(60*60*24*30);//一个月
                    cookie.setMaxAge(300);//一个月
                    response.addCookie(cookie);
                    //响应数据
                    //'获取cookie的数据
                    // String value = cookie.getValue();
                    System.out.println("解码前："+value);
                    //URL解码
                    value = URLDecoder.decode(value,"utf-8");
                    System.out.println("解码后："+value);
                    response.getWriter().write("<h1>欢迎回来，您上次访问的时间为: " +value+"</h1>");

                    break;
                }
            }
        }
        if (cookies == null || cookies.length == 0 ||flag == false) {
            //没有，是第一次访问
            //获取当前时间的字符串，重新设置Cookie的值，重新发送cookie
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String str_data = sdf.format(date);
            System.out.println("编码前："+str_data);
            //URL编码
            str_data = URLEncoder.encode(str_data,"utf-8");
            System.out.println("编码后："+str_data);
            Cookie cookie = new Cookie("lastTime",str_data);
            //设置cookie的存活时间
            cookie.setMaxAge(60*60*24*30);//一个月
            response.addCookie(cookie);

            response.getWriter().write("<h1>您好，欢迎您首次访问</h1>");

        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
