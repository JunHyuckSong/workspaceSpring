package com.test.app.controller;

public class ViewResolver {
	public String prefix; //���λ�
	public String suffix; //���̻� --> .jsp �޾��ֱ�
	
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	
	public String getView(String viewName) {
		return prefix + viewName + suffix;
	}
	
	
}
