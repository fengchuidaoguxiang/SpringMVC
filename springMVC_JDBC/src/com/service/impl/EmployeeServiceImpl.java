package com.service.impl;

import com.dao.IEmployeeDao;
import com.dao.impl.EmployeeDaoImpl;
import com.domain.Employee;
import com.service.IEmployeeService;
import com.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    IEmployeeDao employeeDao;

    @Override
    public Employee get(long id) {
        return employeeDao.get(id);
    }

    @Override
    public List<Employee> getAll() {
        return employeeDao.getAll();
    }

    @Override
    public int add(Employee employee) {
        return employeeDao.add(employee);
    }

    @Override
    public int update(Employee employee) {
        return employeeDao.update(employee);
    }

    @Override
    public int delete(long id) {
        return employeeDao.delete(id);
    }

    @Override
    public void login(String username, String password) {
        Employee currentEmployee = employeeDao.checkLogin(username, password);
        if(currentEmployee == null){
            throw new RuntimeException("账号或密码错误");
        }
        UserContext.setCurrentUser(currentEmployee);

    }
}
