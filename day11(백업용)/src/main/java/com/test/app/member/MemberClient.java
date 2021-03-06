package com.test.app.member;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.test.app.board.BoardService;
import com.test.app.board.BoardVO;

public class MemberClient {
	public static void main(String[] args) {
	      AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
	      
	      MemberService ms = (MemberService) factory.getBean("memberService");
	      MemberVO vo = new MemberVO();
	      vo.setMid("song"); // 현재 이 부분은 DB에 추가하지 않았으므로 실행이 안됨.
	      vo.setPassword("1234");
	      MemberVO data = ms.selectOne(vo);
	      if(data==null) {
	    	  System.out.println("로그인 실패");
	      }
	      else{
	    	  System.out.println("로그인 성공 " + data.getMid() + "님 반갑습니다.");
	      }
	      
	      factory.close();
	   }
}
