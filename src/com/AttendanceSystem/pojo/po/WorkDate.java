package com.AttendanceSystem.pojo.po;

import java.util.Date;

public class WorkDate {
    private Date date;

    private Integer date_type;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getDateType() {
        return date_type;
    }

    public void setDateType(Integer dateType) {
        this.date_type = dateType;
    }
}