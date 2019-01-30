package request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import vo.FormBean;
import vo.User;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/request")
public class HandleRequestController {

    @Autowired
    private ServletContext servletContext;

    @RequestMapping("/test1")
    public void test1(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        System.out.println(request.getParameter("username"));
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);
        System.out.println(this.servletContext);
    }

    //获取请求参数，保证请求参数名称和Controller方法的形式参数（入参）同名
    //如果请求参数名称和形参名称不同----->@RequestParam
    @RequestMapping("/test2")
    public void test2(@RequestParam("name") String username,@RequestParam(value = "age",required = false) Integer age){
        System.out.println(username);
        System.out.println(age);
    }

    //Restful风格传参
    //  一般格式：/delete?id=10
    //  /delete/110
    //@PathVariable:可以将URL中占位符绑定到方法的形参中
    @RequestMapping("/delete/{id}")
    public void test3(@PathVariable("id")Long id){
        System.out.println(id);
    }

    //接收一个参数有多个值的情况
    // 例如：批量删除： /batchDelete?ids=10&ids=3?ids=25
    //解决方案2种：
    // 1.使用数组：可以直接接收
    @RequestMapping("/batchDelete")
    public void batchDelete(Long[] ids){
        System.out.println(Arrays.asList(ids));
    }
    // 2.使用List:不能直接接收，但是可以在对象中存在一个集合
    @RequestMapping("/batchDelete2")
    public void batchDelete2(FormBean fb){
        System.out.println(fb.getIds());
    }
    //把数据直接封装到JavaBean对象
    @RequestMapping("/batchDelete3")
    public void batchDelete3(User user){
        System.out.println(user);
    }
}
