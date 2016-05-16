package com.we2.studyroom;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.we2.sharepjtboard.PjtBoardBean;



@Component
public class StudyRoomService {
	

	@Autowired
	private StudyRoomMapper studyRoomMapper;
	
	public ArrayList<StudyRoomBean> getlist(int row_start, int row_end) throws ParseException{
		ArrayList<StudyRoomBean> arraymapper=studyRoomMapper.getList(row_start, row_end);
		
		for(int i=0; i<arraymapper.size(); i++){
			System.out.println("roomshare 테이블 데이터 : " + arraymapper.get(i).getRcontent());
		}
		return arraymapper;
	}
	

	
	// 총 폐이지 갯수 구하기
	public int getTotalCnt(){
		int nCnt=0;
		nCnt =this.studyRoomMapper.getTotalCnt();
		return nCnt;
	}
	public void insertStudyRoom (StudyRoomBean studyRoomBean){
		System.out.println("게시물 insert 완료.");
		studyRoomMapper.insertStudyRoom(studyRoomBean);
	}
	public void deleteRow(int rcode){
		this.studyRoomMapper.StudyRoomdelete(rcode);
		
	}
	
/*	public StudyRoomBean getSpecificRow(String id){
		return this.studyRoomMapper.getSpecificRow(id);
	}*/
	
	/*public int getTotalCnt(){
		int nCnt = 0;
		nCnt = this.studyRoomMapper.getTotalCnt();
		return nCnt;
	}
	
	public int getTotalCntBySubject(String search){
		int nCnt=0;
		nCnt = this.studyRoomMapper.getTotalCntBySubject(search);
		return nCnt;
	}
	
	
	public void updateBoard(StudyRoomBean StudyRoomBean) {
		studyRoomMapper.updateBoard(StudyRoomBean.getId(), StudyRoomBean.getSubject(), StudyRoomBean.getMail(), StudyRoomBean.getMemo());
	}
	
	*/
	
	/*public ArrayList<StudyRoomBean> getSearchedList(int nStartPage, int list_num, String strSearchThis){
		//return this.studyRoomMapper.getSearchedList(nStartPage, list_num, strSearchThis);
	}*/

}
