package com.zhiyou100.ssh_video.model;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Course {
    private Integer id;

    private String courseName;

    private String courseDescr;

    private Date insertTime;

    private Date updateTime;

    private Integer subjectId;
    
    private Subject sub;
    
    private Set<Video> videoSet = new HashSet<>();

    

	public Set<Video> getVideoSet() {
		return videoSet;
	}

	public void setVideoSet(Set<Video> videoSet) {
		this.videoSet = videoSet;
	}

	public Subject getSub() {
		return sub;
	}

	public void setSub(Subject sub) {
		this.sub = sub;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    public String getCourseDescr() {
        return courseDescr;
    }

    public void setCourseDescr(String courseDescr) {
        this.courseDescr = courseDescr == null ? null : courseDescr.trim();
    }

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

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

	@Override
	public String toString() {
		return "Course [courseName=" + courseName + ", videoSet=" + videoSet + "]";
	}

	

	

}