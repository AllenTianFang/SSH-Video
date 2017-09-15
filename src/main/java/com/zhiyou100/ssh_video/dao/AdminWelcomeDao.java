package com.zhiyou100.ssh_video.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.zhiyou100.ssh_video.model.Admin;

public interface AdminWelcomeDao {

	List<Admin> findAdmin(DetachedCriteria dc);

}
