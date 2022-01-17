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

@Repository("boardDAO")
public class BoardDAO2 {
	
	private String board_insert = "insert into board22(bid,title,writer,content) values((select nvl(max(bid),0) from board22)+1,?,?,?)";
	private String board_update = "upeate board22 set title=?,content=? where bid=?";
	private String board_delete = "delete from board22 where bid=?";
	private String board_selectOne = "select * from board22 where bid=?";
	private String board_selectAll = "select * from board22 order by bid desc";
	
	/*@Autowired //�ַ� ������� ���켭 Ÿ���� �������� ������ ����(DI)
	public void setSuperdataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
		//ds��ü�� ����� �� �ִ� �ڵ� ����
		//ds��ü ����	
	}*/
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insertBoard(BoardVO vo) {
		System.out.println("insert������");
		jdbcTemplate.update(board_insert,vo.getTitle(),vo.getWriter(),vo.getContent());
	}
		
	public void updateBoard(BoardVO vo) {
		System.out.println("update������");
		jdbcTemplate.update(board_update,vo.getTitle(),vo.getContent(),vo.getBid());

	}
	public void deleteBoard(BoardVO vo) {
		System.out.println("delete������");
		jdbcTemplate.update(board_delete,vo.getBid());

	}
	public BoardVO selectOne(BoardVO vo) {
		System.out.println("selectOne������");
		Object[] obj = {vo.getBid()};
		return jdbcTemplate.queryForObject(board_selectOne,obj,new BoardRowMapper());

	}
	public List<BoardVO> selectAll(BoardVO vo) {
		System.out.println("selectAll������");
		return jdbcTemplate.query(board_selectAll,new BoardRowMapper());
	}
}

class BoardRowMapper implements RowMapper<BoardVO>{

	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardVO data=new BoardVO();
        data.setBdate(rs.getDate("bdate"));
        data.setBid(rs.getInt("bid"));
        data.setCnt(rs.getInt("cnt"));
        data.setContent(rs.getString("content"));
        data.setTitle(rs.getString("title"));
        data.setWriter(rs.getString("writer"));
		return data;
	}
	
}






