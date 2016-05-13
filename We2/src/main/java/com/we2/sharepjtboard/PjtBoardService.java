package com.we2.sharepjtboard;

import java.text.DateFormat;
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
	
	public ArrayList<String> getformatDate(int row_start, int row_end) throws ParseException{
		ArrayList<PjtBoardBean> arraymapper=boardMapper.getList(row_start, row_end);

		System.out.println("---------------Date형을 원하는 포멧(String형)으로 바꾸는작업 시작");
		Date mapperdate = null;
		SimpleDateFormat fmt=null;
		String mappercom =null;
		ArrayList<String> formatDate = new ArrayList<String>();
		for(int i=0; i < arraymapper.size(); i++){
			
			mapperdate = arraymapper.get(i).getItemDate();
			System.out.println("1. SQL에서 바로공수(Date형-" + i +") : " + mapperdate);
			
			fmt = new SimpleDateFormat("yyyy-MM-dd");
			mappercom = fmt.format(mapperdate);
			System.out.println("2. 내가 원하는 Date포멧(String형-" + i +") : " + mappercom);
		
			formatDate.add(mappercom);
			System.out.println("3. ArrayList dateToStr(ArrayList<String>형-" + i +") : " + formatDate.get(i));
			
			System.out.println("----------------------------end Routine = " + i);
		} //end for
		System.out.println("---------------Date형을 원하는 포멧(String형)으로 바꾸는작업 끝");
	
		return formatDate;
	}
	
	public ArrayList<PjtBoardBean> getList(int row_start, int row_end) throws ParseException{
		return boardMapper.getList(row_start, row_end);
	};
}
