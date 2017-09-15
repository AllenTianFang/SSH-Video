package com.zhiyou100.ssh_video.utils;



public class DateUtil {
	
	public static String dataFormate(Integer videoLength){
		Integer hour = videoLength / 3600;
    	Integer min =  videoLength % 3600 / 60;
    	Integer sec = videoLength % 60;
		return String.format("%02d : %02d : %02d", hour,min,sec);
	}
	
	

}
