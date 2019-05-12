package com.application.application;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private EmployeeDepartmentRepository employeeDepartmentRepository;

	public Employee getEmployee(Integer id) {
		return employeeRepository.findByEmpId(id);
	}

	public void updateEmployee(Employee entity) {
		Set<EmployeeDepartment> empDepts = entity.getEmployeeDepartments();
		if(empDepts.size() != 0)
			empDepts.stream().forEach(e-> employeeDepartmentRepository.save(e));
		employeeRepository.save(entity);
	}
}
