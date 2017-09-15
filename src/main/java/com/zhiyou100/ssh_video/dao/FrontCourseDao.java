package com.zhiyou100.ssh_video.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.zhiyou100.ssh_video.model.Course;
import com.zhiyou100.ssh_video.model.Subject;

public interface FrontCourseDao {

	Subject findSubject(DetachedCriteria dcs);

	List<Course> findAllCourseBySub(DetachedCriteria dcc);

}
