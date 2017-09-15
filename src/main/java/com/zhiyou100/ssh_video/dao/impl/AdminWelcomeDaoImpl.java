package com.zhiyou100.ssh_video.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.zhiyou100.ssh_video.dao.AdminWelcomeDao;
import com.zhiyou100.ssh_video.model.Admin;
@Repository
public class AdminWelcomeDaoImpl implements AdminWelcomeDao {
	@Autowired
	private HibernateTemplate template;

	@Override
	public List<Admin> findAdmin(DetachedCriteria dc) {
		List<Admin> list = (List<Admin>) template.findByCriteria(dc);
		return list;
	}

}
