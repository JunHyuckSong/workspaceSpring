package com.test.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	String handleRequest(HttpServletRequest request, HttpServletResponse response);
	// : request, response ������� ��û������ �޾Ƽ� ȭ�� �׺���̼�
	//parameter�� request, response�� ���� -> request.getParameter�� ������
	//��ȯŸ���� String�� ���� -> '���'�� ������ View�� �Ѱ�����ϴϱ�.. ��δ� StringŸ���̴�.
	
	
}