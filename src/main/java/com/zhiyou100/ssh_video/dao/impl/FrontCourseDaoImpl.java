package com.zhiyou100.ssh_video.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.zhiyou100.ssh_video.dao.FrontCourseDao;
import com.zhiyou100.ssh_video.model.Course;
import com.zhiyou100.ssh_video.model.Subject;
@Repository
public class FrontCourseDaoImpl implements FrontCourseDao {
	@Autowired
	HibernateTemplate template;

	@Override
	public Subject findSubject(DetachedCriteria dcs) {
		List<Subject> list = (List<Subject>) template.findByCriteria(dcs);
		return list.get(0);
	}

	@Override
	public List<Course> findAllCourseBySub(DetachedCriteria dcc) {
		List<Course> list = (List<Course>) template.findByCriteria(dcc);
		return list;
	}

}
