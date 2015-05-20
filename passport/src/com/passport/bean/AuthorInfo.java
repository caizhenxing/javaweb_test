package com.passport.bean;

import java.util.Date;

public class AuthorInfo {
	private int id;
	private Account account;
	private String commission;
	private Account author;
	private Date authorTime;
	private Account proposer;
	private String proposetime;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public String getCommission() {
		return commission;
	}
	public void setCommission(String commission) {
		this.commission = commission;
	}
	public Account getAuthor() {
		return author;
	}
	public void setAuthor(Account author) {
		this.author = author;
	}
	public Date getAuthorTime() {
		return authorTime;
	}
	public void setAuthorTime(Date authorTime) {
		this.authorTime = authorTime;
	}
	public Account getProposer() {
		return proposer;
	}
	public void setProposer(Account proposer) {
		this.proposer = proposer;
	}
	public String getProposetime() {
		return proposetime;
	}
	public void setProposetime(String proposetime) {
		this.proposetime = proposetime;
	}
	
	
	
}

