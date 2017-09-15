package com.zhiyou100.ssh_video.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.zhiyou100.ssh_video.dao.AdminStatisticDao;
@Repository
public class AdminStatisticDaoImpl implements AdminStatisticDao {
	@Autowired
	HibernateTemplate template;

	@Override
	public List<Object[]> findVideoMessage() {
		String sql = "select c.course_name courseName,avg(video_play_times) avgtimes from video v,course c where c.id = course_id group by course_id";
		List<Object[]> list = template.getSessionFactory().getCurrentSession().createSQLQuery(sql).list();
	    return list;
	}

}
