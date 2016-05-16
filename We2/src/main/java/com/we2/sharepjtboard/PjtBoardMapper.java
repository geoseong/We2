package com.we2.sharepjtboard;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface PjtBoardMapper {
	
	// SQL START //
	
	// 페이징 select문.
	final String select = 
			//"select itemNum, itemTitle, userId, itemDate, itemClick, itemPath, itemContent" 
			"select * from ${category} limit #{row_start}, #{row_end}";
	
	final String select_by_num =
			"select * from ${category} where itemNum=#{itemNum}";
	
	final String count_plus=
			"update ${category} set itemClick=itemClick+1 where itemNum=#{itemNum}";
	
	final String insert =
			"insert into ${category}(itemTitle,userId,itemDate,itemClick,itemPath,itemContent)"
			+ " values("
			+ "#{itemTitle}, "
			+ "#{userId}, "
			+ "curdate(), "
			+ "0, "
			+ "#{itemPath}, "
			+ "#{itemContent})";
			
	final String select_all = "select count(1) from ${category}";
	
	final String modify = 
			"update ${category} set itemTitle=#{itemTitle}, itemPath=#{itemPath}, itemContent=#{itemContent}";
	
	final String delete="delete from ${category} where itemNum=#{itemNum}";
	/* END OF SQL */
	
	// 메소드 정의부분
	@Select(select)
	@Results(value = {
			@Result(property="itemNum", column="itemNum"),
			@Result(property="itemTitle", column="itemTitle"),
			@Result(property="userId", column="userId"),
			@Result(property="itemDate", column="idate"),
			@Result(property="itemClick", column="itemClick"),
			@Result(property="itemPath", column="itemPath"),
			@Result(property="itemContent", column="itemContent")
	})
	ArrayList<PjtBoardBean> getList(@Param("category") String category, @Param("row_start") int row_start, @Param("row_end") int row_end);
	
	@Select(select_all)
	int getTotalCnt(@Param("category") String category);
	
	@Select(count_plus)
	void count_plus(@Param("category") String category, @Param("itemNum") int itemNum);
	
	@Insert(insert)
	void insertBoard(@Param("category") String category, PjtBoardBean pjtboardbean);
}
