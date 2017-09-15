package com.zhiyou100.ssh_video.web.action.admin;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zhiyou100.ssh_video.model.Admin;
import com.zhiyou100.ssh_video.service.AdminWelcomeService;
import com.zhiyou100.ssh_video.utils.MD5Utils;
@Controller("AdminWelcomeAction")
@Scope(scopeName="prototype")
public class AdminWelcomeAction extends ActionSupport implements ModelDriven<Admin>{
	@Autowired
	AdminWelcomeService aws;
	
	private static final String FAIL = "fail";
	
	private Admin admin = new Admin();
	
	@Override
	public Admin getModel() {
		return admin;
	}
	
	public String index() throws Exception {
		return SUCCESS;
	}
	public String login() throws Exception {
		admin.setLoginPwd(MD5Utils.getMD5(admin.getLoginPwd()));
		DetachedCriteria dc = DetachedCriteria.forClass(Admin.class);
		dc.add(Restrictions.eq("loginName", admin.getLoginName())).add(Restrictions.eq("loginPwd", admin.getLoginPwd()));
		List<Admin> list =(List<Admin>) aws.findAdmin(dc);
		if(list.isEmpty()){
			ActionContext.getContext().put("result", "用户名或密码错误");
			return FAIL;
		}else{
			ActionContext.getContext().getSession().put("admin", list.get(0));
			return SUCCESS;
		}
		
	}
	
	public String adminLogout() throws Exception {
		ActionContext.getContext().getSession().remove("admin");
		return SUCCESS;
	}
	

}
