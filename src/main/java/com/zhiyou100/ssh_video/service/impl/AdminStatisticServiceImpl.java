package com.zhiyou100.ssh_video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.ssh_video.dao.AdminStatisticDao;
import com.zhiyou100.ssh_video.service.AdminStatisticService;
@Service
public class AdminStatisticServiceImpl implements AdminStatisticService {
	@Autowired
	AdminStatisticDao asd;

	@Override
	public List<Object[]> findVideoMessage() {
		
		return asd.findVideoMessage();
		
	}

}
