package com.test.app.member;

public interface MemberService {
	public MemberVO selectOne(MemberVO vo);
	public void insertMember(MemberVO vo);
	public void updateMember(MemberVO vo);
}
