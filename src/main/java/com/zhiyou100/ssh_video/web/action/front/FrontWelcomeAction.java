package com.zhiyou100.ssh_video.web.action.front;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
@Controller("FrontWelcomeAction")
@Scope(scopeName="prototype")
public class FrontWelcomeAction extends ActionSupport{
	
	
	public String index() throws Exception {

		return SUCCESS;
	}

}
