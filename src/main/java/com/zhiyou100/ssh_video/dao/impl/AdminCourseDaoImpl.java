package com.zhiyou100.ssh_video.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.zhiyou100.ssh_video.dao.AdminCourseDao;
import com.zhiyou100.ssh_video.model.Course;
import com.zhiyou100.ssh_video.model.Subject;
@Repository
public class AdminCourseDaoImpl implements AdminCourseDao {
	@Autowired
	HibernateTemplate template;

	@Override
	public int findCount(DetachedCriteria dcc1) {
		List<Number> num = (List<Number>) template.findByCriteria(dcc1);
		return num.get(0).intValue();
	}

	@Override
	public List<Course> findAllCourse(DetachedCriteria dcc2, int page1) {
		List<Course> list = (List<Course>) template.findByCriteria(dcc2, (page1-1)*7, 7);
		return list;
	}

	@Override
	public List<Subject> findSubject(DetachedCriteria dcs) {
		List<Subject> list = (List<Subject>) template.findByCriteria(dcs);
		return list;
	}

	@Override
	public void addCourse(Course course) {
		template.save(course);
		
	}

	@Override
	public Course findCourseById(DetachedCriteria dcc) {
		List<Course> list = (List<Course>) template.findByCriteria(dcc);
		return list.get(0);
	}

	@Override
	public void updateCourse(Course course) {
		template.update(course);
		
	}

	@Override
	public void deleteCourse(Course course) {
		template.delete(course);
		
	}

}
