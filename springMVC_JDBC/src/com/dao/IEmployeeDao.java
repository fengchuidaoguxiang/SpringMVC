package com.dao;

import com.domain.Employee;

import java.util.List;

public interface IEmployeeDao {
    public Employee get(long id);
    public List<Employee> getAll();
    public int add(Employee employee);
    public int update(Employee employee);
    public int delete(long id);
}
