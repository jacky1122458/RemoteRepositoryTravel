package cht.model.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class testCalender {
	public static void main(String[] args) throws ParseException{
//		Calendar rightNow = Calendar.getInstance();
//		System.out.println(rightNow.get(Calendar.YEAR));
//		System.out.println(rightNow.get(Calendar.MONTH)+1);
//		System.out.println(rightNow.get(Calendar.DAY_OF_MONTH));
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date first = (java.util.Date) sdf.parse("2016-11-11");
		java.util.Date last = (java.util.Date) sdf.parse("2016-11-12");
		System.out.println(last.getTime()-first.getTime());
		java.util.Date day1 = new java.util.Date();
		java.util.Date day2 = new java.util.Date(day1.getTime()+86400000);
		System.out.println(day2.getDate());
	}
}
