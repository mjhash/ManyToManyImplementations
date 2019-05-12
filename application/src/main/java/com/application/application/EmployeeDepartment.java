package com.application.application;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "employee_department")
public class EmployeeDepartment {
	@Id
	@Setter
	@Getter
	@Column(name = "id")
	public Integer Id;
	
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name = "emp_id")
//    @JsonBackReference
	public Employee employee;

	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name = "department_id")
    @JsonBackReference
	public Department department;
}
