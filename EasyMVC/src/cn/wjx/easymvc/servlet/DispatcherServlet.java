package cn.wjx.easymvc.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//前端控制器，分发
public class DispatcherServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        //扫描使用的类，判断哪些类使用了@Controller注解，如果使用了@Controller注解，需要被处理

    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求的资源名称
        String requestURI = request.getRequestURI();
        if("/favocon.ico".equals(requestURI)){
            return;
        }
        System.out.println(requestURI);
    }
}
