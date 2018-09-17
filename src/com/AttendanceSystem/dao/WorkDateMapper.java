package com.AttendanceSystem.dao;

import com.AttendanceSystem.pojo.po.WorkDate;
import com.AttendanceSystem.pojo.po.WorkDateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkDateMapper {
	
	
	List<WorkDate> getAllworkdate();
	
	void modify(WorkDate wd);
	
    int countByExample(WorkDateExample example);

    int deleteByExample(WorkDateExample example);

    int insert(WorkDate record);

    int insertSelective(WorkDate record);

    List<WorkDate> selectByExample(WorkDateExample example);

    int updateByExampleSelective(@Param("record") WorkDate record, @Param("example") WorkDateExample example);

    int updateByExample(@Param("record") WorkDate record, @Param("example") WorkDateExample example);
}