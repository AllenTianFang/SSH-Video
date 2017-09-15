package com.zhiyou100.ssh_video.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.zhiyou100.ssh_video.model.User;

public interface FrontUserService {

	List<User> findUserByEmail(DetachedCriteria dcu);

	void addUser(User user);

	List<User> findUserByPwd(DetachedCriteria dcu);

	User findUserById(DetachedCriteria dc);

	void updateUser(User user);

	boolean findUserByIdAndPwd(DetachedCriteria dc);

	void sendEmail(User user);

	List<User> findUserByCaptcha(DetachedCriteria dcu);

}
