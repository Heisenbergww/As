package com.AttendanceSystem.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.AttendanceSystem.pojo.po.Department;
import com.AttendanceSystem.pojo.po.Summary;
import com.AttendanceSystem.pojo.po.User;
import com.AttendanceSystem.pojo.po.UserDepartment;
import com.AttendanceSystem.pojo.po.WorkDate;
import com.AttendanceSystem.pojo.vo.UserCustom;
import com.AttendanceSystem.pojo.vo.UserShouldLate;
import com.AttendanceSystem.pojo.vo.YearMonth;
import com.AttendanceSystem.pojo.vo.find_parameter;
import com.AttendanceSystem.service.AttendanceInformationsService;
import com.AttendanceSystem.service.RelationService;

@Controller
public class AttendanceInformationsController {

	
	@Autowired
	private AttendanceInformationsService  attendanceInformationsService;
	
	@Autowired
	private RelationService  relationService;
	
	
	
	@RequestMapping("/attendance/informations/uploadfile")
	@ResponseBody
	public List<Summary> upload(MultipartFile file) throws Exception {
		// 获得文件的原始名字
		
		String orinalFilename = file.getOriginalFilename();
		String pathRoot = "";
		
		Map<String, Object> map=new HashMap<String, Object>();
		map=null;
		if (file != null) {
			// 存储图片的物理路径
			//String pic_path = "C:\\upload\\temp\\";
			String pic_path = "C:/upload/temp/";
			// 定义图片新的名称
			//String newFileName = UUID.randomUUID() + orinalFilename.substring(orinalFilename.lastIndexOf("."));
			// 新的文件
			File newFile = new File(pic_path + orinalFilename);	
			// 复制文件到指定盘符
						try {
							if(!newFile.exists())
								newFile.createNewFile();
							file.transferTo(newFile);
						}catch(Exception e) {
							e.printStackTrace();
						}
			//遍历原始数据
						
			 InputStreamReader reader = new InputStreamReader(new FileInputStream(newFile)); // 建立一个输入流对象reader
			 BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言  
			 String line = "";  
	           line = br.readLine();  
	           List<Summary> list=new  ArrayList<Summary>();
	           List<Summary> oldlist=new  ArrayList<Summary>();
	           oldlist=attendanceInformationsService.getAllOldSummary();
	           
	           
	           SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	           SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd");
	           Calendar c = Calendar.getInstance();
	           Date begin_time=new Date();
	           begin_time=null;
	           Date end_time=new Date();
	           end_time=null;
	           
	           
	            while (line != null) {
	            	if(line.substring(0,4).equals("time")) {
	            		//System.out.println(line);
	            		Summary summary=new Summary();
	            		String[]  strs=line.split("\"");
	            		//System.out.println(strs[3].toString());
	            	
	            		Date data=new Date( );
	            		data=sdf.parse(strs[1].toString());
	            		
	            		summary.setWorkTime(data);
	            		summary.setOffworkTime(data);
	            		
	            		data=sdf2.parse(strs[1].toString().substring(0, 10));
	            		
	            		summary.setDate(data);
	            	
	            		summary.setUser_ID(strs[3].toString());
	            		summary.setUser_Name(strs[5].toString());
	            		

	            		int i=0;
	            		if(summary.getWorkTime().getHours()<=3) {
	            			Date dd=summary.getWorkTime();
	            			
	            	        c.setTime(dd);
	            	        c.add(Calendar.DAY_OF_MONTH, -1);// 今天-1天
	            	        dd = c.getTime();
	            	        summary.setDate(dd);
	            		}
	            		
	            		for(i=0;i<list.size();i++) {
	            				
	            			if((list.get(i).getDate().equals(summary.getDate()))&&(list.get(i).getUser_ID().equals(summary.getUser_ID()))) {
	            							if(list.get(i).getWorkTime().after(summary.getWorkTime())) {
	            									list.get(i).setWorkTime(summary.getWorkTime());
	            									break;
	            							}
	            							else  if(list.get(i).getOffworkTime().before(summary.getWorkTime())){
	            									list.get(i).setOffworkTime(summary.getWorkTime());
	            									break;
	            							}
	            							else {
	            								continue;
	            							}	
	            						}
	            				}
	            		if(i==list.size()) {
	            				list.add(summary);
	            		}
	            		
	            	}	
	                line = br.readLine(); // 一次读入一行数据
	                
	            }  
	            newFile.delete();
	          
	            List<WorkDate> list_workdate=new ArrayList<WorkDate>();
	            list_workdate=attendanceInformationsService.getAllworkdate();
	           
	            if(list.size()>0) {
	            	begin_time=list.get(0).getDate();
		            end_time=list.get(0).getDate();
	            }
	            
	            
	            for(int ii=1;ii<list.size();ii++) {
	            	if(list.get(ii).getDate().before(begin_time)) {
	            		begin_time=list.get(ii).getDate();
	            	}
	            	if(list.get(ii).getDate().after(end_time)) {
	            		end_time=list.get(ii).getDate();
	            	}
	            }
	            
	            
	           for(int j=0;j<list.size();j++) {
	        	   
	        	   		UserDepartment dep=new UserDepartment();
	        	   		dep=attendanceInformationsService.getDepartmentIdByUserId(list.get(j));
	        	   		if(dep!=null)
	        	   		{
				        	   		list.get(j).setAffiliation_id(dep.getDepartment_id());//设置部门ID
				        	   		list.get(j).setAffiliation_name(dep.getDepartment_name());//设置部门名称
	        	   		}
	        	   		//设置应出勤时间
	        	   		//data.getMonth返回0-11
	        	   		if(list.get(j).getDate().getMonth()>=4&&list.get(j).getDate().getMonth()<=8) {
	        	   				list.get(j).setLength_OF_Should_AttendTime(9.5);//设置应出勤时间
	        	   		}
	        	   		else {
	        	   				list.get(j).setLength_OF_Should_AttendTime(9.0);//设置应出勤时间
	        	   		}
	        	   		
	        	   		//设置早晚没打卡
	        	   		if(list.get(j).getWorkTime().equals(list.get(j).getOffworkTime())) {
	        	   				list.get(j).setLength_Of_TotalTime(null);
	        	   				if(list.get(j).getWorkTime().getHours()>3&&list.get(j).getWorkTime().getHours()<=16) {
	        	   						list.get(j).setOffworkTime(null);
	        	   						list.get(j).setNo_punch_card_after_work("1");
	        	   						list.get(j).setNo_punch_card_at_work("2");
	        	   				}
	        	   				else {
	        	   						list.get(j).setWorkTime(null);
	        	   						list.get(j).setNo_punch_card_after_work("2");
	        	   						list.get(j).setNo_punch_card_at_work("1");
	        	   				}
	        	   				list.get(j).setYes_Or_No("1");//设置为异常数据
	        	   		}
	        	   		
	        	   		else {
	        	   			list.get(j).setNo_punch_card_after_work("2");
	   						list.get(j).setNo_punch_card_at_work("2");
	   						list.get(j).setYes_Or_No("2");//设置为正常数据
	        	   			
	        	   			long  diff=list.get(j).getOffworkTime().getTime()-list.get(j).getWorkTime().getTime();
	        	   			double  hours = (diff / (1000.0 * 60 * 60 )) ;//计算工作时间
	        	   			list.get(j).setLength_Of_TotalTime((double)Math.round(hours*100)/100);//将工作时间写入
	        	   			 
	        	   			c.setTime(list.get(j).getDate());
	
	        	   			int w=c.get(Calendar.DAY_OF_WEEK)-1;//星期,数值范围：0-6分别表示周末、周一...周六
	        	   		 
	        	   			if(w==0||w==6)//是周六周末，然后判断是否是正常上班日
	        	   			{
	        	   				 
	        	   					int label_weekendovertime=0;
	        	   					for(int i=0;i<list_workdate.size();i++) {
	        	   							if(list.get(j).getDate().equals(list_workdate.get(i).getDate()))
	        	   							{
	        	   								if(list_workdate.get(i).getDateType()==1)//工作日
	        	   										label_weekendovertime=1;
	        	   								else
	        	   										label_weekendovertime=0;
	        	   									break;
	        	   							}
	        	   					}
	        	   					if(label_weekendovertime==1) {
	        	   							if(list.get(j).getLength_OF_Should_AttendTime()==9.0) //10-4月，应出勤9.0小时
	        	   							{
	        	   								long  diff_moring=list.get(j).getWorkTime().getTime()-list.get(j).getDate().getTime();
	        	   		        	   			double  hours_moring_ddff = (diff_moring / (1000.0 * 60 * 60 )) ;
	        	   		        	   			
		        	   		        	   		long  diff_afternoon=list.get(j).getOffworkTime().getTime()-list.get(j).getDate().getTime();
	        	   		        	   			double  hours_diff_afternoonf = (diff_afternoon / (1000.0 * 60 * 60 )) ;
	        	   		        	   			
        	   		        	   			if(hours_moring_ddff<=8) {
        	   		        	   					if(hours_diff_afternoonf>=17) {
        	   		        	   					
        	   		        	   							list.get(j).setLenght_Of_Workday_overtime((double)Math.round(((8-hours_moring_ddff)+(hours_diff_afternoonf-17))*100)/100);//将加班时间写入
        	   		        	   					}
        	   		        	   					else {
        	   		        	   				 
        	   		        	   							list.get(j).setLenght_Of_Workday_overtime((double)Math.round((8-hours_moring_ddff)*100)/100);//将加班时间写入
        	   		        	   					}
        	   		        	   			}
        	   		        	   			else {
		        	   		        	   			if(hours_diff_afternoonf>=17) {
		        	   		        	   			
		        	   		        	   				list.get(j).setLenght_Of_Workday_overtime((double)Math.round((hours_diff_afternoonf-17)*100)/100);//将加班时间写入
			   		        	   					}
			   		        	   					else {
			   		        	   						list.get(j).setLenght_Of_Workday_overtime(0.0);//将加班时间写入
			   		        	   					}
        	   		        	   			}
        	   		        	   				
	        	   							}
	        	   							else //5-9月，应出勤9.5小时
	        	   							{
	        	   								long  diff_moring=list.get(j).getWorkTime().getTime()-list.get(j).getDate().getTime();
	        	   		        	   			double  hours_moring_ddff = (diff_moring / (1000.0 * 60 * 60 )) ;
	        	   		        	   			
	        	   		        	   		long  diff_afternoon=list.get(j).getOffworkTime().getTime()-list.get(j).getDate().getTime();
        	   		        	   			double  hours_diff_afternoonf = (diff_afternoon / (1000.0 * 60 * 60 )) ;
        	   		        	   			if(hours_moring_ddff<=8) {
        	   		        	   					if(hours_diff_afternoonf>=17.5) {
        	   		        	   					
        	   		        	   							list.get(j).setLenght_Of_Workday_overtime((double)Math.round(((8-hours_moring_ddff)+(hours_diff_afternoonf-17.5))*100)/100);//将加班时间写入
        	   		        	   					}
        	   		        	   					else {
        	   		        	   					
        	   		        	   							list.get(j).setLenght_Of_Workday_overtime((double)Math.round((8-hours_moring_ddff)*100)/100);//将加班时间写入
        	   		        	   					}
        	   		        	   			}
        	   		        	   			else {
		        	   		        	   			if(hours_diff_afternoonf>=17.5) {
		        	   		        	   			
		        	   		        	   				list.get(j).setLenght_Of_Workday_overtime((double)Math.round((hours_diff_afternoonf-17.5)*100)/100);//将加班时间写入
			   		        	   					}
			   		        	   					else {
			   		        	   						list.get(j).setLenght_Of_Workday_overtime(0.0);//将加班时间写入
			   		        	   					}
        	   		        	   			}
	        	   							}
	        	   							
	        	   							list.get(j).setLength_Of_Holiday_overtime(0.0);
	        	   							list.get(j).setLength_Of_TotalOvertime(list.get(j).getLenght_Of_Workday_overtime());
	        	   					}
	        	   					else//是正常周六周日，休息 
	        	   					{
	        	   						list.get(j).setLength_Of_TotalOvertime(list.get(j).getLength_Of_TotalTime());//计算总加班时间=出勤时间
	        	   						list.get(j).setLength_Of_Holiday_overtime(list.get(j).getLength_Of_TotalTime());
	        	   						list.get(j).setLenght_Of_Workday_overtime(0.0);
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
	        	   						list.get(j).setLength_Of_TotalOvertime(list.get(j).getLength_Of_TotalTime());//计算总加班时间=出勤时间
	        	   						list.get(j).setLength_Of_Holiday_overtime(list.get(j).getLength_Of_TotalTime());
	        	   						list.get(j).setLenght_Of_Workday_overtime(0.0);
	        	   					}
	        	   					else//是正常工作日 
	        	   					{
	        	   						if(list.get(j).getLength_OF_Should_AttendTime()==9.0) //10-4月，应出勤9.0小时
        	   							{
        	   								long  diff_moring=list.get(j).getWorkTime().getTime()-list.get(j).getDate().getTime();
        	   		        	   			double  hours_moring_ddff = (diff_moring / (1000.0 * 60 * 60 )) ;
        	   		        	   			
        	   		        	   		long  diff_afternoon=list.get(j).getOffworkTime().getTime()-list.get(j).getDate().getTime();
    	   		        	   			double  hours_diff_afternoonf = (diff_afternoon / (1000.0 * 60 * 60 )) ;
    	   		        	   			if(hours_moring_ddff<=8) {
    	   		        	   					if(hours_diff_afternoonf>=17) {
    	   		        	   					
    	   		        	   							list.get(j).setLenght_Of_Workday_overtime((double)Math.round(((8-hours_moring_ddff)+(hours_diff_afternoonf-17))*100)/100);//将加班时间写入
    	   		        	   					}
    	   		        	   					else {
    	   		        	   				
    	   		        	   							list.get(j).setLenght_Of_Workday_overtime((double)Math.round((8-hours_moring_ddff)*100)/100);//将加班时间写入
    	   		        	   					}
    	   		        	   			}
    	   		        	   			else {
	        	   		        	   			if(hours_diff_afternoonf>=17) {
	        	   		        	   			
	        	   		        	   				list.get(j).setLenght_Of_Workday_overtime((double)Math.round((hours_diff_afternoonf-17)*100)/100);//将加班时间写入
		   		        	   					}
		   		        	   					else {
		   		        	   						list.get(j).setLenght_Of_Workday_overtime(0.0);//将加班时间写入
		   		        	   					}
    	   		        	   			}
    	   		        	   				
        	   							}
        	   							else //5-9月，应出勤9.5小时
        	   							{
        	   								long  diff_moring=list.get(j).getWorkTime().getTime()-list.get(j).getDate().getTime();
        	   		        	   			double  hours_moring_ddff = (diff_moring / (1000.0 * 60 * 60 )) ;
        	   		        	   			
        	   		        	   		long  diff_afternoon=list.get(j).getOffworkTime().getTime()-list.get(j).getDate().getTime();
    	   		        	   			double  hours_diff_afternoonf = (diff_afternoon / (1000.0 * 60 * 60 )) ;
    	   		        	   			if(hours_moring_ddff<=8) {
    	   		        	   					if(hours_diff_afternoonf>=17.5) {
    	   		        	   					
    	   		        	   							list.get(j).setLenght_Of_Workday_overtime((double)Math.round(((8-hours_moring_ddff)+(hours_diff_afternoonf-17.5))*100)/100);//将加班时间写入
    	   		        	   					}
    	   		        	   					else {
    	   		        	   					
    	   		        	   							list.get(j).setLenght_Of_Workday_overtime((double)Math.round((8-hours_moring_ddff)*100)/100);//将加班时间写入
    	   		        	   					}
    	   		        	   			}
    	   		        	   			else {
	        	   		        	   			if(hours_diff_afternoonf>=17.5) {
	        	   		        	   			
	        	   		        	   				list.get(j).setLenght_Of_Workday_overtime((double)Math.round((hours_diff_afternoonf-17.5)*100)/100);//将加班时间写入
		   		        	   					}
		   		        	   					else {
		   		        	   						list.get(j).setLenght_Of_Workday_overtime(0.0);//将加班时间写入
		   		        	   					}
    	   		        	   			}
        	   							}
        	   							
        	   							list.get(j).setLength_Of_Holiday_overtime(0.0);
        	   							list.get(j).setLength_Of_TotalOvertime(list.get(j).getLenght_Of_Workday_overtime());
	        	   					}
	        	   			}
	        	   			
	        	   		}
	        	   		//计算迟到时间
	        	   		if(list.get(j).getWorkTime()!=null) {
	        	   				long  latetime=list.get(j).getWorkTime().getTime()-list.get(j).getDate().getTime();
	        	   				
		        	   			double  hours_latetime = (double)Math.round(((latetime / (1000.0 * 60 * 60 )))*100)/100 ;
		        	   			if(hours_latetime<=8) {
		        	   					list.get(j).setLate_time(0.0);
		        	   					list.get(j).setLate_type("1");
		        	   			}
		        	   			else {
		        	   					list.get(j).setLate_time((double)Math.round((hours_latetime-8.0)*100)/100 );
		        	   					//计算迟到类型
		        	   					if(hours_latetime>8&&hours_latetime<=8.166) {
		        	   							if(list.get(j).getLength_OF_Should_AttendTime()==9.0) {
		        	   								long  diff_after=list.get(j).getOffworkTime().getTime()-list.get(j).getDate().getTime();
		        			        	   			double  diff_after_hour = (double)Math.round(((diff_after / (1000.0 * 60 * 60 )))*100)/100 ;
		        			        	   			if(diff_after_hour>=17.5) {
		        			        	   				list.get(j).setLate_type("2");
		        			        	   			}
		        			        	   			else {
		        			        	   				list.get(j).setLate_type("3");
		        			        	   			}
		        	   							}
		        	   							else {
		        	   								long  diff_after=list.get(j).getOffworkTime().getTime()-list.get(j).getDate().getTime();
		        			        	   			double  diff_after_hour = (double)Math.round(((diff_after / (1000.0 * 60 * 60 )))*100)/100 ;
		        			        	   			if(diff_after_hour>=18) {
		        			        	   				list.get(j).setLate_type("2");
		        			        	   			}
		        			        	   			else {
		        			        	   				list.get(j).setLate_type("3");
		        			        	   			}
		        	   							}
		        	   					}
		        	   					else if(hours_latetime>8.1666&&hours_latetime<=8.5) {
		        	   						if(list.get(j).getLength_OF_Should_AttendTime()==9.0) {
	        	   								long  diff_after=list.get(j).getOffworkTime().getTime()-list.get(j).getDate().getTime();
	        			        	   			double  diff_after_hour = (double)Math.round(((diff_after / (1000.0 * 60 * 60 )))*100)/100 ;
	        			        	   			if(diff_after_hour>=18) {
	        			        	   				list.get(j).setLate_type("4");
	        			        	   			}
	        			        	   			else {
	        			        	   				list.get(j).setLate_type("5");
	        			        	   			}
	        	   							}
	        	   							else {
	        	   								long  diff_after=list.get(j).getOffworkTime().getTime()-list.get(j).getDate().getTime();
	        			        	   			double  diff_after_hour = (double)Math.round(((diff_after / (1000.0 * 60 * 60 )))*100)/100 ;
	        			        	   			if(diff_after_hour>=18.5) {
	        			        	   				list.get(j).setLate_type("4");
	        			        	   			}
	        			        	   			else {
	        			        	   				list.get(j).setLate_type("5");
	        			        	   			}
	        	   							}
		        	   					}
		        	   					else if(hours_latetime>8.5&&hours_latetime<9) {
		        	   							c.setTime(list.get(j).getDate());
		        	   							c.add(Calendar.DAY_OF_MONTH, -1);// 今天-1天
		        	   							Date ddate = c.getTime();
		        	   							if(begin_time.after(ddate)) {
		        	   								int oldlist_label=0;
		        	   									for(oldlist_label=0;oldlist_label<oldlist.size();oldlist_label++) {
		        	   										if(oldlist.get(oldlist_label).getDate().equals(ddate)&&list.get(j).getUser_ID()==oldlist.get(oldlist_label).getUser_ID()) {
		        	   												if(oldlist.get(oldlist_label).getOffworkTime().getHours()>21) {
		        	   													list.get(j).setLate_type("6");
		        	   													break;
		        	   												}
		        	   										}
		        	   									}
		        	   									if(oldlist_label==oldlist.size()) {
		        	   										list.get(j).setLate_type("7");
		        	   									}
		        	   							}
		        	   							else {
		        	   								int list_label=0;
	        	   									for(list_label=0;list_label<list.size();list_label++) {
	        	   										if(list.get(list_label).getDate().equals(ddate)&&list.get(j).getUser_ID()==list.get(list_label).getUser_ID()) {
	        	   												if(list.get(list_label).getOffworkTime().getHours()>21) {
	        	   													list.get(j).setLate_type("6");
	        	   													break;
	        	   												}
	        	   										}
	        	   									}
	        	   									if(list_label==list.size()) {
	        	   										list.get(j).setLate_type("7");
	        	   									}
		        	   							}
		        	   							
		        	   					}
		        	   					else {
		        	   							list.get(j).setLate_type("8");
		        	   					}
		        	   			}
	        	   		}
	        	   		//计算是否早退
	        	   		
	        	   		if(list.get(j).getOffworkTime()!=null) {
	        	   			long  diff_after=list.get(j).getOffworkTime().getTime()-list.get(j).getDate().getTime();
		        	   		double  diff_after_hour = (diff_after / (1000.0 * 60 * 60 )) ;
		        	   		
		        	   		if(list.get(j).getLength_OF_Should_AttendTime()==9.5){
		        	   			
		        	   				if(diff_after_hour>17.5) {
		        	   					list.get(j).setEarly_Retreat("2");
		        	   				}
		        	   				else {
		        	   					list.get(j).setEarly_Retreat("1");
		        	   				}
		        	   		}
		        	   		else {
		        	   			 
		        	   				if(diff_after_hour>17) {
		        	   					list.get(j).setEarly_Retreat("2");
		        	   				}
		        	   				else {
		        	   					list.get(j).setEarly_Retreat("1");
		        	   				}
		        	   		}
	        	   		}
	        	   		
	        	   		//设置是否旷工
	        	   		list.get(j).setAbsenteeism("2");
	        	   		
	        	   		
	        	   		
	        	   		//存入数据库
	        	   		int oldlist_label2=0;
	        	   		
	        	   		for(oldlist_label2=0;oldlist_label2<oldlist.size();oldlist_label2++) {
	        	   				if(oldlist.get(oldlist_label2).getDate().equals(list.get(j).getDate())&&oldlist.get(oldlist_label2).getUser_ID()==list.get(j).getUser_ID()) 
	        	   				{
	        	   						break;
	        	   				}
	        	   		}
	        	   		if(oldlist_label2==oldlist.size())
	        	   				attendanceInformationsService.InsertAttendanceInoformations(list.get(j));
	        	   		
	           }
	           //计算矿工
	           List<User> list_user=attendanceInformationsService.getAllUserForStatisticians();
	           
	           int list_label=0;
	                
	           for(int i=0;i<list_user.size();i++) 
	           {
	        	   	for(c.setTime(begin_time);c.getTime().before(end_time);c.add(Calendar.DAY_OF_MONTH, +1)) 
	        	   	{
			        	   	for(list_label=0;list_label<list.size();list_label++) 
			        	   	{
			        	   		if(list_user.get(i).getUser_id()==list.get(list_label).getUser_ID()&&list.get(list_label).getDate().equals(c.getTime())) {
			        	   				break;
			        	   		}
			        	   	}
			        	   	if(list_label==list.size()) {
			        	   		Summary summary=new Summary();
			        	   		summary.setDate(c.getTime());
			        	   		summary.setUser_ID(list.get(i).getUser_ID());
			        	   		
			        	   		UserDepartment dep=new UserDepartment();
			        	   		dep=attendanceInformationsService.getDepartmentIdByUserId(summary);
			        	   		if(dep!=null) {
			        	   			summary.setAffiliation_id(dep.getDepartment_id());//设置部门ID
				        	   		summary.setAffiliation_name(dep.getDepartment_name());//设置部门名称
			        	   		}
			        	   		
			        	   		summary.setAbsenteeism("1");
			        	   		summary.setYes_Or_No("2");//设置为正常数据
			        	   		int oldlist_label2=0;
			        	   		
			        	   		for(oldlist_label2=0;oldlist_label2<oldlist.size();oldlist_label2++) {
			        	   				if(oldlist.get(oldlist_label2).getDate().equals(summary.getDate())&&oldlist.get(oldlist_label2).getUser_ID()==summary.getUser_ID()) 
			        	   				{
			        	   						break;
			        	   				}
			        	   		}
			        	   		if(oldlist_label2==oldlist.size())
			        	   				attendanceInformationsService.InsertAttendanceInoformations(summary);
			        	   	}
			        	   
	        	   	}
	           }
	          //计算用户表少的用户
	           //用户表list_user   记录表list
	           int user_label=0;
	           for(int i=0;i<list.size();i++) {
	        	   for(user_label=0;user_label<list_user.size();user_label++) {
	        		   	if(list.get(i).getUser_ID().equals(list_user.get(user_label).getUser_id())) {
	        		   			break;
	        		   	}
	        		   	if(user_label==list_user.size()) {
	        		   			User u=new User();
	        		   			u.setUser_id(list.get(i).getUser_ID());
	        		   			u.setUser_name(list.get(i).getUser_Name());
	        		   			u.setUser_type(null);
	        		   			u.setDepartment_id(null);
	        		   			relationService.add(u);
	        		   	}
	        	   }
	           }
	           
	           		return list;
		}
		 
		
		
		return null;

	}
	
	
	
	@RequestMapping("/attendance/informations/find")
	@ResponseBody
	public List<Summary> find(@RequestBody  find_parameter find_p)  
	{
		System.out.println("ok");
		
		
		System.out.println("id:"+find_p.getUser_id());
		System.out.println("mark1:"+find_p.getMark1());
		System.out.println("mark2:"+find_p.getMark2());
		System.out.println("times1:"+find_p.getTimes1());
		System.out.println("times2:"+find_p.getTimes2());
		
		System.out.println("notChckin"+find_p.getNotChckin());
		Date data=new Date();
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
		
		
		if(find_p.getDepartment_id()==""||find_p.getDepartment_id()==null) {
			find_p.setDepartment_id("%");
		}
			
	 
		if(find_p.getUser_id()==""||find_p.getUser_id()==null) {
			find_p.setUser_id("%");
		}
				
		
		List<Summary> list=attendanceInformationsService.getAllSummary(find_p);
		List<UserCustom> list_user=new ArrayList<UserCustom>();
		 
		
		
		for(int i=0;i<list.size();i++) {
			int j=0;
			for(j=0;j<list_user.size();j++) {
				if(list.get(i).getUser_ID().equals(list_user.get(j).getUser_id())) {
					break;
				}
			}
			if(j==list_user.size()) {
				UserCustom u=new UserCustom();
				u.setUser_id(list_user.get(i).getUser_id());
				list_user.add(u);
			}
		}
		
		
		
		List<YearMonth> list_m =new ArrayList<YearMonth>();
		List<UserShouldLate> list_userShouldLate=new ArrayList<UserShouldLate>();//每月三、五次次机会的记录
		 
		
		int month_label=0;
		for(int i=0;i<list.size();i++) {
			YearMonth month=new YearMonth();
			month.setMonth(list.get(i).getDate().getMonth()+1);
			month.setYear(list.get(i).getDate().getYear());
			for(month_label=0;month_label<list_m.size();month_label++) {
				if(list_m.get(month_label).getYear()==month.getYear()&&list_m.get(month_label).getMonth()==month.getMonth()) {
					break;
				}
			}
			if(month_label==list_m.size()) {
				list_m.add(month);
			}
		}
		 
	
		
		
		//System.out.println("size="+list.size());
		if(find_p.getNotChckin()==null)//未打卡
		{
			 	for(int i=0;i<list.size();i++) {
			 		if(list.get(i).getWorkTime()!=null&&list.get(i).getOffworkTime()!=null) {
			 				list.remove(i);
			 				i--;
			 		}
			 	}
		}
		else//on//已经打卡
		{
				for(int i=0;i<list.size();i++) {
			 		if(list.get(i).getWorkTime()==null||list.get(i).getOffworkTime()==null) {
			 				list.remove(i);
			 				i--;
			 		}
			 	}
				if(find_p.getTimes1()!=null) //加班时长作为筛选条件
				{
					if(find_p.getMark1()==0) //0	表示  >
					{
							for(int i=0;i<list.size();i++) 
							{
								if(list.get(i).getLate_time()<find_p.getTimes1()) {
										list.remove(i);
										i--;
								}
							}
					}
					else if(find_p.getMark1()==1)//1	表示  =
					{
							for(int i=0;i<list.size();i++) 
							{
								if(list.get(i).getLate_time()!=(find_p.getTimes1()+0.0)) {
										list.remove(i);
										i--;
								}
							}
					}
					else //2	表示  <
					{
							for(int i=0;i<list.size();i++) 
							{
								if(list.get(i).getLate_time()>=find_p.getTimes1()) {
										list.remove(i);
										i--;
								}
							}
					}
						
				}
				if(find_p.getTimes2()!=null) //迟到次数作为筛选条件
				{
					int p1=0;
					int p2=0;
					 for(int i=0;i<list_m.size();i++) {
						 	List<Summary> list_short=new ArrayList<Summary>();
						 	list_short=attendanceInformationsService.getShortSummary(list_m.get(i));
						 	for(int j=0;j<list_user.size();j++) {
						 		p1=p2=0;
				 			 	UserShouldLate usl=new UserShouldLate();
				 			 	usl.setUser_id(list_user.get(j).getUser_id());
						 		 	for(int k=0;k<list_short.size();k++) {
						 			 	
						 		 		if(list_short.get(k).getUser_ID().equals(list_user.get(j).getUser_id())) {
						 				 			if(list_short.get(k).getLate_type()=="2"||list_short.get(k).getLate_type()=="4") {
						 				 				  if(p1<3) {
						 				 					  p1++;
						 				 				  }
						 				 				  else {	
						 				 					  if(list_short.get(k).getDate().before(usl.getBegin1()))
						 				 						  		usl.setBegin1(list_short.get(k).getDate());	  
						 				 				  }
						 				 			}
						 				 			else	if(list_short.get(k).getLate_type()=="6") {
						 				 				  if(p2<5) {
						 				 					  p1++;
						 				 				  }
						 				 				  else {
						 				 					 if(list_short.get(k).getDate().before(usl.getBegin2()))
						 				 						 		usl.setBegin2(list_short.get(k).getDate());
						 				 				  }
						 				 			}
						 				 			else {
						 				 				
						 				 			}
						 			 }
						 		 }
						 		 	list_userShouldLate.add(usl);
						 	}
					 }
					 
					 //计算用户认定迟到次数
					 for(int i=0;i<list_user.size();i++) {
						  list_user.get(i).setTime(0);
						 	for(int j=0;j<list.size();j++) {
						 		if(list_user.get(i).getUser_id().equals(list.get(j).getUser_ID())) {
						 				
						 				for(int k=0;k<list_userShouldLate.size();k++) {
						 					if(list_userShouldLate.get(k).getBegin1().getYear()==list.get(j).getDate().getYear()&&list_userShouldLate.get(k).getBegin1().getMonth()==list.get(j).getDate().getMonth()&&list_userShouldLate.get(k).getUser_id().equals(list_user.get(i).getUser_id())) {
						 						  if(list.get(j).getLate_type()=="2"||list.get(j).getLate_type()=="4") {
						 							  	if(list.get(j).getDate().after(list_userShouldLate.get(k).getBegin1())) {
						 							  		list_user.get(i).setTime(list_user.get(i).getTime()+1);
						 							  	}
						 						  }
						 						  else if(list.get(j).getLate_type()=="6") {
							 							 if(list.get(j).getDate().after(list_userShouldLate.get(k).getBegin2())) {
							 							  		list_user.get(i).setTime(list_user.get(i).getTime()+1);
							 							  	}
						 						  }
						 						  else if(list.get(j).getLate_type()=="1"){
						 							  
						 						  }
						 						  else {
						 							  list_user.get(i).setTime(list_user.get(i).getTime()+1);
						 						  }
						 					}
						 				}
						 			
						 		}
						 	}
					 }
					 
					
					if(find_p.getMark2()==0) //0	表示  >
					{
								for(int i=0;i<list_user.size();i++) {
								 	if(list_user.get(i).getTime()>find_p.getMark2()) {
								 		continue;
								 	}
								 	else {
								 		list_user.remove(i);
								 		i--;
								 	}
							 }
					}
					else if(find_p.getMark2()==1)//1	表示  =
					{
								for(int i=0;i<list_user.size();i++) {
								 	if(list_user.get(i).getTime()==find_p.getMark2()) {
								 		continue;
								 	}
								 	else {
								 		list_user.remove(i);
								 		i--;
								 	}
							 } 
					}
					else //2	表示  <
					{
							for(int i=0;i<list_user.size();i++) {
							 	if(list_user.get(i).getTime()<find_p.getMark2()) {
							 		continue;
							 	}
							 	else {
							 		list_user.remove(i);
							 		i--;
							 	}
						 }
					}
					
				}
				
		}	
		return list;
		
	}
	
}
