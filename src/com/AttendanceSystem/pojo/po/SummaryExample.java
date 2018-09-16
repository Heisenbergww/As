package com.AttendanceSystem.pojo.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SummaryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SummaryExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andUserNameIsNull() {
            addCriterion("User_Name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("User_Name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("User_Name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("User_Name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("User_Name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("User_Name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("User_Name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("User_Name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("User_Name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("User_Name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("User_Name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("User_Name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("User_Name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("User_Name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("User_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("User_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("User_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("User_ID <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("User_ID >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("User_ID >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("User_ID <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("User_ID <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("User_ID like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("User_ID not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("User_ID in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("User_ID not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("User_ID between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("User_ID not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andAffiliationNameIsNull() {
            addCriterion("Affiliation_name is null");
            return (Criteria) this;
        }

        public Criteria andAffiliationNameIsNotNull() {
            addCriterion("Affiliation_name is not null");
            return (Criteria) this;
        }

        public Criteria andAffiliationNameEqualTo(String value) {
            addCriterion("Affiliation_name =", value, "affiliationName");
            return (Criteria) this;
        }

        public Criteria andAffiliationNameNotEqualTo(String value) {
            addCriterion("Affiliation_name <>", value, "affiliationName");
            return (Criteria) this;
        }

        public Criteria andAffiliationNameGreaterThan(String value) {
            addCriterion("Affiliation_name >", value, "affiliationName");
            return (Criteria) this;
        }

        public Criteria andAffiliationNameGreaterThanOrEqualTo(String value) {
            addCriterion("Affiliation_name >=", value, "affiliationName");
            return (Criteria) this;
        }

        public Criteria andAffiliationNameLessThan(String value) {
            addCriterion("Affiliation_name <", value, "affiliationName");
            return (Criteria) this;
        }

        public Criteria andAffiliationNameLessThanOrEqualTo(String value) {
            addCriterion("Affiliation_name <=", value, "affiliationName");
            return (Criteria) this;
        }

        public Criteria andAffiliationNameLike(String value) {
            addCriterion("Affiliation_name like", value, "affiliationName");
            return (Criteria) this;
        }

        public Criteria andAffiliationNameNotLike(String value) {
            addCriterion("Affiliation_name not like", value, "affiliationName");
            return (Criteria) this;
        }

        public Criteria andAffiliationNameIn(List<String> values) {
            addCriterion("Affiliation_name in", values, "affiliationName");
            return (Criteria) this;
        }

        public Criteria andAffiliationNameNotIn(List<String> values) {
            addCriterion("Affiliation_name not in", values, "affiliationName");
            return (Criteria) this;
        }

        public Criteria andAffiliationNameBetween(String value1, String value2) {
            addCriterion("Affiliation_name between", value1, value2, "affiliationName");
            return (Criteria) this;
        }

        public Criteria andAffiliationNameNotBetween(String value1, String value2) {
            addCriterion("Affiliation_name not between", value1, value2, "affiliationName");
            return (Criteria) this;
        }

        public Criteria andAffiliationIdIsNull() {
            addCriterion("Affiliation_id is null");
            return (Criteria) this;
        }

        public Criteria andAffiliationIdIsNotNull() {
            addCriterion("Affiliation_id is not null");
            return (Criteria) this;
        }

        public Criteria andAffiliationIdEqualTo(String value) {
            addCriterion("Affiliation_id =", value, "affiliationId");
            return (Criteria) this;
        }

        public Criteria andAffiliationIdNotEqualTo(String value) {
            addCriterion("Affiliation_id <>", value, "affiliationId");
            return (Criteria) this;
        }

        public Criteria andAffiliationIdGreaterThan(String value) {
            addCriterion("Affiliation_id >", value, "affiliationId");
            return (Criteria) this;
        }

        public Criteria andAffiliationIdGreaterThanOrEqualTo(String value) {
            addCriterion("Affiliation_id >=", value, "affiliationId");
            return (Criteria) this;
        }

        public Criteria andAffiliationIdLessThan(String value) {
            addCriterion("Affiliation_id <", value, "affiliationId");
            return (Criteria) this;
        }

        public Criteria andAffiliationIdLessThanOrEqualTo(String value) {
            addCriterion("Affiliation_id <=", value, "affiliationId");
            return (Criteria) this;
        }

        public Criteria andAffiliationIdLike(String value) {
            addCriterion("Affiliation_id like", value, "affiliationId");
            return (Criteria) this;
        }

        public Criteria andAffiliationIdNotLike(String value) {
            addCriterion("Affiliation_id not like", value, "affiliationId");
            return (Criteria) this;
        }

        public Criteria andAffiliationIdIn(List<String> values) {
            addCriterion("Affiliation_id in", values, "affiliationId");
            return (Criteria) this;
        }

        public Criteria andAffiliationIdNotIn(List<String> values) {
            addCriterion("Affiliation_id not in", values, "affiliationId");
            return (Criteria) this;
        }

        public Criteria andAffiliationIdBetween(String value1, String value2) {
            addCriterion("Affiliation_id between", value1, value2, "affiliationId");
            return (Criteria) this;
        }

        public Criteria andAffiliationIdNotBetween(String value1, String value2) {
            addCriterion("Affiliation_id not between", value1, value2, "affiliationId");
            return (Criteria) this;
        }

        public Criteria andWorktimeIsNull() {
            addCriterion("WorkTime is null");
            return (Criteria) this;
        }

        public Criteria andWorktimeIsNotNull() {
            addCriterion("WorkTime is not null");
            return (Criteria) this;
        }

        public Criteria andWorktimeEqualTo(Date value) {
            addCriterion("WorkTime =", value, "worktime");
            return (Criteria) this;
        }

        public Criteria andWorktimeNotEqualTo(Date value) {
            addCriterion("WorkTime <>", value, "worktime");
            return (Criteria) this;
        }

        public Criteria andWorktimeGreaterThan(Date value) {
            addCriterion("WorkTime >", value, "worktime");
            return (Criteria) this;
        }

        public Criteria andWorktimeGreaterThanOrEqualTo(Date value) {
            addCriterion("WorkTime >=", value, "worktime");
            return (Criteria) this;
        }

        public Criteria andWorktimeLessThan(Date value) {
            addCriterion("WorkTime <", value, "worktime");
            return (Criteria) this;
        }

        public Criteria andWorktimeLessThanOrEqualTo(Date value) {
            addCriterion("WorkTime <=", value, "worktime");
            return (Criteria) this;
        }

        public Criteria andWorktimeIn(List<Date> values) {
            addCriterion("WorkTime in", values, "worktime");
            return (Criteria) this;
        }

        public Criteria andWorktimeNotIn(List<Date> values) {
            addCriterion("WorkTime not in", values, "worktime");
            return (Criteria) this;
        }

        public Criteria andWorktimeBetween(Date value1, Date value2) {
            addCriterion("WorkTime between", value1, value2, "worktime");
            return (Criteria) this;
        }

        public Criteria andWorktimeNotBetween(Date value1, Date value2) {
            addCriterion("WorkTime not between", value1, value2, "worktime");
            return (Criteria) this;
        }

        public Criteria andOffworktimeIsNull() {
            addCriterion("OffworkTime is null");
            return (Criteria) this;
        }

        public Criteria andOffworktimeIsNotNull() {
            addCriterion("OffworkTime is not null");
            return (Criteria) this;
        }

        public Criteria andOffworktimeEqualTo(Date value) {
            addCriterion("OffworkTime =", value, "offworktime");
            return (Criteria) this;
        }

        public Criteria andOffworktimeNotEqualTo(Date value) {
            addCriterion("OffworkTime <>", value, "offworktime");
            return (Criteria) this;
        }

        public Criteria andOffworktimeGreaterThan(Date value) {
            addCriterion("OffworkTime >", value, "offworktime");
            return (Criteria) this;
        }

        public Criteria andOffworktimeGreaterThanOrEqualTo(Date value) {
            addCriterion("OffworkTime >=", value, "offworktime");
            return (Criteria) this;
        }

        public Criteria andOffworktimeLessThan(Date value) {
            addCriterion("OffworkTime <", value, "offworktime");
            return (Criteria) this;
        }

        public Criteria andOffworktimeLessThanOrEqualTo(Date value) {
            addCriterion("OffworkTime <=", value, "offworktime");
            return (Criteria) this;
        }

        public Criteria andOffworktimeIn(List<Date> values) {
            addCriterion("OffworkTime in", values, "offworktime");
            return (Criteria) this;
        }

        public Criteria andOffworktimeNotIn(List<Date> values) {
            addCriterion("OffworkTime not in", values, "offworktime");
            return (Criteria) this;
        }

        public Criteria andOffworktimeBetween(Date value1, Date value2) {
            addCriterion("OffworkTime between", value1, value2, "offworktime");
            return (Criteria) this;
        }

        public Criteria andOffworktimeNotBetween(Date value1, Date value2) {
            addCriterion("OffworkTime not between", value1, value2, "offworktime");
            return (Criteria) this;
        }

        public Criteria andLengthOfShouldAttendtimeIsNull() {
            addCriterion("Length_OF_Should_AttendTime is null");
            return (Criteria) this;
        }

        public Criteria andLengthOfShouldAttendtimeIsNotNull() {
            addCriterion("Length_OF_Should_AttendTime is not null");
            return (Criteria) this;
        }

        public Criteria andLengthOfShouldAttendtimeEqualTo(Double value) {
            addCriterion("Length_OF_Should_AttendTime =", value, "lengthOfShouldAttendtime");
            return (Criteria) this;
        }

        public Criteria andLengthOfShouldAttendtimeNotEqualTo(Double value) {
            addCriterion("Length_OF_Should_AttendTime <>", value, "lengthOfShouldAttendtime");
            return (Criteria) this;
        }

        public Criteria andLengthOfShouldAttendtimeGreaterThan(Double value) {
            addCriterion("Length_OF_Should_AttendTime >", value, "lengthOfShouldAttendtime");
            return (Criteria) this;
        }

        public Criteria andLengthOfShouldAttendtimeGreaterThanOrEqualTo(Double value) {
            addCriterion("Length_OF_Should_AttendTime >=", value, "lengthOfShouldAttendtime");
            return (Criteria) this;
        }

        public Criteria andLengthOfShouldAttendtimeLessThan(Double value) {
            addCriterion("Length_OF_Should_AttendTime <", value, "lengthOfShouldAttendtime");
            return (Criteria) this;
        }

        public Criteria andLengthOfShouldAttendtimeLessThanOrEqualTo(Double value) {
            addCriterion("Length_OF_Should_AttendTime <=", value, "lengthOfShouldAttendtime");
            return (Criteria) this;
        }

        public Criteria andLengthOfShouldAttendtimeIn(List<Double> values) {
            addCriterion("Length_OF_Should_AttendTime in", values, "lengthOfShouldAttendtime");
            return (Criteria) this;
        }

        public Criteria andLengthOfShouldAttendtimeNotIn(List<Double> values) {
            addCriterion("Length_OF_Should_AttendTime not in", values, "lengthOfShouldAttendtime");
            return (Criteria) this;
        }

        public Criteria andLengthOfShouldAttendtimeBetween(Double value1, Double value2) {
            addCriterion("Length_OF_Should_AttendTime between", value1, value2, "lengthOfShouldAttendtime");
            return (Criteria) this;
        }

        public Criteria andLengthOfShouldAttendtimeNotBetween(Double value1, Double value2) {
            addCriterion("Length_OF_Should_AttendTime not between", value1, value2, "lengthOfShouldAttendtime");
            return (Criteria) this;
        }

        public Criteria andLengthOfTotaltimeIsNull() {
            addCriterion("Length_Of_TotalTime is null");
            return (Criteria) this;
        }

        public Criteria andLengthOfTotaltimeIsNotNull() {
            addCriterion("Length_Of_TotalTime is not null");
            return (Criteria) this;
        }

        public Criteria andLengthOfTotaltimeEqualTo(Double value) {
            addCriterion("Length_Of_TotalTime =", value, "lengthOfTotaltime");
            return (Criteria) this;
        }

        public Criteria andLengthOfTotaltimeNotEqualTo(Double value) {
            addCriterion("Length_Of_TotalTime <>", value, "lengthOfTotaltime");
            return (Criteria) this;
        }

        public Criteria andLengthOfTotaltimeGreaterThan(Double value) {
            addCriterion("Length_Of_TotalTime >", value, "lengthOfTotaltime");
            return (Criteria) this;
        }

        public Criteria andLengthOfTotaltimeGreaterThanOrEqualTo(Double value) {
            addCriterion("Length_Of_TotalTime >=", value, "lengthOfTotaltime");
            return (Criteria) this;
        }

        public Criteria andLengthOfTotaltimeLessThan(Double value) {
            addCriterion("Length_Of_TotalTime <", value, "lengthOfTotaltime");
            return (Criteria) this;
        }

        public Criteria andLengthOfTotaltimeLessThanOrEqualTo(Double value) {
            addCriterion("Length_Of_TotalTime <=", value, "lengthOfTotaltime");
            return (Criteria) this;
        }

        public Criteria andLengthOfTotaltimeIn(List<Double> values) {
            addCriterion("Length_Of_TotalTime in", values, "lengthOfTotaltime");
            return (Criteria) this;
        }

        public Criteria andLengthOfTotaltimeNotIn(List<Double> values) {
            addCriterion("Length_Of_TotalTime not in", values, "lengthOfTotaltime");
            return (Criteria) this;
        }

        public Criteria andLengthOfTotaltimeBetween(Double value1, Double value2) {
            addCriterion("Length_Of_TotalTime between", value1, value2, "lengthOfTotaltime");
            return (Criteria) this;
        }

        public Criteria andLengthOfTotaltimeNotBetween(Double value1, Double value2) {
            addCriterion("Length_Of_TotalTime not between", value1, value2, "lengthOfTotaltime");
            return (Criteria) this;
        }

        public Criteria andLengthOfTotalovertimeIsNull() {
            addCriterion("Length_Of_TotalOvertime is null");
            return (Criteria) this;
        }

        public Criteria andLengthOfTotalovertimeIsNotNull() {
            addCriterion("Length_Of_TotalOvertime is not null");
            return (Criteria) this;
        }

        public Criteria andLengthOfTotalovertimeEqualTo(Double value) {
            addCriterion("Length_Of_TotalOvertime =", value, "lengthOfTotalovertime");
            return (Criteria) this;
        }

        public Criteria andLengthOfTotalovertimeNotEqualTo(Double value) {
            addCriterion("Length_Of_TotalOvertime <>", value, "lengthOfTotalovertime");
            return (Criteria) this;
        }

        public Criteria andLengthOfTotalovertimeGreaterThan(Double value) {
            addCriterion("Length_Of_TotalOvertime >", value, "lengthOfTotalovertime");
            return (Criteria) this;
        }

        public Criteria andLengthOfTotalovertimeGreaterThanOrEqualTo(Double value) {
            addCriterion("Length_Of_TotalOvertime >=", value, "lengthOfTotalovertime");
            return (Criteria) this;
        }

        public Criteria andLengthOfTotalovertimeLessThan(Double value) {
            addCriterion("Length_Of_TotalOvertime <", value, "lengthOfTotalovertime");
            return (Criteria) this;
        }

        public Criteria andLengthOfTotalovertimeLessThanOrEqualTo(Double value) {
            addCriterion("Length_Of_TotalOvertime <=", value, "lengthOfTotalovertime");
            return (Criteria) this;
        }

        public Criteria andLengthOfTotalovertimeIn(List<Double> values) {
            addCriterion("Length_Of_TotalOvertime in", values, "lengthOfTotalovertime");
            return (Criteria) this;
        }

        public Criteria andLengthOfTotalovertimeNotIn(List<Double> values) {
            addCriterion("Length_Of_TotalOvertime not in", values, "lengthOfTotalovertime");
            return (Criteria) this;
        }

        public Criteria andLengthOfTotalovertimeBetween(Double value1, Double value2) {
            addCriterion("Length_Of_TotalOvertime between", value1, value2, "lengthOfTotalovertime");
            return (Criteria) this;
        }

        public Criteria andLengthOfTotalovertimeNotBetween(Double value1, Double value2) {
            addCriterion("Length_Of_TotalOvertime not between", value1, value2, "lengthOfTotalovertime");
            return (Criteria) this;
        }

        public Criteria andLenghtOfWorkdayOvertimeIsNull() {
            addCriterion("Lenght_Of_Workday_overtime is null");
            return (Criteria) this;
        }

        public Criteria andLenghtOfWorkdayOvertimeIsNotNull() {
            addCriterion("Lenght_Of_Workday_overtime is not null");
            return (Criteria) this;
        }

        public Criteria andLenghtOfWorkdayOvertimeEqualTo(Double value) {
            addCriterion("Lenght_Of_Workday_overtime =", value, "lenghtOfWorkdayOvertime");
            return (Criteria) this;
        }

        public Criteria andLenghtOfWorkdayOvertimeNotEqualTo(Double value) {
            addCriterion("Lenght_Of_Workday_overtime <>", value, "lenghtOfWorkdayOvertime");
            return (Criteria) this;
        }

        public Criteria andLenghtOfWorkdayOvertimeGreaterThan(Double value) {
            addCriterion("Lenght_Of_Workday_overtime >", value, "lenghtOfWorkdayOvertime");
            return (Criteria) this;
        }

        public Criteria andLenghtOfWorkdayOvertimeGreaterThanOrEqualTo(Double value) {
            addCriterion("Lenght_Of_Workday_overtime >=", value, "lenghtOfWorkdayOvertime");
            return (Criteria) this;
        }

        public Criteria andLenghtOfWorkdayOvertimeLessThan(Double value) {
            addCriterion("Lenght_Of_Workday_overtime <", value, "lenghtOfWorkdayOvertime");
            return (Criteria) this;
        }

        public Criteria andLenghtOfWorkdayOvertimeLessThanOrEqualTo(Double value) {
            addCriterion("Lenght_Of_Workday_overtime <=", value, "lenghtOfWorkdayOvertime");
            return (Criteria) this;
        }

        public Criteria andLenghtOfWorkdayOvertimeIn(List<Double> values) {
            addCriterion("Lenght_Of_Workday_overtime in", values, "lenghtOfWorkdayOvertime");
            return (Criteria) this;
        }

        public Criteria andLenghtOfWorkdayOvertimeNotIn(List<Double> values) {
            addCriterion("Lenght_Of_Workday_overtime not in", values, "lenghtOfWorkdayOvertime");
            return (Criteria) this;
        }

        public Criteria andLenghtOfWorkdayOvertimeBetween(Double value1, Double value2) {
            addCriterion("Lenght_Of_Workday_overtime between", value1, value2, "lenghtOfWorkdayOvertime");
            return (Criteria) this;
        }

        public Criteria andLenghtOfWorkdayOvertimeNotBetween(Double value1, Double value2) {
            addCriterion("Lenght_Of_Workday_overtime not between", value1, value2, "lenghtOfWorkdayOvertime");
            return (Criteria) this;
        }

        public Criteria andLengthOfHolidayOvertimeIsNull() {
            addCriterion("Length_Of_Holiday_overtime is null");
            return (Criteria) this;
        }

        public Criteria andLengthOfHolidayOvertimeIsNotNull() {
            addCriterion("Length_Of_Holiday_overtime is not null");
            return (Criteria) this;
        }

        public Criteria andLengthOfHolidayOvertimeEqualTo(Double value) {
            addCriterion("Length_Of_Holiday_overtime =", value, "lengthOfHolidayOvertime");
            return (Criteria) this;
        }

        public Criteria andLengthOfHolidayOvertimeNotEqualTo(Double value) {
            addCriterion("Length_Of_Holiday_overtime <>", value, "lengthOfHolidayOvertime");
            return (Criteria) this;
        }

        public Criteria andLengthOfHolidayOvertimeGreaterThan(Double value) {
            addCriterion("Length_Of_Holiday_overtime >", value, "lengthOfHolidayOvertime");
            return (Criteria) this;
        }

        public Criteria andLengthOfHolidayOvertimeGreaterThanOrEqualTo(Double value) {
            addCriterion("Length_Of_Holiday_overtime >=", value, "lengthOfHolidayOvertime");
            return (Criteria) this;
        }

        public Criteria andLengthOfHolidayOvertimeLessThan(Double value) {
            addCriterion("Length_Of_Holiday_overtime <", value, "lengthOfHolidayOvertime");
            return (Criteria) this;
        }

        public Criteria andLengthOfHolidayOvertimeLessThanOrEqualTo(Double value) {
            addCriterion("Length_Of_Holiday_overtime <=", value, "lengthOfHolidayOvertime");
            return (Criteria) this;
        }

        public Criteria andLengthOfHolidayOvertimeIn(List<Double> values) {
            addCriterion("Length_Of_Holiday_overtime in", values, "lengthOfHolidayOvertime");
            return (Criteria) this;
        }

        public Criteria andLengthOfHolidayOvertimeNotIn(List<Double> values) {
            addCriterion("Length_Of_Holiday_overtime not in", values, "lengthOfHolidayOvertime");
            return (Criteria) this;
        }

        public Criteria andLengthOfHolidayOvertimeBetween(Double value1, Double value2) {
            addCriterion("Length_Of_Holiday_overtime between", value1, value2, "lengthOfHolidayOvertime");
            return (Criteria) this;
        }

        public Criteria andLengthOfHolidayOvertimeNotBetween(Double value1, Double value2) {
            addCriterion("Length_Of_Holiday_overtime not between", value1, value2, "lengthOfHolidayOvertime");
            return (Criteria) this;
        }

        public Criteria andDateIsNull() {
            addCriterion("Date is null");
            return (Criteria) this;
        }

        public Criteria andDateIsNotNull() {
            addCriterion("Date is not null");
            return (Criteria) this;
        }

        public Criteria andDateEqualTo(Date value) {
            addCriterionForJDBCDate("Date =", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("Date <>", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThan(Date value) {
            addCriterionForJDBCDate("Date >", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("Date >=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThan(Date value) {
            addCriterionForJDBCDate("Date <", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("Date <=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateIn(List<Date> values) {
            addCriterionForJDBCDate("Date in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("Date not in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("Date between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("Date not between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andVacationTypeIsNull() {
            addCriterion("Vacation_Type is null");
            return (Criteria) this;
        }

        public Criteria andVacationTypeIsNotNull() {
            addCriterion("Vacation_Type is not null");
            return (Criteria) this;
        }

        public Criteria andVacationTypeEqualTo(String value) {
            addCriterion("Vacation_Type =", value, "vacationType");
            return (Criteria) this;
        }

        public Criteria andVacationTypeNotEqualTo(String value) {
            addCriterion("Vacation_Type <>", value, "vacationType");
            return (Criteria) this;
        }

        public Criteria andVacationTypeGreaterThan(String value) {
            addCriterion("Vacation_Type >", value, "vacationType");
            return (Criteria) this;
        }

        public Criteria andVacationTypeGreaterThanOrEqualTo(String value) {
            addCriterion("Vacation_Type >=", value, "vacationType");
            return (Criteria) this;
        }

        public Criteria andVacationTypeLessThan(String value) {
            addCriterion("Vacation_Type <", value, "vacationType");
            return (Criteria) this;
        }

        public Criteria andVacationTypeLessThanOrEqualTo(String value) {
            addCriterion("Vacation_Type <=", value, "vacationType");
            return (Criteria) this;
        }

        public Criteria andVacationTypeLike(String value) {
            addCriterion("Vacation_Type like", value, "vacationType");
            return (Criteria) this;
        }

        public Criteria andVacationTypeNotLike(String value) {
            addCriterion("Vacation_Type not like", value, "vacationType");
            return (Criteria) this;
        }

        public Criteria andVacationTypeIn(List<String> values) {
            addCriterion("Vacation_Type in", values, "vacationType");
            return (Criteria) this;
        }

        public Criteria andVacationTypeNotIn(List<String> values) {
            addCriterion("Vacation_Type not in", values, "vacationType");
            return (Criteria) this;
        }

        public Criteria andVacationTypeBetween(String value1, String value2) {
            addCriterion("Vacation_Type between", value1, value2, "vacationType");
            return (Criteria) this;
        }

        public Criteria andVacationTypeNotBetween(String value1, String value2) {
            addCriterion("Vacation_Type not between", value1, value2, "vacationType");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("Remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("Remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("Remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("Remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("Remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("Remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("Remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("Remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("Remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("Remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("Remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("Remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("Remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("Remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andLateTimeIsNull() {
            addCriterion("Late_time is null");
            return (Criteria) this;
        }

        public Criteria andLateTimeIsNotNull() {
            addCriterion("Late_time is not null");
            return (Criteria) this;
        }

        public Criteria andLateTimeEqualTo(Double value) {
            addCriterion("Late_time =", value, "lateTime");
            return (Criteria) this;
        }

        public Criteria andLateTimeNotEqualTo(Double value) {
            addCriterion("Late_time <>", value, "lateTime");
            return (Criteria) this;
        }

        public Criteria andLateTimeGreaterThan(Double value) {
            addCriterion("Late_time >", value, "lateTime");
            return (Criteria) this;
        }

        public Criteria andLateTimeGreaterThanOrEqualTo(Double value) {
            addCriterion("Late_time >=", value, "lateTime");
            return (Criteria) this;
        }

        public Criteria andLateTimeLessThan(Double value) {
            addCriterion("Late_time <", value, "lateTime");
            return (Criteria) this;
        }

        public Criteria andLateTimeLessThanOrEqualTo(Double value) {
            addCriterion("Late_time <=", value, "lateTime");
            return (Criteria) this;
        }

        public Criteria andLateTimeIn(List<Double> values) {
            addCriterion("Late_time in", values, "lateTime");
            return (Criteria) this;
        }

        public Criteria andLateTimeNotIn(List<Double> values) {
            addCriterion("Late_time not in", values, "lateTime");
            return (Criteria) this;
        }

        public Criteria andLateTimeBetween(Double value1, Double value2) {
            addCriterion("Late_time between", value1, value2, "lateTime");
            return (Criteria) this;
        }

        public Criteria andLateTimeNotBetween(Double value1, Double value2) {
            addCriterion("Late_time not between", value1, value2, "lateTime");
            return (Criteria) this;
        }

        public Criteria andLateTypeIsNull() {
            addCriterion("Late_type is null");
            return (Criteria) this;
        }

        public Criteria andLateTypeIsNotNull() {
            addCriterion("Late_type is not null");
            return (Criteria) this;
        }

        public Criteria andLateTypeEqualTo(String value) {
            addCriterion("Late_type =", value, "lateType");
            return (Criteria) this;
        }

        public Criteria andLateTypeNotEqualTo(String value) {
            addCriterion("Late_type <>", value, "lateType");
            return (Criteria) this;
        }

        public Criteria andLateTypeGreaterThan(String value) {
            addCriterion("Late_type >", value, "lateType");
            return (Criteria) this;
        }

        public Criteria andLateTypeGreaterThanOrEqualTo(String value) {
            addCriterion("Late_type >=", value, "lateType");
            return (Criteria) this;
        }

        public Criteria andLateTypeLessThan(String value) {
            addCriterion("Late_type <", value, "lateType");
            return (Criteria) this;
        }

        public Criteria andLateTypeLessThanOrEqualTo(String value) {
            addCriterion("Late_type <=", value, "lateType");
            return (Criteria) this;
        }

        public Criteria andLateTypeLike(String value) {
            addCriterion("Late_type like", value, "lateType");
            return (Criteria) this;
        }

        public Criteria andLateTypeNotLike(String value) {
            addCriterion("Late_type not like", value, "lateType");
            return (Criteria) this;
        }

        public Criteria andLateTypeIn(List<String> values) {
            addCriterion("Late_type in", values, "lateType");
            return (Criteria) this;
        }

        public Criteria andLateTypeNotIn(List<String> values) {
            addCriterion("Late_type not in", values, "lateType");
            return (Criteria) this;
        }

        public Criteria andLateTypeBetween(String value1, String value2) {
            addCriterion("Late_type between", value1, value2, "lateType");
            return (Criteria) this;
        }

        public Criteria andLateTypeNotBetween(String value1, String value2) {
            addCriterion("Late_type not between", value1, value2, "lateType");
            return (Criteria) this;
        }

        public Criteria andEarlyRetreatIsNull() {
            addCriterion("Early_retreat is null");
            return (Criteria) this;
        }

        public Criteria andEarlyRetreatIsNotNull() {
            addCriterion("Early_retreat is not null");
            return (Criteria) this;
        }

        public Criteria andEarlyRetreatEqualTo(String value) {
            addCriterion("Early_retreat =", value, "earlyRetreat");
            return (Criteria) this;
        }

        public Criteria andEarlyRetreatNotEqualTo(String value) {
            addCriterion("Early_retreat <>", value, "earlyRetreat");
            return (Criteria) this;
        }

        public Criteria andEarlyRetreatGreaterThan(String value) {
            addCriterion("Early_retreat >", value, "earlyRetreat");
            return (Criteria) this;
        }

        public Criteria andEarlyRetreatGreaterThanOrEqualTo(String value) {
            addCriterion("Early_retreat >=", value, "earlyRetreat");
            return (Criteria) this;
        }

        public Criteria andEarlyRetreatLessThan(String value) {
            addCriterion("Early_retreat <", value, "earlyRetreat");
            return (Criteria) this;
        }

        public Criteria andEarlyRetreatLessThanOrEqualTo(String value) {
            addCriterion("Early_retreat <=", value, "earlyRetreat");
            return (Criteria) this;
        }

        public Criteria andEarlyRetreatLike(String value) {
            addCriterion("Early_retreat like", value, "earlyRetreat");
            return (Criteria) this;
        }

        public Criteria andEarlyRetreatNotLike(String value) {
            addCriterion("Early_retreat not like", value, "earlyRetreat");
            return (Criteria) this;
        }

        public Criteria andEarlyRetreatIn(List<String> values) {
            addCriterion("Early_retreat in", values, "earlyRetreat");
            return (Criteria) this;
        }

        public Criteria andEarlyRetreatNotIn(List<String> values) {
            addCriterion("Early_retreat not in", values, "earlyRetreat");
            return (Criteria) this;
        }

        public Criteria andEarlyRetreatBetween(String value1, String value2) {
            addCriterion("Early_retreat between", value1, value2, "earlyRetreat");
            return (Criteria) this;
        }

        public Criteria andEarlyRetreatNotBetween(String value1, String value2) {
            addCriterion("Early_retreat not between", value1, value2, "earlyRetreat");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismIsNull() {
            addCriterion("Absenteeism is null");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismIsNotNull() {
            addCriterion("Absenteeism is not null");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismEqualTo(String value) {
            addCriterion("Absenteeism =", value, "absenteeism");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismNotEqualTo(String value) {
            addCriterion("Absenteeism <>", value, "absenteeism");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismGreaterThan(String value) {
            addCriterion("Absenteeism >", value, "absenteeism");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismGreaterThanOrEqualTo(String value) {
            addCriterion("Absenteeism >=", value, "absenteeism");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismLessThan(String value) {
            addCriterion("Absenteeism <", value, "absenteeism");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismLessThanOrEqualTo(String value) {
            addCriterion("Absenteeism <=", value, "absenteeism");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismLike(String value) {
            addCriterion("Absenteeism like", value, "absenteeism");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismNotLike(String value) {
            addCriterion("Absenteeism not like", value, "absenteeism");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismIn(List<String> values) {
            addCriterion("Absenteeism in", values, "absenteeism");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismNotIn(List<String> values) {
            addCriterion("Absenteeism not in", values, "absenteeism");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismBetween(String value1, String value2) {
            addCriterion("Absenteeism between", value1, value2, "absenteeism");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismNotBetween(String value1, String value2) {
            addCriterion("Absenteeism not between", value1, value2, "absenteeism");
            return (Criteria) this;
        }

        public Criteria andNoPunchCardAtWorkIsNull() {
            addCriterion("No_punch_card_at_work is null");
            return (Criteria) this;
        }

        public Criteria andNoPunchCardAtWorkIsNotNull() {
            addCriterion("No_punch_card_at_work is not null");
            return (Criteria) this;
        }

        public Criteria andNoPunchCardAtWorkEqualTo(String value) {
            addCriterion("No_punch_card_at_work =", value, "noPunchCardAtWork");
            return (Criteria) this;
        }

        public Criteria andNoPunchCardAtWorkNotEqualTo(String value) {
            addCriterion("No_punch_card_at_work <>", value, "noPunchCardAtWork");
            return (Criteria) this;
        }

        public Criteria andNoPunchCardAtWorkGreaterThan(String value) {
            addCriterion("No_punch_card_at_work >", value, "noPunchCardAtWork");
            return (Criteria) this;
        }

        public Criteria andNoPunchCardAtWorkGreaterThanOrEqualTo(String value) {
            addCriterion("No_punch_card_at_work >=", value, "noPunchCardAtWork");
            return (Criteria) this;
        }

        public Criteria andNoPunchCardAtWorkLessThan(String value) {
            addCriterion("No_punch_card_at_work <", value, "noPunchCardAtWork");
            return (Criteria) this;
        }

        public Criteria andNoPunchCardAtWorkLessThanOrEqualTo(String value) {
            addCriterion("No_punch_card_at_work <=", value, "noPunchCardAtWork");
            return (Criteria) this;
        }

        public Criteria andNoPunchCardAtWorkLike(String value) {
            addCriterion("No_punch_card_at_work like", value, "noPunchCardAtWork");
            return (Criteria) this;
        }

        public Criteria andNoPunchCardAtWorkNotLike(String value) {
            addCriterion("No_punch_card_at_work not like", value, "noPunchCardAtWork");
            return (Criteria) this;
        }

        public Criteria andNoPunchCardAtWorkIn(List<String> values) {
            addCriterion("No_punch_card_at_work in", values, "noPunchCardAtWork");
            return (Criteria) this;
        }

        public Criteria andNoPunchCardAtWorkNotIn(List<String> values) {
            addCriterion("No_punch_card_at_work not in", values, "noPunchCardAtWork");
            return (Criteria) this;
        }

        public Criteria andNoPunchCardAtWorkBetween(String value1, String value2) {
            addCriterion("No_punch_card_at_work between", value1, value2, "noPunchCardAtWork");
            return (Criteria) this;
        }

        public Criteria andNoPunchCardAtWorkNotBetween(String value1, String value2) {
            addCriterion("No_punch_card_at_work not between", value1, value2, "noPunchCardAtWork");
            return (Criteria) this;
        }

        public Criteria andNoPunchCardAfterWorkIsNull() {
            addCriterion("No_punch_card_after_work is null");
            return (Criteria) this;
        }

        public Criteria andNoPunchCardAfterWorkIsNotNull() {
            addCriterion("No_punch_card_after_work is not null");
            return (Criteria) this;
        }

        public Criteria andNoPunchCardAfterWorkEqualTo(String value) {
            addCriterion("No_punch_card_after_work =", value, "noPunchCardAfterWork");
            return (Criteria) this;
        }

        public Criteria andNoPunchCardAfterWorkNotEqualTo(String value) {
            addCriterion("No_punch_card_after_work <>", value, "noPunchCardAfterWork");
            return (Criteria) this;
        }

        public Criteria andNoPunchCardAfterWorkGreaterThan(String value) {
            addCriterion("No_punch_card_after_work >", value, "noPunchCardAfterWork");
            return (Criteria) this;
        }

        public Criteria andNoPunchCardAfterWorkGreaterThanOrEqualTo(String value) {
            addCriterion("No_punch_card_after_work >=", value, "noPunchCardAfterWork");
            return (Criteria) this;
        }

        public Criteria andNoPunchCardAfterWorkLessThan(String value) {
            addCriterion("No_punch_card_after_work <", value, "noPunchCardAfterWork");
            return (Criteria) this;
        }

        public Criteria andNoPunchCardAfterWorkLessThanOrEqualTo(String value) {
            addCriterion("No_punch_card_after_work <=", value, "noPunchCardAfterWork");
            return (Criteria) this;
        }

        public Criteria andNoPunchCardAfterWorkLike(String value) {
            addCriterion("No_punch_card_after_work like", value, "noPunchCardAfterWork");
            return (Criteria) this;
        }

        public Criteria andNoPunchCardAfterWorkNotLike(String value) {
            addCriterion("No_punch_card_after_work not like", value, "noPunchCardAfterWork");
            return (Criteria) this;
        }

        public Criteria andNoPunchCardAfterWorkIn(List<String> values) {
            addCriterion("No_punch_card_after_work in", values, "noPunchCardAfterWork");
            return (Criteria) this;
        }

        public Criteria andNoPunchCardAfterWorkNotIn(List<String> values) {
            addCriterion("No_punch_card_after_work not in", values, "noPunchCardAfterWork");
            return (Criteria) this;
        }

        public Criteria andNoPunchCardAfterWorkBetween(String value1, String value2) {
            addCriterion("No_punch_card_after_work between", value1, value2, "noPunchCardAfterWork");
            return (Criteria) this;
        }

        public Criteria andNoPunchCardAfterWorkNotBetween(String value1, String value2) {
            addCriterion("No_punch_card_after_work not between", value1, value2, "noPunchCardAfterWork");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}