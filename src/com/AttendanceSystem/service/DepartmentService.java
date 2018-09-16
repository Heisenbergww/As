package com.AttendanceSystem.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.AttendanceSystem.pojo.po.Department;

public interface DepartmentService {

	
	List<Department> getAllDepartment();
	
	void modify(Department dep);
	
	void add(Department dep);
	
	void delete(Department dep);
	
	 
}
