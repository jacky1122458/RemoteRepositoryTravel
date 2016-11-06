package model.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
public class Day {
	SimpleDateFormat sdf =new SimpleDateFormat("yyyy/MM/dd");

	public static void main(String[] args) {
		Day day = new Day();
		java.util.Date date = new Date();
		
		
	}
	public int daysOfTwo(Calendar befor, Calendar after) {
		long m = after.getTimeInMillis() - befor.getTimeInMillis();
		m=m/(24*60*60*1000);
		//判斷是不是同一天
		if(m==0 && after.get(Calendar.DAY_OF_YEAR)!=befor.get(Calendar.DAY_OF_YEAR)){
		m+=1;
		}
		return (int)m;
		}
	public int howManyDays(String checkin,String checkout){
		SimpleDateFormat df2 = new SimpleDateFormat("yyyy/MM/dd");
		Calendar cc = Calendar.getInstance();
		Calendar dd = Calendar.getInstance();
		 int b =0;
		try {
		     cc.setTime(df2.parse(checkin));
		     dd.setTime(df2.parse(checkout));
		     Day a = new Day();
		     b = a.daysOfTwo(cc, dd); 
		} catch (Exception e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();}
		return b;
	}
	public List<java.sql.Date> changeToSqlDate(java.util.Date checkin,java.util.Date checkout){
		java.util.Date day1 = null;
		java.util.Date day2 = null;
		try {
			day1 = checkin;
			day2 = checkout;
		} catch (Exception e) {
			// TODO: handle exception
		}
		long time = day1.getTime();
		long time1 = day2.getTime();
		java.sql.Date date1 = new java.sql.Date(time);
		java.sql.Date date2 = new java.sql.Date(time1);
		List<java.sql.Date> day = new ArrayList<>();
		day.add(date1);
		day.add(date2);
		return day;
	}
	public java.util.Date changeToUtilDate(String checkin){
		 Date date = null;  
	        try {  
	            date = sdf.parse(checkin); 
	        } catch (ParseException e) {  
	            e.printStackTrace();  
	        }  
		return date;
	}
	public List<java.sql.Date> orderChangeToSqlDate(java.util.Date orderday,java.util.Date checkin,java.util.Date checkout){
		java.util.Date day1 = null;
		java.util.Date day2 = null;
		java.util.Date day3 = null;
		try {
			day1 = orderday;
			day2 = checkin;
			day3 = checkout;
		} catch (Exception e) {
		}
		long time1 = day1.getTime();
		long time2 = day2.getTime();
		long time3 = day3.getTime();
		java.sql.Date date1 = new java.sql.Date(time1);
		java.sql.Date date2 = new java.sql.Date(time2);
		java.sql.Date date3 = new java.sql.Date(time3);
		List<java.sql.Date> day = new ArrayList<>();
		day.add(date1);
		day.add(date2);
		day.add(date3);
		return day;
	}
	public  java.util.Date getSpecifiedDayBefore(String specifiedDay) {//可以用new Date().toLocalString()传递参数  
        Calendar c = Calendar.getInstance();  
        Date date = null;  
        try {  
            date = sdf.parse(specifiedDay); 
        } catch (ParseException e) {  
            e.printStackTrace();  
        }  
        c.setTime(date);  
        int day = c.get(Calendar.DATE);  
        c.set(Calendar.DATE, day - 1);  
  
        String dayBefore = new SimpleDateFormat("yyyy/MM/dd").format(c  
                .getTime());  
        java.util.Date checkout1 = null;
		try {
			checkout1 = sdf.parse(dayBefore);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return checkout1;  
    }  
	public  java.util.Date getCheckin(String specifiedDay) {//可以用new Date().toLocalString()传递参数  
        Calendar c = Calendar.getInstance();  
        Date date = null;  
        try {  
            date = sdf.parse(specifiedDay); 
        } catch (ParseException e) {  
            e.printStackTrace();  
        }  
        c.setTime(date);  
        int day = c.get(Calendar.DATE);  
 
  
        String dayBefore = sdf.format(c  
                .getTime());  
        java.util.Date checkout1 = null;
		try {
			checkout1 = sdf.parse(dayBefore);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return checkout1;  
    }  
}
