package com.zhiyou100.ssh_video.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.zhiyou100.ssh_video.model.Course;
import com.zhiyou100.ssh_video.model.Subject;

public interface FrontCourseService {

	Subject findSubject(DetachedCriteria dcs);

	List<Course> findAllCourseBySub(DetachedCriteria dcc);

}
