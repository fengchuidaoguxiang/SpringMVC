package com.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Employee {
    private Long id;
    private String username;
    private String password;
    private int age;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date hiredate;

    public Employee(){}

    public Employee(long id, String username, String password, int age, Date hiredate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.age = age;
        this.hiredate = hiredate;
    }
    public Employee( String username, String password, int age, Date hiredate) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.hiredate = hiredate;
    }
}
