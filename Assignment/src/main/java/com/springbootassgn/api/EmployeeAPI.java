package com.springbootassgn.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springbootassgn.model.Address;
import com.springbootassgn.model.Employee;
import com.springbootassgn.service.EmployeeService;

public class EmployeeAPI {

	@RestController
	@CrossOrigin
	public class UserAPI {

		//Logger logger = LoggerFactory.getLogger(this.getClass());

		@Autowired
		EmployeeService empService;

		// adds new employee
		@PostMapping(value = "/employees", consumes = "application/json" )
		public Long addEmployee(@RequestBody Employee employee) throws Exception {
			try {
				return empService.addEmployee(employee);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		
		// updates employee details
		@PutMapping(value = "/user/update")
		public void updateEmployee( @RequestBody Long id, Address address) {
			try {
				empService.updateEmployee(id, address);
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		} 

				
		// deletes employee
		@RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE )
		public void delete(@PathVariable (value="id") Long empid) {
			try {
				empService.deleteEmployee(empid);
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		} 
	}
}
