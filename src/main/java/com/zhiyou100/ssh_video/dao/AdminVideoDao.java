package com.zhiyou100.ssh_video.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.zhiyou100.ssh_video.model.Course;
import com.zhiyou100.ssh_video.model.Speaker;
import com.zhiyou100.ssh_video.model.Video;

public interface AdminVideoDao {

	List<Speaker> findAllSpeaker(DetachedCriteria dcs);

	List<Course> findAllCourse(DetachedCriteria dcc);

	

	int findCount(DetachedCriteria dcv1);

	List<Video> findAllVideo(DetachedCriteria dcv2, int page1);

	void addVideo(Video video);

	List<Video> findVideo(DetachedCriteria dcv);

	void updataVideo(Video video);

	void deleteVideo(Video video);

	void multiDeleteVideo(Video v);


}
