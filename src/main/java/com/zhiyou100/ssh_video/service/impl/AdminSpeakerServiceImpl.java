package com.zhiyou100.ssh_video.service.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.ssh_video.dao.AdminSpeakerDao;
import com.zhiyou100.ssh_video.model.Speaker;
import com.zhiyou100.ssh_video.model.Video;
import com.zhiyou100.ssh_video.service.AdminSpeakerService;
import com.zhiyou100.ssh_video.utils.Page;
@Service
public class AdminSpeakerServiceImpl implements AdminSpeakerService {
	@Autowired
	AdminSpeakerDao asd;

	@Override
	public Page<Speaker> fingAllSpeaker(DetachedCriteria dcs1, DetachedCriteria dcs2, int page1) {
		Page<Speaker> pageInfo = new Page<>();
		pageInfo.setPage(page1);
		pageInfo.setSize(7);
		pageInfo.setTotal(asd.findCount(dcs1));
		pageInfo.setRows(asd.findAllSpeaker(dcs2,page1));
		return pageInfo;
	}

	@Override
	public void addSpeaker(Speaker speaker) {
		asd.addSpeaker(speaker);
		
	}

	@Override
	public Speaker findSpeakerById(DetachedCriteria dcs) {
		// TODO Auto-generated method stub
		return asd.findSpeakerById( dcs);
	}

	@Override
	public void updateSpeaker(Speaker speaker) {
		asd.updateSpeaker(speaker);
		
	}

	@Override
	public void deleteSpeaker(Speaker speaker) {
		asd.deleteSpeaker(speaker);
		
	}

	

}
