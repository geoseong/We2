package com.we2.studyroom;


import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class StudyRoomService {
	

	@Autowired
	private StudyRoomMapper studyRoomMapper;
	
	public ArrayList<StudyRoomBean> getList(int row_start, int row_end){
		return this.studyRoomMapper.getList(row_start, row_end);
	}
	
	public void insertStudyRoom(StudyRoomBean studyRoomBean){
		//StudyRoomMapper.insertStudyRoom(studyRoomBean);
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
	
	public void deleteRow(int id){
		this.studyRoomMapper.deleteSpecificRow(id);
		
	}*/
	
	/*public ArrayList<StudyRoomBean> getSearchedList(int nStartPage, int list_num, String strSearchThis){
		//return this.studyRoomMapper.getSearchedList(nStartPage, list_num, strSearchThis);
	}*/

}
