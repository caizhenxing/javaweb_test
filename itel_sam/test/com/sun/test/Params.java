package com.sun.test;

public class Params {
	
	public static void out(Object obj){
		System.out.println(obj);
	}
	
	public static void getParams2(UrlValue ... urlValues ){
		out("getParmas2 params length:"+urlValues.length);
		for(UrlValue value : urlValues){
			out(value);
		}
	}
	
	public static void getParamas(String... args){
		out("getParmas params length:"+args.length);
		for(String value : args){
			out(value);
		}
	}
	
	public static void main(String[] args){
		getParamas("1111","2222","33333");
		getParams2(new UrlValue(),new UrlValue());
	}

}
