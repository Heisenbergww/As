package com.AttendanceSystem.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.AttendanceSystem.dao.DepartmentMapper;
import com.AttendanceSystem.dao.ModifyLogMapper;
import com.AttendanceSystem.dao.WorkDateMapper;
import com.AttendanceSystem.pojo.po.ModifyLog;
import com.AttendanceSystem.pojo.po.WorkDate;
import com.AttendanceSystem.service.DateAddService;


@Service
public class DateAddServiceImpl implements DateAddService {

	
	@Resource
	private WorkDateMapper workDateMapper; 
	
	@Resource
	private ModifyLogMapper modifyLogMapper; 
	
	
	@Override
	public List<WorkDate> getAllWorkDate() {
		// TODO Auto-generated method stub
		return workDateMapper.getAllworkdate();
	}

	@Override
	public List<ModifyLog> getAllModifyLog() {
		// TODO Auto-generated method stub
		return modifyLogMapper.getAllModifyLog();
	}

	@Override
	public void modify(WorkDate wd) {
		// TODO Auto-generated method stub
		workDateMapper. modify(wd);
	}

	@Override
	public void addModifyLog(String log) {
		// TODO Auto-generated method stub
		modifyLogMapper.addModifyLog(log);
	}

}
