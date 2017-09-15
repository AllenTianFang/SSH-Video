package com.zhiyou100.ssh_video.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.zhiyou100.ssh_video.dao.FrontVideoDao;
import com.zhiyou100.ssh_video.model.Subject;
import com.zhiyou100.ssh_video.model.Video;
@Repository
public class FrontVideoDaoImpl implements FrontVideoDao {
	@Autowired
	HibernateTemplate template;

	@Override
	public Subject findSubject(DetachedCriteria dcs) {
		List<Subject> list = (List<Subject>) template.findByCriteria(dcs);
		return list.get(0);
	}

	@Override
	public Video findVideo(DetachedCriteria dcv) {
		List<Video> list = (List<Video>) template.findByCriteria(dcv);
		return list.get(0);
	}

	@Override
	public List<Video> finDVideoByCid(DetachedCriteria dcv1) {
		List<Video> list = (List<Video>) template.findByCriteria(dcv1);
		return list;
	}

	@Override
	public void updateVideo(Video video1) {
		template.update(video1);
		
	}

}
