package com.wjx.hello;



import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//处理器
public class HelloController2 implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        System.out.println("hello SpringMVC.....");
        ModelAndView mv = new ModelAndView();
        //注入视图名称
        mv.setViewName("/WEB-INF/views/welcome.jsp");
        //注入数据
        mv.addObject("msg","你好SpringMVC2");
        return mv;
    }
}
