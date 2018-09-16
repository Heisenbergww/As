package com.AttendanceSystem.dao;

import com.AttendanceSystem.pojo.po.UserDepartment;
import com.AttendanceSystem.pojo.po.UserDepartmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserDepartmentMapper {
    int countByExample(UserDepartmentExample example);

    int deleteByExample(UserDepartmentExample example);

    int insert(UserDepartment record);

    int insertSelective(UserDepartment record);

    List<UserDepartment> selectByExample(UserDepartmentExample example);

    int updateByExampleSelective(@Param("record") UserDepartment record, @Param("example") UserDepartmentExample example);

    int updateByExample(@Param("record") UserDepartment record, @Param("example") UserDepartmentExample example);
}