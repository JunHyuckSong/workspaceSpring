package com.test.app.board.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.test.app.board.BoardVO;

// ���� BoardDAO�� �Ѱ踦 ��.�� �غ��� : �ߺ��ڵ� ����
// -> JDBCTemplate ���
//		1) JdbcDaoSupport Ŭ������ ��ӹ޾Ƽ� ���� -> ������ ����
//		2) JdbcTemplate Ŭ���� <bean> ����Ͽ� DI ��

//@Repository("boardDAO")
public class BoardDAO2 {
	
	private String board_insert = "insert into board22(bid,title,writer,content,filepath) values((select nvl(max(bid),0) from board22)+1,?,?,?,?)";
	private String board_update = "update board22 set title=?,content=? where bid=?";
	private String board_delete = "delete from board22 where bid=?";
	private String board_selectOne = "select * from board22 where bid=?";
	private String board_selectAll = "select * from board22 order by bid desc";
	private String selectWriter = "select * from board22 where writer like '%'||?||'%' order by bid desc";
	private String selectTitle = "select * from board22 where title like '%'||?||'%' order by bid desc";
	
	/*@Autowired //�ַ� ������� ���켭 Ÿ���� �������� ������ ����(DI) applicationContext.xml�� <bean>����ص� DataSource�� �������� Autowired
	public void setSuperdataSource(DataSource dataSource) {
		//super.set;
		//dataSource��ü�� ����� �� �ִ� �ڵ� ����
		//dataSource��ü ����	
	}*/
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insertBoard(BoardVO vo) {
		//getJdbcTemplate().update(board_insert,vo.getTitle(),vo.getWriter(),vo.getContent()); //JdbcDaoSupport�� ��ӹ޾��� ��� �̷��� ��밡��
		System.out.println("insert������");
		//insert into board22(bid,title,writer,content) values((select nvl(max(bid),0) from board22)+1,?,?,?,?)
		jdbcTemplate.update(board_insert,vo.getTitle(),vo.getWriter(),vo.getContent(),vo.getFilepath());
	}
		
	public void updateBoard(BoardVO vo) {
		//getJdbcTemplate().update(board_update,vo.getTitle(),vo.getContent(),vo.getBid());
		System.out.println("update������");
		//update board22 set title=?,content=? where bid=?
		jdbcTemplate.update(board_update,vo.getTitle(),vo.getContent(),vo.getBid());

	}
	public void deleteBoard(BoardVO vo) {
		//getJdbcTemplate().update(board_delete,vo.getBid());
		System.out.println("delete������");
		//delete from board22 where bid=?
		jdbcTemplate.update(board_delete,vo.getBid());
		
	}
	public BoardVO selectOne(BoardVO vo) {
		System.out.println("selectOne������");
		//select * from board22 where bid=?
		Object[] obj = {vo.getBid()};
		//return getJdbcTemplate().queryForObject(board_selectOne,obj,new BoardRowMapper()); //JdbcDaoSupport�� ��ӹ޾��� ��� �̷��� ��밡��
		return jdbcTemplate.queryForObject(board_selectOne,obj,new BoardRowMapper());
		
	}
	public List<BoardVO> selectAll(BoardVO vo) {
		System.out.println("selectAll������");
		//select * from board22 order by bid desc
		Object[] obj = {vo.getSearchContent()};
		String sql = board_selectAll;
		
		if(vo.getSearchCondition().equals("title")) {
  		  // �������� �˻��ϴ� ����
			sql = selectTitle;
			//select * from board22 where title like '%'||?||'%' order by bid desc
		}
		else if(vo.getSearchCondition().equals("writer")){
			sql = selectWriter;
			//select * from board22 where writer like '%'||?||'%' order by bid desc
		}
		return jdbcTemplate.query(sql, obj, new BoardRowMapper());
	}
}

class BoardRowMapper implements RowMapper<BoardVO>{

	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		//���⼭ rowNum�� �ݺ�Ƚ���� �ǹ��Ѵ�. �츮�� ���� �ۼ��� �ʿ�� ����.
		BoardVO data=new BoardVO();
        data.setBdate(rs.getDate("bdate"));
        data.setBid(rs.getInt("bid"));
        data.setCnt(rs.getInt("cnt"));
        data.setContent(rs.getString("content"));
        data.setTitle(rs.getString("title"));
        data.setWriter(rs.getString("writer"));
        data.setFilepath(rs.getString("filepath"));
		return data;
	}
	
}






