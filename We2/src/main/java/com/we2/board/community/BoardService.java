package com.we2.board.community;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.we2.board.community.BoardBean;
import com.we2.board.community.BoardMapper;

@Component
public class BoardService {

	@Autowired
	private BoardMapper boardMapper;
	
	//페이지 처리
	public ArrayList<BoardBean> getList(int nStartPage, int list_num){
		return this.boardMapper.getList(nStartPage, list_num);
	}
	
	//게시번호
	public BoardBean getSpecificRow(String cFindNum){
		return this.boardMapper.getSpecificRow(cFindNum);
	}
	
	public int getTotalCnt(){
		int nCnt = 0;
		nCnt = this.boardMapper.getTotalCnt();
		return nCnt;
	}
	
	public int getTotalCntBySubject(String search){
		int nCnt=0;
		nCnt = this.boardMapper.getTotalCntBycFindTitle(search);
		return nCnt;
	}
	
	public void insertBoard(BoardBean boardBean){
		boardMapper.insertBoard(boardBean);
	}
	public void updateBoard(BoardBean boardBean) {
		boardMapper.updateBoard(boardBean.getcFindNum(), boardBean.getcFindTitle(), boardBean.getcFindContent());
	}
	
	public void deleteRow(int cFindNum){
		this.boardMapper.deleteSpecificRow(cFindNum);
		
	}
	
	public ArrayList<BoardBean> getSearchedList(int nStartPage, int list_num, String strSearchThis){
		return this.boardMapper.getSearchedList(nStartPage, list_num, strSearchThis);
	}
}
