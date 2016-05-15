package com.we2.sharepjtboard;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PjtBoardService {
	
	@Autowired
	private PjtBoardMapper boardMapper;
	
	public ArrayList<FormattedDate> getformatDate(int row_start, int row_end) throws ParseException{
		ArrayList<PjtBoardBean> arraymapper=boardMapper.getList( row_start, row_end);
		
		System.out.println("---------------Date형을 원하는 포멧(String형)으로 바꾸는작업 시작");
		Date mapperdate = null;
		SimpleDateFormat fmt=null;
		String mappercom =null;
		
		FormattedDate formatDate;
		ArrayList<FormattedDate> formattedDate = new ArrayList<FormattedDate>();
		for(int i=0; i < arraymapper.size(); i++){
			mapperdate = arraymapper.get(i).getItemDate();
			
			fmt = new SimpleDateFormat("yyyy-MM-dd");
			mappercom = fmt.format(mapperdate);
		
			formatDate= new FormattedDate(
						arraymapper.get(i).getItemNum(), 
						arraymapper.get(i).getItemTitle(),
						arraymapper.get(i).getUserId(),
						mappercom,
						arraymapper.get(i).getItemClick(),
						arraymapper.get(i).getItemPath(),
						arraymapper.get(i).getItemContent()
						);
			formattedDate.add(i, formatDate);
		} //end for
		
		System.out.println("☆☆☆☆☆☆Date형을 원하는 포멧(String형)으로 바꾸는작업 끝☆☆☆☆☆☆");
	
		return formattedDate;
	}
	
	// 총 폐이지 갯수 구하기
	public int getTotalCnt(){
		return boardMapper.getTotalCnt();
	}
	
	// 게시물 등록
	public void insertBoard (PjtBoardBean pjtboardbean){
		boardMapper.insertBoard(pjtboardbean);
	}
}
