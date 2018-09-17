package com.AttendanceSystem.pojo.po;

import java.util.Date;

public class ModifyLog {
    private Date modification_date;

    private String content;

    public Date getModificationDate() {
        return modification_date;
    }

    public void setModificationDate(Date modificationDate) {
        this.modification_date = modificationDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}