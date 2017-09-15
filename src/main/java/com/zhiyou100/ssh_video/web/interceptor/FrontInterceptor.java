package com.zhiyou100.ssh_video.web.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.zhiyou100.ssh_video.model.User;

public class FrontInterceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation arg0) throws Exception {
		String str = null;
		User user = (User) ActionContext.getContext().getSession().get("_front_user");
		if(user != null){
			str = arg0.invoke();
		}else{
			str = "index";
		}
		return str;
	}

}
