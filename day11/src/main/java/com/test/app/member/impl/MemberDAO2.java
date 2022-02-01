package com.test.app.member.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import org.springframework.stereotype.Repository;

import com.test.app.member.MemberVO;

@Repository("memberDAO")
public class MemberDAO2 {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private String member_selectOne = "select * from member22 where mid = ? and password = ?";
	private String member_insert = "insert into member22 values(?,?,?,?)";
	private String member_update = "update member22 set password=?,mname=? where mid = ?";
	
	public MemberVO selectOne(MemberVO vo) throws Exception{
		System.out.println("DAO2 : selectOne ½ÇÇà");
		Object[] obj = {vo.getMid(),vo.getPassword()};
		return jdbcTemplate.queryForObject(member_selectOne,obj,new MemberRowMapper());
			
	}
	
	public void insertMember(MemberVO vo){
		System.out.println("insert");
		jdbcTemplate.update(member_insert,vo.getMid(),vo.getPassword(),vo.getMname(),vo.getRole());
	}
	
	public void updateMember(MemberVO vo) {
		System.out.println("update");
		jdbcTemplate.update(member_update, vo.getPassword(),vo.getMname(),vo.getMid());
	}
	
}

class MemberRowMapper implements RowMapper<MemberVO>{

	@Override
	public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberVO data=new MemberVO();
        data.setMid(rs.getString("mid"));
        data.setMname(rs.getString("mname"));
        data.setPassword(rs.getString("password"));
        data.setRole(rs.getString("role"));
		return data;
	}
	
}