package com.zhiyou100.ssh_video.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.ssh_video.dao.AdminCourseDao;
import com.zhiyou100.ssh_video.model.Course;
import com.zhiyou100.ssh_video.model.Subject;
import com.zhiyou100.ssh_video.service.AdminCourseService;
import com.zhiyou100.ssh_video.utils.Page;
@Service
public class AdminCourseServiceImpl implements AdminCourseService {
	@Autowired
	AdminCourseDao acd;

	@Override
	public Page<Course> findAllCourse(DetachedCriteria dcc1, DetachedCriteria dcc2, int page1) {
		Page<Course> pageInfo = new Page<>();
		pageInfo.setPage(page1);
		pageInfo.setSize(7);
		pageInfo.setTotal(acd.findCount(dcc1));
		pageInfo.setRows(acd.findAllCourse(dcc2,page1));
		return pageInfo;
	}

	@Override
	public List<Subject> findSubject(DetachedCriteria dcs) {
		
		return acd.findSubject(dcs);
	}

	@Override
	public void addCourse(Course course) {
		acd.addCourse(course);
		
	}

	@Override
	public Course findCourseById(DetachedCriteria dcc) {
		
		return acd.findCourseById(dcc);
	}

	@Override
	public void updateCourse(Course course) {
		acd.updateCourse(course);
		
	}

	@Override
	public void deleteCourse(Course course) {
		acd.deleteCourse(course);
		
	}

}
