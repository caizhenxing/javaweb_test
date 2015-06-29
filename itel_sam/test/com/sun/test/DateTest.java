package com.sun.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest<E> {
	
	
	
	private static Date castDate(String date){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date d = null;
		try {
			 d = format.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			d = new Date();
		}
		return d;
	}
	public static void main(String[] args){
		Date d = castDate("2014-5-9");
//		Date d = castDate("");
		System.out.println(1900+d.getYear());
		System.out.println(d.getMonth()+1);
		System.out.println(d.getDate());
	}

}
