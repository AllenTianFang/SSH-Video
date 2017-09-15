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
import com.zhiyou100.ssh_video.model.Course;
import com.zhiyou100.ssh_video.model.Subject;
import com.zhiyou100.ssh_video.service.FrontCourseService;

@Controller("FrontCourseAction")
@Scope(scopeName="prototype")
public class FrontCourseAction extends ActionSupport implements ModelDriven<Course>{
	@Autowired
	FrontCourseService fcs;
	private Course course = new Course();
	
	
	
	@Override
	public Course getModel() {
		
		return course;
	}
	
	//查询课程,跳转至course的jsp的页面
	public String index() throws Exception {
		DetachedCriteria dcc = DetachedCriteria.forClass(Course.class);
		DetachedCriteria dcs = DetachedCriteria.forClass(Subject.class);
		dcc.add(Restrictions.eq("sub.id", course.getSub().getId()));
		dcs.add(Restrictions.eq("id", course.getSub().getId()));
		Subject subject = fcs.findSubject(dcs);
		List<Course> list = fcs.findAllCourseBySub(dcc);
		
		ActionContext.getContext().put("subject", subject);
		ActionContext.getContext().put("course", list);
		return SUCCESS;
	}


	

}
