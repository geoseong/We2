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
	
	public ArrayList<FormattedDate> getformatDate(String category, int row_start, int row_end) throws ParseException{
		ArrayList<PjtBoardBean> arraymapper=boardMapper.getList(category, row_start, row_end);
		
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
	public int getTotalCnt(String category){
		return boardMapper.getTotalCnt(category);
	}
	
	// 게시물 등록
	public void insertBoard (String category, PjtBoardBean pjtboardbean){
		System.out.println("게시물 insert 완료.");
		boardMapper.insertBoard(category, pjtboardbean);
	}
	
	public void count_plus(String category, int itemNum){
		boardMapper.count_plus(category, itemNum);
	}
	
	public ArrayList<PjtBoardBean> select_by_num(String category, int itemNum){
		return boardMapper.select_by_num(category, itemNum);
	}
}
