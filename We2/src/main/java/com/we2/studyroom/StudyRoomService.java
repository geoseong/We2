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
	
	public ArrayList<StudyRoomBean> getlist(int row_start, int rows_per_page) throws ParseException{
		ArrayList<StudyRoomBean> arraymapper=studyRoomMapper.getList(row_start, rows_per_page);
		return arraymapper;
	}
	public ArrayList<StudyRoomBean> getSearchstudyroom(String rlocatoin , String rlocationdetail, int row_start, int rows_per_page){
		System.out.println("Service - " + rlocatoin + " / "+ rlocationdetail);
		return studyRoomMapper.getSearchstudyroom(rlocatoin, rlocationdetail, row_start, rows_per_page);
	}
	
	public StudyRoomBean getSearchbyrcode(int rcode){
		return this.studyRoomMapper.getSearchbyrcode(rcode);
	}
	
	// 총 행 갯수 구하기
	public int getTotalCnt(){
		int nCnt=0;
		nCnt =this.studyRoomMapper.getTotalCnt();
		return nCnt;
	}
	
	// 총 행 갯수 구하기
	public int getsearchTotalCnt(String rlocation , String rlocationdetail){
		int nCnt=0;
		nCnt =this.studyRoomMapper.getsearchTotalCnt(rlocation, rlocationdetail);
		return nCnt;
	}
	
	public void insertStudyRoom (
			 String rname, 
			 String rlocation, 
			 String rlocationdetail, 
			 String rcontent, 
			 int rmember, 
		     String rpictureurl){
		System.out.println("게시물 insert 완료.");
		studyRoomMapper.insertStudyRoom(rname, rlocation, rlocationdetail, rcontent, rmember, rpictureurl);
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



