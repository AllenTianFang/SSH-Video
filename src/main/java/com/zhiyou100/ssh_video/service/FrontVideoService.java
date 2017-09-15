package com.zhiyou100.ssh_video.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.zhiyou100.ssh_video.model.Subject;
import com.zhiyou100.ssh_video.model.Video;

public interface FrontVideoService {

	Subject findSubject(DetachedCriteria dcs);

	Video findVideo(DetachedCriteria dcv);

	List<Video> finDVideoByCid(DetachedCriteria dcv1);

	void updateVideo(Video video1);

}
