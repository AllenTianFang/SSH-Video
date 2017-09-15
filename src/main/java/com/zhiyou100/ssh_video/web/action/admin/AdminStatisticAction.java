package com.zhiyou100.ssh_video.web.action.admin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhiyou100.ssh_video.model.ResuleJson;
import com.zhiyou100.ssh_video.service.AdminStatisticService;

@Controller("AdminStatisticAction")
@Scope(scopeName="prototype")
public class AdminStatisticAction extends ActionSupport {
	@Autowired
	AdminStatisticService ass;
	
	private ResuleJson result = new ResuleJson();
	
	
	
	
	public ResuleJson getResult() {
		return result;
	}




	public void setResult(ResuleJson result) {
		this.result = result;
	}




	//statistic查询数据回填
	public String statistic() throws Exception {
		List<Object[]> list = ass.findVideoMessage();
		
		StringBuilder times = new StringBuilder();
		times.append("["+list.get(0)[1]);
		for(int a= 1;a<list.size();a++){
			times.append(","+list.get(a)[1]);
		}
		times.append("]");
		
		StringBuilder sb = new StringBuilder();
		sb.append("[\""+list.get(0)[0]+"\"");
		for(int a= 1;a<list.size();a++){
			sb.append(",\""+list.get(a)[0]+"\"");
		}
		sb.append("]");
		
		ActionContext.getContext().put("courseName", sb);
		ActionContext.getContext().put("avgTimes", times);
		System.out.println(times);
		return SUCCESS;
	}

	//ajxa请求
	public String statisticAjax() throws Exception {
		List<Object[]> list = ass.findVideoMessage();
		
		for(int i = 0 ;i < list.size();i++){
			result.getCourseName().add((String) list.get(i)[0]);
			result.getPlayTimes().add(list.get(i)[1]);
		}
		return SUCCESS;
	}
}
