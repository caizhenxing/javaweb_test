package com.book.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;

/**
 * 书
 * @author Administrator
 *
 */
@Entity
@Table(name = "book_basic", uniqueConstraints = { @UniqueConstraint(columnNames = {
"contentId" }) })
public class Book {

	/// id	
	@Id
	@Column(name = "book_id")
	@GenericGenerator(name = "generator", strategy = "increment")
	@GeneratedValue(generator = "generator")
	private Integer bookid;
	/// 文件名
	private String name;
	/// 大小
	private long size;
	/// 内容id
	private String contentId;
	/// 资源路径
	private String path;
	/// MD5
	private String md5;
	/// 拥有者账号
	private String carrier;
	/// 作者
	private String author;
//	/// 最后修改时间
//	private Date lastChangeDate;
//	/// 上传时间
//	private Date uploadDate;
//	/// 简介
//	private String introduction;
	
	
	
	public Integer getBookid() {
		return bookid;
	}
	public void setBookid(Integer bookid) {
		this.bookid = bookid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
	public String getContentId() {
		return contentId;
	}
	public void setContentId(String contentId) {
		this.contentId = contentId;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getMd5() {
		return md5;
	}
	public void setMd5(String md5) {
		this.md5 = md5;
	}
	public String getCarrier() {
		return carrier;
	}
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
//	public Date getLastChangeDate() {
//		return lastChangeDate;
//	}
//	public void setLastChangeDate(Date lastChangeDate) {
//		this.lastChangeDate = lastChangeDate;
//	}
//	public Date getUploadDate() {
//		return uploadDate;
//	}
//	public void setUploadDate(Date uploadDate) {
//		this.uploadDate = uploadDate;
//	}
//	public String getIntroduction() {
//		return introduction;
//	}
//	public void setIntroduction(String introduction) {
//		this.introduction = introduction;
//	}

}
