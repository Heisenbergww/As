package com.AttendanceSystem.dao;

import com.AttendanceSystem.pojo.po.Department;
import com.AttendanceSystem.pojo.po.User;
import com.AttendanceSystem.pojo.po.UserExample;
import com.AttendanceSystem.pojo.vo.UserCustom;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
	
	List<User> getAllUserForStatisticians();
	
	List<UserCustom> getAllUser(User user);
	
	User getDepIDByUserID(User user);
	
	void delete(User user);
	
	void setDepIDUserIDToNull(Department dep);
	
	 void add(User user);
	
	 void modify(User user);
	
	
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);
}