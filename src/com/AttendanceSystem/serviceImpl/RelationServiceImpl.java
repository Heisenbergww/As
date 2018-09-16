package com.AttendanceSystem.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.AttendanceSystem.dao.DepartmentMapper;
import com.AttendanceSystem.dao.UserMapper;
import com.AttendanceSystem.pojo.po.User;
import com.AttendanceSystem.pojo.vo.UserCustom;
import com.AttendanceSystem.service.RelationService;

@Service
public class RelationServiceImpl implements RelationService {

	@Resource
	private UserMapper userMapper; 
	
	@Resource
	private DepartmentMapper  departmentMapper; 
	
	@Override
	public List<UserCustom> getAllUser(User user) {
		// TODO Auto-generated method stub
		 List<UserCustom> list =userMapper.getAllUser( user);
		
		 for(int i=0;i<list.size();i++) {
			// System.out.println("type"+i+":"+list.get(i).getUser_type());
			 
			 if(list.get(i).getUser_type()==null) {
				 	list.get(i).setUser_type("");
			 }
			 else {
				 if(list.get(i).getUser_type().equals("1")) {
					 	list.get(i).setUser_type("司长");
				 }
				 else if(list.get(i).getUser_type().equals("2")) {
					 list.get(i).setUser_type("正式员工");
				 }
				 else if(list.get(i).getUser_type().equals("3")) {
					 list.get(i).setUser_type("借调人员");
				 }
				 else {
					 
				 }
			 }
		 }
		return list;
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		User u=new User();
		u=userMapper.getDepIDByUserID(user);
		departmentMapper.updateDepTotal(u);
		userMapper.delete( user) ;
	}

	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		userMapper.add(user);
	}

	@Override
	public void modify(User user) {
		// TODO Auto-generated method stub
		userMapper.modify(user);
	}

}
