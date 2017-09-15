package com.zhiyou100.ssh_video.utils;

import java.util.Random;

public class RandomUtil {
	private static final Integer LIMIT_NUM=5;
	public static Integer getRandomNumber(){
		Integer minNum = (int)Math.pow(10, (LIMIT_NUM-1));
		Integer maxNum = (int)Math.pow(10, (LIMIT_NUM))-1;
		Random ran = new Random();
		return ran.nextInt(maxNum-minNum+1)+minNum;
	}

}
