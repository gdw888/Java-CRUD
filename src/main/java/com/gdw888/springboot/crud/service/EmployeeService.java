package com.gdw888.springboot.crud.service;

import java.util.List;

import com.gdw888.springboot.crud.entity.Employee;

public interface EmployeeService {
	public List<Employee> findAll();
	public Employee findById(int id);
	public void save(Employee employee);
	public void deleteById(int id);
}
