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

// 기존 BoardDAO의 한계를 극.복 해복자 : 중복코드 많음
// -> JDBCTemplate 사용
//		1) JdbcDaoSupport 클래스를 상속받아서 구현 -> 강제성 부족
//		2) JdbcTemplate 클래스 <bean> 등록하여 DI ★

//@Repository("boardDAO")
public class BoardDAO2 {
	
	private String board_insert = "insert into board22(bid,title,writer,content,filepath) values((select nvl(max(bid),0) from board22)+1,?,?,?,?)";
	private String board_update = "update board22 set title=?,content=? where bid=?";
	private String board_delete = "delete from board22 where bid=?";
	private String board_selectOne = "select * from board22 where bid=?";
	private String board_selectAll = "select * from board22 order by bid desc";
	private String selectWriter = "select * from board22 where writer like '%'||?||'%' order by bid desc";
	private String selectTitle = "select * from board22 where title like '%'||?||'%' order by bid desc";
	
	/*@Autowired //주로 멤버변수 위헤서 타입을 먼저보고 의존성 주입(DI) applicationContext.xml에 <bean>등록해둔 DataSource를 가져오는 Autowired
	public void setSuperdataSource(DataSource dataSource) {
		//super.set;
		//dataSource객체를 사용할 수 있는 코드 존재
		//dataSource객체 주입	
	}*/
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insertBoard(BoardVO vo) {
		//getJdbcTemplate().update(board_insert,vo.getTitle(),vo.getWriter(),vo.getContent()); //JdbcDaoSupport를 상속받았을 경우 이렇게 사용가능
		System.out.println("insert수행중");
		//insert into board22(bid,title,writer,content) values((select nvl(max(bid),0) from board22)+1,?,?,?,?)
		jdbcTemplate.update(board_insert,vo.getTitle(),vo.getWriter(),vo.getContent(),vo.getFilepath());
	}
		
	public void updateBoard(BoardVO vo) {
		//getJdbcTemplate().update(board_update,vo.getTitle(),vo.getContent(),vo.getBid());
		System.out.println("update수행중");
		//update board22 set title=?,content=? where bid=?
		jdbcTemplate.update(board_update,vo.getTitle(),vo.getContent(),vo.getBid());

	}
	public void deleteBoard(BoardVO vo) {
		//getJdbcTemplate().update(board_delete,vo.getBid());
		System.out.println("delete수행중");
		//delete from board22 where bid=?
		jdbcTemplate.update(board_delete,vo.getBid());
		
	}
	public BoardVO selectOne(BoardVO vo) {
		System.out.println("selectOne수행중");
		//select * from board22 where bid=?
		Object[] obj = {vo.getBid()};
		//return getJdbcTemplate().queryForObject(board_selectOne,obj,new BoardRowMapper()); //JdbcDaoSupport를 상속받았을 경우 이렇게 사용가능
		return jdbcTemplate.queryForObject(board_selectOne,obj,new BoardRowMapper());
		
	}
	public List<BoardVO> selectAll(BoardVO vo) {
		System.out.println("selectAll수행중");
		//select * from board22 order by bid desc
		Object[] obj = {vo.getSearchContent()};
		String sql = board_selectAll;
		
		if(vo.getSearchCondition().equals("title")) {
  		  // 제목으로 검색하는 로직
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
		//여기서 rowNum은 반복횟수를 의미한다. 우리가 따로 작성할 필요는 없다.
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






