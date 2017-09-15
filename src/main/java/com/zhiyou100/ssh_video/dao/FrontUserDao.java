package com.zhiyou100.ssh_video.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.zhiyou100.ssh_video.model.User;

public interface FrontUserDao {

	List<User> findUserByEmail(DetachedCriteria dcu);

	void addUser(User user);

	List<User> findUserByPwd(DetachedCriteria dcu);

	User findUserById(DetachedCriteria dc);

	void updateUser(User user);

	List<User> findUserByIdAndPwd(DetachedCriteria dc);

	List<User> findUserByCaptcha(DetachedCriteria dcu);

}
