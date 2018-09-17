package com.AttendanceSystem.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.AttendanceSystem.pojo.po.ModifyLog;
import com.AttendanceSystem.pojo.po.WorkDate;
import com.AttendanceSystem.pojo.vo.find_parameter;
import com.AttendanceSystem.pojo.vo.persons;
import com.AttendanceSystem.service.DateAddService;
import com.AttendanceSystem.service.DepartmentService;

@Controller
public class DateAddController {


	@Autowired
	private DateAddService  dateAddService;
	
	@RequestMapping("/dateadd/find")
	@ResponseBody
	public Map<String ,Object> find( )  
	{
		Map<String ,Object> result =new HashMap<String ,Object>();
		//recordList
		//dateList
		//workDateList
		List<WorkDate> list_workdate=dateAddService.getAllWorkDate();
		List<ModifyLog> list_modifylog=dateAddService.getAllModifyLog();
		
		List<String> dateWork=new ArrayList<String>();
		List<String> dateHoliday=new ArrayList<String>();
		
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		
		result.put("recordList", list_modifylog);
		for(int i=0;i<list_workdate.size();i++) {
				if(list_workdate.get(i).getDateType()==1)//工作日
				{
					dateWork.add(sdf.format(list_workdate.get(i).getDate()).toString());
				}
				else//公休日
				{
					dateHoliday.add(sdf.format(list_workdate.get(i).getDate()).toString());
				}
		}
		result.put("dateList", dateHoliday);
		result.put("workDateList", dateWork);
		
		return result;
	}
	@RequestMapping("/dateadd/modify")
	@ResponseBody
	public Map<String ,Object> modify( @RequestBody  List<String>  list)  
	{
		String regEx="[^0-9]";  
		Pattern p = Pattern.compile(regEx);  
		Matcher m=null;
		
		SimpleDateFormat sdf= new SimpleDateFormat("yyyyMMdd");
		
		//System.out.println("workDate="+list.size());
		for(int i=0;i<list.size();i++) {
			WorkDate wd=new WorkDate();
			m = p.matcher(list.get(i));  
			try {
				wd.setDate(sdf.parse(m.replaceAll("").trim()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println( m.replaceAll("").trim());
			if(list.get(i).charAt(list.get(i).length()-1)=='k') {
				//System.out.println(list.get(i)+":"+"k");
				wd.setDateType(1);
			}
			else {
				//System.out.println(list.get(i)+":"+"y");
				wd.setDateType(2);
			}
			dateAddService.modify(wd);
			dateAddService.addModifyLog(list.get(i).substring(0, list.get(i).length()-1));
		}
		
		
		
		Map<String ,Object> map=new HashMap<String ,Object>();
		map.put("success", true);
		return map ;
		
	}
	
}
