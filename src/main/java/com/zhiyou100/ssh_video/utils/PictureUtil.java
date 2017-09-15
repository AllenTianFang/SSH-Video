package com.zhiyou100.ssh_video.utils;

import java.io.File;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;

public class PictureUtil {
	
	private static final String PATH = "D:\\upload";
	private static final String FILE_PATH = "/pic/";
	
	public static String getFileName(String origcalName){
		String name = UUID.randomUUID().toString().replaceAll("-", "");
		String str = FilenameUtils.getExtension(origcalName);
		return name+"."+str;
	}
	
	public static String getFileUrl(String origcalName){
		return FILE_PATH+getFileName(origcalName);
	}
	
	public static File getFilePath(String FileUrl){
		String[] str = FileUrl.split("/");
		return new File(PATH+"\\"+str[2]);
	}

}
