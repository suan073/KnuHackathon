package com.example.bottonnav;


public class Course {
    int eventNum;
    String eventName;
    String eventType;
    int eResStartMonth;
    int eResEndMonth;
    int eResStartDay;
    int eResEndDay;
    int eProStartMonth;
    int eProEndMonth;
    int eProStartDay;
    int eProEndDay;
    String eventMajor;
    int eventGrade;
    String eventDetail;
    String eventLink;


    public int getEventNum() {
        return eventNum;
    }

    public void setEventNum(int eventNum) {
        this.eventNum = eventNum;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public int geteResStartMonth() {
        return eResStartMonth;
    }

    public void seteResStartMonth(int eResStartMonth) {
        this.eResStartMonth = eResStartMonth;
    }

    public int geteResEndMonth() {
        return eResEndMonth;
    }

    public void seteResEndMonth(int eResEndMonth) {
        this.eResEndMonth = eResEndMonth;
    }

    public int geteResStartDay() {
        return eResStartDay;
    }

    public void seteResStartDay(int eResStartDay) {
        this.eResStartDay = eResStartDay;
    }

    public int geteResEndDay() {
        return eResEndDay;
    }

    public void seteResEndDay(int eResEndDay) {
        this.eResEndDay = eResEndDay;
    }

    public int geteProStartMonth() {
        return eProStartMonth;
    }

    public void seteProStartMonth(int eProStartMonth) {
        this.eProStartMonth = eProStartMonth;
    }

    public int geteProEndMonth() {
        return eProEndMonth;
    }

    public void seteProEndMonth(int eProEndMonth) {
        this.eProEndMonth = eProEndMonth;
    }

    public int geteProStartDay() {
        return eProStartDay;
    }

    public void seteProStartDay(int eProStartDay) {
        this.eProStartDay = eProStartDay;
    }

    public int geteProEndDay() {
        return eProEndDay;
    }

    public void seteProEndDay(int eProEndDay) {
        this.eProEndDay = eProEndDay;
    }

    public String getEventMajor() {
        return eventMajor;
    }

    public void setEventMajor(String eventMajor) {
        this.eventMajor = eventMajor;
    }

    public int getEventGrade() {
        return eventGrade;
    }

    public void setEventGrade(int eventGrade) {
        this.eventGrade = eventGrade;
    }

    public String getEventDetail() {
        return eventDetail;
    }

    public void setEventDetail(String eventDetail) {
        this.eventDetail = eventDetail;
    }

    public String getEventLink() {
        return eventLink;
    }

    public void setEventLink(String eventLink) {
        this.eventLink = eventLink;
    }

    public Course(String userID, int eventNum, String eventName, String eventType, int eResStartMonth, int eResEndMonth, int eResStartDay, int eResEndDay, int eProStartMonth, int eProEndMonth, int eProStartDay, int eProEndDay, String eventMajor, int eventGrade, String eventDetail, String eventLink) {
        this.eventNum = eventNum;
        this.eventName = eventName;
        this.eventType = eventType;
        this.eResStartMonth = eResStartMonth;
        this.eResEndMonth = eResEndMonth;
        this.eResStartDay = eResStartDay;
        this.eResEndDay = eResEndDay;
        this.eProStartMonth = eProStartMonth;
        this.eProEndMonth = eProEndMonth;
        this.eProStartDay = eProStartDay;
        this.eProEndDay = eProEndDay;
        this.eventMajor = eventMajor;
        this.eventGrade = eventGrade;
        this.eventDetail = eventDetail;
        this.eventLink = eventLink;
    }
}

