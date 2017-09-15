package com.zhiyou100.ssh_video.web.action.front;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zhiyou100.ssh_video.model.Subject;
import com.zhiyou100.ssh_video.model.Video;
import com.zhiyou100.ssh_video.service.FrontVideoService;

@Controller("FrontVideoAction")
@Scope(scopeName="prototype")
public class FrontVideoAction extends ActionSupport implements ModelDriven<Video>{
	@Autowired
	FrontVideoService fvs;
	private Video video = new Video();
	private Integer subjectId;
	
	
	
	
	public Integer getSubjectId() {
		return subjectId;
	}


	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}


	@Override
	public Video getModel() {
		return video;
	}
	
	
	public String index() throws Exception {
		DetachedCriteria dcs = DetachedCriteria.forClass(Subject.class);
		DetachedCriteria dcv = DetachedCriteria.forClass(Video.class);
		dcs.add(Restrictions.eq("id", subjectId));
		dcv.add(Restrictions.eq("id", video.getId()));
		Subject sub = fvs.findSubject(dcs);
		Video video = fvs.findVideo(dcv);
		ActionContext.getContext().put("subject", sub);
		ActionContext.getContext().put("video", video);
		return SUCCESS;
	}
	
	public String videoData() throws Exception {
		DetachedCriteria dcv = DetachedCriteria.forClass(Video.class);
		dcv.add(Restrictions.eq("id", video.getId()));
		Video video1 = fvs.findVideo(dcv);
		ActionContext.getContext().put("video", video1);
		
		DetachedCriteria dcs = DetachedCriteria.forClass(Subject.class);
		dcs.add(Restrictions.eq("id", subjectId));
		Subject sub = fvs.findSubject(dcs);
		ActionContext.getContext().put("subject", sub);
		
		DetachedCriteria dcv1 = DetachedCriteria.forClass(Video.class);
		dcv1.add(Restrictions.eq("course.id", video1.getCourse().getId()));
		List<Video> list = fvs.finDVideoByCid(dcv1);
		ActionContext.getContext().put("list", list);
		return SUCCESS;
	}
	
	public String state() throws Exception {
		DetachedCriteria dcv = DetachedCriteria.forClass(Video.class);
		dcv.add(Restrictions.eq("id", video.getId()));
		Video video1 = fvs.findVideo(dcv);
		
		video1.setVideoPlayTimes(video1.getVideoPlayTimes()+1);
		fvs.updateVideo(video1);
		return SUCCESS;
	}

}
