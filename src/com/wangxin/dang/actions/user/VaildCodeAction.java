package com.wangxin.dang.actions.user;

import com.wangxin.dang.actions.BaseAction;

public class VaildCodeAction extends BaseAction{
	//����
	//input
	private String code;
	//output
	private boolean codeOk=false;
	
	//����
	public String execute(){
		String code1=(String)session.get("number");
		//System.out.println("VaildCodeAction 15 code1:"+code1);
		//System.out.println("code:"+code);
		if(code1.equals(code)){
			codeOk=true;
		}else{
			codeOk=false;
		}
		//����json��result���͵Ľ�������
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
