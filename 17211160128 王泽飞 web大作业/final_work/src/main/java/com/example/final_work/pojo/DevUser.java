package com.example.final_work.pojo;

import javax.validation.constraints.Pattern;
import java.util.Date;

public class DevUser {
	private Integer id;//主键id  /^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*\.[a-zA-z0-9]{2,6}$/
	@Pattern(regexp="/^[0-9a-zA-Z]+$/" , message = "非法用户账号格式")
	private String devCode;//开发者帐号(系统登录账号)
	private String devName;//开发者名称
    @Pattern(regexp = "/^[0-9a-zA-Z]{6,12}$/" ,message = "密码格式错误")
	private String devPassword;//开发者密码
    @Pattern(regexp = "/^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-z0-9]{2,6}$/",message = "非法邮箱格式")
	private String devEmail;//开发者邮箱
	private String devInfo;	//开发者简介
	private Integer createdBy;//创建者
	private Date creationDate;//创建时间
	private Integer modifyBy;//更新者
	private Date modifyDate;//更新时间
	private String status;//审核状态

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "DevUser{" +
				"id=" + id +
				", devCode='" + devCode + '\'' +
				", devName='" + devName + '\'' +
				", devPassword='" + devPassword + '\'' +
				", devEmail='" + devEmail + '\'' +
				", devInfo='" + devInfo + '\'' +
				", createdBy=" + createdBy +
				", creationDate=" + creationDate +
				", modifyBy=" + modifyBy +
				", modifyDate=" + modifyDate +
				", status='" + status + '\'' +
				'}';
	}

	public String getDevCode() {
		return devCode;
	}
	public void setDevCode(String devCode) {
		this.devCode = devCode;
	}
	public String getDevName() {
		return devName;
	}
	public void setDevName(String devName) {
		this.devName = devName;
	}
	public String getDevPassword() {
		return devPassword;
	}
	public void setDevPassword(String devPassword) {
		this.devPassword = devPassword;
	}
	public String getDevEmail() {
		return devEmail;
	}
	public void setDevEmail(String devEmail) {
		this.devEmail = devEmail;
	}
	public String getDevInfo() {
		return devInfo;
	}
	public void setDevInfo(String devInfo) {
		this.devInfo = devInfo;
	}
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Integer getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(Integer modifyBy) {
		this.modifyBy = modifyBy;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	
}
