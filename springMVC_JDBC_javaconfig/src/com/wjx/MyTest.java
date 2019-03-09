package com.wjx;

import com.dao.IEmployeeDao;
import com.domain.Employee;
import com.service.IEmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.Date;


@SpringJUnitConfig
//@ContextConfiguration(classes = ApplicationConfig.class)
//@ContextConfiguration("classpath:mvc.xml")
public class MyTest {
    @Autowired
    private IEmployeeDao dao;

    @Autowired
    private IEmployeeService service;

    @Test
    public void test1(){
        Employee employee = new Employee("Linda","ccc",19,new Date());
        System.out.println(dao.add(employee));
    }

}
