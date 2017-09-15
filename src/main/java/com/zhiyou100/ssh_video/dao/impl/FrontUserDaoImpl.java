package com.zhiyou100.ssh_video.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.zhiyou100.ssh_video.dao.FrontUserDao;
import com.zhiyou100.ssh_video.model.User;
@Repository
public class FrontUserDaoImpl implements FrontUserDao {
	@Autowired
	HibernateTemplate template;

	@Override
	public List<User> findUserByEmail(DetachedCriteria dcu) {
		List<User> list = (List<User>) template.findByCriteria(dcu);
		return list;
	}

	@Override
	public void addUser(User user) {
		template.save(user);
		
	}

	@Override
	public List<User> findUserByPwd(DetachedCriteria dcu) {
		List<User> list = (List<User>) template.findByCriteria(dcu);
		return list;
	}

	@Override
	public User findUserById(DetachedCriteria dc) {
		List<User> list = (List<User>) template.findByCriteria(dc);
		
		return list.get(0);
	}

	@Override
	public void updateUser(User user) {
		template.update(user);
		
	}

	@Override
	public List<User> findUserByIdAndPwd(DetachedCriteria dc) {
		List<User> list = (List<User>) template.findByCriteria(dc);
		return list;
	}

	@Override
	public List<User> findUserByCaptcha(DetachedCriteria dcu) {
		List<User> list = (List<User>) template.findByCriteria(dcu);
		return list;
	}

}
