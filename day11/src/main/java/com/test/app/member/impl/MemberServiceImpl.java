package com.test.app.member.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.app.member.MemberService;
import com.test.app.member.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDAO2 memberDAO;// dao�� ����ϱ� ���� "�ɹ�����" ����
	
	
	/*public MemberDAO getMemberDAO() {
		return memberDAO;
	}
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}*/



	@Override
	public MemberVO selectOne(MemberVO vo) {
		// TODO Auto-generated method stub
		try {
			return memberDAO.selectOne(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
		}
	}


	@Override
	public void insertMember(MemberVO vo) {
		try {
			memberDAO.insertMember(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("insert Ʈ����� �����߻�");
		}
	}

}


// 1.applicationContext.xml���� setter�� ������ ����
//		- setter�� �����ؾ��ϴ� ��?? == "impl"	
// 2.������̼� ���




