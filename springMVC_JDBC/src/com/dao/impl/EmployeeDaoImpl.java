package com.dao.impl;

import com.dao.IEmployeeDao;
import com.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements IEmployeeDao {

    private JdbcTemplate jdbcTemplate;
    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Employee get(long id) {
        List<Employee> employees = this.jdbcTemplate.query("select id,username,password,age,hiredate from employee where id=?",
                new Object[]{1L}, new RowMapper<Employee>() {
                    @Override
                    public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
                        Employee employee = new Employee();
                        employee.setId(resultSet.getLong("id"));
                        employee.setUsername(resultSet.getString("username"));
                        employee.setPassword(resultSet.getString("password"));
                        employee.setAge(resultSet.getInt("age"));
                        employee.setHiredate(resultSet.getDate("hiredate"));

                        return employee;
                    }
                });
        return employees.size()== 0 ? null : employees.get(0);
    }

    @Override
    public List<Employee> getAll() {
        String sql = "select id,username,password,age,hiredate from employee";
        List<Employee> employees = this.jdbcTemplate.query(sql, new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
                Employee employee = new Employee();
                employee.setId(resultSet.getLong("id"));
                employee.setUsername(resultSet.getString("username"));
                employee.setPassword(resultSet.getString("password"));
                employee.setAge(resultSet.getInt("age"));
                employee.setHiredate(resultSet.getDate("hiredate"));
                return employee;
            }
        });
        return employees;
    }

    @Override
    public int add(Employee employee) {
        String sql = "insert into employee(username,password,age,hiredate) values(?,?,?,?)";
        int result = this.jdbcTemplate.update(sql,
                employee.getUsername(),
                employee.getPassword(),
                employee.getAge(),
                employee.getHiredate());
        return result;
    }

    @Override
    public int update(Employee employee) {
        String sql = "update employee set id=?,username=?,password=?,age=?,hiredate=? where id=?";
        int result = this.jdbcTemplate.update(sql,
                employee.getUsername(),
                employee.getPassword(),
                employee.getAge(),
                employee.getHiredate(),
                employee.getId());
        return result;
    }

    @Override
    public int delete(long id) {
        String sql = "delete from employee where id=?";
        int result = this.jdbcTemplate.update(sql,id);
        return result;
    }

    @Override
    public Employee checkLogin(String username, String password) {

        String sql = "select id,username,password,age,hiredate from employee where username=? and password=?";
        List<Employee> employees = this.jdbcTemplate.query(sql, new Object[]{username,password},
                new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
                Employee employee = new Employee();
                employee.setId(resultSet.getLong("id"));
                employee.setUsername(resultSet.getString("username"));
                employee.setPassword(resultSet.getString("password"));
                employee.setAge(resultSet.getInt("age"));
                employee.setHiredate(resultSet.getDate("hiredate"));
                return employee;
            }
        });
        return employees.size()== 0 ? null : employees.get(0);
    }
}
