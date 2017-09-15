package com.zhiyou100.ssh_video.web.action.front;

import java.io.File;
import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zhiyou100.ssh_video.model.ResuleJson;
import com.zhiyou100.ssh_video.model.User;
import com.zhiyou100.ssh_video.service.FrontUserService;
import com.zhiyou100.ssh_video.utils.MD5Utils;
import com.zhiyou100.ssh_video.utils.PictureUtil;

@Controller("FrontUserAction")
@Scope(scopeName="prototype")
public class FrontUserAction extends ActionSupport implements ModelDriven<User>{
	@Autowired
	FrontUserService fus;
	private User user = new User();
	private ResuleJson result = new ResuleJson();
	private File image_file;
	private String image_fileFileName;
	private String image_fileContentType;

	
	
	
	public String getImage_fileContentType() {
		return image_fileContentType;
	}

	public void setImage_fileContentType(String image_fileContentType) {
		this.image_fileContentType = image_fileContentType;
	}

	public File getImage_file() {
		return image_file;
	}

	public void setImage_file(File image_file) {
		this.image_file = image_file;
	}

	public String getImage_fileFileName() {
		return image_fileFileName;
	}

	public void setImage_fileFileName(String image_fileFileName) {
		this.image_fileFileName = image_fileFileName;
	}

	public ResuleJson getResult() {
		return result;
	}

	public void setResult(ResuleJson result) {
		this.result = result;
	}

	@Override
	public User getModel() {
		return user;
	}
	
	//用户注册
	public String regist() throws Exception {
		DetachedCriteria dcu = DetachedCriteria.forClass(User.class);
		dcu.add(Restrictions.eq("email", user.getEmail()));
		List<User> list = fus.findUserByEmail(dcu);
		if(list.isEmpty()){
			result.setSuccess(true);
			user.setPassword(MD5Utils.getMD5(user.getPassword()));
			user.setInsertTime(new Timestamp(System.currentTimeMillis()));
			fus.addUser(user);
		}else{
			result.setSuccess(false);
			result.setMessage("email is have");
		}
		return SUCCESS;
	}
	
	//用户登录
	public String login() throws Exception {
		user.setPassword(MD5Utils.getMD5(user.getPassword()));
		DetachedCriteria dcu = DetachedCriteria.forClass(User.class);
		dcu.add(Restrictions.eq("email", user.getEmail())).add(Restrictions.eq("password", user.getPassword()));
		List<User> list = fus.findUserByPwd(dcu);
		if(list.isEmpty()){
			result.setSuccess(false);
			result.setMessage("email or password is error");
		}else{
			result.setSuccess(true);
			ActionContext.getContext().getSession().put("_front_user", list.get(0));
		}
		return SUCCESS;
	}
	
	//用户退出
	public String logout() throws Exception {
		ActionContext.getContext().getSession().remove("_front_user");
		return SUCCESS;
	}
	
	
	//用户个人中心退出
	public String logoutUser() throws Exception {
		ActionContext.getContext().getSession().remove("user");
		return SUCCESS;
	}
	
	//更新session
	private  void select(){
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		dc.add(Restrictions.eq("id", user.getId()));
		User u = fus.findUserById(dc);
		ActionContext.getContext().getSession().put("user", u);
	}
	
	//用户详情,放入session,回填数据,显示页面
	public String user() throws Exception {
		select();
		return SUCCESS;
	}
	
	//跳转至修改个人信息页面
	public String profile() throws Exception {
		
		return SUCCESS;
	}
	
	//修改个人信息,跳转至首页面
	public String profile2() throws Exception {
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		dc.add(Restrictions.eq("id", user.getId()));
		User u = fus.findUserById(dc);
		u.setProperty(user);
		fus.updateUser(u);	
		return SUCCESS;
	}
	
	//跳转至修改头像页面
	public String avatar() throws Exception {
			
		return SUCCESS;
	}
		
	//修改头像,跳转至首页面
	public String avatar2() throws Exception {
		String url = PictureUtil.getFileUrl(image_fileFileName);
		FileUtils.copyFile(new File(image_file.getAbsolutePath()), PictureUtil.getFilePath(url));
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		dc.add(Restrictions.eq("id", user.getId()));
		User u = fus.findUserById(dc);
        u.setHeadUrl(url);
        u.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        fus.updateUser(u);
		return SUCCESS;
	}

	
	//跳转至修改密码页面
	public String password() throws Exception {
				
		return SUCCESS;
	}
	
	//ajax判断原始密码是否正确,正确才能提交
	public String passwordJuge() throws Exception {
		user.setPassword(MD5Utils.getMD5(user.getPassword()));
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		dc.add(Restrictions.eq("id", user.getId())).add(Restrictions.eq("password", user.getPassword()));
		if(fus.findUserByIdAndPwd(dc)){
			result.setSuccess(false);
		}else{
			result.setSuccess(true);
		}
		return SUCCESS;
	}
			
	//修改密码,跳转至首页面
	public String password2() throws Exception {
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		dc.add(Restrictions.eq("id", user.getId()));
		User u = fus.findUserById(dc);
		u.setPassword(MD5Utils.getMD5(user.getPassword()));
		u.setUpdateTime(new Timestamp(System.currentTimeMillis()));
		fus.updateUser(u);
		return SUCCESS;
	}
	
	//跳转至忘记密码页面
	public String forgetpwd() throws Exception {
					
		return SUCCESS;
	}
		
	//ajax验证邮箱是否注册
	public String sendemail() throws Exception {
		DetachedCriteria dcu = DetachedCriteria.forClass(User.class);
		dcu.add(Restrictions.eq("email", user.getEmail()));
		List<User> list = fus.findUserByEmail(dcu);
		if(list.isEmpty()){
			result.setSuccess(false);
			result.setMessage("邮箱未注册");
		}else{
			result.setSuccess(true);
			fus.sendEmail(list.get(0));
		}
		return SUCCESS;
	}
		
	//判断验证码是否正确
	public String forgetpwd2() throws Exception {
		DetachedCriteria dcu = DetachedCriteria.forClass(User.class);
		dcu.add(Restrictions.eq("email", user.getEmail())).add(Restrictions.eq("captcha", user.getCaptcha()));
		List<User> list = fus.findUserByCaptcha(dcu);
		if(list.isEmpty()){
			ActionContext.getContext().put("title", "验证码错误,请重新发送");
			return "fail";
		}else{
			ActionContext.getContext().put("user", list.get(0));
			return SUCCESS;
		}
	}
		
	//重置密码
	public String resetpwd() throws Exception {
		System.out.println(user.getId());
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		dc.add(Restrictions.eq("id", user.getId()));
		User u = fus.findUserById(dc);
		u.setPassword(MD5Utils.getMD5(user.getPassword()));
		u.setUpdateTime(new Timestamp(System.currentTimeMillis()));
		fus.updateUser(u);
		return SUCCESS;
	}
}
