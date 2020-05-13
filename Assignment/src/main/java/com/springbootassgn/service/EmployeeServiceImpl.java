package com.springbootassgn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.springbootassgn.dao.EmployeeDAO;
import com.springbootassgn.entity.EmployeeEntity;
import com.springbootassgn.model.Address;
import com.springbootassgn.model.Employee;

@Service(value = "employeeService")
@Transactional
public class EmployeeServiceImpl {
	@Autowired
	private EmployeeDAO employeeDAO;

	public Long addEmployee(Employee employee) throws Exception {
		Long id = null;
		id = employeeDAO.addEmployee(employee);
		return id;
	}

	public void updateEmployee(Long id, Address address) throws Exception {
		EmployeeEntity emp = new EmployeeEntity();
		if(emp.getId() == id) {
			employeeDAO.updateEmployee(id, address);
		}
	}

	public void deleteEmployee(Long id) throws Exception {
		EmployeeEntity emp = new EmployeeEntity();
		if(emp.getId() == id) {
			employeeDAO.deleteEmployee(id);
		}
	}
}
