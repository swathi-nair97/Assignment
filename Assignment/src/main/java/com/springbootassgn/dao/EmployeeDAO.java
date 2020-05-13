package com.springbootassgn.dao;

import com.springbootassgn.model.Address;
import com.springbootassgn.model.Employee;

public interface EmployeeDAO {
	public Long addEmployee(Employee employee);
	public void updateEmployee(Long id, Address address);
	public void deleteEmployee(Long id);
}
