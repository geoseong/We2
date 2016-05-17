package com.we2.file;


import java.text.ParseException;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class FileService {
	

	@Autowired
	private FileMapper fileMapper;
	
	public ArrayList<FileBean> getlist(int row_start, int row_end) throws ParseException{
		ArrayList<FileBean> arraymapper=fileMapper.getList(row_start, row_end);
		
		for(int i=0; i<arraymapper.size(); i++){
			System.out.println("roomshare 테이블 데이터 : " + arraymapper.get(i).getFileurl());
		}
		return arraymapper;
	}
	
/*	public FileBean getSearchbyfcode(int fcode){
		return this.fileMapper.getSearchbyfcode(fcode);
	}
	*/
	// 총 폐이지 갯수 구하기
	public int getTotalCnt(){
		int nCnt=0;
		nCnt =this.fileMapper.getTotalCnt();
		return nCnt;
	}
/*	
	public void insertfile (FileBean fileBean){
		System.out.println("게시물 insert 완료.");
		fileMapper.insertfile(fileBean);
	}
	public void deleteRow(int fcode){
		this.fileMapper.filedelete(fcode);
		
	}
	
	public void updateRow(
			 int fcode,
			String rname, 
			 String rlocation, 
			 String rlocationdetail, 
			 String rcontent, 
			 int rmember, 
			String rpictureurl){
		System.out.println("fileservice updaterow");
		//this.fileMapper.fileupdate(/*fcode, rname, rlocation, rlocationdetail, rcontent, rmember, rpictureurl);
	}
  */
}



