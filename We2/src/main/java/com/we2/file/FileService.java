package com.we2.file;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.we2.sharepjtboard.PjtBoardBean;


@Component
public class FileService {
	

	@Autowired
	private FileMapper fileMapper;
	
	public ArrayList<FileBean> getlist(int row_start, int row_end, int pjtcode) throws ParseException{
		ArrayList<FileBean> arraymapper=fileMapper.getList(row_start, row_end, pjtcode);
		
		for(int i=0; i<arraymapper.size(); i++){
			System.out.println("fileshare 테이블 데이터 : " + arraymapper.get(i).getFileurl());
		}
		return arraymapper;
	}
	
	public FileBean getSearchbyfcode(int fcode, int pjtCode){
		return this.fileMapper.getSearchbyfcode(fcode, pjtCode);
	}
	
	// 총 폐이지 갯수 구하기
	public int getTotalCnt(int pjtCode){
		int nCnt=0;
		nCnt =this.fileMapper.getTotalCnt(pjtCode);
		return nCnt;
	}

	public void insertFile (String fname, String fileurl, int pjtCode){
		fileMapper.insertFile(fname, fileurl, pjtCode);
	}
	
	public void deleteRow(int fcode, int pjtCode){
		this.fileMapper.filedelete(fcode, pjtCode);
		
	}
	
	public void updateRow(
			 int fcode,
		   	 String fname, 
			 String fileurl,
			 int pjtCode
			 ){
		System.out.println("fileservice updaterow");
		this.fileMapper.fileupdate(fcode, fname, fileurl, pjtCode);
	}
	
	// itemNum으로 게시물 조회
	public FileBean select_by_num(int pjtCode, int fcode){
		return fileMapper.select_by_num(pjtCode, fcode);
	}
 
}



