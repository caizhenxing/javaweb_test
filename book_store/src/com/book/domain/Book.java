package com.book.domain;

import java.util.Date;

public class Book {

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
	/// 最后修改时间
	Date lastChangeDate;
	/// 上传时间
	Date uploadDate;
}
