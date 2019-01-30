package response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

//处理响应
@Controller
@RequestMapping("/response")
public class HandleResponseController {

    //返回void类型，此时可以把Controller方法当作Servlet来使用
    @RequestMapping("/test1")
    public void test1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //请求转发
        request.getRequestDispatcher("/hello.html").forward(request,response);
        //URL重定向
        response.sendRedirect("/hello.html");
        //设置数据(model)
            request.setAttribute("msg","wjx");
//        //输出JSON格式
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().println("");
    }

    //返回void:文件下载
    @RequestMapping("/test2")
    public void test2(OutputStream outputStream) throws IOException {
        Files.copy(Paths.get("E:\\springProgram\\SpringMVC\\SpringMVC_request_response\\else\\junit5-master.zip"),outputStream);
    }

    //返回ModelAndView
    @RequestMapping("/test3")
    public ModelAndView test3(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","返回ModelAndView");//设置共享数据的key和value
        mv.addObject("随便来一点。。。");//设置共享数据的value，此时会把value的类型作为key（首字母小写）
        mv.setViewName("result");
        return mv;
    }
    //   /WEB-INF/views/result.jsp
    //   前缀：/WEB-INF/views/
    //   后缀：/.jsp
    //   物理视图=前缀+逻辑视图名+后缀
    //    <!--配置视图解析器-->
    //    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
    //        <property name="prefix" value="/WEB-INF/views/"/>
    //        <property name="suffix" value=".jsp"/>
    //    </bean>


    //返回String，逻辑视图名称，此时需要结合Model类型的参数一起使用
    @RequestMapping("/test4")
    public String test4(Model model){
        model.addAttribute("msg","SpringMVC世界");
        model.addAttribute("忘记了");
        return "result";
    }

    //请求转发:forward
    //原理：request.getRequestDispatcher("").forword(request,response)
    @RequestMapping("/test6")
    public String test5(Model model){
        return "forward:/hello4.html";
    }

    //URL重定向，浏览器地址栏会改变
    //原理：response.sendRedirect("");
    @RequestMapping("/test7")
    public String test7(Model model){
        return "redirect:/hello.html";
    }

    /**
     * 请求转发和URL重定向的选择：
     *                     请求转发        URL重定向
     *-------------------------------------------------
     * 地址栏               不会            会变
     * 共享数据             可以            不能？
     * 表单重复提交          导致            不会
     *
     *
     * 请求资源的路径问题：
     *      重定向 redirect:/hello.html 和 redirect:hello.html
     *
     *      访问资源的时候前面带上/,表示绝对路径,从根路径开始去寻找资源。
     *      访问资源的时候前面不加/,表示相对路径,从上一级上下文路径中去寻找资源。
     *      例如：
     *      /response/test6----->"redirect:/hello.html"------>ip:port/hello.html
     *      /response/test6----->"redirect:hello.html"------->ip:port/response/hello.html
     *
     *      结论：以后访问资源的时候，都使用/开头。
     *
     * 传统的方式，在URL重定向的时候，因为是两次不同的请求，所以不能共享请求中的数据。
     *    在开发中，有的时候，需要重定向跳转后共享数据。
     *    Spring3.1开始提供了Flash属性,只能使用从Controller重定向到Controller,不能到JSP。
     *
     *
     */
    @RequestMapping("/a")
    public String a(RedirectAttributes ra){
        ra.addAttribute("msg1","hello SpringMVC");
        ra.addFlashAttribute("msg2","haha haha");
        return "redirect:/response/b";
    }

    @RequestMapping("/b")
    public ModelAndView b(String msg1, @ModelAttribute("msg2")String msg2){
        System.out.println("msg1:" + msg1);
        System.out.println("msg2:" + msg2);
        return null;
    }
}
