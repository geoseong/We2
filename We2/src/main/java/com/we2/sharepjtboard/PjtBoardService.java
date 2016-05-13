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
	
	public/* ArrayList<PjtBoardBean>*/void getList(int row_start, int row_end) throws ParseException{
		ArrayList<PjtBoardBean> arraymapper=boardMapper.getList(row_start, row_end);
		
		Date mapperdate = arraymapper.get(3).getItemDate();
			System.out.println("mapperdate : " + mapperdate);
			
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		String mappercom = fmt.format(mapperdate);
		System.out.println("내가 원하는 Date형 : " + mappercom);
		
		
		
	
		//return this.boardMapper.getList(row_start, row_end);
	}
}
