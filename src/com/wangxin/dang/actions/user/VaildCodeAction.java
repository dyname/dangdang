package com.wangxin.dang.actions.user;

import com.wangxin.dang.actions.BaseAction;

public class VaildCodeAction extends BaseAction{
	//属性
	//input
	private String code;
	//output
	private boolean codeOk=false;
	
	//方法
	public String execute(){
		String code1=(String)session.get("number");
		//System.out.println("VaildCodeAction 15 code1:"+code1);
		//System.out.println("code:"+code);
		if(code1.equals(code)){
			codeOk=true;
		}else{
			codeOk=false;
		}
		//利用json的result类型的将结果输出
		return "success";
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public boolean isCodeOk() {
		return codeOk;
	}

	public void setCodeOk(boolean codeOk) {
		this.codeOk = codeOk;
	}

	
}
