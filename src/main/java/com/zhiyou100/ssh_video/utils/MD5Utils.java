package com.zhiyou100.ssh_video.utils;

import org.springframework.util.DigestUtils;

public class MD5Utils {
	
	public static String getMD5(String str){
		String rstr = null;
		rstr = DigestUtils.md5DigestAsHex(str.getBytes());
		return rstr;
	}

}
