package com.yash.EmployeeMgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.EmployeeMgmt.exception.ResourceNotFoundException;
import com.yash.EmployeeMgmt.model.Employee;
import com.yash.EmployeeMgmt.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	String message="Employee is not exist with this id ";

	public Employee saveEmployeeObject(Employee employee) {
		return employeeRepository.save(employee);

	}

	public List<Employee> getAllEmployeeObject() {    
		return employeeRepository.findAll();

	}

	public Employee getSingleEmployeeData(int eid) {
		return employeeRepository.findById(eid)
				.orElseThrow(() -> new ResourceNotFoundException(message + eid));
	}

	public Employee updateEmployeeObject(int eid, Employee employeeDetails) {
		Employee employee = employeeRepository.findById(eid)
				.orElseThrow(() -> new ResourceNotFoundException(message + eid));
		employee.setEname(employeeDetails.getEname());
		employee.setDOJ(employeeDetails.getDOJ());
		employee.setTotalExp(employeeDetails.getTotalExp());
		employee.setReportingManager(employeeDetails.getReportingManager());
		employee.setDesignation(employeeDetails.getDesignation());
		employee.setSkill(employeeDetails.getSkill());
		employeeRepository.save(employee);
		return employee;
	}

	public Integer deleteEmployeeObject(int eid) {

		Employee employee = employeeRepository.findById(eid)
				.orElseThrow(() -> new ResourceNotFoundException(message + eid));
		int eid2 = employee.getEid();
		employeeRepository.delete(employee);
		return eid2;
	}
}
