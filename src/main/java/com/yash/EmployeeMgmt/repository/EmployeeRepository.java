package com.yash.EmployeeMgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.EmployeeMgmt.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
