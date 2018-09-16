package com.AttendanceSystem.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.AttendanceSystem.pojo.po.Department;
import com.AttendanceSystem.pojo.po.Summary;
import com.AttendanceSystem.pojo.po.WorkDate;
import com.AttendanceSystem.pojo.vo.summary_parameter;
import com.AttendanceSystem.service.AttendanceInformationsService;
import com.AttendanceSystem.service.EditAndSaveService;
import com.alibaba.fastjson.JSONObject;



@Controller
public class EditAndSaveController {

	
	@Autowired
	private EditAndSaveService  editAndSaveService;
	
	@Autowired
	private AttendanceInformationsService  attendanceInformationsService;
	
	@RequestMapping("/EditAndSave/Save")
	@ResponseBody
	public Map<String,Object> Save(String  str )  
	{
		System.out.println(str);
        List<summary_parameter> list = JSONObject.parseArray(str, summary_parameter.class);
        
        Summary summary=new Summary();
        Calendar c = Calendar.getInstance();
        
        List<Summary> oldlist=new  ArrayList<Summary>();
        oldlist=attendanceInformationsService.getAllOldSummary();
        
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=new Date();
        
        for(int j=0;j<list.size();j++) {
//			System.out.println("user_id:"+list.get(j).getUser_ID());
//			System.out.println("Affiliation_name:"+list.get(j).getAffiliation_name());
//			System.out.println("date:"+list.get(j).getDate());
//			System.out.println("WorkTime:"+list.get(j).getWorkTime());
//			System.out.println("OffworkTime:"+list.get(j).getOffworkTime());
//			System.out.println("Vacation_Type:"+list.get(j).getVacation_Type());
//			System.out.println("Remark:"+list.get(j).getRemark());
        		summary.setUser_ID(list.get(j).getUser_ID());
        		try {
 				   //date=sdf.parse("2018-01-07 09:20:20".replaceAll("：", ":"));
 				   date=sdf.parse(list.get(j).getDate());
 				   summary.setDate(date);
 				   date=sdf2.parse(list.get(j).getDate()+list.get(j).getWorkTime().replaceAll("：", ":"));
 				   summary.setWorkTime(date);
 				  date=sdf2.parse(list.get(j).getDate()+list.get(j).getOffworkTime().replaceAll("：", ":").trim());
				   summary.setWorkTime(date);
 			} catch (ParseException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}
        		if(list.get(j).getVacation_Type()=="") {
        				summary.setVacation_Type(null);
        		}
        		else {
        				summary.setVacation_Type(list.get(j).getVacation_Type());
        		}
        		if(list.get(j).getRemark()=="") {
    				summary.setRemark(null);
    		}
    		else {
    				summary.setRemark(list.get(j).getRemark());
    		}
        	
        		
        		List<WorkDate> list_workdate=new ArrayList<WorkDate>();
	            list_workdate=attendanceInformationsService.getAllworkdate();
 	            
 	            if(list.get(j).getVacation_Type()==null||list.get(j).getVacation_Type()=="2") {  	
 	            	
 	            	//设置应出勤时间
        	   		//data.getMonth返回0-11
        	   		if(summary.getDate().getMonth()>=4&&summary.getDate().getMonth()<=8) {
        	   				summary.setLength_OF_Should_AttendTime(9.5);//设置应出勤时间
        	   		}
        	   		else {
        	   			summary.setLength_OF_Should_AttendTime(9.0);//设置应出勤时间
        	   		}
        	   		
		 	        	  long  diff=summary.getOffworkTime().getTime()-summary.getWorkTime().getTime();
		 		   		  double  hours = (diff / (1000.0 * 60 * 60 )) ;//计算工作时间
		 		   		  summary.setLength_Of_TotalTime((double)Math.round(hours*100)/100);//将工作时间写入
		 		   		  
		 		   		  c.setTime(summary.getDate());
		 		   		int w=c.get(Calendar.DAY_OF_WEEK)-1;//星期,数值范围：0-6分别表示周末、周一...周六
		 		   		if(w==0||w==6)//是周六周末，然后判断是否是正常上班日
		 		   		{
     	   				 
     	   					int label_weekendovertime=0;
     	   					for(int i=0;i<list_workdate.size();i++) {
     	   							if(summary.getDate().equals(list_workdate.get(i).getDate())){
				     	   							if(list_workdate.get(i).getDateType()==1)//工作日
				   										label_weekendovertime=1;
				     	   							else
				   										label_weekendovertime=0;
				   									break;
     	   							}
     	   					}
     	   					if(label_weekendovertime==1) {
     	   							if(summary.getLength_OF_Should_AttendTime()==9.0) //10-4月，应出勤9.0小时
     	   							{
     	   								long  diff_moring=summary.getWorkTime().getTime()-summary.getDate().getTime();
     	   		        	   			double  hours_moring_ddff = (diff_moring / (1000.0 * 60 * 60 )) ;
     	   		        	   			
     	   		        	   		long  diff_afternoon=summary.getOffworkTime().getTime()-summary.getDate().getTime();
 	   		        	   			double  hours_diff_afternoonf = (diff_afternoon / (1000.0 * 60 * 60 )) ;
 	   		        	   			if(hours_moring_ddff<=8) {
 	   		        	   					if(hours_diff_afternoonf>=17) {
 	   		        	   					
 	   		        	   						summary.setLenght_Of_Workday_overtime((double)Math.round(((8-hours_moring_ddff)+(hours_diff_afternoonf-17))*100)/100);//将加班时间写入
 	   		        	   					}
 	   		        	   					else {
 	   		        	   				 
 	   		        	   						summary.setLenght_Of_Workday_overtime((double)Math.round((8-hours_moring_ddff)*100)/100);//将加班时间写入
 	   		        	   					}
 	   		        	   			}
 	   		        	   			else {
	        	   		        	   			if(hours_diff_afternoonf>=17) {
	        	   		        	   			
	        	   		        	   			summary.setLenght_Of_Workday_overtime((double)Math.round((hours_diff_afternoonf-17)*100)/100);//将加班时间写入
		   		        	   					}
		   		        	   					else {
		   		        	   					summary.setLenght_Of_Workday_overtime(0.0);//将加班时间写入
		   		        	   					}
 	   		        	   			}
 	   		        	   				
     	   							}
     	   							else //5-9月，应出勤9.5小时
     	   							{
     	   								long  diff_moring=summary.getWorkTime().getTime()-summary.getDate().getTime();
     	   		        	   			double  hours_moring_ddff = (diff_moring / (1000.0 * 60 * 60 )) ;
     	   		        	   			
     	   		        	   		long  diff_afternoon=summary.getOffworkTime().getTime()-summary.getDate().getTime();
 	   		        	   			double  hours_diff_afternoonf = (diff_afternoon / (1000.0 * 60 * 60 )) ;
 	   		        	   			if(hours_moring_ddff<=8) {
 	   		        	   					if(hours_diff_afternoonf>=17.5) {
 	   		        	   					
 	   		        	   						summary.setLenght_Of_Workday_overtime((double)Math.round(((8-hours_moring_ddff)+(hours_diff_afternoonf-17.5))*100)/100);//将加班时间写入
 	   		        	   					}
 	   		        	   					else {
 	   		        	   					
 	   		        	   						summary.setLenght_Of_Workday_overtime((double)Math.round((8-hours_moring_ddff)*100)/100);//将加班时间写入
 	   		        	   					}
 	   		        	   			}
 	   		        	   			else {
	        	   		        	   			if(hours_diff_afternoonf>=17.5) {
	        	   		        	   			
	        	   		        	   				summary.setLenght_Of_Workday_overtime((double)Math.round((hours_diff_afternoonf-17.5)*100)/100);//将加班时间写入
		   		        	   					}
		   		        	   					else {
		   		        	   						summary.setLenght_Of_Workday_overtime(0.0);//将加班时间写入
		   		        	   					}
 	   		        	   			}
     	   							}
     	   							
     	   							summary.setLength_Of_Holiday_overtime(0.0);
     	   							summary.setLength_Of_TotalOvertime(summary.getLenght_Of_Workday_overtime());
     	   					}
     	   					else//是正常周六周日，休息 
     	   					{
     	   						summary.setLength_Of_TotalOvertime(summary.getLength_Of_TotalTime());//计算总加班时间=出勤时间
     	   						summary.setLength_Of_Holiday_overtime(summary.getLength_Of_TotalTime());
     	   						summary.setLenght_Of_Workday_overtime(0.0);
     	   					}
     	   					 
     	   			}
     	   			else//是周一到周五，然后判断是否是公休日
     	   			{
     	   			int label_holiday=0;
   					for(int i=0;i<list_workdate.size();i++) {
   							if(list.get(j).getDate().equals(list_workdate.get(i).getDate()))
   							{
   								if(list_workdate.get(i).getDateType()==2)
   										label_holiday=1;
   								else
   										label_holiday=0;
   									break;
   							}
   					}
   					if(label_holiday==1) {
   						summary.setLength_Of_TotalOvertime(summary.getLength_Of_TotalTime());//计算总加班时间=出勤时间
   						summary.setLength_Of_Holiday_overtime(summary.getLength_Of_TotalTime());
   						summary.setLenght_Of_Workday_overtime(0.0);
   					}
   					else//是正常工作日 
   					{
   						if(summary.getLength_OF_Should_AttendTime()==9.0) //10-4月，应出勤9.0小时
							{
								long  diff_moring=summary.getWorkTime().getTime()-summary.getDate().getTime();
		        	   			double  hours_moring_ddff = (diff_moring / (1000.0 * 60 * 60 )) ;
		        	   			
		        	   		long  diff_afternoon=summary.getOffworkTime().getTime()-summary.getDate().getTime();
	        	   			double  hours_diff_afternoonf = (diff_afternoon / (1000.0 * 60 * 60 )) ;
	        	   			if(hours_moring_ddff>=8) {
	        	   					if(hours_diff_afternoonf>=17) {
	        	   					
	        	   						summary.setLenght_Of_Workday_overtime((double)Math.round(((hours_moring_ddff-8)+(hours_diff_afternoonf-17))*100)/100);//将加班时间写入
	        	   					}
	        	   					else {
	        	   				
	        	   						summary.setLenght_Of_Workday_overtime((double)Math.round((hours_moring_ddff-8)*100)/100);//将加班时间写入
	        	   					}
	        	   			}
	        	   			else {
   		        	   			if(hours_diff_afternoonf>=17) {
   		        	   			
   		        	   					summary.setLenght_Of_Workday_overtime((double)Math.round((hours_diff_afternoonf-17)*100)/100);//将加班时间写入
	        	   					}
	        	   					else {
	        	   						summary.setLenght_Of_Workday_overtime(0.0);//将加班时间写入
	        	   					}
	        	   			}
	        	   				
							}
							else //5-9月，应出勤9.5小时
							{
								long  diff_moring=summary.getWorkTime().getTime()-summary.getDate().getTime();
		        	   			double  hours_moring_ddff = (diff_moring / (1000.0 * 60 * 60 )) ;
		        	   			
		        	   		long  diff_afternoon=summary.getOffworkTime().getTime()-summary.getDate().getTime();
	        	   			double  hours_diff_afternoonf = (diff_afternoon / (1000.0 * 60 * 60 )) ;
	        	   			if(hours_moring_ddff>=8) {
	        	   					if(hours_diff_afternoonf>=17.5) {
	        	   					
	        	   						summary.setLenght_Of_Workday_overtime((double)Math.round(((hours_moring_ddff-8)+(hours_diff_afternoonf-17.5))*100)/100);//将加班时间写入
	        	   					}
	        	   					else {
	        	   					
	        	   						summary.setLenght_Of_Workday_overtime((double)Math.round((hours_moring_ddff-8)*100)/100);//将加班时间写入
	        	   					}
	        	   			}
	        	   			else {
   		        	   			if(hours_diff_afternoonf>=17.5) {
   		        	   			
   		        	   					summary.setLenght_Of_Workday_overtime((double)Math.round((hours_diff_afternoonf-17.5)*100)/100);//将加班时间写入
	        	   					}
	        	   					else {
	        	   						summary.setLenght_Of_Workday_overtime(0.0);//将加班时间写入
	        	   					}
	        	   			}
							}
							
   							summary.setLength_Of_Holiday_overtime(0.0);
   							summary.setLength_Of_TotalOvertime(summary.getLenght_Of_Workday_overtime());
   					}	
   				//计算迟到时间
        	   		if(summary.getWorkTime()!=null) {
        	   				long  latetime=summary.getWorkTime().getTime()-summary.getDate().getTime();
        	   				
	        	   			double  hours_latetime = (double)Math.round(((latetime / (1000.0 * 60 * 60 )))*100)/100 ;
	        	   			if(hours_latetime<=8) {
	        	   				summary.setLate_time(0.0);
	        	   				summary.setLate_type("1");
	        	   			}
	        	   			else {
	        	   					summary.setLate_time((double)Math.round((hours_latetime-8.0)*100)/100 );
	        	   					//计算迟到类型
	        	   					if(hours_latetime>8&&hours_latetime<=8.166) {
	        	   							if(summary.getLength_OF_Should_AttendTime()==9.0) {
	        	   								long  diff_after=summary.getOffworkTime().getTime()-summary.getDate().getTime();
	        			        	   			double  diff_after_hour = (double)Math.round(((diff_after / (1000.0 * 60 * 60 )))*100)/100 ;
	        			        	   			if(diff_after_hour>=17.5) {
	        			        	   				summary.setLate_type("2");
	        			        	   			}
	        			        	   			else {
	        			        	   				summary.setLate_type("3");
	        			        	   			}
	        	   							}
	        	   							else {
	        	   								long  diff_after=summary.getOffworkTime().getTime()-summary.getDate().getTime();
	        			        	   			double  diff_after_hour = (double)Math.round(((diff_after / (1000.0 * 60 * 60 )))*100)/100 ;
	        			        	   			if(diff_after_hour>=18) {
	        			        	   				summary.setLate_type("2");
	        			        	   			}
	        			        	   			else {
	        			        	   				summary.setLate_type("3");
	        			        	   			}
	        	   							}
	        	   					}
	        	   					else if(hours_latetime>8.1666&&hours_latetime<=8.5) {
	        	   						if(summary.getLength_OF_Should_AttendTime()==9.0) {
        	   								long  diff_after=summary.getOffworkTime().getTime()-summary.getDate().getTime();
        			        	   			double  diff_after_hour = (double)Math.round(((diff_after / (1000.0 * 60 * 60 )))*100)/100 ;
        			        	   			if(diff_after_hour>=18) {
        			        	   				summary.setLate_type("4");
        			        	   			}
        			        	   			else {
        			        	   				summary.setLate_type("5");
        			        	   			}
        	   							}
        	   							else {
        	   								long  diff_after=summary.getOffworkTime().getTime()-summary.getDate().getTime();
        			        	   			double  diff_after_hour = (double)Math.round(((diff_after / (1000.0 * 60 * 60 )))*100)/100 ;
        			        	   			if(diff_after_hour>=18.5) {
        			        	   				summary.setLate_type("4");
        			        	   			}
        			        	   			else {
        			        	   				summary.setLate_type("5");
        			        	   			}
        	   							}
	        	   					}
	        	   					else if(hours_latetime>8.5&&hours_latetime<9) {
	        	   							c.setTime(summary.getDate());
	        	   							c.add(Calendar.DAY_OF_MONTH, -1);// 今天-1天
	        	   							Date ddate = c.getTime();
	        	   			
	        	   								int oldlist_label=0;
	        	   									for(oldlist_label=0;oldlist_label<oldlist.size();oldlist_label++) {
	        	   										if(oldlist.get(oldlist_label).getDate().equals(ddate)&&summary.getUser_ID()==oldlist.get(oldlist_label).getUser_ID()) {
	        	   												if(oldlist.get(oldlist_label).getOffworkTime().getHours()>21) {
	        	   													summary.setLate_type("6");
	        	   													break;
	        	   												}
	        	   										}
	        	   									}
	        	   									if(oldlist_label==oldlist.size()) {
	        	   										summary.setLate_type("7");
	        	   									}
	        	   							
	        	   							 
	        	   							
	        	   					}
	        	   					else {
	        	   							summary.setLate_type("8");
	        	   					}
	        	   			}
        	   		}
        	   		//计算是否早退
        	   		
        	   		if(summary.getLength_OF_Should_AttendTime()==9.5){
        	   			long  diff_after=summary.getOffworkTime().getTime()-summary.getDate().getTime();
        	   			double  diff_after_hour = (double)Math.round(((diff_after / (1000.0 * 60 * 60 )))*100)/100 ;
        	   				if(diff_after_hour>17.5) {
        	   					summary.setEarly_Retreat("2");
        	   				}
        	   				else {
        	   					summary.setEarly_Retreat("1");
        	   				}
        	   		}
        	   		else {
        	   			long  diff_after=summary.getOffworkTime().getTime()-summary.getDate().getTime();
        	   			double  diff_after_hour = (double)Math.round(((diff_after / (1000.0 * 60 * 60 )))*100)/100 ;
        	   				if(diff_after_hour>17) {
        	   					summary.setEarly_Retreat("2");
        	   				}
        	   				else {
        	   					summary.setEarly_Retreat("1");
        	   				}
        	   		}
        	   			//设置是否旷工
        	   			summary.setAbsenteeism("2");		
     	   			}
		 		   	editAndSaveService.updata2(summary);
 	            }

 	            else //休年假
 	            {
 	            		summary.setLength_OF_Should_AttendTime(0.0);
 	            		editAndSaveService.updata(summary);
 	            }
 	           
        		
	}
		return null;
		
	}
}
