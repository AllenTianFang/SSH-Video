package com.zhiyou100.ssh_video.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.zhiyou100.ssh_video.model.Speaker;

public interface AdminSpeakerDao {

	int findCount(DetachedCriteria dcs1);

	List<Speaker> findAllSpeaker(DetachedCriteria dcs2, int page1);

	void addSpeaker(Speaker speaker);


	Speaker findSpeakerById(DetachedCriteria dcs);

	void updateSpeaker(Speaker speaker);

	void deleteSpeaker(Speaker speaker);


}
