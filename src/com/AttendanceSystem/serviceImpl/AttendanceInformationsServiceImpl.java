package com.AttendanceSystem.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.AttendanceSystem.dao.DepartmentMapper;
import com.AttendanceSystem.dao.SummaryMapper;
import com.AttendanceSystem.dao.UserMapper;
import com.AttendanceSystem.dao.WorkDateMapper;
import com.AttendanceSystem.pojo.po.Summary;
import com.AttendanceSystem.pojo.po.User;
import com.AttendanceSystem.pojo.po.UserDepartment;
import com.AttendanceSystem.pojo.po.WorkDate;
import com.AttendanceSystem.pojo.vo.find_parameter;
import com.AttendanceSystem.service.AttendanceInformationsService;

@Service
public class AttendanceInformationsServiceImpl implements AttendanceInformationsService {

	
	@Resource
	private UserMapper userMapper; 
	
	@Resource
	private SummaryMapper summaryMapper; 
	
	@Resource
	private DepartmentMapper departmentMapper; 
	
	@Resource
	private WorkDateMapper workDateMapper; 

	
	@Override
	public UserDepartment getDepartmentIdByUserId(Summary summary) {
		
		return departmentMapper.getDepartmentIdByUserId(summary);
	}

	@Override
	public void InsertAttendanceInoformations(Summary summary) {
		// TODO Auto-generated method stub
		summaryMapper.InsertAttendanceInoformations(summary) ;
		
	}

	
	@Override
	public List<WorkDate> getAllworkdate() {
		// TODO Auto-generated method stub
		
		return workDateMapper.getAllworkdate();
	}



	@Override
	public List<Summary> getAllSummary(find_parameter find_p) {
		// TODO Auto-generated method stub
		
		return summaryMapper. getAllSummary(  find_p);
	}

	
	
	@Override
	public List<Summary> getAllOldSummary() {
		// TODO Auto-generated method stub
		return summaryMapper.getAllOldSummary( );
	}

	@Override
	public List<User> getAllUserForStatisticians() {
		// TODO Auto-generated method stub
		return userMapper.getAllUserForStatisticians();
	}
}
