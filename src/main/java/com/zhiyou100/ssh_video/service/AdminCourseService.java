package com.zhiyou100.ssh_video.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.zhiyou100.ssh_video.model.Course;
import com.zhiyou100.ssh_video.model.Subject;
import com.zhiyou100.ssh_video.utils.Page;

public interface AdminCourseService {

	Page<Course> findAllCourse(DetachedCriteria dcc1, DetachedCriteria dcc2, int page1);

	List<Subject> findSubject(DetachedCriteria dcs);

	void addCourse(Course course);

	Course findCourseById(DetachedCriteria dcc);

	void updateCourse(Course course);

	void deleteCourse(Course course);

}
