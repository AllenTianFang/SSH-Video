package com.zhiyou100.ssh_video.model;

import java.util.ArrayList;
import java.util.List;

public class ResuleJson {
	
	private List<String> courseName = new ArrayList<>();
	private List<Object> playTimes = new ArrayList<>();
	private boolean success;
	private String message;
	
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<String> getCourseName() {
		return courseName;
	}
	public void setCourseName(List<String> courseName) {
		this.courseName = courseName;
	}
	
	
	public List<Object> getPlayTimes() {
		return playTimes;
	}
	public void setPlayTimes(List<Object> playTimes) {
		this.playTimes = playTimes;
	}
	@Override
	public String toString() {
		return "ResuleJson [courseName=" + courseName + ", playTimes=" + playTimes + ", success=" + success
				+ ", message=" + message + "]";
	}
	
	
}
