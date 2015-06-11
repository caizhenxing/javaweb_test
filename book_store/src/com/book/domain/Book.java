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
 * ��
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
	/// �ļ���
	private String name;
	/// ��С
	private long size;
	/// ����id
	private String contentId;
	/// ��Դ·��
	private String path;
	/// MD5
	private String md5;
	/// ӵ�����˺�
	private String carrier;
	/// ����
	private String author;
//	/// ����޸�ʱ��
//	private Date lastChangeDate;
//	/// �ϴ�ʱ��
//	private Date uploadDate;
//	/// ���
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
