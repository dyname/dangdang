package com.wangxin.dang.actions.user;

import java.io.InputStream;

import com.wangxin.dang.actions.BaseAction;

public class ImageCodeAction extends BaseAction{
	//����
	//output
	private InputStream input;
	
	private int codeNumber;
	
	private StreamAction stream=new StreamAction();
	//����
	public String execute(){
//		System.out.println("imageCodeAction execute.");
//		System.out.println("session:"+session);
		//��̬����һ��ͼƬ
		//����result(stream)���output����
		this.input=stream.getInputStream(session,codeNumber);
		return "success";
	}
	public InputStream getInput() {
		return input;
	}
	public void setInput(InputStream input) {
		this.input = input;
	}
	public int getCodeNumber() {
		return codeNumber;
	}
	public void setCodeNumber(int codeNumber) {
		this.codeNumber = codeNumber;
	}


	
	
}
