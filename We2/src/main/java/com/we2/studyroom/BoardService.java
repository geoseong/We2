//서비스 파일은 기본적으로 dao와 controller에서 하지 않는 추가적인 기능을 넣을 때 쓴다.
//여기 게시판 만들기에서는 딱히 추가적인 기능을 넣고 있지 않기 때문에 걍 컨트롤러와 디비 사이에서 전달 역할만 하고 있는 것
// 결론은 여기선 없어도 된다! 

package com.we2.studyroom;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


	@Component
	public class BoardService {
		@Autowired
		private BoardMapper boardMapper;
		
		public ArrayList<BoardBean> getList(int nStartPage, int list_num){
			return this.boardMapper.getList(nStartPage, list_num);
		}
		public BoardBean getSpecificRow(String id){
			return this.boardMapper.getSpecificRow(id);
		}
		
		public int getTotalCnt(){
			int nCnt = 0;
			nCnt = this.boardMapper.getTotalCnt();
			return nCnt;
		}
		
		public int getTotalCntBySubject(String search){
			int nCnt=0;
			nCnt = this.boardMapper.getTotalCntBySubject(search);
			return nCnt;
		}
		
		public void insertBoard(BoardBean boardBean){
			boardMapper.insertBoard(boardBean);
		}
		public void updateBoard(BoardBean boardBean) {
			boardMapper.updateBoard(boardBean.getId(), boardBean.getSubject(), boardBean.getMail(), boardBean.getMemo());
		}
		
		public void deleteRow(int id){
			this.boardMapper.deleteSpecificRow(id);
			
		}
		
		public ArrayList<BoardBean> getSearchedList(int nStartPage, int list_num, String strSearchThis){
			return this.boardMapper.getSearchedList(nStartPage, list_num, strSearchThis);
		}

	}
	

