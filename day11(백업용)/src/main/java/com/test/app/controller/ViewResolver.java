package com.test.app.controller;

public class ViewResolver {
	public String prefix; //접두사
	public String suffix; //접미사 --> .jsp 달아주기
	
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
