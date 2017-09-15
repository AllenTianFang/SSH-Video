package com.zhiyou100.ssh_video.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.ssh_video.dao.FrontVideoDao;
import com.zhiyou100.ssh_video.model.Subject;
import com.zhiyou100.ssh_video.model.Video;
import com.zhiyou100.ssh_video.service.FrontVideoService;
@Service
public class FrontVideoServiceImpl implements FrontVideoService {
	@Autowired
	FrontVideoDao fvd;

	@Override
	public Subject findSubject(DetachedCriteria dcs) {
		return fvd.findSubject(dcs);
	}

	@Override
	public Video findVideo(DetachedCriteria dcv) {
		return fvd.findVideo(dcv);
	}

	@Override
	public List<Video> finDVideoByCid(DetachedCriteria dcv1) {
		return fvd.finDVideoByCid( dcv1);
	}

	@Override
	public void updateVideo(Video video1) {
		fvd.updateVideo( video1);
		
	}

}
