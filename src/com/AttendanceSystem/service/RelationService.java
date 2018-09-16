package com.AttendanceSystem.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.AttendanceSystem.pojo.po.User;
import com.AttendanceSystem.pojo.vo.UserCustom;

public interface RelationService {

	
	List<UserCustom> getAllUser(User  user);
	
	void  delete(User user);
	
	void add(User user) ;
	
	void modify(User user) ;
}
