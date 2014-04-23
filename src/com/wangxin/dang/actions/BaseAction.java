package com.wangxin.dang.actions;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

public class BaseAction implements SessionAware, ServletRequestAware,ServletResponseAware{
	protected Map<String, Object> session;
	protected HttpServletRequest httpRequest;
	protected HttpServletResponse httpResponse;
	
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setServletRequest(HttpServletRequest httpRequest) {
		this.httpRequest = httpRequest;
	}

	public void setServletResponse(HttpServletResponse httpResponse) {
		this.httpResponse=httpResponse;
	}
	

}