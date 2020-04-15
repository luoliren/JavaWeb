package cn.itcast.web.servletcontext;

import cn.itcast.utils.DownLoadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/downloadServlet")
public class downloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求参数
        String filename = request.getParameter("filename");
        //2.使用字节输入流加载文件进内存
        //2.1找到文件服务器路径
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/img"+filename);
        //2.2用字节流关联
        FileInputStream fls = new FileInputStream(realPath);


        //3.设置response的响应头
        //3.1设置响应头类型：context-type
        String mimeType = servletContext.getMimeType(filename);
        response.setHeader("content-type",mimeType);
        //3.2设置响应头打开方式：content-disposition 属性是作为对下载文件的一个标识字段
        response.setHeader("context-disposition","attachment;filename="+filename);

        //解决中文乱码的问题
        //1.获取user-agent请求头
        String agent = request.getHeader("user-agent");
        //使用工具类方法编码文件名即可
        filename = DownLoadUtils.getFilename(agent,filename);
        //4 .将输入流的数据写到输出流中
        ServletOutputStream sos = response.getOutputStream();
        byte [] buff = new byte[1024 * 8];
        int len = 0;
        while((len = fls.read(buff)) != -1) {
            sos.write(buff,0,len);
        }
        fls.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
    }
}
