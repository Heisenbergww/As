package com.AttendanceSystem.service;

import java.util.ArrayList;
import java.util.List;

import com.AttendanceSystem.pojo.po.Summary;
import com.AttendanceSystem.pojo.po.User;
import com.AttendanceSystem.pojo.po.UserDepartment;
import com.AttendanceSystem.pojo.po.WorkDate;
import com.AttendanceSystem.pojo.vo.find_parameter;

public interface AttendanceInformationsService {

	UserDepartment getDepartmentIdByUserId(Summary summary);
	
	void InsertAttendanceInoformations(Summary summary);
	
	List<WorkDate> getAllworkdate();
    
    List<Summary>  getAllSummary(find_parameter find_p);
    
    List<Summary>  getAllOldSummary();
    
    
    List<User> getAllUserForStatisticians();
}
