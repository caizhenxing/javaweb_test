package com.sun.test;

import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;

public class FontSort {
	@Test
	public void sort() {
		Comparator cmp = Collator.getInstance(java.util.Locale.CHINA);

		String[] arr = { "张三", "李四", "王五", "刘六","wo" };
		Arrays.sort(arr, cmp);
		for (int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);
	}

}
