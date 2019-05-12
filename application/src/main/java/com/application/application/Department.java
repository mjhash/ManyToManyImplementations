package com.application.application;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "department")
public class Department {
	@Id
	@Getter
	@Setter
	@JsonView(EmployeeDepartmentView.class)
	public Integer departmentId;

	@Getter
	@Setter
	@JsonView(EmployeeDepartmentView.class)
	public String departmentName;

	@Getter
	@Setter
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "department",fetch = FetchType.LAZY)
    @JsonManagedReference
	public Set<EmployeeDepartment> employeeDepartments;

}
