package com.yash.EmployeeMgmt;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yash.EmployeeMgmt.controller.EmployeeController;
import com.yash.EmployeeMgmt.model.Employee;
import com.yash.EmployeeMgmt.service.EmployeeService;


@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
 class EmployeeControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	EmployeeService employeeService;
	
	@Test
	void testSaveEmployeeObject() throws JsonProcessingException, Exception {
		Employee employee=new Employee(101, "someshwar",
				"02-08-2022", 2.11, "prithviraj", "software engineer", "full stack");

		when(employeeService.saveEmployeeObject(employee)).thenReturn(employee);
		
		mockMvc.perform(post("/employee/addEmployeeData")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(employee)))
				.andExpect(status().isCreated());
		}
	
	
		@Test
		void testAllEmployeeObject() throws Exception {
			
			Employee employee=new Employee(101, "someshwar",
					"02-08-2022", 2.11, "prithviraj", "software engineer", "full stack");
			
			List<Employee>listEmployee=Arrays.asList(employee);
			when(employeeService.getAllEmployeeObject()).thenReturn(listEmployee);
			
			mockMvc.perform(get("/employee/getAllEmployeeData")
					.contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isAccepted());
			
		}
	
		@Test
		void testDeleteEmployeeObject() throws Exception {
			
			Employee employee=new Employee(101, "someshwar",
					"02-08-2022", 2.11, "prithviraj", "software engineer", "full stack");
			
			when(employeeService.deleteEmployeeObject(employee.getEid())).thenReturn(employee.getEid());
			
			mockMvc.perform(delete("/employee/deleteEmployeeData/"+employee.getEid())
					.contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isAccepted());
			
		}
	
//		@Test
//		public void should_throw_exception_when_user_doesnt_exist() throws Exception {
//			
//			Employee employee=new Employee(102, "someshwar",
//					"02-08-2022", 2.11, "prithviraj", "software engineer", "full stack");
//			
//			Mockito.doThrow(new ResourceNotFoundException("user not present with this id"+employee.getEid()))
//			.when(employeeService).deleteEmployeeObject(employee.getEid());
//			
//			mockMvc.perform(delete("/employee/deleteEmployeeData/"+employee.getEid())
//					.contentType(MediaType.APPLICATION_JSON))
//					.andExpect(status().isNotFound());
//		}
		
		@Test
		 void testGetEmployeeObject() throws Exception {
			
			Employee employee=new Employee(102, "someshwar",
					"02-08-2022", 2.11, "prithviraj", "software engineer", "full stack");
			
			when(employeeService.getSingleEmployeeData(employee.getEid())).thenReturn(employee);
			
			mockMvc.perform(get("/employee/getEmployeeData/"+employee.getEid())
					.contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk());
			
		}
		
		@Test
		 void testUpdateEmployeeObject() throws Exception, Exception {
			
			Employee employee=new Employee(102, "someshwar",
					"02-08-2022", 2.11, "prithviraj", "software engineer", "full stack");
			
			when(employeeService.updateEmployeeObject(employee.getEid(), employee)).thenReturn(employee);
			
			mockMvc.perform(put("/employee/updateEmployeeData/"+employee.getEid())
					.content(new ObjectMapper().writeValueAsString(employee))
					.contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isCreated());
			
			
		}
		
		
		
		
		

}
