package com.AttendanceSystem.dao;

import com.AttendanceSystem.pojo.po.Summary;
import com.AttendanceSystem.pojo.po.SummaryExample;
import com.AttendanceSystem.pojo.vo.YearMonth;
import com.AttendanceSystem.pojo.vo.find_parameter;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SummaryMapper {
	
	List<Summary> getAllOldSummary();
	
	void InsertAttendanceInoformations(Summary summary);
	
	 List<Summary> getAllSummary(find_parameter find_p);
	
	 void updata(Summary summary);
	 
	 void updata2(Summary summary);
	
	 List<Summary> getShortSummary(YearMonth ym);
	
	
	
	
    int countByExample(SummaryExample example);

    int deleteByExample(SummaryExample example);

    int insert(Summary record);

    int insertSelective(Summary record);

    List<Summary> selectByExample(SummaryExample example);

    int updateByExampleSelective(@Param("record") Summary record, @Param("example") SummaryExample example);

    int updateByExample(@Param("record") Summary record, @Param("example") SummaryExample example);
}