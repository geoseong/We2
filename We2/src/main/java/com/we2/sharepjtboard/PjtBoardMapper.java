package com.we2.sharepjtboard;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface PjtBoardMapper {
	
	// SQL START //
	
	// 페이징 select문.
	final String select = 
			//"select itemNum, itemTitle, userId, itemDate, itemClick, itemPath, itemContent" 
			"select * from ${category} order by itemNum desc limit #{row_start}, #{rows_per_page}";
	
	final String select_by_num =
			"select * from ${category} where itemNum=#{itemNum}";
	
	final String count_plus=
			"update ${category} set itemClick=itemClick+1 where itemNum=#{itemNum}";
	
	final String insert =
			"insert into ${category} (itemTitle,userId,itemDate,itemClick,itemPath,itemContent, itemDataType)"
			+ " values("
			+ "#{itemTitle}, "
			+ "#{userId}, "
			+ "curdate(), "
			+ "0, "
			+ "#{itemPath}, "
			+ "#{itemContent}, "
			+"#{itemDataType})";
			
	final String select_all = "select count(1) from ${category}";
	
	final String modify = 
			"update ${category} set itemTitle=#{itemTitle}, itemPath=#{itemPath}, itemContent=#{itemContent}, itemDataType=#{itemDataType}";
	
	final String delete="delete from ${category} where itemNum=#{itemNum}";
	
	// find
	final String find_list="select * from ${category} where ${find} like '%${findword}%' order by itemNum desc limit #{row_start}, #{row_end}";
	
	final String find_count="select count(1) from ${category} where ${find} like '%${findword}%'";
	/* END OF SQL */
	
	
	/** 메소드 정의부분 */
	@Select(select)
	@Results(value = {
			@Result(property="itemNum", column="itemNum"),
			@Result(property="itemTitle", column="itemTitle"),
			@Result(property="userId", column="userId"),
			@Result(property="itemDate", column="idate"),
			@Result(property="itemClick", column="itemClick"),
			@Result(property="itemPath", column="itemPath"),
			@Result(property="itemContent", column="itemContent"),
			@Result(property="itemDataType", column="itemDataType")
	})
	ArrayList<PjtBoardBean> getList(@Param("category") String category, @Param("row_start") int row_start, @Param("rows_per_page") int rows_per_page);
	
	@Select(select_all)
	int getTotalCnt(@Param("category") String category);
	
	@Select(count_plus)
	void count_plus(@Param("category") String category, @Param("itemNum") int itemNum);
	
	@Insert(insert)
	void insertBoard(
			@Param("category") String category, 
			@Param("itemTitle")String itemTitle, 
			@Param("userId")String userId, 
			@Param("itemPath")String itemPath,
			@Param("itemContent")String itemContent, 
			@Param("itemDataType")String itemDataType);
	
	@Select(select_by_num)
	@Results(value = {
			@Result(property="itemNum", column="itemNum"),
			@Result(property="itemTitle", column="itemTitle"),
			@Result(property="userId", column="userId"),
			@Result(property="itemDate", column="idate"),
			@Result(property="itemClick", column="itemClick"),
			@Result(property="itemPath", column="itemPath"),
			@Result(property="itemContent", column="itemContent"),
			@Result(property="itemDataType", column="itemDataType")
	})
	PjtBoardBean select_by_num(@Param("category") String category, @Param("itemNum")int itemNum);

	@Update(modify)
	void updateBoard(
			@Param("category") String category, 
			@Param("itemTitle") String itemTitle, 
			@Param("itemPath") String itemPath, 
			@Param("itemContent") String itemContent, 
			@Param("itemDataType")String itemDataType);

	@Delete(delete)
	void deleteBoard(@Param("category") String category, @Param("itemNum") int itemNum);
	
	@Select(find_list)
	@Results(value = {
			@Result(property="itemNum", column="itemNum"),
			@Result(property="itemTitle", column="itemTitle"),
			@Result(property="userId", column="userId"),
			@Result(property="itemDate", column="idate"),
			@Result(property="itemClick", column="itemClick"),
			@Result(property="itemPath", column="itemPath"),
			@Result(property="itemContent", column="itemContent"),
			@Result(property="itemDataType", column="itemDataType")
	})
	ArrayList<PjtBoardBean> findBoard(
			@Param("category") String category, 
			@Param("find") String find, 
			@Param("findword") String findword, 
			@Param("row_start") int row_start, 
			@Param("row_end") int row_end);
	
	@Select(find_count)
	int getFindCnt(@Param("category") String category, @Param("find") String find, @Param("findword") String findword);
}
