package com.we2.studyroom;


import java.text.ParseException;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class StudyRoomService {
	

	@Autowired
	private StudyRoomMapper studyRoomMapper;
	
	public ArrayList<StudyRoomBean> getlist(int row_start, int row_end) throws ParseException{
		ArrayList<StudyRoomBean> arraymapper=studyRoomMapper.getList(row_start, row_end);
		
		for(int i=0; i<arraymapper.size(); i++){
			System.out.println("roomshare 테이블 데이터 : " + arraymapper.get(i).getRpictureurl());
		}
		return arraymapper;
	}
	public StudyRoomBean getSearchstudyroom(String rlocatoin , String rlocationdetail){
		return this.studyRoomMapper.getSearchstudyroom(rlocatoin, rlocationdetail);
	}
	
	public StudyRoomBean getSearchbyrcode(int rcode){
		return this.studyRoomMapper.getSearchbyrcode(rcode);
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
	
	public void updateRow(
			 int rcode,
			 String rname, 
			 String rlocation, 
			 String rlocationdetail, 
			 String rcontent, 
			 int rmember, 
		     String rpictureurl){
		System.out.println("studyroomservice updaterow");
		this.studyRoomMapper.StudyRoomupdate(rcode, rname, rlocation, rlocationdetail, rcontent, rmember, rpictureurl);
	}
}



