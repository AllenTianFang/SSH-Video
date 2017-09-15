package com.zhiyou100.ssh_video.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.zhiyou100.ssh_video.model.Course;
import com.zhiyou100.ssh_video.model.Subject;

public interface AdminCourseDao {

	int findCount(DetachedCriteria dcc1);

	List<Course> findAllCourse(DetachedCriteria dcc2, int page1);

	List<Subject> findSubject(DetachedCriteria dcs);

	void addCourse(Course course);

	Course findCourseById(DetachedCriteria dcc);

	void updateCourse(Course course);

	void deleteCourse(Course course);

}
