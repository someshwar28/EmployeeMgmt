package com.yash.EmployeeMgmt;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.yash.EmployeeMgmt.model.Employee;
import com.yash.EmployeeMgmt.repository.EmployeeRepository;
import com.yash.EmployeeMgmt.service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest
class EmployeeMgmtApplicationTests {

	@Mock
	EmployeeRepository employeeRepository;
	
	@InjectMocks
	EmployeeService employeeService;
	
	
	@Test
	 void testSaveEmployeeObject() {
		Employee employee=new Employee(101, "someshwar",
				"02-08-2022", 2.11, "prithviraj", "software engineer", "full stack");
		when(employeeRepository.save(employee)).thenReturn(employee);
		Employee saveEmployeeObject = employeeService.saveEmployeeObject(employee);
		assertThat(saveEmployeeObject.getEname()).isSameAs(employee.getEname());
		//verify(employeeRepository).save(employee);
		Mockito.verify(employeeRepository, Mockito.atLeastOnce()).save(employee);
	}
	
	@Test
	 void testAllEmployeeList() {
//		when(employeeRepository.findAll()).thenReturn(Stream.of(new Employee(101, "someshwar", 
//				"02-08-2022",2.10,"prithviraj", "software engineer", "full stack")).toList());
//		assertEquals(1, employeeService.getAllEmployeeObject().size());
		
		List<Employee>list=new ArrayList<>();
		list.add(new Employee());
		when(employeeRepository.findAll()).thenReturn(list);
		List<Employee> allEmployeeObject = employeeService.getAllEmployeeObject();
		assertEquals(list, allEmployeeObject);
		Mockito.verify(employeeRepository).findAll();
	}
	
	@Test
	 void testDeleteEmployeeObject() {
		Employee employee=new Employee(101, "someshwar", "02-08-2022", 
				2.10, "Prithviraj", "software engineer", "full stack");
		when(employeeRepository.findById(employee.getEid())).thenReturn(Optional.of(employee));
		employeeService.getSingleEmployeeData(employee.getEid());
		Mockito.verify(employeeRepository, Mockito.atLeastOnce()).findById(employee.getEid());
	}
	
	@Test
	 void testUpdateEmployeeObject() {
		Employee employee=new Employee(101, "someshwar", "02-08-2022",
				2.10, "Prithviraj", "software engineer", "full stack");
		Employee employee2 = new Employee(101, "anurag", "02-08-2022",
				2.10, "Prithviraj", "software engineer", "full stack");
		when(employeeRepository.findById(employee.getEid())).thenReturn(Optional.of(employee));
		employeeService.updateEmployeeObject(employee.getEid(), employee2);
		Mockito.verify(employeeRepository, Mockito.atLeastOnce()).save(any());
		}
	
	
}
