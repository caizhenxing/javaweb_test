package com.lesson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		File file = new File("G:\\1.txt");
		
		FileReader reader = null;
		try {
			reader = new FileReader(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		BufferedReader buffer = new BufferedReader(reader);
		
		try {
			
			
			if (buffer.ready()) {
				int len = 1000;
				char [] b = new char[len];
				int rlen = buffer.read(b, 0, len);
				
				String part = new String(b);
				
				System.out.println("read length : "+rlen+ " content : " + part);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
