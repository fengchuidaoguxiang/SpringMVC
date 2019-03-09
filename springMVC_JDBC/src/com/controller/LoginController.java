package com.controller;

import com.domain.Employee;
import com.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private IEmployeeService employeeService;

    @RequestMapping("/login")
    public String login(String username, String password, HttpSession session){
        System.out.println("-----login-----");
        try{
            employeeService.login(username,password);
        }catch (Exception e){
            session.setAttribute("errorMsg",e.getMessage());
            return "redirect:/login.jsp";
        }
        return "redirect:/employee/list";
    }
}
