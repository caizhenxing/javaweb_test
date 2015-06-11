package com.book.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 读书记录
 * @author Administrator
 *
 */
//@Entity
//@Table(name="book_mark")
public class BookMark {

	/// id
	@Id
	@Column(name = "bm_id")
	@GenericGenerator(name = "generator", strategy = "increment")
	@GeneratedValue(generator = "generator")
	private Integer bookMarkId;
	
	/// 书id
	private Book book;
	
	/// 读书人
	private Account reder;
	
	/// 书签
	private long bookMark;
	
	/// 书签label
	private String bmLabel;
	
	/// 添加日期
	private Date time;

	
	public Integer getReadId() {
		return bookMarkId;
	}

	public void setReadId(Integer bookMarkId) {
		this.bookMarkId = bookMarkId;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Account getReder() {
		return reder;
	}

	public void setReder(Account reder) {
		this.reder = reder;
	}

	public long getBookMark() {
		return bookMark;
	}

	public void setBookMark(long bookMark) {
		this.bookMark = bookMark;
	}

	public String getBmLabel() {
		return bmLabel;
	}

	public void setBmLabel(String bmLabel) {
		this.bmLabel = bmLabel;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
}
