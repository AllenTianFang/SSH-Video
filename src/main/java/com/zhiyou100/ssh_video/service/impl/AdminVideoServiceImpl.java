package com.zhiyou100.ssh_video.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.ssh_video.dao.AdminVideoDao;
import com.zhiyou100.ssh_video.model.Course;
import com.zhiyou100.ssh_video.model.Speaker;
import com.zhiyou100.ssh_video.model.Video;
import com.zhiyou100.ssh_video.service.AdminVideoService;
import com.zhiyou100.ssh_video.utils.Page;
@Service
public class AdminVideoServiceImpl implements AdminVideoService {
	@Autowired
	AdminVideoDao avd;

	@Override
	public List<Speaker> findAllSpeaker(DetachedCriteria dcs) {
		return avd.findAllSpeaker( dcs);
	}

	@Override
	public List<Course> findAllCourse(DetachedCriteria dcc) {
		return avd.findAllCourse(dcc);
	}

	

	@Override
	public Page<Video> fingAllVideo(DetachedCriteria dcv1,DetachedCriteria dcv2, int page1) {
		Page<Video> pageInfo = new Page<>();
		pageInfo.setPage(page1);
		pageInfo.setSize(7);
		pageInfo.setTotal(avd.findCount(dcv1));
		pageInfo.setRows(avd.findAllVideo(dcv2,page1));
		return pageInfo;
	}

	@Override
	public void addVideo(Video video) {
		avd.addVideo(video);
		
	}

	@Override
	public List<Video> findVideo(DetachedCriteria dcv) {
		
		return avd.findVideo( dcv);
	}

	@Override
	public void updateVideo(Video video) {
		avd.updataVideo(video);
		
	}

	@Override
	public void deleteVideo(Video video) {
		avd.deleteVideo( video);
		
	}

	@Override
	public void multiDeleteVideo(Integer[] arr) {
		
		for(int i = 0;i < arr.length;i++){
			Video v = new Video();
			v.setId(arr[i]);
			avd.multiDeleteVideo(v);
		}
		
	}

	

}
