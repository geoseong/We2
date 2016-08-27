package com.we2.file;

import java.util.ArrayList;
import java.util.Date;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.we2.sharepjtboard.PjtBoardBean;




@Repository
public interface FileMapper {
	
	// 페이징 select문.
	final String select = 
			"select fcode, fname, fileurl, pjtCode, date_format(fdate,'%Y-%m-%d'), userId from limit #{row_start}, #{row_end}";
	
	final String select_by_fcode=
			"select * from fileshare where fcode=${fcode} and pjtCode=${pjtCode}";
	
	final String select_all = "select count(1) from fileshare where pjtCode=${pjtCode}";
	
	final String count_plus=
			"update set itemClick=itemClick+1 where itemNum=#{itemNum}";
	
	final String select_by_id ="select userId, fcode, fname, fileurl, date_format(fdate,'%Y-%m-%d') fdate from fileshare where pjtcode=${pjtcode} order by fcode desc limit #{row_start}, #{row_end}";
	
	final String insertFile = "insert into fileshare(fname, fileurl, fdate, pjtCode, userId) values (#{fname}, #{fileurl}, date_format(now(),'%Y-%m-%d'), ${pjtCode}, #{userId})";
	
	final String delete_by_fcode = "delete from fileshare where fcode = #{fcode} and pjtCode=${pjtCode}";
	
	final String update_by_fcode = "update fileshare set fname = #{fname}, fileurl = #{fileurl}, fdate=now() where fcode = #{fcode} and pjtCode=${pjtCode}";
			
	final String select_by_num =
			"select * from fileshare where fcode=${fcode} and pjtCode=${pjtCode}";

		@Select(select_by_id)				
		@Results(value = {   
				@Result(property="fcode", column="fcode"),
				@Result(property="userId", column="userId"),
				@Result(property="fname", column="fname"),
				@Result(property="fileurl", column="fileurl"),
				@Result(property="fdate", column="fdate"),
				@Result(property="pjtCode", column="pjtCode")
		})
		ArrayList<FileBean> getList(@Param("row_start") int row_start, @Param("row_end") int row_end, @Param("pjtcode") int pjtcode);
		
		@Select(select_by_fcode)				
		@Results(value = {   
				@Result(property="fcode", column="fcode"),
				@Result(property="userId", column="userId"),
				@Result(property="fname", column="fname"),
				@Result(property="fileurl", column="fileurl"),
				@Result(property="fdate", column="fdate"),
				@Result(property="pjtCode", column="pjtCode")
		})
		FileBean getSearchbyfcode(@Param("fcode") int fcode, @Param("pjtCode") int pjtCode);
	
		
		@Insert(insertFile)  		
		void insertFile(@Param("fname")String fname, @Param("fileurl")String fileurl, @Param("pjtCode") int pjtCode, @Param("userId")String userId) ;
		
		@Select(select_all)
		int getTotalCnt(@Param("pjtCode") int pjtCode);
		
		@Delete(delete_by_fcode)  
		void filedelete(@Param("fcode") int fcode, @Param("pjtCode") int pjtCode);
		
		@Update(update_by_fcode) 
		void fileupdate(
				@Param("fcode") int rcode,
				@Param("fname") String fname, 
				@Param("fileurl")String fileurl,
				@Param("pjtCode") int pjtCode);
		
		@Select(select_by_num)
		@Results(value = {
				@Result(property="fcode", column="fcode"),
				@Result(property="userId", column="userId"),
				@Result(property="fname", column="fname"),
				@Result(property="fileurl", column="fileurl"),
				@Result(property="fdate", column="fdate"),
				@Result(property="pjtCode", column="pjtCode")
		}, id="fileresult")
		FileBean select_by_num(@Param("pjtCode")int pjtCode, @Param("fcode")int fcode);
} //end Mapper
