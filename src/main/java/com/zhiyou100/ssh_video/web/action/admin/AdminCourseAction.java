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
import com.zhiyou100.ssh_video.model.Subject;
import com.zhiyou100.ssh_video.service.AdminCourseService;
import com.zhiyou100.ssh_video.utils.Page;

@Controller("AdminCourseAction")
@Scope(scopeName="prototype")
public class AdminCourseAction extends ActionSupport implements ModelDriven<Course>{
	@Autowired
	AdminCourseService acs;
	private Course course = new Course();
	private int page1;
	private String message;
	
	
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
	public Course getModel() {
		return course;
	}
	
	//查询course的列表包括模糊查询
    public String courseList() throws Exception {
    	if(page1 == 0){ page1 = 1;}
    	DetachedCriteria dcc1 = DetachedCriteria.forClass(Course.class);
    	DetachedCriteria dcc2 = DetachedCriteria.forClass(Course.class);
    	dcc1.setProjection(Projections.rowCount());
    	Page<Course> page = acs.findAllCourse(dcc1,dcc2,page1);
    	ActionContext.getContext().put("page", page);
    	return SUCCESS;
    }
    
    //添加course跳转至addJSP
     public String addCourse() throws Exception {
    	DetachedCriteria dcs = DetachedCriteria.forClass(Subject.class);
    	List<Subject> list = acs.findSubject(dcs);
    	ActionContext.getContext().put("subject", list);
    	return SUCCESS;
    }
     
     //course的添加动作
     public String add() throws Exception {
    	acs.addCourse(course);
     	return SUCCESS;
     }
     
   //修改course并回填数据跳至jsp
     public String updateCourse() throws Exception {
    	DetachedCriteria dcs = DetachedCriteria.forClass(Subject.class);
     	List<Subject> list = acs.findSubject(dcs);
     	ActionContext.getContext().put("subject", list);
     	DetachedCriteria dcc = DetachedCriteria.forClass(Course.class);
     	dcc.add(Restrictions.eq("id", course.getId()));
     	Course course = acs.findCourseById(dcc);
     	ActionContext.getContext().put("list", course);
    	return SUCCESS;
    }
     
     //course的更新动作
     public String update() throws Exception {
    	acs.updateCourse(course);
     	return SUCCESS;
     }
     
   //speaker的删除动作
     public String deleteCourse() throws Exception {
    	 message = SUCCESS;
    	acs.deleteCourse(course);
     	return SUCCESS;
     }

}
