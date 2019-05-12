package com.application.application;

import java.util.List;

import javax.sound.midi.SysexMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/test")
//@JsonView(EmployeeDepartmentView.class)
public class TestController {
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private DepartmentService deptService;

	@GetMapping("/name")
	public String getMyName() {
		return "manu";
	}

	@GetMapping("/department")
	public List<Department> getMydept() throws JsonProcessingException {
		return deptService.getAllDepartment();
	}

	@GetMapping("/emp/{id}")
	public Employee getEmployee(@PathVariable Integer id) throws JsonProcessingException {
		Employee emp =  employeeService.getEmployee(id);
		ObjectMapper mapper = new ObjectMapper();
		System.err.println(mapper.writeValueAsString(emp));
		return emp;
	}
	@CrossOrigin
	@PutMapping("/emp")
	public ResponseEntity<HttpStatus> updateEmployee(@RequestBody Employee employee) {
		employeeService.updateEmployee(employee);
		return ResponseEntity.ok(HttpStatus.OK);
	}
	
	@PostMapping("/emp")
	public ResponseEntity<HttpStatus> addNewEmployee(@RequestBody Employee employee) {
		employeeService.updateEmployee(employee);
		return ResponseEntity.ok(HttpStatus.OK);
	}
}
