package com.AttendanceSystem.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.AttendanceSystem.pojo.po.Department;
import com.AttendanceSystem.pojo.po.Summary;
import com.AttendanceSystem.pojo.vo.department;
import com.AttendanceSystem.pojo.vo.find_parameter;
import com.AttendanceSystem.pojo.vo.persons;
import com.AttendanceSystem.service.AttendanceInformationsService;
import com.AttendanceSystem.service.DepartmentService;

@Controller
public class DepartmentController {

	
	@Autowired
	private AttendanceInformationsService  attendanceInformationsService;
	
	@Autowired
	private DepartmentService  departmentService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/department/find")
	@ResponseBody
	public List<department> find(@RequestBody  find_parameter find_p)  
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
		
		
		if(find_p.getDepartment_id()==null||find_p.getDepartment_id()=="") {
			find_p.setDepartment_id("%");
			
		}
			
	 
		if(find_p.getUser_id()==null||find_p.getUser_id()=="") {
			find_p.setUser_id("%");
			
		}
				
		
		List<Summary> list=attendanceInformationsService.getAllSummary(find_p);
		if(list.size()>0) {
			begin_time=list.get(0).getDate();
			end_time=list.get(0).getDate();
		}
		
		List<department>  departments_list=new ArrayList<department>();
		int department_list_label=0;
		int AllUser=0;
		
		for(int i=0;i<list.size();i++) 
		{
				for(department_list_label=0;department_list_label<departments_list.size();department_list_label++) {
						if(departments_list.get(department_list_label).getDepartment_id().equals(list.get(i).getAffiliation_id())) {
								break;
						}
				}
				if(department_list_label==departments_list.size()) {
						department  department=new department();
						department.setDepartment_id(list.get(i).getAffiliation_id());
						
						departments_list.add(department);
						
				}
		}
		
		
		List<Department> list_Dep=departmentService.getAllDepartment();
		System.out.println("list_Dep:"+list_Dep.size());
		for(int i=0;i<departments_list.size();i++) {
			for(int j=0;j<list_Dep.size();j++) {
				if(departments_list.get(i).getDepartment_id().equals(list_Dep.get(j).getDepartment_id())) {
					departments_list.get(i).setDepartment_name(list_Dep.get(j).getDepartment_name());
					departments_list.get(i).setDepartment_total(list_Dep.get(j).getDepartment_total());
					
				}
			}
			AllUser=AllUser+departments_list.get(i).getDepartment_total();
		}
		System.out.println("departments_list:"+departments_list.size());
	Double  ALLOVERTIME=0.0;
	
		
for(int i=0;i<departments_list.size();i++) {
	departments_list.get(i).setShouldAttendTime(0.0);
	departments_list.get(i).setAttendTime(0.0);
	departments_list.get(i).setWorkdayOverTime(0.0);
	departments_list.get(i).setHolidayOverTime(0.0);
	
	
	departments_list.get(i).setOldLateTime(0);
	departments_list.get(i).setOldEarlyRetreatTime(0);
	departments_list.get(i).setEarlyRetreatTime(0);
	departments_list.get(i).setAbsenteeismTime(0);
	departments_list.get(i).setBingTime(0);
	departments_list.get(i).setNianTime(0);
				for(int j=0;j<list.size();j++) {
					
					ALLOVERTIME=ALLOVERTIME+list.get(j).getLength_Of_TotalOvertime();
					
						if(departments_list.get(i).getDepartment_id()==list.get(j).getAffiliation_id())
						{
							departments_list.get(i).setShouldAttendTime(departments_list.get(i).getShouldAttendTime()+list.get(j).getLength_OF_Should_AttendTime());
							departments_list.get(i).setAttendTime(departments_list.get(i).getAttendTime()+list.get(j).getLength_Of_TotalTime());
							departments_list.get(i).setWorkdayOverTime(departments_list.get(i).getWorkdayOverTime()+list.get(j).getLenght_Of_Workday_overtime());
							departments_list.get(i).setHolidayOverTime(departments_list.get(i).getHolidayOverTime()+list.get(j).getLength_Of_Holiday_overtime());
							
							
								if(list.get(j).getLate_type()=="3"||list.get(j).getLate_type()=="5"||list.get(j).getLate_type()=="7"||list.get(j).getLate_type()=="8") {
									departments_list.get(i).setOldLateTime(departments_list.get(i).getOldLateTime()+1);
								}
								if(list.get(j).getEarly_Retreat()=="1") {
									departments_list.get(i).setOldEarlyRetreatTime(departments_list.get(i).getOldEarlyRetreatTime()+1);
									departments_list.get(i).setEarlyRetreatTime(departments_list.get(i).getEarlyRetreatTime()+1);
								}
								if(list.get(j).getAbsenteeism()=="1") {
									departments_list.get(i).setAbsenteeismTime(departments_list.get(i).getAbsenteeismTime()+1);
								}
								if(list.get(j).getVacation_Type()=="1") {
									departments_list.get(i).setBingTime(departments_list.get(i).getBingTime()+1);
								}
								else if(list.get(j).getVacation_Type()=="2") {
									departments_list.get(i).setNianTime(departments_list.get(i).getNianTime()+1);
								}
								else {}
							
								
						}
						if(list.get(j).getDate().before(begin_time)) {
								begin_time=list.get(j).getDate();
							}
						if(list.get(j).getDate().after(end_time)) {
								end_time=list.get(j).getDate();
							}
				}
				//计算加班时长
				departments_list.get(i).setOverTime(departments_list.get(i).getWorkdayOverTime()+departments_list.get(i).getHolidayOverTime());
				//计算平均加班时长
				departments_list.get(i).setAverageOverTime(departments_list.get(i).getOverTime()/departments_list.get(i).getDepartment_total());
				//计算平均加班时长与室平均的差值
				departments_list.get(i).setAllAverageOverTime(departments_list.get(i).getAverageOverTime()-(ALLOVERTIME)/AllUser);
				ALLOVERTIME=0.0;
				
		}
		
		
//   加班时长排名
		Collections.sort(departments_list, new DepSortByOverTime());
		for(int i=0;i<departments_list.size();i++) {
			departments_list.get(i).setOverTimeRank(i+1);
			
		}
	//   工作日加班时长排名
		Collections.sort(departments_list, new DepSortByWorkDayOverTime());
		for(int i=0;i<departments_list.size();i++) {
			departments_list.get(i).setWorkdayOverTimeRank(i+1);
			
		}
	//   公休日加班时长排名
		Collections.sort(departments_list, new DepSortByHolidayOverTime());
		for(int i=0;i<departments_list.size();i++) {
			departments_list.get(i).setHolidayOverTimeRank(i+1);
			
		}
		
	//   平均加班时长排名
		Collections.sort(departments_list, new DepSortByAverageOverTime());
		for(int i=0;i<departments_list.size();i++) {
			departments_list.get(i).setAverageOverTimeRank(i+1);
			
		}
	
		System.out.println("departments_list:"+departments_list.size());
		
		return departments_list;
	}
	
}


class DepSortByOverTime implements Comparator {
    public int compare(Object o1, Object o2) {
     department s1 = (department) o1;
     department s2 = (department) o2;
    if (s1.getOverTime() > s2.getOverTime())
      return -1;
     return 1;
    }
   }

class DepSortByWorkDayOverTime implements Comparator {
    public int compare(Object o1, Object o2) {
    	department s1 = (department) o1;
    	department s2 = (department) o2;
    if (s1.getWorkdayOverTime() > s2.getWorkdayOverTime())
      return -1;
     return 1;
    }
   }

class DepSortByHolidayOverTime implements Comparator {
    public int compare(Object o1, Object o2) {
    	department s1 = (department) o1;
    	department s2 = (department) o2;
    if (s1.getHolidayOverTime() > s2.getHolidayOverTime())
      return -1;
     return 1;
    }
   }

class DepSortByAverageOverTime implements Comparator {
    public int compare(Object o1, Object o2) {
    	department s1 = (department) o1;
    	department s2 = (department) o2;
    if (s1.getAverageOverTime() > s2.getAverageOverTime())
      return -1;
     return 1;
    }
   }


