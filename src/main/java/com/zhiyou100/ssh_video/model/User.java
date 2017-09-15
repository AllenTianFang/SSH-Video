package com.zhiyou100.ssh_video.model;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;



public class User {
    private Integer id;

    private String nickName;

    private Integer sex;
   
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birthday;

    private String email;

    private String province;

    private String city;

    private String headUrl;

    private String password;
    
    private String oldPassword;
    
    private String newPassword;
    
    private Date insertTime;
    
    private Date updateTime;
    
    private String captcha;
    
    

	public Date getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getHeadUrl() {
		return headUrl;
	}

	public void setHeadUrl(String headUrl) {
		this.headUrl = headUrl;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public void setProperty(User u){
		this.nickName = u.getNickName() == null?this.nickName:u.getNickName();
		this.sex = u.getSex() == null?this.sex:u.getSex();
		this.birthday = u.getBirthday() == null?this.birthday:u.getBirthday();
		this.email = u.getEmail() == null?this.email:u.getEmail();
		this.province = u.getProvince() == null?this.province:u.getProvince();
		this.city = u.getCity() == null?this.city:u.getCity();
		this.headUrl = u.getHeadUrl() == null?this.headUrl:u.getHeadUrl();
		this.password = u.getPassword() == null?this.password:u.getPassword();
		this.insertTime = u.getInsertTime() == null?this.insertTime:u.getInsertTime();
		this.updateTime = new Timestamp(System.currentTimeMillis());
		this.captcha = u.getCaptcha() == null?this.captcha:u.getCaptcha();
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nickName=" + nickName + ", sex=" + sex + ", birthday=" + birthday + ", email="
				+ email + ", province=" + province + ", city=" + city + ", headUrl=" + headUrl + ", password="
				+ password + ", oldPassword=" + oldPassword + ", newPassword=" + newPassword + ", insertTime="
				+ insertTime + ", updateTime=" + updateTime + ", captcha=" + captcha + "]";
	}
    
   
    
}