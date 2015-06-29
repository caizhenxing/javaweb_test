package com.itel.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 设备实体Bean
 * @author Administrator
 *
 */
@Entity
@Table(name = "itel_sam_device")
public class SamDevice implements Serializable {
	private static final long serialVersionUID = -6198816771803785370L;
	@Id
	@Column(name = "var_pitel")
	private String varPitel;//产品itel号
	@Column(name = "var_type")
	private String varType;//设备类型(后期扩展使用)
	@Column(name = "var_title")
	private String varTitle;//设备标题
	@Column(name = "var_deviceid")
	private String varDeviceId;//设备id(暂时无用)
	@Column(name = "var_password")
	private String varPassWord;//设备密码
	@Column(name = "date_regtime")
	private String dateRegTime;//注册时间
	@Column(name = "var_uitel")
	private String varUiTel;//拥有者itel号
	@Column(name = "var_remark")
	private String varRemark;//备注
	@Column(name = "userbind",columnDefinition="varchar default N")
	private String userbind = "N";//是否允许所有人绑定
	@Column(name = "flag_share",columnDefinition="varchar default N")
	private String flagShare = "N";//是否分享(公共摄像头)
	@Column(name = "flag_isdel",columnDefinition="varchar default N")
	private String flagIsDel = "N";//设备是否损坏(暂时无用)

	public String getVarPitel() {
		return varPitel;
	}

	public void setVarPitel(String varPitel) {
		this.varPitel = varPitel;
	}

	public String getVarType() {
		return varType;
	}

	public void setVarType(String varType) {
		this.varType = varType;
	}

	public String getVarTitle() {
		return varTitle;
	}

	public void setVarTitle(String varTitle) {
		this.varTitle = varTitle;
	}

	public String getVarDeviceId() {
		return varDeviceId;
	}

	public void setVarDeviceId(String varDeviceId) {
		this.varDeviceId = varDeviceId;
	}

	public String getVarPassWord() {
		return varPassWord;
	}

	public void setVarPassWord(String varPassWord) {
		this.varPassWord = varPassWord;
	}

	/*public Timestamp getDateRegTime() {
		return dateRegTime;
	}

	public void setDateRegTime(Timestamp dateRegTime) {
		this.dateRegTime = dateRegTime;
	}*/

	public String getVarUiTel() {
		return varUiTel;
	}

	/*public Date getDateRegTime() {
		
		return dateRegTime;
	}

	public void setDateRegTime(Date dateRegTime) {
		this.dateRegTime = dateRegTime;
	}*/
	

	public void setVarUiTel(String varUiTel) {
		this.varUiTel = varUiTel;
	}

	public String getDateRegTime() {
		return dateRegTime;
	}

	public void setDateRegTime(String dateRegTime) {
		this.dateRegTime = dateRegTime;
	}

	public String getVarRemark() {
		return varRemark;
	}

	public void setVarRemark(String varRemark) {
		this.varRemark = varRemark;
	}
	public String getFlagShare() {
		return flagShare;
	}

	public void setFlagShare(String flagShare) {
		this.flagShare = flagShare;
	}
	
	public String getFlagIsDel() {
		return flagIsDel;
	}
	
	public void setFlagIsDel(String flagIsDel) {
		this.flagIsDel = flagIsDel;
	}

	public String getUserbind() {
		return userbind;
	}

	public void setUserbind(String userbind) {
		this.userbind = userbind;
	}

}