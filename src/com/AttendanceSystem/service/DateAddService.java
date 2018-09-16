package com.AttendanceSystem.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.AttendanceSystem.pojo.po.ModifyLog;
import com.AttendanceSystem.pojo.po.WorkDate;

public interface DateAddService {

	
	List<WorkDate>  getAllWorkDate();
	
	List<ModifyLog>  getAllModifyLog();
	
	void modify( WorkDate wd);  
	
	void addModifyLog(String  log);
	
}
