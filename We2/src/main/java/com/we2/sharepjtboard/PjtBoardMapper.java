package com.we2.sharepjtboard;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface PjtBoardMapper {
	final String select_by_id = "select * from Item where userId=#{id}";
	
	@Select(select_by_id)
	@Results(value = {
			@Result(property="itemNum", column="itemNum"),
			@Result(property="itemTitle", column="itemTitle"),
			@Result(property="userId", column="userId"),
			@Result(property="itemDate", column="itemDate"),
			@Result(property="itemHit", column="itemHit"),
			@Result(property="itemPath", column="itemPath"),
			@Result(property="itemContent", column="itemContent")
	})
	PjtBoardBean getList(@Param("userId") String userId);
	
}
