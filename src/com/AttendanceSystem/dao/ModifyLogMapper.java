package com.AttendanceSystem.dao;

import com.AttendanceSystem.pojo.po.ModifyLog;
import com.AttendanceSystem.pojo.po.ModifyLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ModifyLogMapper {
	
	List<ModifyLog> getAllModifyLog();
	
	 void addModifyLog(String log);
  
}