package com.AttendanceSystem.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.AttendanceSystem.dao.DepartmentMapper;
import com.AttendanceSystem.dao.UserMapper;
import com.AttendanceSystem.pojo.po.Department;
import com.AttendanceSystem.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Resource
	private DepartmentMapper departmentMapper; 
	
	@Resource
	private UserMapper userMapper; 
	
	@Override
	public List<Department> getAllDepartment() {
		// TODO Auto-generated method stub
		return departmentMapper.getAllDepartment();
	}

	@Override
	public void modify(Department dep) {
		// TODO Auto-generated method stub
		departmentMapper.modify(dep );
	}

	@Override
	public void add(Department dep) {
		// TODO Auto-generated method stub
		departmentMapper.add(dep );
	}

	@Override
	public void delete(Department dep) {
		// TODO Auto-generated method stub
		departmentMapper.delete(dep );
		userMapper.setDepIDUserIDToNull(dep);
	}

 

}
