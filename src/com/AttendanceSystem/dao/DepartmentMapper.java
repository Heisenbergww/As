package com.AttendanceSystem.dao;

import com.AttendanceSystem.pojo.po.Department;
import com.AttendanceSystem.pojo.po.DepartmentExample;
import com.AttendanceSystem.pojo.po.Summary;
import com.AttendanceSystem.pojo.po.User;
import com.AttendanceSystem.pojo.po.UserDepartment;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DepartmentMapper {
	
	
	UserDepartment getDepartmentIdByUserId(Summary summary);
	
	List<Department> getAllDepartment();
	
	void modify(Department dep);
	
	void add(Department dep);
	
	void delete(Department dep);
	
	void updateDepTotal(User u);
	
    int countByExample(DepartmentExample example);

    int deleteByExample(DepartmentExample example);

    int insert(Department record);

    int insertSelective(Department record);

    List<Department> selectByExample(DepartmentExample example);

    int updateByExampleSelective(@Param("record") Department record, @Param("example") DepartmentExample example);

    int updateByExample(@Param("record") Department record, @Param("example") DepartmentExample example);
}