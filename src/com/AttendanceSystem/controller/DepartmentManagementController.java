package com.AttendanceSystem.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.AttendanceSystem.pojo.po.Department;
import com.AttendanceSystem.pojo.vo.department;
import com.AttendanceSystem.pojo.vo.find_parameter;
import com.AttendanceSystem.service.DepartmentService;

@Controller
public class DepartmentManagementController {

	
	@Autowired
	private DepartmentService  departmentService;
	
	
	 
	@RequestMapping("/departmentManagement/find")
	@ResponseBody
	public List<Department> find( )  
	{
		
		return departmentService.getAllDepartment();
		
	}
	
	 
	@RequestMapping("/departmentManagement/modify")
	@ResponseBody
	public Map<String ,Object> modify(@RequestBody  Department dep)  
	{
		Map<String ,Object> map=new HashMap<String ,Object>();
		map.put("success", true);
//		System.out.println("Department_id:"+dep.getDepartment_id());
//		System.out.println("Department_name:"+dep.getDepartment_name());
//		System.out.println("Department_total:"+dep.getDepartment_total());
		departmentService.modify(dep);
		return map;
		
	}
	
	
	//departmentManagement/add
	@RequestMapping("/departmentManagement/add")
	@ResponseBody
	public Map<String ,Object> add(@RequestBody  Department dep)  
	{
		Map<String ,Object> map=new HashMap<String ,Object>();
		map.put("success", true);
//		System.out.println("Department_id:"+dep.getDepartment_id());
//		System.out.println("Department_name:"+dep.getDepartment_name());
//		System.out.println("Department_total:"+dep.getDepartment_total());
		dep.setDepartment_total(0);
		departmentService.add(dep);
		return map;
		
	}
 
	@RequestMapping("/departmentManagement/delete")
	@ResponseBody
	public Map<String ,Object> delete(String  res)  
	{
		Map<String ,Object> map=new HashMap<String ,Object>();
		map.put("success", true);
		System.out.println("res:"+res.replace("\"", ""));
		Department dep=new Department();
		dep.setDepartment_id(res.replace("\"", ""));
		departmentService.delete(dep);
		return map;
		
	}
	
}
