package com.zhiyou100.ssh_video.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.zhiyou100.ssh_video.dao.AdminSpeakerDao;
import com.zhiyou100.ssh_video.model.Speaker;
@Repository
public class AdminSpeakerDaoImpl implements AdminSpeakerDao {
	@Autowired
	HibernateTemplate template;

	@Override
	public int findCount(DetachedCriteria dcs1) {
		List<Number> num = (List<Number>) template.findByCriteria(dcs1);
		return num.get(0).intValue();
	}

	@Override
	public List<Speaker> findAllSpeaker(DetachedCriteria dcs2, int page1) {
		List<Speaker> list = (List<Speaker>) template.findByCriteria(dcs2, (page1-1)*7, 7);
		return list;
	}

	@Override
	public void addSpeaker(Speaker speaker) {
		template.save(speaker);
		
	}

	

	@Override
	public Speaker findSpeakerById(DetachedCriteria dcs) {
		List<Speaker> list = (List<Speaker>) template.findByCriteria(dcs);
		return list.get(0);
	}

	@Override
	public void updateSpeaker(Speaker speaker) {
		template.update(speaker);
		
	}

	@Override
	public void deleteSpeaker(Speaker speaker) {
		template.delete(speaker);
		
	}

}
