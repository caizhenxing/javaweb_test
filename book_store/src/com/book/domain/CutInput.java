package com.book.domain;

public class CutInput
{
	public CutInput() {
		
	}
	public CutInput(int off, int len) {
		setLen(len);
		setOff(off);
	}
	private int off;
	private int len;
	private int totalLen;
	private boolean end;
	
	public boolean isEnd() {
		return end;
	}
	public void setEnd(boolean end) {
		this.end = end;
	}
	public int getOff() {
		return off;
	}
	public void setOff(int off) {
		this.off = off;
	}
	public int getLen() {
		return len;
	}
	public void setLen(int len) {

		this.len = len;
	}
	public void setTotalLen(int totalLen) {
		this.totalLen = totalLen;
	}
	public int getTotalLen() {
		return totalLen;
	}
}