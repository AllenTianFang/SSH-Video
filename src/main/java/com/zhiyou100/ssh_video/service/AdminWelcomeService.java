package com.zhiyou100.ssh_video.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.zhiyou100.ssh_video.model.Admin;

public interface AdminWelcomeService {

	List<Admin> findAdmin(DetachedCriteria dc);

}
