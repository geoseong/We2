package com.we2.sharepjtboard;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface PjtBoardMapper {
	
	// 페이징 select문.
	final String select_by_id = 
			"select itemNum, itemTitle, userId, date_format(itemDate,'%Y-%m-%d') as idate, itemClick, itemPath, itemContent" 
			+ " from pGroup limit #{row_start}, #{row_end}";
	
	final String insert =
			"insert into pGroup(itemTitle,userId,itemDate,itemClick,itemPath,itemContent)"
			+ " values("
			+ "#{itemTitle}, "
			+ "#{userId}, "
			+ "curdate(), "
			+ "0"
			+ "itemPath, "
			+ "itemContent)";
			
	
	@Select(select_by_id)
	@Results(value = {
			@Result(property="itemNum", column="itemNum"),
			@Result(property="itemTitle", column="itemTitle"),
			@Result(property="userId", column="userId"),
			@Result(property="itemDate", column="idate"),
			@Result(property="itemClick", column="itemClick"),
			@Result(property="itemPath", column="itemPath"),
			@Result(property="itemContent", column="itemContent")
	})
	ArrayList<PjtBoardBean> getList(@Param("row_start") int row_start, @Param("row_end") int row_end);
	
	
}
