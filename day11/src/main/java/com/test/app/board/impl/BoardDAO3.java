package com.test.app.board.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.app.board.BoardVO;
import com.test.app.board.SqlSessionFactoryBean;

//1. 상속
//2. @			이 두가지 방법을 이용할 예정 -> JdbcTemplate이랑 비슷한 향기가 난다.
@Repository("boardDAO")
public class BoardDAO3{
	
	/*private SqlSession mybatis;	
	public BoardDAO3() {
		mybatis = SqlSessionFactoryBean.getSqlSessionInstance();
	}*/
	
	/*@Autowired
	// 상속 extends SqlSessionDaoSupport을 할때 사용
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}*/
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertBoard(BoardVO vo) {
		/*mybatis.insert("BoardDAO.insertBoard", vo);
		mybatis.commit();*/
		//getSqlSession().insert("BoardDAO.insertBoard", vo);
		mybatis.insert("BoardDAO.insertBoard", vo);
	}
	
	public void updateBoard(BoardVO vo) {
		//getSqlSession().update("BoardDAO.updateBoard", vo);
		mybatis.update("BoardDAO.updateBoard", vo);
	}
	
	public void deleteBoard(BoardVO vo) {
		//getSqlSession().delete("BoardDAO.deleteBoard", vo);
		mybatis.delete("BoardDAO.deleteBoard", vo);
	}
	
	public List<BoardVO> selectAll(BoardVO vo){
		//return getSqlSession().selectList("BoardDAO.selectAll", vo);
		/*if(vo.getSearchCondition().equals("title")) {
	  		  // 제목으로 검색하는 로직
				return mybatis.selectList("BoardDAO.selectT", vo);
				//select * from board22 where title like '%'||?||'%' order by bid desc
		}
		else if(vo.getSearchCondition().equals("writer")){
			return mybatis.selectList("BoardDAO.selectW", vo);
			//select * from board22 where writer like '%'||?||'%' order by bid desc
		}
		return mybatis.selectList("BoardDAO.selectW", vo);*/
		return mybatis.selectList("BoardDAO.selectAll", vo);
	}
	
	public BoardVO selectOne(BoardVO vo) {
		//return (BoardVO)getSqlSession().selectOne("BoardDAO.selectOne", vo);
		return (BoardVO)mybatis.selectOne("BoardDAO.selectOne", vo);
	}
	
}






