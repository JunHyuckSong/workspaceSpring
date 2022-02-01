package com.test.app.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.app.board.BoardService;
import com.test.app.board.BoardVO;
import com.test.app.common.LogAdvice2;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDAO3 boardDAO;
	
	
	
	
	@Override
	public void insertBoard(BoardVO vo) {
		boardDAO.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		//la.printLog2(); 
		boardDAO.deleteBoard(vo);
	}

	@Override
	public BoardVO selectOne(BoardVO vo) {
		//la.printLog2(); 
		return boardDAO.selectOne(vo);
	}

	@Override
	public List<BoardVO> selectAll(BoardVO vo) {
		//la.printLog2(); 
		System.out.println("검색로직 추가");
		return boardDAO.selectAll(vo);
	}

}
