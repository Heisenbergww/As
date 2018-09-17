package com.AttendanceSystem.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.AttendanceSystem.dao.SummaryMapper;
import com.AttendanceSystem.pojo.po.Summary;
import com.AttendanceSystem.service.EditAndSaveService;



@Service
public class EditAndSaveServiceImpl implements EditAndSaveService {

	
	@Resource
	private SummaryMapper summaryMapper; 
	
	
	@Override
	public void updata(Summary summary) {
		// TODO Auto-generated method stub
		summaryMapper.updata(summary);
	}


	@Override
	public void updata2(Summary summary) {
		// TODO Auto-generated method stub
		summaryMapper.updata2(summary);
	}
	
}
