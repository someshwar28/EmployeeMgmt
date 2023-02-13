package com.yash.EmployeeMgmt;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.yash.EmployeeMgmt.model.Employee;
import com.yash.EmployeeMgmt.repository.EmployeeRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Transactional
 class EmployeeRepoTest {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Test
	@Order(1)
	void testSaveEmployeeObject() {
		
		Employee employee=new Employee(101, "someshwar",
				"02-08-2022", 2.11, "prithviraj", "software engineer", "full stack");
		
		employeeRepository.save(employee);
		
		assertThat(employee.getEid()).isPositive();
	
	}
	

	
	@Test
	@Order(2)
	void testGetAllEmployeeObject() {
		
		List<Employee> findAll = employeeRepository.findAll();
		
		assertThat(findAll).isEmpty();
		
	}
	
	
	
	

}
