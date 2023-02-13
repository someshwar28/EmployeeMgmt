package com.yash.EmployeeMgmt;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yash.EmployeeMgmt.model.Employee;

public class JsonUtil {

	public static byte[] toJson(Employee employee) throws JsonProcessingException {
		ObjectMapper objectMapper=new ObjectMapper();
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		return objectMapper.writeValueAsBytes(employee);
	}

}
