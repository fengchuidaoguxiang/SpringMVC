package com.service.impl;

import com.dao.IEmployeeDao;
import com.dao.impl.EmployeeDaoImpl;
import com.domain.Employee;
import com.service.IEmployeeService;
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
}
