package com.test.app.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.test.app.board.BoardVO;
import com.test.app.common.JDBCUtil;

//@Repository//("boardDAO")
public class BoardDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private String board_insert = "insert into board22(bid,title,writer,content) values((select nvl(max(bid),0) from board22)+1,?,?,?)";
	private String board_update = "upeate board22 set title=?,content=? where bid=?";
	private String board_delete = "delete from board22 where bid=?";
	private String board_selectOne = "select * from board22 where bid=?";
	private String board_selectAll = "select * from board22 order by bid desc";
	
	public void insertBoard(BoardVO vo) {
		conn=JDBCUtil.connect();
	      try {
	         pstmt=conn.prepareStatement(board_insert);
	         pstmt.setString(1, vo.getTitle());
	         pstmt.setString(2, vo.getWriter());
	         pstmt.setString(3, vo.getContent());
	         pstmt.executeUpdate();
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         JDBCUtil.disconnect(pstmt, conn);
	      }
	}
	public void updateBoard(BoardVO vo) {
		conn=JDBCUtil.connect();
	      try {
	         pstmt=conn.prepareStatement(board_update);
	         pstmt.setString(1, vo.getTitle());
	         pstmt.setString(2, vo.getContent());
	         pstmt.setInt(3, vo.getBid());
	         pstmt.executeUpdate();
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         JDBCUtil.disconnect(pstmt, conn);
	      }

	}
	public void deleteBoard(BoardVO vo) {
		 conn=JDBCUtil.connect();
	      try {
	         pstmt=conn.prepareStatement(board_delete);
	         pstmt.setInt(1, vo.getBid());
	         pstmt.executeUpdate();
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         JDBCUtil.disconnect(pstmt, conn);
	      }

	}
	public BoardVO selectOne(BoardVO vo) {
		BoardVO data=null;
	      conn=JDBCUtil.connect();
	      try {
	         pstmt=conn.prepareStatement(board_selectOne);
	         pstmt.setInt(1, vo.getBid());
	         rs=pstmt.executeQuery();
	         while(rs.next()) {
	            data=new BoardVO();
	            data.setBdate(rs.getDate("bdate"));
	            data.setBid(rs.getInt("bid"));
	            data.setCnt(rs.getInt("cnt"));
	            data.setContent(rs.getString("content"));
	            data.setTitle(rs.getString("title"));
	            data.setWriter(rs.getString("writer")); 
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         JDBCUtil.disconnect(pstmt, conn);
	      }   
	      return data;

	}
	public ArrayList<BoardVO> selectAll(BoardVO vo) {
		ArrayList<BoardVO> datas=new ArrayList<BoardVO>();
	      conn=JDBCUtil.connect();
	      try {
	         pstmt=conn.prepareStatement(board_selectAll);
	         rs=pstmt.executeQuery();
	         while(rs.next()) {
	            BoardVO data=new BoardVO();
	            data.setBdate(rs.getDate("bdate"));
	            data.setBid(rs.getInt("bid"));
	            data.setCnt(rs.getInt("cnt"));
	            data.setContent(rs.getString("content"));
	            data.setTitle(rs.getString("title"));
	            data.setWriter(rs.getString("writer"));            
	            datas.add(data);
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         JDBCUtil.disconnect(pstmt, conn);
	      }   
	      return datas;

	}

	
}
