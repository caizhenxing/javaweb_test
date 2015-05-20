package com.passport.bean;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="level_info")
public class LevelInfo {

	@Id
	@GenericGenerator(name = "pkGenerator", strategy = "native", parameters = { @Parameter(name = "property", value = "account") })
	@GeneratedValue(generator = "pkGenerator")
	private int id;
	
	@OneToOne(mappedBy="levelInfo",cascade=CascadeType.ALL,fetch=FetchType.LAZY,targetEntity=Account.class)
	private Account account;
	private int level;
	private Date activetime;
	private long chainday;
	private long activeday;
	
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
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public Date getActivetime() {
		return activetime;
	}
	public void setActivetime(Date activetime) {
		this.activetime = activetime;
	}
	public long getChainday() {
		return chainday;
	}
	public void setChainday(long chainday) {
		this.chainday = chainday;
	}
	public long getActiveday() {
		return activeday;
	}
	public void setActiveday(long activeday) {
		this.activeday = activeday;
	}
}
