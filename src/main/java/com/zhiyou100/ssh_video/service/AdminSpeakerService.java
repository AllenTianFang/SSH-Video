package com.zhiyou100.ssh_video.service;

import org.hibernate.criterion.DetachedCriteria;

import com.zhiyou100.ssh_video.model.Speaker;
import com.zhiyou100.ssh_video.model.Video;
import com.zhiyou100.ssh_video.utils.Page;

public interface AdminSpeakerService {

	Page<Speaker> fingAllSpeaker(DetachedCriteria dcs1, DetachedCriteria dcs2, int page1);

	void addSpeaker(Speaker speaker);

	Speaker findSpeakerById(DetachedCriteria dcs);

	void updateSpeaker(Speaker speaker);

	void deleteSpeaker(Speaker speaker);

}
