package com.we2.board.community;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardMapper {

	final String SELECT = 
			"select count(*) from cteamwork";
	
@Select(SELECT) int boardcount();
}
