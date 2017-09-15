package com.zhiyou100.ssh_video.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.zhiyou100.ssh_video.dao.AdminVideoDao;
import com.zhiyou100.ssh_video.model.Course;
import com.zhiyou100.ssh_video.model.Speaker;
import com.zhiyou100.ssh_video.model.Video;
@Repository
public class AdminVideoDaoImpl implements AdminVideoDao {
	@Autowired
	HibernateTemplate template;

	@Override
	public List<Speaker> findAllSpeaker(DetachedCriteria dcs) {
        List<Speaker> list = (List<Speaker>) template.findByCriteria(dcs);
		return list;
	}

	@Override
	public List<Course> findAllCourse(DetachedCriteria dcc) {
		List<Course> list = (List<Course>) template.findByCriteria(dcc);
		return list;
	}

	

	@Override
	public int findCount(DetachedCriteria dcv1) {
		List<Number> count =  (List<Number>) template.findByCriteria(dcv1);
		Number number = count.get(0);
		int a = number.intValue();
		return a;
	}

	@Override
	public List<Video> findAllVideo(DetachedCriteria dcv2, int page1) {
		List<Video> list = (List<Video>) template.findByCriteria(dcv2, (page1-1)*7, 7);
		return list;
	}

	@Override
	public void addVideo(Video video) {
		template.save(video);
	}

	@Override
	public List<Video> findVideo(DetachedCriteria dcv) {
		List<Video> list = (List<Video>) template.findByCriteria(dcv);
		return list;
	}

	@Override
	public void updataVideo(Video video) {
		template.update(video);
		
		
	}

	@Override
	public void deleteVideo(Video video) {
		template.delete(video);
			
		
	}

	@Override
	public void multiDeleteVideo(Video v) {
		template.delete(v);
		
	}

	
}
