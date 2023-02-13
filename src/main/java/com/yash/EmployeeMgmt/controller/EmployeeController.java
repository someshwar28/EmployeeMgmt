package com.yash.EmployeeMgmt.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.EmployeeMgmt.model.Employee;
import com.yash.EmployeeMgmt.service.EmployeeService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping(value = "/addEmployeeData")
	public ResponseEntity<Employee> addEmployeeObject(@Valid @RequestBody Employee employee) {
		Employee saveEmployeeObject = employeeService.saveEmployeeObject(employee);
		System.out.println("object created successfully ");
		return new ResponseEntity<>(saveEmployeeObject,HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getAllEmployeeData")
	public ResponseEntity<List<Employee>> getAllEmployeeData(){
		List<Employee> allEmployeeObject = employeeService.getAllEmployeeObject();
		System.out.println("data fetched successfully ");
		return new ResponseEntity<>(allEmployeeObject,HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "/getEmployeeData/{eid}")
	public ResponseEntity<Employee> getSingleEmployeeData(@PathVariable int eid) {
		 Employee singleEmployeeData = employeeService.getSingleEmployeeData(eid);
		 System.out.println("data fetched successfully ");
		 return ResponseEntity.ok(singleEmployeeData);
		}
	
	@PutMapping(value = "/updateEmployeeData/{eid}")
	public ResponseEntity<Employee> updateEmployeeData(@PathVariable int eid,@RequestBody Employee employee){
		Employee updateEmployeeObject = employeeService.updateEmployeeObject(eid, employee);
		System.out.println("data updated successfully ");
		return new ResponseEntity<>(updateEmployeeObject,HttpStatus.CREATED);
		}
	@DeleteMapping(value = "/deleteEmployeeData/{eid}")
	public ResponseEntity<Map<String,Integer>> deleteEmployeeData(@PathVariable int eid){
		Integer eid2 = employeeService.deleteEmployeeObject(eid);
		Map<String,Integer>map=new HashMap<>();
		map.put("deleted id is", eid2);
		System.out.println("data deleted successfully ");
		return new ResponseEntity<>(map,HttpStatus.ACCEPTED);
	}
	
}
