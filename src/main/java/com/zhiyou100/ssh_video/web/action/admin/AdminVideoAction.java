package com.zhiyou100.ssh_video.web.action.admin;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zhiyou100.ssh_video.model.Course;
import com.zhiyou100.ssh_video.model.Speaker;
import com.zhiyou100.ssh_video.model.Video;
import com.zhiyou100.ssh_video.service.AdminVideoService;
import com.zhiyou100.ssh_video.utils.Page;

@Controller("AdminVideoAction")
@Scope(scopeName="prototype")
public class AdminVideoAction extends ActionSupport implements ModelDriven<Video>{
	@Autowired
	AdminVideoService avs;
	
	private Video video = new Video();
	private int speaker_id;
	private int course_id;
	private int page1 ;
	private String video_title;
	private String message;
	private Integer [] check;
	
	
	


	public Integer[] getCheck() {
		return check;
	}


	public void setCheck(Integer[] check) {
		this.check = check;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public int getSpeaker_id() {
		return speaker_id;
	}


	public void setSpeaker_id(int speaker_id) {
		this.speaker_id = speaker_id;
	}


	public int getCourse_id() {
		return course_id;
	}


	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}


	public int getPage1() {
		return page1;
	}


	public void setPage1(int page1) {
		this.page1 = page1;
	}


	public String getVideo_title() {
		return video_title;
	}


	public void setVideo_title(String video_title) {
		this.video_title = video_title;
	}
	
	@Override
	public Video getModel() {
		// TODO Auto-generated method stub
		return video;
	}


	public String videoList() throws Exception {
		
		if(video_title == null){
			video_title = "";
		}
		if(page1 == 0){
			page1 = 1;
		}
		DetachedCriteria dcv1 = DetachedCriteria.forClass(Video.class);//count
		DetachedCriteria dcv2= DetachedCriteria.forClass(Video.class);//list
		
		DetachedCriteria dcs = DetachedCriteria.forClass(Speaker.class);
		DetachedCriteria dcc = DetachedCriteria.forClass(Course.class);
        
		List<Speaker> speaker = avs.findAllSpeaker(dcs);
        ActionContext.getContext().put("speaker", speaker);
        List<Course> course = avs.findAllCourse(dcc);
        ActionContext.getContext().put("course", course);
        
       dcv1.setProjection(Projections.rowCount());
        if(speaker_id != 0){
        	dcv1.add(Restrictions.eq("speaker.id", speaker_id));
        	dcv2.add(Restrictions.eq("speaker.id", speaker_id));
        }
        if(course_id != 0 ){
        	dcv1.add(Restrictions.eq("course.id", course_id));
        	dcv2.add(Restrictions.eq("course.id", course_id));
        }
        if(video_title != null && video_title != ""){
        	dcv1.add(Restrictions.like("videoTitle", video_title, MatchMode.ANYWHERE));
            dcv2.add(Restrictions.like("videoTitle", video_title,MatchMode.ANYWHERE));
        }
        ActionContext.getContext().put("cid", course_id);
		ActionContext.getContext().put("sid", speaker_id);
		ActionContext.getContext().put("title", video_title);
        
        Page<Video> list = avs.fingAllVideo(dcv1,dcv2,page1);
        ActionContext.getContext().put("page", list);
        
		return SUCCESS;
	}
	
	public String addVideo() throws Exception{
		
		DetachedCriteria dcs = DetachedCriteria.forClass(Speaker.class);
		DetachedCriteria dcc = DetachedCriteria.forClass(Course.class);
        
		List<Speaker> speaker = avs.findAllSpeaker(dcs);
        ActionContext.getContext().put("speaker", speaker);
        List<Course> course = avs.findAllCourse(dcc);
        ActionContext.getContext().put("course", course);
		return SUCCESS;
	}
    public String add() throws Exception{
		avs.addVideo(video);
		return SUCCESS;
	}
    public String updateVideo() throws Exception{
		
		DetachedCriteria dcs = DetachedCriteria.forClass(Speaker.class);
		DetachedCriteria dcc = DetachedCriteria.forClass(Course.class);
		DetachedCriteria dcv = DetachedCriteria.forClass(Video.class);
		List<Speaker> speaker = avs.findAllSpeaker(dcs);
        ActionContext.getContext().put("speaker", speaker);
        List<Course> course = avs.findAllCourse(dcc);
        ActionContext.getContext().put("course", course);
        dcv.add(Restrictions.eq("id", video.getId()));
        List<Video> video = avs.findVideo(dcv);
        ActionContext.getContext().put("list", video.get(0));
		return SUCCESS;
	}
    public String update() throws Exception{
		avs.updateVideo(video);
		return SUCCESS;
	}
    public String deleteVideo() throws Exception{
    	message = SUCCESS;
		avs.deleteVideo(video);
		return SUCCESS;
	}
    public String multiDeleteVideo() throws Exception{
		avs.multiDeleteVideo(check);
		return SUCCESS;
	}




}
