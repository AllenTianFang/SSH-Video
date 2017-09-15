package com.zhiyou100.ssh_video.web.action.admin;

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
import com.zhiyou100.ssh_video.model.Speaker;
import com.zhiyou100.ssh_video.model.Video;
import com.zhiyou100.ssh_video.service.AdminSpeakerService;
import com.zhiyou100.ssh_video.utils.Page;

@Controller("AdminSpeakerAction")
@Scope(scopeName="prototype")
public class AdminSpeakerAction extends ActionSupport implements ModelDriven<Speaker>{
	@Autowired
	AdminSpeakerService ass;
	private Speaker speaker = new Speaker();
	private String speaker_name;
	private String speaker_job;
	private int page1;
	private String message;
	
	
	
	public String getSpeaker_name() {
		return speaker_name;
	}

    public void setSpeaker_name(String speaker_name) {
		this.speaker_name = speaker_name;
	}

    public String getSpeaker_job() {
		return speaker_job;
	}

    public void setSpeaker_job(String speaker_job) {
		this.speaker_job = speaker_job;
	}

    public int getPage1() {
		return page1;
	}

    public void setPage1(int page1) {
		this.page1 = page1;
	}

    public String getMessage() {
		return message;
	}

    public void setMessage(String message) {
		this.message = message;
	}

    @Override
	public Speaker getModel() {
		return speaker;
	}
    
   //查询speaker的列表包括模糊查询
    public String speakerList() throws Exception {
    	
    	if(page1 == 0){page1 = 1;}
    	
    	DetachedCriteria dcs1 = DetachedCriteria.forClass(Speaker.class);
    	DetachedCriteria dcs2 = DetachedCriteria.forClass(Speaker.class);
    	dcs1.setProjection(Projections.rowCount());
    	if(speaker_name != null){
    		dcs1.add(Restrictions.like("speakerName", speaker_name, MatchMode.ANYWHERE));
    		dcs2.add(Restrictions.like("speakerName", speaker_name, MatchMode.ANYWHERE));
    	}
    	if(speaker_job != null){
    		dcs1.add(Restrictions.like("speakerJob", speaker_job, MatchMode.ANYWHERE));
    		dcs2.add(Restrictions.like("speakerJob", speaker_job, MatchMode.ANYWHERE));
    	}
    	
    	ActionContext.getContext().put("speaker_name", speaker_name);
		ActionContext.getContext().put("speaker_job", speaker_job);
        
        Page<Speaker> list = ass.fingAllSpeaker(dcs1,dcs2,page1);
        ActionContext.getContext().put("page", list);
    	
    	return SUCCESS;
    }
    
    //添加speaker跳转至addJSP
     public String addSpeaker() throws Exception {
    	return SUCCESS;
    }
     
     //speaker的添加动作
     public String add() throws Exception {
    	ass.addSpeaker(speaker);
     	return SUCCESS;
     }
     
   //修改speaker并回填数据跳至jsp
     public String updateSpeaker() throws Exception {
    	 DetachedCriteria dcs = DetachedCriteria.forClass(Speaker.class);
    	 dcs.add(Restrictions.eq("id", speaker.getId()));
    	Speaker speaker = ass.findSpeakerById(dcs);
    	ActionContext.getContext().put("list", speaker);
    	return SUCCESS;
    }
     
     //speaker的更新动作
     public String update() throws Exception {
    	ass.updateSpeaker(speaker);
     	return SUCCESS;
     }
     
   //speaker的删除动作
     public String deleteSpeaker() throws Exception {
    	message = SUCCESS;
    	ass.deleteSpeaker(speaker);
     	return SUCCESS;
     }
    
    

}
