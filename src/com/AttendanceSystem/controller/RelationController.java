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
import com.AttendanceSystem.pojo.po.User;
import com.AttendanceSystem.pojo.vo.UserCustom;
import com.AttendanceSystem.service.PersonService;
import com.AttendanceSystem.service.RelationService;

@Controller
public class RelationController {

	@Autowired
	private RelationService  relationService;
	
	
	@RequestMapping("/relation/find")
	@ResponseBody
	public List<UserCustom> find(@RequestBody User user )  
	{
		System.out.println("user_id"+user.getUser_id());
		System.out.println("user_name"+user.getUser_name());
		System.out.println("dep_id"+user.getDepartment_id());
		if(user.getUser_id()==""||user.getUser_id()==null) {
				user.setUser_id("%");
		}
		if(user.getUser_name()==""||user.getUser_name()==null) {
			user.setUser_name("%");
	}
		if(user.getDepartment_id()==""||user.getDepartment_id()==null) {
			user.setDepartment_id("%");
	}
		return relationService.getAllUser(user);
		
	}
 
	@RequestMapping("/relation/add")
	@ResponseBody
	public Map<String ,Object> add(@RequestBody User user)  
	{
		Map<String ,Object> map=new HashMap<String ,Object>();
		map.put("success", true);
		System.out.println("user_id:"+user.getUser_id());
		System.out.println("user_name:"+user.getUser_name());
		System.out.println("dep_id:"+user.getDepartment_id());
		relationService.add(user);
		return map;
		
	}
	 
	@RequestMapping("/relation/modify")
	@ResponseBody
	public Map<String ,Object> modify(@RequestBody User user)  
	{
		Map<String ,Object> map=new HashMap<String ,Object>();
		map.put("success", true);
		System.out.println("user_id:"+user.getUser_id());
		System.out.println("user_name:"+user.getUser_name());
		System.out.println("dep_id:"+user.getDepartment_id());
		System.out.println("user_type:"+user.getUser_type());
		relationService.modify(user);
		return map;
		
	}
	
	@RequestMapping("/relation/delete")
	@ResponseBody
	public Map<String ,Object> delete(String  str)  
	{
		Map<String ,Object> map=new HashMap<String ,Object>();
		map.put("success", true);
		System.out.println("str:"+str.replace("\"", ""));
		User user=new User();
		user.setUser_id(str.replace("\"", ""));
		relationService.delete(user);
		return map;
		
	}
}
