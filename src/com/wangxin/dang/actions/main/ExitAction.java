package com.wangxin.dang.actions.main;

import com.wangxin.dang.actions.BaseAction;

public class ExitAction extends BaseAction {
	
	public String execute(){
		session.clear();
		return "success";
	}
}
