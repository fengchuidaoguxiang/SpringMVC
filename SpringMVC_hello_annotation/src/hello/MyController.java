package hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller //将这个Bean组件注册到Spring的IoC容器中
public class MyController {

    @RequestMapping("/hello4")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("----输出视图-----");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/WEB-INF/views/myView.jsp");
        modelAndView.addObject("msg","使用注解开发SpringMVC");
        return modelAndView;
    }
    @RequestMapping("/hello5")
    public ModelAndView handleRequest5(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("----输出视图2-----");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/WEB-INF/views/myView.jsp");
        modelAndView.addObject("msg","使用注解开发SpringMVC2");
        return modelAndView;
    }
}
