package com.sun.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import javax.xml.crypto.Data;

public class ApName {
	
	public static String encry(String str) {
		if (str == null)
			return null;
		char[] arry = str.toCharArray();
		for (int i = 0; i < arry.length; i++) {
			arry[i] = (char) (arry[i] ^ 't');
		}
		String s = "";
		for (int i = 0; i < arry.length; i++) {
			s += arry[i];
		}
		return s;
	}
	
	public static String decry(String str){
		char[] arry = new char[str.length()];
		for(int i = 0;i<str.length();i++){
			arry[i] = (char)(str.charAt(i)^ 't');
		}
		String s = new String(arry);
		return s;
	}
	
	public static boolean validMethod(String str){
		String decry = decry(str);
		String[] arr = decry.split("#");
		if(arr.length<=1){
			System.out.println("错误的密匙");
			return false;
		}else{
			SimpleDateFormat sim = new SimpleDateFormat("yyyyMMdd");
			try {
				Date date = sim.parse(arr[0]);
				Calendar ca = Calendar.getInstance();
			    ca.add(ca.DATE, -Integer.parseInt(arr[2]));
			    Date nowDate = ca.getTime();
			    if(nowDate.after(date)){
			    	System.out.println("您输入的密匙过期");
			    	return false;
			    }
			} catch (Exception e) {
				System.out.println("错误的密匙");
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args){
		StringBuffer sb = new StringBuffer();
		sb.append("itel_device");
		sb.append(System.currentTimeMillis());
		System.out.println(sb.toString());
	}

}
