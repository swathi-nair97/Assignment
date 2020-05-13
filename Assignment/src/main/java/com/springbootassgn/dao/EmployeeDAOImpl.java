package com.springbootassgn.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import com.springbootassgn.entity.AddressEntity;
import com.springbootassgn.entity.EmployeeEntity;
import com.springbootassgn.model.Address;
import com.springbootassgn.model.Employee;

@Repository(value = "employeeDao")
public class EmployeeDAOImpl {

	@PersistenceContext
	private EntityManager entityManager;

	public Long addEmployee(Employee employee) {
		Long employeeId = null;
		EmployeeEntity employeeEntity = new EmployeeEntity();
		employeeEntity.setFirstName(employee.getFirstName());
		employeeEntity.setLastName(employee.getLastName());
		List<Address> addressList = employee.getAddress();
		List<AddressEntity> newAddressList = new ArrayList<AddressEntity>();
		for (Address a : addressList) {
			AddressEntity newAddress = new AddressEntity();
			newAddress.setHouseNumber(a.getHouseNumber());
			newAddress.setStreetName(a.getStreetName());
			newAddress.setCity(a.getCity());
			newAddress.setState(a.getState());
			newAddress.setCountry(a.getCountry());
			newAddress.setPincode(a.getPincode());
			newAddressList.add(newAddress);
		}
		employeeEntity.setAddressEntity(newAddressList);
		entityManager.persist(employeeEntity);
		employeeId = employeeEntity.getId();
		return employeeId;
		
	}

	public void updateEmployee(Long id, Address address) {
		EmployeeEntity emp = entityManager.find(EmployeeEntity.class, id);
		AddressEntity ae = new AddressEntity();
		ae.setHouseNumber(address.getHouseNumber());
		ae.setStreetName(address.getStreetName());
		ae.setCity(address.getCity());
		ae.setState(address.getState());
		ae.setCountry(address.getCountry());
		ae.setPincode(address.getPincode());
		List<AddressEntity> a = emp.getAddressEntity();
		a.add(ae);
		emp.setAddressEntity(a);
		
	}

	public void deleteEmployee(Long id) {
		EmployeeEntity employee = entityManager.find(EmployeeEntity.class, id);
		entityManager.remove(employee);
		
	}
}
