package com.zhiyou100.ssh_video.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.ssh_video.dao.AdminWelcomeDao;
import com.zhiyou100.ssh_video.model.Admin;
import com.zhiyou100.ssh_video.service.AdminWelcomeService;
@Service
public class AdminWelcomeServiceImpl implements AdminWelcomeService {
	@Autowired
	AdminWelcomeDao awd;

	@Override
	public List<Admin> findAdmin(DetachedCriteria dc) {
		// TODO Auto-generated method stub
		return awd.findAdmin(dc);
	}

}
