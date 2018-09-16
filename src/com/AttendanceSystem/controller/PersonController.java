package com.AttendanceSystem.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.AttendanceSystem.pojo.po.Summary;
import com.AttendanceSystem.pojo.vo.find_parameter;
import com.AttendanceSystem.pojo.vo.persons;
import com.AttendanceSystem.pojo.vo.summary_parameter;
import com.AttendanceSystem.service.AttendanceInformationsService;
import com.AttendanceSystem.service.PersonService;
import com.alibaba.fastjson.JSONObject;

@Controller
public class PersonController {

	
	@Autowired
	private PersonService  personService;
	
	
	@Autowired
	private AttendanceInformationsService  attendanceInformationsService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/persons/find")
	@ResponseBody
	public List<persons> find(@RequestBody  find_parameter find_p)  
	{
		System.out.println("ok");	
		System.out.println("id:"+find_p.getUser_id());
		System.out.println("mark1:"+find_p.getMark1());
		System.out.println("mark2:"+find_p.getMark2());
		System.out.println("times1:"+find_p.getTimes1());
		System.out.println("times2:"+find_p.getTimes2());
		
		
		Date data=new Date();
		Date begin_time=new Date();
		Date end_time=new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		
		if(find_p.getBegin_date()=="") {
			try {
				data=sdf.parse("19500101");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				find_p.setBegin_date2(data);
		}
		else {
				try {
						data=sdf.parse(find_p.getBegin_date());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				find_p.setBegin_date2(data);
		}
		
		if(find_p.getEnd_date()=="") {
				Date now=new Date();
				find_p.setEnd_date2(now);
		}
		else {
				try {
						data=sdf.parse(find_p.getEnd_date());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				find_p.setEnd_date2(data);
		}
		
		
		if(find_p.getDepartment_id()==null) {
			find_p.setDepartment_id("%");
		}
			
	 
		if(find_p.getUser_id()==null) {
			find_p.setUser_id("%");
		}
				
		
		List<Summary> list=attendanceInformationsService.getAllSummary(find_p);
		if(list.size()>0) {
			begin_time=list.get(0).getDate();
			end_time=list.get(0).getDate();
		}
		
		List<persons>  person_list=new ArrayList<persons>();
		int person_list_label=0;
	
		
		for(int i=0;i<list.size();i++) 
		{
				for(person_list_label=0;person_list_label<person_list.size();person_list_label++) {
						if(person_list.get(person_list_label).getUser_ID().equals(list.get(i).getUser_ID())) {
								break;
						}
				}
				if(person_list_label==person_list.size()) {
						persons  person=new persons();
						person.setAffiliation_id(list.get(i).getAffiliation_id());
						person.setAffiliation_name(list.get(i).getAffiliation_name());
						person.setUser_ID(list.get(i).getUser_ID());
						person.setUser_Name(list.get(i).getUser_Name());
						System.out.println("id:"+list.get(i).getUser_ID());
						System.out.println("name:"+list.get(i).getUser_Name());
						person_list.add(person);
						
				}
				
		}
		
	
	
		for(int i=0;i<person_list.size();i++) {
			
			person_list.get(i).setOldLateTime(0);
			person_list.get(i).setOldEarlyRetreatTime(0);
			person_list.get(i).setEarlyRetreatTime(0);
			person_list.get(i).setAbsenteeismTime(0);
			person_list.get(i).setBingTime(0);
			person_list.get(i).setNianTime(0);
			person_list.get(i).setShouldAttendTime(0.0);
			person_list.get(i).setAttendTime(0.0);
			person_list.get(i).setWorkdayOverTime(0.0);
			person_list.get(i).setHolidayOverTime(0.0);
			person_list.get(i).setNoPunchCardAfterWorkTime(0);
			person_list.get(i).setNoPunchCardAtWorkTime(0);
			
				for(int j=0;j<list.size();j++) {
						if(person_list.get(i).getUser_ID()==list.get(j).getUser_ID())//计算原始迟到
						{
								if(list.get(j).getLate_type()=="3"||list.get(j).getLate_type()=="5"||list.get(j).getLate_type()=="7"||list.get(j).getLate_type()=="8") {
									person_list.get(i).setOldLateTime(person_list.get(i).getOldLateTime()+1);
								}
								if(list.get(j).getEarly_Retreat()=="1") {
									person_list.get(i).setOldEarlyRetreatTime(person_list.get(i).getOldEarlyRetreatTime()+1);
									person_list.get(i).setEarlyRetreatTime(person_list.get(i).getEarlyRetreatTime()+1);
								}
								if(list.get(j).getAbsenteeism()=="1") {
									person_list.get(i).setAbsenteeismTime(person_list.get(i).getAbsenteeismTime()+1);
								}
								if(list.get(j).getVacation_Type()=="1") {
									person_list.get(i).setBingTime(person_list.get(i).getBingTime()+1);
								}
								else if(list.get(j).getVacation_Type()=="2") {
									person_list.get(i).setNianTime(person_list.get(i).getNianTime()+1);
								}
								else {}
								if(list.get(j).getNo_punch_card_after_work()=="1") {
									person_list.get(i).setNoPunchCardAfterWorkTime(person_list.get(i).getNoPunchCardAfterWorkTime()+1);
								}
								if(list.get(j).getNo_punch_card_at_work()=="1") {
									person_list.get(i).setNoPunchCardAtWorkTime(person_list.get(i).getNoPunchCardAtWorkTime()+1);
								}
								person_list.get(i).setShouldAttendTime(person_list.get(i).getShouldAttendTime()+list.get(j).getLength_OF_Should_AttendTime());
								person_list.get(i).setAttendTime(person_list.get(i).getAttendTime()+list.get(j).getLength_Of_TotalTime());
								person_list.get(i).setWorkdayOverTime(person_list.get(i).getWorkdayOverTime()+list.get(j).getLenght_Of_Workday_overtime());
								person_list.get(i).setHolidayOverTime(person_list.get(i).getHolidayOverTime()+list.get(j).getLength_Of_Holiday_overtime());
								
						}
						if(list.get(j).getDate().before(begin_time)) {
								begin_time=list.get(j).getDate();
							}
						if(list.get(j).getDate().after(end_time)) {
								end_time=list.get(j).getDate();
							}
				}
				if(person_list.get(i).getAttendTime()-person_list.get(i).getShouldAttendTime()>0)
					person_list.get(i).setBeyondAttendTime(person_list.get(i).getAttendTime()-person_list.get(i).getShouldAttendTime());
				person_list.get(i).setOverTime(person_list.get(i).getWorkdayOverTime()+person_list.get(i).getHolidayOverTime());
		}
		
		Collections.sort(person_list, new SortByOverTime());
		for(int i=0;i<person_list.size();i++) {
			person_list.get(i).setRank(i+1);
			
		}
		System.out.println("size:"+person_list.size());
		return person_list;
		
      
	}
}

@SuppressWarnings("rawtypes")
class SortByOverTime implements Comparator {
    public int compare(Object o1, Object o2) {
     persons s1 = (persons) o1;
     persons s2 = (persons) o2;
    if (s1.getOverTime() > s2.getOverTime())
      return -1;
     return 1;
    }
   }
