package com.passport.bean;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="reg_info")
public class RegInfo {

	// RegInfo��ID���������ģ�������Ҫ����ID�������Ĳ���Ϊnative��������ָ��wife��ID��ʹ��husband�����е�ID
	@Id
	@GenericGenerator(name = "pkGenerator", strategy = "native", parameters = { @Parameter(name = "property", value = "account") })
	@GeneratedValue(generator = "pkGenerator")
	private int id;

	@OneToOne(mappedBy="regInfo",cascade=CascadeType.ALL,fetch=FetchType.LAZY,targetEntity=Account.class)
	private Account account;
	/**
	 * ע��ʱ��
	 */
	private Date regtime;
	/**
	 * ע��ip
	 */
	private String regip;
	/**
	 * ע������
	 */
	@Transient
	private AuthorInfo channel;
	/**
	 * ע����
	 */
	@Transient
	private Account register;

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

	public Date getRegtime() {
		return regtime;
	}

	public void setRegtime(Date regtime) {
		this.regtime = regtime;
	}

	public String getRegip() {
		return regip;
	}

	public void setRegip(String regip) {
		this.regip = regip;
	}

	public AuthorInfo getChannel() {
		return channel;
	}

	public void setChannel(AuthorInfo channel) {
		this.channel = channel;
	}

	public Account getRegister() {
		return register;
	}

	public void setRegister(Account register) {
		this.register = register;
	}

}
