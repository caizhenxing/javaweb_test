package com.sun.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * 
 * @author yangxuan
 *
 */
public class InitKey {

	

	public static String getEnKey(String key) {
		if ((key == null) || (key.equals(""))) {
			return "";
		}
		return encry(key);
	}
	/**
	 *  加密
	 * @param str
	 * @return
	 */
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
	
	/**
	 * 解密
	 * @param str
	 * @return
	 */
	public static String decry(String str){
		char[] arry = new char[str.length()];
		for(int i = 0;i<str.length();i++){
			arry[i] = (char)(str.charAt(i)^ 't');
		}
		String s = new String(arry);
		return s;
	}
	
	/**
	 * 校验
	 * @param str
	 * @return
	 */
	public static boolean validMethod(String str){
		String decry = decry(str);
		int i = 0;
		try{
			i = Integer.parseInt(decry);
		}catch(NumberFormatException e){
			e.printStackTrace();
			System.out.println("错误的号码");
			return false;
		}
		if(i!=0&&i%2==0){
			return true;
		}
		return true;
	}
	

	public static void main(String[] args) {
		Random random = new Random();
		int i =0;
		while(true){
			i = random.nextInt(10000000);
			if(i!=0&&i%2==0){
				break;
			}
		}
		System.out.println(i);
		System.out.println(encry(i+""));
		String entrykey = encry(i+"");
		System.out.println(decry(entrykey));
		System.out.println(validMethod("AEALADFDfff"));
	}

}
