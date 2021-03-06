package com.test.app.member.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.app.member.MemberService;
import com.test.app.member.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDAO memberDAO;// dao를 사용하기 위한 "맴버변수" 선언
	
	
	public MemberDAO getMemberDAO() {
		return memberDAO;
	}
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}



	@Override
	public MemberVO selectOne(MemberVO vo) {
		// TODO Auto-generated method stub
		return memberDAO.selectOne(vo);
	}

}


// 1.applicationContext.xml에서 setter로 의존성 주입
//		- setter를 구현해야하는 곳?? == "impl"	
// 2.어노테이션 사용




