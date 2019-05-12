package com.application.application;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

	@Autowired
	public DepartmentRepository departmentRepository;

	@Autowired
	private EmployeeDepartmentRepository employeeDepartmentRepository;

	public Department getDepartment(Integer id) {
		return departmentRepository.getOne(id);
	}

	public void updateDepartment(Department entity) {
		Set<EmployeeDepartment> empDepts = entity.getEmployeeDepartments();
		if(empDepts.size() != 0)
			empDepts.stream().forEach(e-> employeeDepartmentRepository.save(e));
		departmentRepository.save(entity);
	}

	public List<Department> getAllDepartment() {
		return departmentRepository.findAll();
	}
}
