package com.zhiyou100.ssh_video.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.ssh_video.dao.FrontCourseDao;
import com.zhiyou100.ssh_video.model.Course;
import com.zhiyou100.ssh_video.model.Subject;
import com.zhiyou100.ssh_video.service.FrontCourseService;
@Service
public class FrontCourseServiceImpl implements FrontCourseService {
	@Autowired
	FrontCourseDao fcd;

	@Override
	public Subject findSubject(DetachedCriteria dcs) {
		return fcd.findSubject(dcs);
	}

	@Override
	public List<Course> findAllCourseBySub(DetachedCriteria dcc) {
		return fcd.findAllCourseBySub(dcc);
	}

}
