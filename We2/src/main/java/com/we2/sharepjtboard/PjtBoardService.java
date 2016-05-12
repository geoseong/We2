package com.we2.sharepjtboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PjtBoardService {
	
	@Autowired
	private PjtBoardMapper boardMapper;
	
	public PjtBoardBean getList(String userId){
		return this.boardMapper.getList(userId);
	}
}
