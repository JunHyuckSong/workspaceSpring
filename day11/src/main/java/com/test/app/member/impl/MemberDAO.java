package com.test.app.member.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.test.app.board.BoardVO;
import com.test.app.common.JDBCUtil;
import com.test.app.member.MemberVO;

//@Repository("memberDAO") //일반적으로 이름(id)를 붙여준다. 
public class MemberDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private String member_selectOne = "select * from member22 where mid = ? and password = ?";
	private String member_update = "update member22 set password=?,mname=? where mid = ?";
	
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
	            data.setMname(rs.getString("mname"));
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
	
	public void updateMember(MemberVO vo) {
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(member_update);
			//update member22 set password=?,mname=? where mid = ?
			pstmt.setString(1, vo.getPassword());
			pstmt.setString(2, vo.getMname());
			pstmt.setString(3, vo.getMid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
	}
	
	
}
