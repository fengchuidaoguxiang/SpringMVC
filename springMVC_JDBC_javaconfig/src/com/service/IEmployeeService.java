package com.service;

import com.domain.Employee;

import java.util.List;

public interface IEmployeeService {
    public Employee get(long id);
    public List<Employee> getAll();
    public int add(Employee employee);
    public int update(Employee employee);
    public int delete(long id);

    public void login(String username, String password);
}
