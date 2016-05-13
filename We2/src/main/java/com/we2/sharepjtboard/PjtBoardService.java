package com.we2.sharepjtboard;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PjtBoardService {
	
	@Autowired
	private PjtBoardMapper boardMapper;
	
	public /*ArrayList<PjtBoardBean>*/void getList(int row_start, int row_end){
		ArrayList<PjtBoardBean> arraymapper=boardMapper.getList(row_start, row_end);
		
		Date mapperdate = arraymapper.get(3).getItemDate();
			System.out.println("mapperdate : " + mapperdate);
			
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("내가 원하는 Date형 : " + fmt.format(mapperdate));
		
		String mappercom = fmt.format(mapperdate);
		//arraymapper.set(3, );
		
//		return this.boardMapper.getList(row_start, row_end);
	}
}
