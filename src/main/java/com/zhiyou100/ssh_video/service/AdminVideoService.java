package com.zhiyou100.ssh_video.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.zhiyou100.ssh_video.model.Course;
import com.zhiyou100.ssh_video.model.Speaker;
import com.zhiyou100.ssh_video.model.Video;
import com.zhiyou100.ssh_video.utils.Page;

public interface AdminVideoService {

	List<Speaker> findAllSpeaker(DetachedCriteria dcs);

	List<Course> findAllCourse(DetachedCriteria dcc);


	Page<Video> fingAllVideo(DetachedCriteria dcv, DetachedCriteria dcv2, int page1);

	void addVideo(Video video);

	

	List<Video> findVideo(DetachedCriteria dcv);

	void updateVideo(Video video);

	void deleteVideo(Video video);

	void multiDeleteVideo(Integer[] arr);

}
