package com.zhiyou100.ssh_video.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.ssh_video.dao.FrontUserDao;
import com.zhiyou100.ssh_video.model.User;
import com.zhiyou100.ssh_video.service.FrontUserService;
import com.zhiyou100.ssh_video.utils.MailUtil;
import com.zhiyou100.ssh_video.utils.RandomUtil;
@Service
public class FrontUserServiceImpl implements FrontUserService {
	@Autowired
	FrontUserDao fud;

	@Override
	public List<User> findUserByEmail(DetachedCriteria dcu) {
		
		return fud.findUserByEmail(dcu);
	}

	@Override
	public void addUser(User user) {
		fud.addUser(user);
		
	}

	@Override
	public List<User> findUserByPwd(DetachedCriteria dcu) {
		return fud.findUserByPwd(dcu);
	}

	@Override
	public User findUserById(DetachedCriteria dc) {
		// TODO Auto-generated method stub
		return fud.findUserById(dc);
	}

	@Override
	public void updateUser(User user) {
		fud.updateUser(user);
		
	}

	@Override
	public boolean findUserByIdAndPwd(DetachedCriteria dc) {
		boolean res = true;
		List<User> list = fud.findUserByIdAndPwd(dc);
		if(list.isEmpty()){
			res=false;
		}
		return res;
	}

	@Override
	public void sendEmail(User user){
		try {
			String str = RandomUtil.getRandomNumber()+"";
			MailUtil.send(user.getEmail(), "验证码", str);
			user.setCaptcha(str);
			System.out.println(user);
			fud.updateUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<User> findUserByCaptcha(DetachedCriteria dcu) {
		
		return fud.findUserByCaptcha(dcu);
	}

}
