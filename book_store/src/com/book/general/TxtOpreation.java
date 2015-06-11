package com.book.general;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.book.domain.CutInput;


public class TxtOpreation {
    /**
     * 读取txt文件的内容
     * @param file 想要读取的文件对象
     * @return 返回文件内容
     */
    public static String txt2String(File file , CutInput input){
        String result = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            long set = input.getLen();
            br.skip(input.getOff());
            //System.out.println("开始"+"off:"+input.off+" len:"+set);
            
            
            while((s = br.readLine())!=null && set > 0){//使用readLine方法，一次读一行
                result = result + "\r" +s;
                set --;
                //System.out.println("line :>"+s+"<");
            }
            br.close();    
        }catch(Exception e){
            e.printStackTrace();
        }
        char []ret = result.toCharArray();
        input.setOff(input.getOff()+ ret.length) ;
        return result;
    }
    
    public static String txtCut(File file , CutInput input) {
    	FileReader reader = null;
    	String part = "";
		try {
			reader = new FileReader(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		BufferedReader buffer = new BufferedReader(reader);
		
		try {
			if (buffer.ready()) {
				int len = input.getLen();
				int off = input.getOff();
				buffer.skip(off);
				char [] b = new char[len];
				int rlen = buffer.read(b, 0, len);
			
				part = new String(b);
				input.setEnd(rlen < len);
				//System.out.println("read length : "+input.getLen()+" fact read length : "+rlen+ " content : " + part);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
			try {
				buffer.close();
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		return part;
	}
}