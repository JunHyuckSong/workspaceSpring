package com.test.app.board;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardClient {
	 public static void main(String[] args) {
	      AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
	      
	      BoardService bs=(BoardService)factory.getBean("boardService");
	      // �Խñ� �ۼ��ϱ� ��ư�� ����
	      // �Խñ� �ۼ� ������
	      // �Խñ��� �ۼ���
	      // �� ��� ��ư�� ����
	      BoardVO vo=new BoardVO();
	      vo.setContent("�ۼ��� ����");
	      vo.setTitle("�� ����");
	      vo.setWriter("�ۼ���");
	      bs.insertBoard(vo); // c�� insert ����Ͻ��޼��带 ����
	      // -> ���������δ� dao�� �ش� ������ ������
	      
	      factory.close();
	   }

}
