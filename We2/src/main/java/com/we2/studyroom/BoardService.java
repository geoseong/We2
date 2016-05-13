//���� ������ �⺻������ dao�� controller���� ���� �ʴ� �߰����� ����� ���� �� ����.
//���� �Խ��� ����⿡���� ���� �߰����� ����� �ְ� ���� �ʱ� ������ �� ��Ʈ�ѷ��� ��� ���̿��� ���� ���Ҹ� �ϰ� �ִ� ��
// ����� ���⼱ ��� �ȴ�! 

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
	

