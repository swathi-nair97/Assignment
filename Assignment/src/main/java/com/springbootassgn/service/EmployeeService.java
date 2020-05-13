package com.springbootassgn.service;

import com.springbootassgn.model.Address;
import com.springbootassgn.model.Employee;

public interface EmployeeService {
	public Long addEmployee(Employee employee) throws Exception;
	public void updateEmployee(Long id, Address address) throws Exception;
	public void deleteEmployee(Long id) throws Exception;
}
