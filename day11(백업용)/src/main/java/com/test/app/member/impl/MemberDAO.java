package com.test.app.member.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.test.app.board.BoardVO;
import com.test.app.common.JDBCUtil;
import com.test.app.member.MemberVO;

@Repository("memberDAO") //일반적으로 이름(id)를 붙여준다. 
public class MemberDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private String member_selectOne = "select * from member22 where mid = ? and password = ?";
	
	public MemberVO selectOne(MemberVO vo) {
		MemberVO data = null;
		conn = JDBCUtil.connect();
		 try {
	         pstmt=conn.prepareStatement(member_selectOne);
	         pstmt.setString(1, vo.getMid());
	         pstmt.setString(2, vo.getPassword());
	         rs=pstmt.executeQuery();
	         if(rs.next()) {
	            data=new MemberVO();
	            data.setMid(rs.getString("mid"));
	            data.setName(rs.getString("name"));
	            data.setPassword(rs.getString("password"));
	            data.setRole(rs.getString("role"));
	            
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         JDBCUtil.disconnect(pstmt, conn);
	      }   
	      return data;
		
	}
	
}
